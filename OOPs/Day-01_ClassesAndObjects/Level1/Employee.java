public class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name       : " + name);
        System.out.println("Salary     : ₹" + salary);
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Pankaj Pandey", 101, 55000.0);

        emp1.displayDetails();
    }
}