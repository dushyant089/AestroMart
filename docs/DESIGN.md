# Aestro Mart — Design System

## 1. Visual Identity

Aestro Mart is a modern e-commerce application with a premium dark-blue interface.

- Primary background: `#0A0F19`
- Dark surface: `#0B0D12`
- Brand accent: Blue
- Framework: Tailwind CSS v4
- UI components: shadcn/ui

Keep the existing theme consistent across all pages.

## 2. Design Principles

- Keep the interface clean, modern, and easy to navigate.
- Maintain readable text contrast on dark backgrounds.
- Use consistent spacing, borders, buttons, and cards.
- Support mobile, tablet, and desktop screens.
- Show loading, empty, success, and error states.
- Avoid unnecessary UI changes that break existing features.

## 3. Main Screens

- Authentication and registration
- OTP verification
- Product listing and details
- Shopping cart
- Checkout and payments
- Orders and order history
- Wishlist
- Gift cards
- Admin dashboard
- Return requests
- Customer support conversations

Confirm actual routes and components from the source code before modifying them.

## 4. Product UI

Product cards should present relevant product information clearly, including available images, names, prices, and shopping actions.

Reuse existing components and utilities wherever possible.

## 5. Checkout and Payments

- Clearly distinguish Razorpay and Cash on Delivery.
- Display the gift-card discount and final payable amount accurately.
- Calculate final amounts using trusted backend data.
- Prevent duplicate order submissions.
- Display success only after backend confirmation.
- Never expose Razorpay secret keys in frontend code.

## 6. Responsive Design

- Check layouts at mobile, tablet, and desktop widths.
- Avoid horizontal overflow.
- Ensure forms, navigation, product cards, and dialogs remain usable on small screens.
- Keep buttons and form controls easy to interact with.

## 7. Accessibility

- Use semantic headings and labelled form controls.
- Maintain visible keyboard focus.
- Use meaningful alternative text for images.
- Do not communicate status through color alone.
- Provide clear validation and error messages.

## 8. Development Rules

- Preserve the existing premium dark-blue theme unless a redesign is requested.
- Prefer existing shadcn/ui components.
- Keep API calls in the appropriate frontend API or feature modules.
- Use TypeScript types for API requests and responses.
- Do not move business rules from the backend into the frontend.

## 9. Verification

After frontend changes, run:

cd /d C:\Desktop\AestroMart\frontend
npm run build

Review the build result and test the affected screen before considering the change complete.






