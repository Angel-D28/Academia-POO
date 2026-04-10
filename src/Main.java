import java.util.Scanner;

public class Main {
    public static void loadTestData() {

    // ================= TEACHERS =================
    Teacher t1 = new Teacher(35, "John Smith");
    Teacher t2 = new Teacher(42, "Maria Lopez");
    Teacher t3 = new Teacher(29, "David Brown");

    academy.addTeacher(t1);
    academy.addTeacher(t2);
    academy.addTeacher(t3);

    // ================= COURSES =================
    Course c1 = new Course("Java Programming");
    Course c2 = new Course("Data Structures");
    Course c3 = new Course("Databases");

    academy.addCourse(c1);
    academy.addCourse(c2);
    academy.addCourse(c3);

    // ================= STUDENTS =================
    Student s1 = new Student("Alice", 20);
    Student s2 = new Student("Bob", 22);
    Student s3 = new Student("Carlos", 19);
    Student s4 = new Student("Diana", 21);

    academy.addStudent(s1);
    academy.addStudent(s2);
    academy.addStudent(s3);
    academy.addStudent(s4);

    System.out.println("Test data loaded successfully");
}

    static Scanner sc = new Scanner(System.in);
    static Academia academy = new Academia("Dev Senior");

    public static void main(String[] args) {
        loadTestData();
        mainMenu();
    }

    public static void mainMenu() {
        String option;

        do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Students");
            System.out.println("2. Teachers");
            System.out.println("3. Courses");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            option = sc.nextLine();

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
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println(" Invalid option");
            }

        } while (!option.equals("4"));
    }

    public static void studentMenu() {
        String option;

        do {
            System.out.println("\n--- STUDENT MENU ---");
            System.out.println("1. Create student");
            System.out.println("2. List students");
            System.out.println("3. enroll in course");
            System.out.println("4. View student enrollments");
            System.out.println("5. Back");
            System.out.print("Select an option: ");

            option = sc.nextLine();

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
                    System.out.println(" Invalid option");
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

            option = sc.nextLine();

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
                    System.out.println("Invalid option");
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
            System.out.println("5. Back");
            System.out.print("Select an option: ");

            option = sc.nextLine();

            switch (option) {
                case "1":
                    academy.CreateCourse();
                    break;
                case "2":
                    academy.readCourses();
                    break;
                case "3":
                    viewCourseDetails();
                    break;
                case "4":
                    academy.assignTeacherToCourse();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Invalid option");
            }

        } while (!option.equals("5"));
    }


    public static void viewCourseDetails() {
        Course course = academy.selectCourse();
        academy.readCourse(course);
        }
}