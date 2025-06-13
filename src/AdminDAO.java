import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {
    private Connection conn;
    public AdminDAO(Connection conn){
        super();
        this.conn=conn;
    }

    public boolean checkAdmin(String email,String password){

        boolean isAuthenticated=false;
        try{
            String sql="Select * from admin where email=? AND password=? ";
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
}
