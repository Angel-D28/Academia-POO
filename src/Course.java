public class Course {
    private String name;
    private Teacher assignedTeacher;
    private Lesson[] lessons;
    private Enrollment[] enrollments;

    public Course(String name) {
        this.name = name;
        this.assignedTeacher = null;
        this.lessons = new Lesson[10];
        this.enrollments = new Enrollment[30];
    }

    public String getName() {
        return name;
    }

    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }

    public Lesson[] getLessons() {
        return lessons;
    }

    public Enrollment[] getEnrollments() {
        return enrollments;
    }

    public void setAssignedTeacher(Teacher assignedTeacher) {
        this.assignedTeacher = assignedTeacher;
    }

    public void addLessons(Lesson lesson) {
        for (int i = 0; i < lessons.length; i++) {
            if (lessons[i] == null) {
                lessons[i] = lesson;
                break;
            }
        }
    }
    
    public void addEnrollment(Enrollment enrollment) {
        for (int i = 0; i < enrollments.length; i++) {
            if (enrollments[i] == null) {
                enrollments[i] = enrollment;
                break;
            }
        }
    }

}
