import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class courseDAO{
    private Connection conn;

    public courseDAO(Connection conn) {
        super();
        this.conn = conn;
    }
    public boolean addCourse(Course course){
        boolean success=false;
        try{
            String sql="insert into course(id,name,information) values(?,?,?)";
            PreparedStatement prep=conn.prepareStatement(sql);
            prep.setInt(1,course.getCourse_id());
            prep.setString(2,course.getCourse_name());
            prep.setString(3,course.getInformation());
            int i=prep.executeUpdate();
            success = (i == 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;

    }
    public void displayCourse(){

        try {
            String sql="select * from course";
            PreparedStatement prep=conn.prepareStatement(sql);
            ResultSet rs=prep.executeQuery();
            System.out.println("----------------------All Courses -------------------------");
            while (rs.next()){
                int id=rs.getInt("Id");
                String name=rs.getString("name");
                String information=rs.getString("information");

                Course course=new Course(id,name,information);
                course.displayCourse();
                System.out.println("------------------------------------------");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public boolean updateCourse(Course course,int id){
        boolean success=false;
        try{
            String sql="update course set name=?,information=? where id=? ";
            PreparedStatement prep=conn.prepareStatement(sql);
            prep.setString(1,course.getCourse_name());
            prep.setString(2,course.getInformation());
            prep.setInt(3,id);
            int i=prep.executeUpdate();
            success = (i == 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    public Course getById(int id) {
        Course course = null;
        try {
            String sql = "select * from course where id=?";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1, id);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                int Did = rs.getInt("id");
                String Dname = rs.getString("name");
                String DInfo = rs.getString("information");
                course = new Course(Did, Dname, DInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return course;
    }

    public Boolean deleteCourse(int id){
        boolean f=false;
        try{
            String sql="delete from course where id=?";
            PreparedStatement prep=conn.prepareStatement(sql);
            prep.setInt(1,id);
            int i=prep.executeUpdate();
            f = (i > 0);
        }catch (Exception e){
            System.out.println("Course Will be Assigned A Student Do Not Delete");
        }
        return f;
    }
}