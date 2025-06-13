public enum StudentMenu {
    VIEW_COURSES,
    UPDATE_PROFILE,
    CHECK_ENROLLMENT,
    LOGOUT;

    public static void displayMenu() {
        System.out.println("\n------ Student Menu ------");
        System.out.println("1. View All Courses");
        System.out.println("2. Update Profile");
        System.out.println("3. Check Enrollment");
        System.out.println("4. Logout");
        System.out.print("Enter your choice: ");
    }
}
