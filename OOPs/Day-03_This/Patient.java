public class Patient {

    static String hospitalName = "City Care Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients in " + hospitalName + ": " + totalPatients);
    }

    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        } else {
            System.out.println("Invalid patient object.");
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient(1, "Alice", 30, "Flu");
        Patient p2 = new Patient(2, "Bob", 45, "Fracture");

        p1.displayPatientDetails();
        System.out.println();
        p2.displayPatientDetails();
        System.out.println();

        Patient.getTotalPatients();
    }
}