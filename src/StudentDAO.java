import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
        private Connection conn;
        public StudentDAO(Connection conn){
            super();
            this.conn=conn;
        }
    // Check User
    public boolean checkUser(String email,String password){
        boolean isAuthenticated=false;
        try{
            String sql="Select * from student where email=? AND password=? ";
            PreparedStatement prep=conn.prepareStatement(sql);
            prep.setString(1, email);
            prep.setString(2, password);
            ResultSet  res=prep.executeQuery();
            if (res.next()) {
                System.out.println("You are Logged in");
                isAuthenticated = true;
            } else {
                System.out.println("Email and Password Not matched!!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return isAuthenticated;
    }

        public boolean studentRegistration(Student student){
            boolean f=false;
            try{
                String sql="insert into student(id,name,email,course_id,password) values(?,?,?,?,?)";
                PreparedStatement prep=conn.prepareStatement(sql);
                prep.setInt(1,student.getId());
                prep.setString(2,student.getName());
                prep.setString(3,student.getEmail());
                prep.setInt(4,student.getCourseId());
                prep.setString(5,student.getPassword());
                int i=prep.executeUpdate();
                if(i==1){
                    f=true;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return f;
        }
        public void displayStudent(){

            try{

                String sql = "SELECT student.id AS student_id, " +
                        "student.name AS student_name, " +
                        "student.email AS student_email,"+
                        "course.id AS course_id, " +
                        "course.name AS course_name, " +
                        "course.information " +
                        "FROM student " +
                        "JOIN course ON student.course_id = course.id";
                PreparedStatement prep=conn.prepareStatement(sql);
                ResultSet rs=prep.executeQuery();
                System.out.println("-----------------------------All Students---------------------------------");
                while(rs.next()){
                    System.out.println("Id:"+rs.getInt("student_id"));
                    System.out.println("Student: " + rs.getString("student_name"));
                    System.out.println("Email:"+rs.getString("student_email"));
                    System.out.println("Enrolled Course: " + rs.getString("course_name"));
                    System.out.println("Course Info: " + rs.getString("information"));
                    System.out.println("------------------------------------------");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    public void checkStudent(int studentId) {
        try {
            String sql = "SELECT student.id AS student_id, " +
                    "student.name AS student_name, " +
                    "student.email AS student_email, " +
                    "course.id AS course_id, " +
                    "course.name AS course_name, " +
                    "course.information " +
                    "FROM student " +
                    "JOIN course ON student.course_id = course.id " +
                    "WHERE student.id = ?";

            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1, studentId);
            ResultSet rs = prep.executeQuery();

            System.out.println("----------------------------- Student Details -----------------------------");
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("student_id"));
                System.out.println("Name: " + rs.getString("student_name"));
                System.out.println("Email: " + rs.getString("student_email"));
                System.out.println("Enrolled Course: " + rs.getString("course_name"));
                System.out.println("Course Info: " + rs.getString("information"));
                System.out.println("-------------------------------------------------------------------------");
            } else {
                System.out.println("No student found with ID: " + studentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public  boolean  updateStudent(Student student,int id){
            boolean f=false;
            try {
                String sql="update student  set name=?,email=?,course_id=?,password=? where id=?";
                PreparedStatement prep=conn.prepareStatement(sql);
                prep.setString(1,student.getName());
                prep.setString(2,student.getEmail());
                prep.setInt(3,student.getCourseId());
                prep.setString(4,student.getPassword());
                prep.setInt(5,id);
                int i=prep.executeUpdate();
                if(i==1){
                    f=true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return f;
        }
}
