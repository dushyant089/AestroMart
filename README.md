# 🛍️ Aestro Mart — Full-Stack E-Commerce Platform

Aestro Mart is a full-stack e-commerce application built to provide a modern online shopping experience. It combines a responsive React frontend with a Java Spring Boot backend and a MySQL database.

## ✨ Features

- 🔐 User authentication and protected routes
- 📦 Product browsing and product management
- 🛒 Shopping cart and checkout
- ❤️ Wishlist management
- 📋 Order placement and order tracking
- 💳 Payment integration with Razorpay
- 🎁 Gift card functionality
- ↩️ Return and refund request management
- 🛠️ Admin dashboard for managing store operations
- 📱 Responsive user interface
- 🔌 REST API integration between frontend and backend

*Feature availability may depend on the current implementation and configuration.*

## 🧰 Tech Stack

### Frontend
- React
- TypeScript
- Vite
- Redux Toolkit
- Tailwind CSS
- Axios

### Backend
- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Maven
- REST APIs

### Database and Tools
- MySQL
- Git and GitHub
- Razorpay integration

## 📁 Project Structure

```text
AestroMart/
├── backend/       # Spring Boot application
├── frontend/      # React + TypeScript application
├── docs/          # Project documentation
├── .gitignore
└── README.md
```

## ⚙️ Prerequisites

Install the following before running the project locally:

- Java 21
- Maven
- Node.js and npm
- MySQL
- Git

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/dushyant089/AestroMart.git
cd AestroMart
```

### 2. Configure the database

Create a MySQL database and configure the backend database connection using your local configuration or environment variables.

**Security:** Never commit database passwords, production secrets, OAuth credentials, or payment secret keys to GitHub.

### 3. Run the backend

Open a terminal:

```bash
cd backend
mvn spring-boot:run
```

The backend is configured for port `8080` by default, unless changed in your configuration.

### 4. Configure and run the frontend

Open another terminal:

```bash
cd frontend
npm install
npm run dev
```

Vite will display the local frontend URL in the terminal, typically `http://localhost:5173`.

Configure the frontend API URL and required integration keys according to your local environment.

## 🔒 Security Notes

- Keep production credentials outside source control.
- Use environment variables for sensitive configuration.
- Configure CORS and authentication rules before production deployment.
- Use Razorpay test credentials during development and verify payment handling on the backend.

## 🖼️ Screenshots

Screenshots of the application will be added here.

## 🌐 Live Demo

**Status:** Deployment pending.

Live frontend and backend links will be added after successful production deployment.

## 👨‍💻 Author

**Dushyant Kumar**

- GitHub: [@dushyant089](https://github.com/dushyant089)
- LinkedIn: [Dushyant Rajput](https://www.linkedin.com/in/dushyant-rajput-a76a27309/)

## 📄 License

No license has been specified yet. All rights are reserved by default unless a license is added to the repository.

---

⭐ If you find this project interesting, consider starring the repository!
