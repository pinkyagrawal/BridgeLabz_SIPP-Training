// Superclass
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Subclass 1
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println(name + " is a Teacher who teaches " + subject);
    }
}

// Subclass 2
class Student extends Person {
    int grade;

    Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println(name + " is a Student of grade " + grade);
    }
}

// Subclass 3
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println(name + " is a Staff member in " + department + " department");
    }
}

// Test
public class SchoolSystem {
    public static void main(String[] args) {
        Teacher t = new Teacher("Mr. Verma", 40, "Maths");
        Student s = new Student("Anjali", 16, 10);
        Staff st = new Staff("Ravi", 35, "Administration");

        t.displayRole();
        s.displayRole();
        st.displayRole();
    }
}
