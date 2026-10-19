# Aestro Mart — Task Board

## Render Deployment

### Repository
- [ ] Verify .gitignore and .dockerignore.
- [ ] Confirm the intended GitHub repository.
- [ ] Exclude secrets, OAuth tokens, backups, target/, and node_modules/.
- [ ] Push reviewed project files.

### Database
- [ ] Choose production MySQL provider.
- [ ] Create database and user.
- [ ] Configure DB_URL, DB_USERNAME, DB_PASSWORD in Render.

### Backend
- [ ] Create Render Web Service using backend Dockerfile.
- [ ] Configure JWT_SECRET and bootstrap admin credentials.
- [ ] Configure Razorpay test keys, Cloudinary, and Gmail OAuth if required.
- [ ] Check build/runtime logs and database connectivity.

### Frontend
- [ ] Confirm Vite API environment variable.
- [ ] Deploy as Static Site using npm run build and dist.
- [ ] Configure backend CORS and SPA fallback.
- [ ] Verify no production API requests use localhost.

### Testing
- [ ] Test registration and login.
- [ ] Test products, cart, and wishlist.
- [ ] Test COD order.
- [ ] Test Razorpay verification in test mode.
- [ ] Test gift-card balance on success and failure.
- [ ] Test order history, returns, and support.

## Important
Do not mark a task complete until it has actually been verified.