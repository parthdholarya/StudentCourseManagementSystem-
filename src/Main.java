import java.sql.Connection;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void adminMenu(Connection conn, Scanner sc) {
        courseDAO courseDAO = new courseDAO(conn);
        StudentDAO studentDAO = new StudentDAO(conn);

        while (true) {
            AdminMenu.displayMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (choice < 1 || choice > AdminMenu.values().length) {
                System.out.println("Invalid choice.");
                continue;
            }

            AdminMenu option = AdminMenu.values()[choice - 1];

            switch (option) {
                case ADD_COURSE:
                    System.out.print("Enter Course ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Course Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Course Info: ");
                    String info = sc.nextLine();

                    Course course = new Course(id, name, info);
                    if (courseDAO.addCourse(course)) {
                        System.out.println("Course added successfully.");
                    } else {
                        System.out.println("Failed to add course.");
                    }
                    break;

                case VIEW_COURSES:
                    courseDAO.displayCourse();
                    break;

                case UPDATE_COURSE:
                    System.out.print("Enter Course ID to update: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Course Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter New Course Info: ");
                    String cinfo = sc.nextLine();

                    Course updatedCourse = new Course(cid, cname, cinfo);
                    if (courseDAO.updateCourse(updatedCourse, cid)) {
                        System.out.println("Course updated successfully.");
                    } else {
                        System.out.println("Failed to update course.");
                    }
                    break;

                case DELETE_COURSE:
                    System.out.print("Enter Course ID to delete: ");
                    int did = sc.nextInt();
                    Course courseToDelete = courseDAO.getById(did);
                    if (courseToDelete == null) {
                        System.out.println("Course not found.");
                    } else if (courseDAO.deleteCourse(did)) {
                        System.out.println("Course deleted: " + courseToDelete.getCourse_name());
                    }
                    break;

                case ENROLL_STUDENT:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String sname = sc.nextLine();
                    System.out.print("Enter Student Email: ");
                    String semail = sc.nextLine();
                    System.out.print("Enter Course ID: ");
                    int courseId = sc.nextInt();
                    System.out.print("Enter Password: ");
                    String spass = sc.next();

                    Student newStudent = new Student(sid, sname, semail, courseId, spass);
                    if (studentDAO.studentRegistration(newStudent)) {
                        System.out.println("Student enrolled.");
                    } else {
                        System.out.println("Failed to enroll student.");
                    }
                    break;

                case UPDATE_STUDENT:
                    System.out.print("Enter Student ID: ");
                    sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    sname = sc.nextLine();
                    System.out.print("Enter New Email: ");
                    semail = sc.nextLine();
                    System.out.print("Enter New Course ID: ");
                    courseId = sc.nextInt();
                    System.out.print("Enter New Password: ");
                    spass = sc.next();

                    Student updatedStudent = new Student(sid, sname, semail, courseId, spass);
                    if (studentDAO.updateStudent(updatedStudent, sid)) {
                        System.out.println("Student updated.");
                    } else {
                        System.out.println("Failed to update student.");
                    }
                    break;

                case VIEW_STUDENTS:
                    studentDAO.displayStudent();
                    break;

                case LOGOUT:
                    System.out.println("Logging out...");
                    return;
            }
        }
    }

    public static void studentMenu(Connection conn, Scanner sc) {
        courseDAO courseDAO = new courseDAO(conn);
        StudentDAO studentDAO = new StudentDAO(conn);

        while (true) {
            StudentMenu.displayMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice < 1 || choice > StudentMenu.values().length) {
                System.out.println("Invalid choice.");
                continue;
            }

            StudentMenu option = StudentMenu.values()[choice - 1];

            switch (option) {
                case VIEW_COURSES:
                    courseDAO.displayCourse();
                    break;

                case UPDATE_PROFILE:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter New Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter New Course ID: ");
                    int cid = sc.nextInt();
                    System.out.print("Enter New Password: ");
                    String pass = sc.next();

                    Student student = new Student(sid, name, email, cid, pass);
                    if (studentDAO.updateStudent(student, sid)) {
                        System.out.println("Profile updated.");
                    } else {
                        System.out.println("Failed to update profile.");
                    }
                    break;

                case CHECK_ENROLLMENT:
                    System.out.print("Enter your Student ID: ");
                    int id = sc.nextInt();
                    studentDAO.checkStudent(id);
                    break;

                case LOGOUT:
                    System.out.println("Logging out...");
                    return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = DatabaseConnection.getConn();

        AdminDAO adminDAO = new AdminDAO(conn);
        StudentDAO studentDAO = new StudentDAO(conn);

        System.out.println("Welcome to Student Course Management");
        System.out.println("1) Admin Login");
        System.out.println("2) Student Login");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Admin Email: ");
                String adminEmail = sc.next();
                System.out.print("Enter Admin Password: ");
                String adminPassword = sc.next();

                if (adminDAO.checkAdmin(adminEmail, adminPassword)) {
                    System.out.println("Welcome Admin!");
                    adminMenu(conn, sc);
                } else {
                    System.out.println("Invalid admin credentials.");
                }
                break;

            case 2:
                System.out.print("Enter Student Email: ");
                String studentEmail = sc.next();
                System.out.print("Enter Student Password: ");
                String studentPassword = sc.next();

                if (studentDAO.checkUser(studentEmail, studentPassword)) {
                    System.out.println("Welcome Student!");
                    studentMenu(conn, sc);
                } else {
                    System.out.println("Invalid student credentials.");
                }
                break;

            default:
                System.out.println("Invalid selection.");
        }
    }
}
