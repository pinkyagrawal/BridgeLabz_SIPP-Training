class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentLinkedList {
    Student head = null;

    // 1. Add at beginning
    public void addAtBeginning(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // 2. Add at end
    public void addAtEnd(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // 3. Add at specific position (1-based index)
    public void addAtPosition(int position, int roll, String name, int age, char grade) {
        if (position <= 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }

        Student newStudent = new Student(roll, name, age, grade);
        Student temp = head;

        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // 4. Delete by Roll Number
    public void deleteByRollNumber(int roll) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNumber == roll) {
            head = head.next;
            System.out.println("Student with Roll No " + roll + " deleted.");
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Roll Number not found.");
            return;
        }

        temp.next = temp.next.next;
        System.out.println("Student with Roll No " + roll + " deleted.");
    }

    // 5. Search by Roll Number
    public void searchByRollNumber(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Student Found: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll No " + roll + " not found.");
    }

    // 6. Display all students
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records to display.");
            return;
        }

        Student temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // 7. Update grade by Roll Number
    public void updateGrade(int roll, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated for Roll No " + roll);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Roll Number not found.");
    }

    // Main method for testing
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.addAtEnd(101, "Alice", 20, 'A');
        list.addAtBeginning(102, "Bob", 21, 'B');
        list.addAtEnd(103, "Charlie", 19, 'C');
        list.addAtPosition(2, 104, "David", 22, 'B');

        list.displayAll();
        System.out.println();

        list.searchByRollNumber(103);
        list.updateGrade(102, 'A');
        System.out.println();

        list.displayAll();
        System.out.println();

        list.deleteByRollNumber(104);
        list.displayAll();
    }
}
