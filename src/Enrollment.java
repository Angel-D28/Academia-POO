public class Enrollment {
    private Student student;
    private Course course;
    private String idEnrollment;

    public Enrollment(Student student, Course course, String idEnrollment) {
        this.student = student;
        this.course = course;
        this.idEnrollment = idEnrollment;
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
