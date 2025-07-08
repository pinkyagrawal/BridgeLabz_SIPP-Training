import java.util.*;

class Faculty {
    private String name;
    private String subject;

    public Faculty(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void displayFaculty() {
        System.out.println("Faculty: " + name + ", Subject: " + subject);
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String deptName;
    private List<Faculty> facultyList;

    public Department(String deptName) {
        this.deptName = deptName;
        this.facultyList = new ArrayList<>();
    }

    public void assignFaculty(Faculty faculty) {
        facultyList.add(faculty); // Aggregation: using faculty, not creating it
    }

    public void displayDepartment() {
        System.out.println("Department: " + deptName);
        for (Faculty f : facultyList) {
            f.displayFaculty();
        }
        System.out.println();
    }

    public void clearFaculty() {
        facultyList.clear();
    }
}

class University {
    private String universityName;
    private List<Department> departments;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept); // Composition: University owns the departments
    }

    public void showUniversityStructure() {
        System.out.println("University: " + universityName);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    public void deleteUniversity() {
        for (Department dept : departments) {
            dept.clearFaculty(); // Optional cleanup
        }
        departments.clear();
        System.out.println("University \"" + universityName + "\" and all its departments have been deleted.");
    }
}

public class UniversityExample {
    public static void main(String[] args) {
        Faculty f1 = new Faculty("Alice", "Mathematics");
        Faculty f2 = new Faculty("Bob", "Physics");
        Faculty f3 = new Faculty("Charlie", "Computer Science");

        Department mathDept = new Department("Mathematics Department");
        mathDept.assignFaculty(f1);

        Department sciDept = new Department("Science Department");
        sciDept.assignFaculty(f2);
        sciDept.assignFaculty(f3);

        University uni = new University("Global University");
        uni.addDepartment(mathDept);
        uni.addDepartment(sciDept);

        uni.showUniversityStructure();

        uni.deleteUniversity();

        System.out.println("\nFaculty members still exist independently:");
        f1.displayFaculty();
        f2.displayFaculty();
        f3.displayFaculty();
    }
}