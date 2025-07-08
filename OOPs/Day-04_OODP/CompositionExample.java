import java.util.*;

class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void displayEmployee() {
        System.out.println("Employee: " + name + ", Role: " + role);
    }
}

class Department {
    private String deptName;
    private List<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }

    public void displayDepartment() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) {
            e.displayEmployee();
        }
        System.out.println();
    }

    public void clearEmployees() {
        employees.clear();
    }
}

class Company {
    private String companyName;
    private List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void displayCompanyStructure() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    public void deleteCompany() {
        for (Department dept : departments) {
            dept.clearEmployees();
        }
        departments.clear();
        System.out.println("Company \"" + companyName + "\" and all its departments and employees have been deleted.");
    }
}

public class CompositionExample {
    public static void main(String[] args) {
        Company company = new Company("TechVision Ltd.");

        Department devDept = new Department("Development");
        devDept.addEmployee("Alice", "Software Engineer");
        devDept.addEmployee("Bob", "Backend Developer");

        Department hrDept = new Department("HR");
        hrDept.addEmployee("Charlie", "HR Manager");

        company.addDepartment(devDept);
        company.addDepartment(hrDept);

        company.displayCompanyStructure();

        company.deleteCompany();
    }
}