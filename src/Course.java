class Course{
    private int course_id;
    private String course_name;
    private String information;

    Course(int course_id,String course_name,String information){
        this.course_id=course_id;
        this.course_name=course_name;
        this.information=information;
    }

    public void setCourse_id(int course_id){
        this.course_id=course_id;
    }
    public void setCourse_name(String course_name){
        this.course_name=course_name;
    }
    public void setInformation(String information){
        this.information=information;
    }
    public int getCourse_id(){
        return course_id;
    }
    public String getCourse_name(){
        return course_name;
    }
    public String getInformation(){
        return information;
    }
    public void displayCourse(){
        System.out.println("Course Id:-"+getCourse_id());
        System.out.println("Course Name:-"+getCourse_name());
        System.out.println("Information:-"+getInformation());
    }

}
