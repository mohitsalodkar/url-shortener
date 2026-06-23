# 🔗 URL Shortener Web Application

A URL Shortener web application developed using Java and Spring Boot that allows users to shorten long URLs and access them using unique short links. The project uses PostgreSQL for data storage, Redis for caching, Spring Security for authentication, and Docker for containerization.

## 🚀 Live Demo

https://url-shortener-v71n.onrender.com/

## 📂 GitHub Repository

https://github.com/mohitsalodkar/url-shortener

---

## 📌 Features

* User registration and login using Spring Security
* Generate unique short URLs
* Redirect users using shortened links
* Store URL data using PostgreSQL
* Improve performance using Redis caching
* Responsive user interface using Thymeleaf and Bootstrap
* Docker support for containerized deployment
* Deployed on Render Cloud

---

## 🛠️ Technologies Used

### Backend

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate

### Frontend

* Thymeleaf
* HTML
* CSS
* Bootstrap

### Database

* PostgreSQL

### Caching

* Redis

### Tools

* Docker
* Maven
* Git
* GitHub
* Render

---

## ⚙️ Installation

Clone the repository:

```bash
git clone https://github.com/mohitsalodkar/url-shortener.git
cd url-shortener
```

Update the database configuration in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/urlshortener
spring.datasource.username=postgres
spring.datasource.password=yourpassword
```

Run the project:

```bash
./mvnw spring-boot:run
```

Open:

```text
http://localhost:8080
```

---

## 🐳 Docker

Build the image:

```bash
docker build -t url-shortener .
```

Run the container:

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
└── templates
```

---

## 🔮 Future Improvements

* QR code generation
* Click analytics dashboard
* Custom short URLs
* URL expiration feature
* User dashboard

---

## 👨‍💻 Developed By

**Mohit Salodkar**

B.Tech CSE Student
Priyadarshini College of Engineering, Nagpur

📧 [mohitsalodkar24@gmail.com](mailto:mohitsalodkar24@gmail.com)

🔗 LinkedIn: https://linkedin.com/in/mohit_salodkar

💻 GitHub: https://github.com/mohitsalodkar

---

If you found this project useful, feel free to give it a ⭐ on GitHub.
