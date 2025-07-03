public class PensDivision {
    public static void main(String[] args) {
        int totalPens = 14;
        int students = 3;
        int perStudent = totalPens / students;
        int remaining = totalPens % students;

        System.out.println("The Pen Per Student is " + perStudent + " and the remaining pen not distributed is " + remaining);
    }
}
