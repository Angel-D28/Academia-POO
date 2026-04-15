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
        System.out.print("Enter the name of the teacher:");
        String name = sc.nextLine();
        System.out.print("Enter the age of the teacher:");
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
        System.out.print("Enter the name of the course:");
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
        System.out.print("Enter the name of the student:");
        String name = sc.nextLine();
        System.out.print("Enter the age of the student:");
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
        System.out.print("Teacher " + teacherSelected.getName() + " assigned to course " + courseSelected.getName());
    }

    public void enrollStudentInCourse(Student student, Course course) {
        Enrollment enrollment = new Enrollment(student, course);
        course.addEnrollment(enrollment);
        student.addEnrollmentCourses(enrollment);
        System.out.print("Student " + student.getName() + " enrolled in course " + course.getName());
    }

    public void createEnrollment() {
        Student studentSelected;
        Course courseSelected;
        do {
        studentSelected = selectStudent();
        courseSelected = selectCourse();
        } while (checkEnrollments(studentSelected, courseSelected));
        enrollStudentInCourse(studentSelected, courseSelected);
    }

    public boolean checkEnrollments(Student Student, Course course) {
        for(int i = 0; i < Student.getEnrollmentCourses().length; i++) {
            if (Student.getEnrollmentCourses()[i] != null && Student.getEnrollmentCourses()[i].getCourse() == course) {
                System.out.println("The student is already enrolled in this course. Please select another course.");
                return true;
            }
        }
        return false;
    }

    public Student selectStudent() {
        Student student;
        int studentIndex;
        do {
            readStudents();
            System.out.print("Select the student by index:");
            studentIndex = sc.nextInt();
            student = students[studentIndex];
            sc.nextLine();
        } while (student == null);
        
        return student;
    }

    public Teacher selectTeacher() {
        Teacher teacher;
        int  teacherIndex;
        do {
            readTeachers();
            System.out.print("Select the teacher by index:");
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
            System.out.print("Select the course by index:");
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

    public void viewCourseDetails() {
        Course course = selectCourse();
        readCourse(course);
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

    public void readCoursesFromStudent(Student student){
        System.out.println("Student: " + student.getName());
        Enrollment[] enrollments = student.getEnrollmentCourses();
        for (int i = 0; i < enrollments.length; i++) {
            if (enrollments[i] != null) {
                System.out.println("Course: " + enrollments[i].getCourse().getName());
            }
        }
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
