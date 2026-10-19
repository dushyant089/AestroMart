# Aestro Mart — Engineering Rules

## General
- Preserve the exact project name Aestro Mart.
- Inspect existing code before editing.
- Provide complete updated files for code changes.
- Use Windows CMD commands unless asked otherwise.

## Security
- Never commit database passwords, JWT secrets, Razorpay secret keys, OAuth credentials, or token files.
- Configure secrets in Render environment variables.
- Enforce authorization in the backend.
- Use HTTPS in production.

## Payments
- The backend is the source of truth for prices and payment status.
- Verify Razorpay signatures server-side.
- Never trust client-submitted totals.
- Clear the cart after successful order creation only.
- Apply gift-card deductions only after successful order/payment processing.

## Frontend
- Do not use localhost as the production API URL.
- Handle loading and error states.
- Do not show success before backend confirmation.
- Preserve the premium dark-blue design.

## Build Commands
Backend: cd /d C:\Desktop\AestroMart\backend then mvnw.cmd clean package -DskipTests
Frontend: cd /d C:\Desktop\AestroMart\frontend then npm run build

A build with -DskipTests does not verify test behavior.