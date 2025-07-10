interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class InPatient extends Patient implements MedicalRecord {
    public InPatient(String patientId, String name, int age) {
        super(patientId, name, age);
    }

    public double calculateBill() {
        return 5000;
    }

    public void addRecord(String record) {}

    public void viewRecords() {}
}

class OutPatient extends Patient implements MedicalRecord {
    public OutPatient(String patientId, String name, int age) {
        super(patientId, name, age);
    }

    public double calculateBill() {
        return 1000;
    }

    public void addRecord(String record) {}

    public void viewRecords() {}
}

public class HospitalSystem {
    public static void main(String[] args) {
        Patient[] patients = new Patient[] {
            new InPatient("P101", "John Doe", 45),
            new OutPatient("P202", "Jane Smith", 30)
        };

        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Bill Amount: " + p.calculateBill());
            System.out.println();
        }
    }
}
