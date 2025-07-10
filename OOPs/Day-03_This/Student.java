public class Student {

    static String universityName = "Global University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students in " + universityName + ": " + totalStudents);
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated for Roll Number " + rollNumber);
        } else {
            System.out.println("Cannot update grade for invalid object.");
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice", "A");
        Student s2 = new Student(102, "Bob", "B");

        s1.displayStudentDetails();
        System.out.println();
        s2.displayStudentDetails();
        System.out.println();

        s1.updateGrade("A+");
        System.out.println();
        s1.displayStudentDetails();
        System.out.println();

        Student.displayTotalStudents();
    }
}