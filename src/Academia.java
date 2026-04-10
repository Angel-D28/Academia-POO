import java.util.Scanner;

public class Academia {
    private String name;
    private Course[] courses;
    private Teacher[] teachers;
    private Student[] students;
    Scanner sc = new Scanner(System.in);

    public Academia(String name) {
        this.name = name;
        this.courses = new Course[5];
        this.teachers = new Teacher[15];
        this.students = new Student[1000];
    }
    
    public void CreateTeacher(){
        System.out.println("Enter the name of the teacher:");
        String name = sc.nextLine();
        System.out.println("Enter the age of the teacher:");
        int age = sc.nextInt();
        sc.nextLine();
        Teacher teacher = new Teacher(age, name);
        addTeacher(teacher);
    }

    public void addTeacher(Teacher teacher) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                teachers[i] = teacher;
                break;
            }
        }
    }

    public void CreateCourse(){
        System.out.println("Enter the name of the course:");
        String name = sc.nextLine();
        Course course = new Course(name);
        addCourse(course);
    }

    public void addCourse(Course course) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                courses[i] = course;
                break;
            }
        }
    }

    public void CreateStudent(){
        System.out.println("Enter the name of the student:");
        String name = sc.nextLine();
        System.out.println("Enter the age of the student:");
        int age = sc.nextInt();
        sc.nextLine();
        Student student = new Student(name, age);
        addStudent(student);
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    public void assignTeacherToCourse() {
        Teacher  teacherSelected = selectTeacher();
        Course courseSelected = selectCourse();
        courseSelected.setAssignedTeacher(teacherSelected);
        teacherSelected.addActiveCourses(courseSelected);
        System.out.println("Teacher " + teacherSelected.getName() + " assigned to course " + courseSelected.getName());
    }

    public Teacher selectTeacher() {
        Teacher teacher;
        int  teacherIndex;
        do {
            readTeachers();
            System.out.println("Select the teacher by index:");
            teacherIndex = sc.nextInt();
            teacher = teachers[teacherIndex];
            sc.nextLine();
        } while (teacher == null);
        
        return teacher;
    }

    public Course selectCourse() {
        Course course;
        int courseIndex;
        do {
            readCourses();
            System.out.println("Select the course by index:");
            courseIndex = sc.nextInt();
            course = courses[courseIndex];
            sc.nextLine();
        } while (course == null);
        
        return course;
    }

    public void readTeachers(){
        System.out.println("==========Teachers==========");
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] != null) {
                System.out.println(i +") Name: " + teachers[i].getName() + ", Age: " + teachers[i].getAge());
            }
        }
        System.out.println("============================");
    }

    public void readCourses(){
        System.out.println("==========Courses==========");
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null) {
                System.out.println(i +") Name: " + courses[i].getName());
            }
        }
        System.out.println("============================");
    }

    public void readCourse(Course course){
        System.out.println("Course: " + course.getName());
        if (course.getAssignedTeacher() != null) {
            System.out.println("Assigned Teacher: " + course.getAssignedTeacher().getName());
        } else {
            System.out.println("No teacher assigned");
        }
    }

    public void readStudents(){
        System.out.println("==========Students==========");
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println(i +") Name: " + students[i].getName() + ", Age: " + students[i].getAge());
            }
        }
        System.out.println("============================");
    }   

    public String getName() {
        return name;
    }

    public Course[] getCourses() {
        return courses;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public Student[] getStudents() {
        return students;
    }

}
