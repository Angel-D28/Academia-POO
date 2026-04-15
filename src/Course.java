import java.util.Scanner;

public class Course {
    private String name;
    private Teacher assignedTeacher;
    private Lesson[] lessons;
    private Enrollment[] enrollments;

    Scanner sc = new Scanner(System.in);

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

    public void askLesson(Course course) {
        System.out.print("Enter the title of the lesson: ");
        String lessonTitle = sc.nextLine();
        System.out.print("Enter the date of the lesson: ");
        String date = sc.nextLine();
        createLesson(lessonTitle, date);
    }

    public void updateVideo(){
        Lesson selectedLesson  = selectLesson();
        selectedLesson.createVideo();
    }

    public Lesson selectLesson() {
        Lesson lesson;
        int lessonIndex;
        do {
            readLessons();
            System.out.print("Select the lesson by index:");
            lessonIndex = sc.nextInt();
            lesson = lessons[lessonIndex];
            sc.nextLine();
        } while (lesson == null);
        
        return lesson;
    }

    public void readLessons(){
        System.out.println("==========Lessons==========");
        for (int i = 0; i < lessons.length; i++) {
            if (lessons[i] != null) {
                System.out.println(i +") Title: " + lessons[i].getTitle() + " Date: " + lessons[i].getDate());
            }
        }
        System.out.println("============================");
    }



    public void createLesson(String videoTitle, String date) {
        Lesson lesson = new Lesson(videoTitle, date);
        addLessons(lesson);
    }
    
    public void addEnrollment(Enrollment enrollment) {
        for (int i = 0; i < enrollments.length; i++) {
            if (enrollments[i] == null) {
                enrollments[i] = enrollment;
                break;
            }
        }
    }

    public void readEnrollments() {
        System.out.println("==========Enrollments==========");
        for (int i = 0; i < enrollments.length; i++) {
            if (enrollments[i] != null) {
                System.out.println(i +") Student: " + enrollments[i].getStudent().getName());
            }
        }
        System.out.println("============================");
    }

}
