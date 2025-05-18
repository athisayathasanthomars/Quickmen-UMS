# 🎓 University Management System (UMS) - Spring Boot Application

This is a simple Spring Boot application built to manage university student records using RESTful APIs. It demonstrates MVC architecture, validation, exception handling, and Spring Data JPA integration with an in-memory H2 database or MySQL.

---

## 📦 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web
- Spring Validation
- MySQL
- Lombok
- Maven

---

## 🚀 How to Run the Application

### ✅ Prerequisites

- Java JDK 17+
- IntelliJ IDEA (Community or Ultimate)
- Maven (comes with IntelliJ)
- SQL or NoSQL database
- Internet connection for Maven dependencies

---

### 🧭 Steps

### 1. Clone or Open the Project

-Clone the project by "git clone https://github.com/athisayathasanthomars/Quickmen-UMS"
- Open IntelliJ IDEA
- Go to `File > Open`
- Select the folder containing `pom.xml`

---

### 2. Let IntelliJ Import the Maven Project

- IntelliJ will automatically download all required dependencies

---

### 3. Build the Project

- Go to application.properties 
- if you're using different database than MYSQL, change the database-platform jpa
- Change the database username and password mentioned according to yours
- Go to UmsApplication.java file
- Click Run UmsApplication.main()

---

### 4. Test with PostMan API using REST APIs

- Go to Controller Folder
- Checkout RestController and Mapping APIs and test with JSON Responses and Requests
