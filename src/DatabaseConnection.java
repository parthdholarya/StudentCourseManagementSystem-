import java.sql.Connection;
import java.sql.DriverManager;

class DatabaseConnection{

    private static Connection conn;

    public static Connection getConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_ces","root","Parth@9268");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConn() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}