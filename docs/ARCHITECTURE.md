# Aestro Mart — Architecture

## Project Overview

Aestro Mart is a full-stack e-commerce application.

## Technology Stack

### Frontend
- React 19
- TypeScript
- Vite
- Redux Toolkit
- Tailwind CSS v4
- shadcn/ui

### Backend
- Java 21
- Spring Boot 4.0.6
- Maven
- Spring Data JPA
- Hibernate

### Database
- MySQL

### Authentication
- JWT bearer token
- ProtectedRoute
- AdminRoute

### Payment
- Razorpay
- Cash on Delivery (COD)
- Gift Cards

### Other Integrations
- Cloudinary
- Gmail OAuth
- OTP verification

## Project Structure

- frontend/ — React frontend
- backend/ — Spring Boot REST API
- docs/ — Project documentation

## Main Features

- Customer authentication
- Registration OTP verification
- Product and category management
- Shopping cart
- Wishlist
- Checkout and orders
- Razorpay payment verification
- Cash on Delivery
- Gift cards
- Return requests
- Admin dashboard
- Support conversations and unread tracking

## Backend Configuration

Production environment variables:

- DB_URL
- DB_USERNAME
- DB_PASSWORD
- PORT
- JWT_SECRET
- JWT_EXPIRATION_MS
- BOOTSTRAP_ADMIN_EMAIL
- BOOTSTRAP_ADMIN_PASSWORD
- CLOUDINARY_CLOUD_NAME
- CLOUDINARY_API_KEY
- CLOUDINARY_API_SECRET
- RAZORPAY_KEY_ID
- RAZORPAY_KEY_SECRET
- GMAIL_OAUTH_CREDENTIALS_PATH
- GMAIL_OAUTH_TOKEN_PATH
- GMAIL_SENDER

Never commit actual secret values.

## Payment Security

- Calculate payment amounts on the backend.
- Verify Razorpay signatures on the backend.
- Do not mark orders as paid before verification.
- Clear the cart only after successful order creation.
- Deduct gift-card balance only after successful order/payment processing.

## Deployment

Target platform: Render.

1. Push reviewed project files to GitHub.
2. Configure production MySQL.
3. Deploy the backend.
4. Configure backend environment variables.
5. Deploy the frontend.
6. Configure production API URL and CORS.
7. Test authentication, orders, payments, and gift cards.