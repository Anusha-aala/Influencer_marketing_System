# Influencer Platform API 🚀

A **Spring Boot REST API** for an Influencer Platform that allows influencers to register, authenticate using JWT, and manage their profiles.

## 🛠 Tech Stack

* Java 17
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA
* H2 Database
* Maven

## ✨ Features

* User Registration
* User Login with JWT Authentication
* Role-based Authorization
* Get Influencer Profile
* Update Influencer Profile
* Secure REST APIs using Spring Security

## 📂 Project Structure

src
├── controller
├── service
├── repository
├── model
├── security
└── config

## 🔐 Authentication

This project uses **JWT (JSON Web Token)** for authentication.

After login, the server returns a **JWT token** that must be included in API requests:

Authorization: Bearer YOUR_TOKEN

## ⚙️ Running the Project

1. Clone the repository

git clone https://github.com/Anusha-aala/Influencer_marketing_System.git

2. Navigate to the project folder

cd platform

3. Run the application

mvn spring-boot:run

## 🧪 H2 Database Console

Access the H2 console at:

http://localhost:8080/h2-console

JDBC URL:

jdbc:h2:mem:testdb

## API Endpoints

### Register User

POST /auth/register

### Login

POST /auth/login

### Get Profile

GET /influencers/profile

### Update Profile

PUT /influencers/profile

## 🔒 Security

Sensitive configurations like **JWT secret keys** are stored in:

application-secret.properties

This file is ignored using `.gitignore`.

## 📚 Future Improvements

* Influencer campaign management
* Brand collaboration system
* MySQL/PostgreSQL integration
* Deployment to cloud

## 👨‍💻 Author

Anusha
Java Backend Developer
