public enum AdminMenu {
    ADD_COURSE,
    VIEW_COURSES,
    UPDATE_COURSE,
    DELETE_COURSE,
    ENROLL_STUDENT,
    UPDATE_STUDENT,
    VIEW_STUDENTS,
    LOGOUT;

    public static void displayMenu() {
        System.out.println("\n------ Admin Menu ------");
        System.out.println("1. Add New Course");
        System.out.println("2. View All Courses");
        System.out.println("3. Update Course");
        System.out.println("4. Delete Course");
        System.out.println("5. Enroll Student");
        System.out.println("6. Update Student");
        System.out.println("7. View Enrolled Students");
        System.out.println("8. Logout");
        System.out.print("Enter your choice: ");
    }
}
