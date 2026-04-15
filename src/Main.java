import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Academia academy = new Academia("Dev Senior");
    static Teacher loggedInTeacher;


// LOAD TEST DATA
    public static void loadTestData() {
        Teacher t1 = new Teacher(35, "John Smith");
        Teacher t2 = new Teacher(42, "Maria Lopez");
        Teacher t3 = new Teacher(29, "David Brown");
        academy.addTeacher(t1);
        academy.addTeacher(t2);
        academy.addTeacher(t3);

        Course c1 = new Course("Java Programming");
        Course c2 = new Course("Data Structures");
        Course c3 = new Course("Databases");
        academy.addCourse(c1);
        academy.addCourse(c2);
        academy.addCourse(c3);

        Student s1 = new Student("Alice", 20);
        Student s2 = new Student("Bob", 22);
        Student s3 = new Student("Carlos", 19);
        Student s4 = new Student("Diana", 21);
        academy.addStudent(s1);
        academy.addStudent(s2);
        academy.addStudent(s3);
        academy.addStudent(s4);

        System.out.println("Test data loaded successfully.");
    }

    public static void main(String[] args) {
        loadTestData();
        loginMenu();
    }

    // SESSION LOGIN & MAIN MENU

    public static void loginMenu() {
        String option;

        do {
            System.out.println("\n========================================");
            System.out.println("       Welcome to " + academy.getName());
            System.out.println("========================================");
            System.out.println("1. Admin");
            System.out.println("2. Teacher");
            System.out.println("3. Exit");
            System.out.print("Select your role: ");

            option = sc.nextLine().trim();

            switch (option) {
                case "1":
                    mainMenu();
                    break;
                case "2":
                    teacherSessionMenu();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (!option.equals("3"));
    }


    // MENÚ ADMIN — acceso total

    public static void mainMenu() {
        String option;

        do {
            System.out.println("\n--- MAIN MENU (Admin) ---");
            System.out.println("1. Students");
            System.out.println("2. Teachers");
            System.out.println("3. Courses");
            System.out.println("4. Back");
            System.out.print("Select an option: ");

            option = sc.nextLine().trim();

            switch (option) {
                case "1":
                    studentMenu();
                    break;
                case "2":
                    teacherMenu();
                    break;
                case "3":
                    courseMenu();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (!option.equals("4"));
    }

    public static void studentMenu() {
        String option;

        do {
            System.out.println("\n--- STUDENT MENU ---");
            System.out.println("1. Create student");
            System.out.println("2. List students");
            System.out.println("3. Enroll in course");
            System.out.println("4. View student enrollments");
            System.out.println("5. Back");
            System.out.print("Select an option: ");

            option = sc.nextLine().trim();

            switch (option) {
                case "1":
                    academy.CreateStudent();
                    break;
                case "2":
                    academy.readStudents();
                    break;
                case "3":
                    academy.createEnrollment();
                    break;
                case "4":
                    academy.readCoursesFromStudent(academy.selectStudent());
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (!option.equals("5"));
    }

    public static void teacherMenu() {
        String option;

        do {
            System.out.println("\n--- TEACHER MENU ---");
            System.out.println("1. Create teacher");
            System.out.println("2. List teachers");
            System.out.println("3. Back");
            System.out.print("Select an option: ");

            option = sc.nextLine().trim();

            switch (option) {
                case "1":
                    academy.CreateTeacher();
                    break;
                case "2":
                    academy.readTeachers();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (!option.equals("3"));
    }

    public static void courseMenu() {
        String option;

        do {
            System.out.println("\n--- COURSE MENU ---");
            System.out.println("1. Create course");
            System.out.println("2. List courses");
            System.out.println("3. View course details");
            System.out.println("4. Assign teacher to course");
            System.out.println("5. Read lessons from course");
            System.out.println("6. Back");
            System.out.print("Select an option: ");

            option = sc.nextLine().trim();

            switch (option) {
                case "1":
                    academy.CreateCourse();
                    break;
                case "2":
                    academy.readCourses();
                    break;
                case "3":
                    academy.viewCourseDetails();
                    break;
                case "4":
                    academy.assignTeacherToCourse();
                    break;
                case "5":
                    Course course = academy.selectCourse();
                    course.readLessons();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (!option.equals("6"));
    }

    // MENÚ TEACHER 

    public static void teacherSessionMenu() {
        loggedInTeacher = academy.selectTeacher();
        String option;
        do {
            System.out.println("\n--- TEACHER MENU ---");
            System.out.println("1. View my assigned courses");
            System.out.println("2. View students in my courses");
            System.out.println("3. Create lesson ");
            System.out.println("4. Update video to lesson: ");
            System.out.println("5. Read lessons from my courses");
            System.out.println("6. Back");
            System.out.print("Select an option: ");

            option = sc.nextLine().trim();

            switch (option) {
                case "1":
                    loggedInTeacher.readCourses();
                    break;
                case "2":
                    Course course= loggedInTeacher.selectCourse();
                    course.readEnrollments();
                    break;
                case "3":
                    loggedInTeacher.createLesson();
                    break;
                case "4":
                    loggedInTeacher.updateVideo();
                    break;
                case "5":
                    Course courseSelected = loggedInTeacher.selectCourse();
                    courseSelected.readLessons();
                    break;
                case "6":
                    loggedInTeacher = null;
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (!option.equals("6"));
    }
}