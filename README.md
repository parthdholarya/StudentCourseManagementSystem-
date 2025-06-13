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

🧮 Database Schema

+------------+ +-----------+ +------------+
| Course | | Student | | Admin |
+------------+ +-----------+ +------------+
| course_id |<----->| course_id | | admin_id |
| name | | student_id| | email |
| info | | name | | password |
| email |
| password |

👨‍💻 Author
Parth Dholariya
