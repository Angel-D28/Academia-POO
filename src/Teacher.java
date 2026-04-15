import java.util.Scanner;

public class Teacher {
    private int age;
    private String name;
    private Course[] activeCourses;

    static Scanner sc = new Scanner(System.in);

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

    public void createLesson(){
        Course course = selectCourse();
        course.askLesson(course);
    }

    public  void updateVideo(){
        Course course = selectCourse();
        course.updateVideo();
    }


    public Course selectCourse() {
        Course course;
        int courseIndex;
        do {
            readCourses();
            System.out.print("Select the course by index:");
            courseIndex = sc.nextInt();
            course = activeCourses[courseIndex];
            sc.nextLine();
        } while (course == null);
        
        return course;
    }

        public void readCourses(){
        System.out.println("==========Courses==========");
        for (int i = 0; i < activeCourses.length; i++) {
            if (activeCourses[i] != null) {
                System.out.println(i +") Name: " + activeCourses[i].getName());
            }
        }
        System.out.println("============================");
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
