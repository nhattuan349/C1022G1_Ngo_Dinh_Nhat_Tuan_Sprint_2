package cau_hoi_java.demo2;

public class ShapeCalculation {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        double circleArea = circle.calculateArea();
        System.out.println("Circle area: " + circleArea); // Kết quả: Circle area: 78.53981633974483

        Rectangle rectangle = new Rectangle(4.0, 6.0);
        double rectangleArea = rectangle.calculateArea();
        System.out.println("Rectangle area: " + rectangleArea); // Kết quả: Rectangle area: 24.0
    }
}
