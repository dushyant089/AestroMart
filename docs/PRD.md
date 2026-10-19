# Aestro Mart — Product Requirements Document

## Product Summary
A full-stack e-commerce application for customers and administrators.

## Customer Features
- Register and log in.
- Verify registration using OTP.
- Browse products and categories.
- Manage cart and wishlist.
- Place COD and Razorpay orders.
- View order history and status.
- Use gift cards where supported.
- Access returns and customer support where implemented.

## Admin Features
- Access protected admin dashboard.
- Manage supported catalog and order operations.
- Review return requests.
- Access support-management features where implemented.

## Security Requirements
- Backend validates prices and discounts.
- Verify Razorpay payments server-side.
- Protect admin endpoints with backend authorization.
- Store secrets in deployment environment variables.
- Deduct gift-card balance only after successful order/payment processing.

## Deployment Acceptance Criteria
- Backend connects to production MySQL.
- Frontend calls the deployed HTTPS API.
- Authentication, cart, orders, payments, and gift cards are tested.
- No secrets are committed to GitHub.