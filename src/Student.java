public class Student {
    private String name;
    private int age;
    private Enrollment[] enrollmentCourses;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.enrollmentCourses = new Enrollment[5];
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Enrollment[] getEnrollmentCourses() {
        return enrollmentCourses;
    }

    public void addEnrollmentCourses(Enrollment enrollment) {
        for (int i = 0; i < enrollmentCourses.length; i++) {
            if (enrollmentCourses[i] == null) {
                enrollmentCourses[i] = enrollment;
                break;
            }
        }
    }
}
