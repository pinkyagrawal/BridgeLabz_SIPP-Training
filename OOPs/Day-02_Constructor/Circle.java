public class Circle {
    double radius;

    public Circle() {
        this(1.0); 
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.display();
        Circle c2 = new Circle(5.5); 
        c2.display();
    }
}