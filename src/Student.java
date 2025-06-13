public class Student {
    private  int Id;
    private  String name;
    private  String email;
    private  int courseId;
    private  String password;

    public Student(int Id,String name,String email,int courseId,String password){
        this.Id=Id;
        this.name=name;
        this.email=email;
        this.courseId=courseId;
        this.password=password;
    }
    public void setId(int Id){
        this.Id=Id;
    }
    public  void setName(String name){this.name=name;}
    public void setEmail(String email){this.email=email;}
    public void setCourseId(int courseEnrolled){this.courseId=courseEnrolled;}
    public void setPassword(String password){this.password=password;}
    public int getId(){return Id;}
    public String getName(){return name;}
    public String getEmail(){return email;}
    public int getCourseId(){return courseId;}
    public String getPassword(){return password;}

    public void DisplayStudent(){
        System.out.println("Id:-"+getId());
        System.out.println("Name:-"+getName());
        System.out.println("Email:-"+getEmail());
        if(getCourseId()==0){
            System.out.println("CourseId:- No Course Selected..");
        }
        else {
            System.out.println("CourseId:-"+getCourseId());
        }

    }

}
