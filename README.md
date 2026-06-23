# 🔗 URL Shortener Web Application

A full-stack URL Shortener web application built using **Java, Spring Boot, PostgreSQL, Redis, Spring Security, Docker, and Thymeleaf**. The application allows users to shorten long URLs, manage links securely, and improve performance using Redis caching.

---

## 🚀 Live Demo

🔗 https://url-shortener-v71n.onrender.com/

---

## 📂 GitHub Repository

🔗 https://github.com/mohitsalodkar/url-shortener

---

## ✨ Features

* User Registration and Login
* Spring Security Authentication
* URL Shortening with Unique Short Codes
* URL Redirection
* PostgreSQL Database Integration
* Redis Caching for Faster Access
* Responsive User Interface using Thymeleaf
* Docker Containerization
* Production Deployment on Render

---

## 🛠️ Tech Stack

### Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate

### Frontend

* Thymeleaf
* HTML5
* CSS3
* Bootstrap

### Database

* PostgreSQL

### Caching

* Redis

### DevOps & Tools

* Docker
* Maven
* Git & GitHub
* Render Cloud

---

## 📸 Screenshots

Add your application screenshots here.

```text
screenshots/
├── home.png
├── login.png
├── dashboard.png
└── url-shortener.png
```

---

## ⚙️ Installation

### Clone Repository

```bash
git clone https://github.com/mohitsalodkar/url-shortener.git

cd url-shortener
```

### Configure Database

Update `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/urlshortener
spring.datasource.username=postgres
spring.datasource.password=yourpassword
```

### Run Application

```bash
./mvnw spring-boot:run
```

Application will run on:

```text
http://localhost:8080
```

---

## 🐳 Docker Support

Build Docker image:

```bash
docker build -t url-shortener .
```

Run container:

```bash
docker run -p 8080:8080 url-shortener
```

---

## 📁 Project Structure

```text
src
├── controller
├── service
├── repository
├── entity
├── config
├── dto
└── templates
```

---

## 🔐 Authentication

* User Registration
* User Login
* Password Encryption using BCrypt
* Session Management using Spring Security

---

## 📈 Future Enhancements

* QR Code Generation
* Click Analytics Dashboard
* User Profile Management
* Custom Short URLs
* Expiring URLs
* REST API Support

---

## 👨‍💻 Author

**Mohit Salodkar**

📧 [mohitsalodkar24@gmail.com](mailto:mohitsalodkar24@gmail.com)

🔗 LinkedIn: https://linkedin.com/in/mohit_salodkar

💻 GitHub: https://github.com/mohitsalodkar

---

## ⭐ Support

If you found this project helpful, please consider giving it a ⭐ on GitHub.
