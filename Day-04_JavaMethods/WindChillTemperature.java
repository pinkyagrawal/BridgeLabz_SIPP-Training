import java.util.Scanner;

public class WindChillTemperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the temperature");
        Double temperature = sc.nextDouble();
        System.out.println("Enter the windspeed");
        Double windSpeed = sc.nextDouble();
        System.out.println("Windchill : " + calculateWindChill(temperature,windSpeed));

    }
    public  static double calculateWindChill(double temperature, double windSpeed){
        Double windchill = 35.74 + 0.6215 * temperature + ( 0.4275 * temperature - 35.75 ) * Math.pow(windSpeed,0.16);
        return windchill;
    }
}