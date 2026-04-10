public class Teacher {
    private int age;
    private String name;
    private Course[] activeCourses;

    public Teacher(int age, String name) {
        this.age = age;
        this.name = name;
        this.activeCourses = new Course[5];
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Course[] getActiveCourses() {
        return activeCourses;
    }

    public void addActiveCourses(Course  course) {
        for (int i = 0; i < activeCourses.length; i++) {
            if (activeCourses[i] == null) {
                activeCourses[i] = course;
                break;
            }
        }
    }
}
