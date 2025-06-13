# 🎓 Student Course Management System

A **Java-based console application** for managing student enrollments and courses using JDBC and MySQL. It supports Admin and Student roles with authentication and CRUD functionalities.

---

## 📚 Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Functionality](#functionality)
- [Database Schema](#database-schema)
- [Screenshots](#screenshots)
- [Author](#author)
- [License](#license)

---

## 🚀 Features

### 🔑 Admin
- Admin login (email & password)
- Add, update, delete, and view courses
- Enroll students and update their details
- View all enrolled students

### 🎓 Student
- Login using registered credentials
- View available courses
- Update personal information
- Check enrollment status

---

🗂️ Project Structure
StudentCourseManagementSystem/
├── dao/
│ ├── AdminDAO.java
│ ├── CourseDAO.java
│ └── StudentDAO.java
├── model/
│ ├── Admin.java
│ ├── Course.java
│ └── Student.java
├── utils/
│ └── DatabaseConnection.java
├── enums/
│ └── MenuOption.java
├── Main.java
└── README.md

-- Create tables
CREATE TABLE Admin (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE Course (
    course_id INT PRIMARY KEY,
    name VARCHAR(100),
    info TEXT
);

CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    course_id INT,
    password VARCHAR(100),
    FOREIGN KEY (course_id) REFERENCES Course(course_id)
);
👨‍💻 Author
Parth Dholariya
