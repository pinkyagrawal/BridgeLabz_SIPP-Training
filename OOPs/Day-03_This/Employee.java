public class Employee {

    static String companyName = "Tech Solutions Ltd.";
    private static int totalEmployees = 0;

    private final int id;
    private String name;
    private String designation;

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees in " + companyName + ": " + totalEmployees);
    }

    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Invalid employee object.");
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Alice", "Developer");
        Employee e2 = new Employee(102, "Bob", "Manager");

        e1.displayEmployeeDetails();
        System.out.println();
        e2.displayEmployeeDetails();
        System.out.println();

        Employee.displayTotalEmployees();
    }
}