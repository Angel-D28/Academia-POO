public class Enrollment {
    private Student student;
    private Course course;
    private String idEnrollment;
    private int Counter = 0;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.idEnrollment = uniqueId();
    }
    private String uniqueId() {
        String uniqueId  =  "COUU-00" + Counter++;
        Counter++;
        return uniqueId;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getIdEnrollment() {
        return idEnrollment;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
