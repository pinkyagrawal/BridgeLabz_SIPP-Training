public class Course {
    String courseName;
    int duration; 
    double fee;
    static String instituteName = "ABC Institute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: ₹" + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 8, 5000);
        Course c2 = new Course("Web Development", 12, 7000);

        c1.displayCourseDetails();
        System.out.println();

        c2.displayCourseDetails();
        System.out.println();

        Course.updateInstituteName("TechSkills Academy");
        System.out.println("Institute name updated.\n");

        c1.displayCourseDetails();
        System.out.println();

        c2.displayCourseDetails();
    }
}