package com.stlabs.ecommerce.auth.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.UserCredentials;

import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Properties;

@Service
public class EmailService {

    private static final GsonFactory JSON_FACTORY =
            GsonFactory.getDefaultInstance();

    private static final String APPLICATION_NAME =
            "AestroMart Gmail OTP";

    @Value("${gmail.oauth.credentials-path}")
    private String credentialsPath;

    @Value("${gmail.oauth.token-path}")
    private String tokenPath;

    @Value("${gmail.sender:}")
    private String configuredSenderEmail;

    /**
     * Sends registration OTP through Gmail API.
     */
    public void sendRegistrationOtp(
            String toEmail,
            String otp
    ) {

        try {

            Gmail gmail = getGmailService();

            String senderEmail = getSenderEmail();

            if (senderEmail == null
                    || senderEmail.isBlank()) {

                throw new IllegalStateException(
                        "Gmail sender email is not configured"
                );
            }

            String subject =
                    "AestroMart - Email Verification OTP";

            String body =
                    "Hello,\n\n"
                    + "Welcome to AestroMart!\n\n"
                    + "Your email verification OTP is:\n\n"
                    + otp + "\n\n"
                    + "This OTP is valid for 10 minutes.\n"
                    + "Please do not share this OTP with anyone.\n\n"
                    + "If you did not create an AestroMart account, "
                    + "you can safely ignore this email.\n\n"
                    + "Regards,\n"
                    + "AestroMart Team";

            MimeMessage email = createEmail(
                    toEmail,
                    senderEmail,
                    subject,
                    body
            );

            Message message =
                    createGmailMessage(email);

            gmail.users()
                    .messages()
                    .send("me", message)
                    .execute();

            System.out.println(
                    "AestroMart OTP email sent successfully to: "
                            + toEmail
            );

        } catch (Exception exception) {

            System.err.println(
                    "Failed to send AestroMart OTP email: "
                            + exception.getMessage()
            );

            throw new IllegalStateException(
                    "Unable to send OTP email. Please try again.",
                    exception
            );
        }
    }

    /**
     * Creates Gmail API client using Google OAuth credentials.
     */
    private Gmail getGmailService()
            throws Exception {

        File credentialsFile =
                new File(credentialsPath);

        File tokenFile =
                new File(tokenPath);

        if (!credentialsFile.exists()) {

            throw new IllegalStateException(
                    "Google OAuth credentials file not found: "
                            + credentialsFile.getAbsolutePath()
            );
        }

        if (!tokenFile.exists()) {

            throw new IllegalStateException(
                    "Google OAuth token file not found: "
                            + tokenFile.getAbsolutePath()
            );
        }

        GoogleClientSecrets clientSecrets;

        try (
                FileReader reader =
                        new FileReader(
                                credentialsFile,
                                StandardCharsets.UTF_8
                        )
        ) {

            clientSecrets =
                    GoogleClientSecrets.load(
                            JSON_FACTORY,
                            reader
                    );
        }

        String clientId =
                clientSecrets
                        .getDetails()
                        .getClientId();

        String clientSecret =
                clientSecrets
                        .getDetails()
                        .getClientSecret();

        String refreshToken =
                readRefreshToken(
                        tokenFile.toPath()
                );

        UserCredentials credentials =
                UserCredentials.newBuilder()
                        .setClientId(clientId)
                        .setClientSecret(clientSecret)
                        .setRefreshToken(refreshToken)
                        .build();

        credentials.refreshIfExpired();

        return new Gmail.Builder(
                GoogleNetHttpTransport
                        .newTrustedTransport(),
                JSON_FACTORY,
                new HttpCredentialsAdapter(
                        credentials
                )
        )
                .setApplicationName(
                        APPLICATION_NAME
                )
                .build();
    }

    /**
     * Reads refresh_token from token.json.
     */
    private String readRefreshToken(
            Path tokenFile
    ) throws Exception {

        String json =
                Files.readString(
                        tokenFile,
                        StandardCharsets.UTF_8
                );

        String key =
                "\"refresh_token\"";

        int keyIndex =
                json.indexOf(key);

        if (keyIndex == -1) {

            throw new IllegalStateException(
                    "refresh_token not found in token.json"
            );
        }

        int colonIndex =
                json.indexOf(
                        ":",
                        keyIndex
                );

        int firstQuote =
                json.indexOf(
                        "\"",
                        colonIndex + 1
                );

        int secondQuote =
                json.indexOf(
                        "\"",
                        firstQuote + 1
                );

        if (firstQuote == -1
                || secondQuote == -1) {

            throw new IllegalStateException(
                    "Invalid refresh_token format in token.json"
            );
        }

        return json.substring(
                firstQuote + 1,
                secondQuote
        );
    }

    /**
     * Returns configured Gmail sender address.
     */
    private String getSenderEmail() {

        if (configuredSenderEmail != null
                && !configuredSenderEmail.isBlank()) {

            return configuredSenderEmail.trim();
        }

        return "";
    }

    /**
     * Creates MIME email.
     */
    private MimeMessage createEmail(
            String to,
            String from,
            String subject,
            String body
    ) throws Exception {

        Properties properties =
                new Properties();

        Session session =
                Session.getDefaultInstance(
                        properties,
                        null
                );

        MimeMessage email =
                new MimeMessage(session);

        email.setFrom(
                new InternetAddress(from)
        );

        email.addRecipient(
                jakarta.mail.Message.RecipientType.TO,
                new InternetAddress(to)
        );

        email.setSubject(
                subject,
                StandardCharsets.UTF_8.name()
        );

        email.setText(
                body,
                StandardCharsets.UTF_8.name()
        );

        return email;
    }

    /**
     * Converts MIME email into Gmail API Message.
     */
    private Message createGmailMessage(
            MimeMessage email
    ) throws Exception {

        try (
                java.io.ByteArrayOutputStream buffer =
                        new java.io.ByteArrayOutputStream()
        ) {

            email.writeTo(buffer);

            byte[] rawBytes =
                    buffer.toByteArray();

            String encodedEmail =
                    Base64.getUrlEncoder()
                            .withoutPadding()
                            .encodeToString(
                                    rawBytes
                            );

            Message message =
                    new Message();

            message.setRaw(
                    encodedEmail
            );

            return message;
        }
    }
}