import java.util.*;

class Course {
    private String courseName;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.addCourse(this); // establish 2-way association
        }
    }

    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
        System.out.println();
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void viewCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName());
        }
        System.out.println();
    }
}

class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showAllStudents() {
        System.out.println("Students in " + schoolName + ":");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
        System.out.println();
    }
}

public class SchoolSystemExample {
    public static void main(String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        Course history = new Course("History");

        math.enrollStudent(s1);
        science.enrollStudent(s1);
        science.enrollStudent(s2);
        history.enrollStudent(s2);

        School school = new School("Green Valley High School");
        school.addStudent(s1);
        school.addStudent(s2);

        school.showAllStudents();

        s1.viewCourses();
        s2.viewCourses();

        math.showEnrolledStudents();
        science.showEnrolledStudents();
        history.showEnrolledStudents();
    }
}