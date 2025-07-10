class PetrolPump {
    int petrol;
    int distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {

    public static int findStartingPoint(PetrolPump[] pumps) {
        int start = 0;
        int deficit = 0;
        int balance = 0;

        for (int i = 0; i < pumps.length; i++) {
            balance += pumps[i].petrol - pumps[i].distance;

            // If balance is negative, this can't be starting point
            if (balance < 0) {
                start = i + 1;         // Try next pump as start
                deficit += balance;    // Track shortage
                balance = 0;
            }
        }

        return (balance + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(6, 4),
            new PetrolPump(3, 6),
            new PetrolPump(7, 3)
        };

        int startIndex = findStartingPoint(pumps);

        if (startIndex == -1) {
            System.out.println("No possible tour found.");
        } else {
            System.out.println("Start tour from petrol pump index: " + startIndex);
        }
    }
}
