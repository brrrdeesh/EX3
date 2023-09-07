import java.util.Scanner;

class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        this.color = "unknown";
        this.filled = false;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Shape [color=" + color + ", filled=" + filled + "]";
    }
}

class Circle extends Shape {
    private double radius;

    public Circle() {
        super();
        this.radius = 1.0;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle [color=" + getColor() + ", filled=" + isFilled() + ", radius=" + radius + "]";
    }
}

class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
        super();
        this.width = 1.0;
        this.length = 1.0;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle [color=" + getColor() + ", filled=" + isFilled() + ", width=" + width + ", length=" + length + "]";
    }
}

class Square extends Rectangle {
    public Square() {
        super();
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public double getSide() {
        return getWidth(); 
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

  
    public void setWidth(double width) {
        setSide(width); 
    }

    @Override
    public void setLength(double length) {
        setSide(length); 
    }

    @Override
    public String toString() {
        return "Square [color=" + getColor() + ", filled=" + isFilled() + ", side=" + getSide() + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Shape object using the no-argument constructor
        Shape shape = new Shape();
        System.out.println("Created Shape: " + shape);

        // Create a Circle object using the parameterized constructor
        System.out.print("Enter the color of the circle: ");
        String circleColor = scanner.nextLine();
        System.out.print("Is the circle filled? (true/false): ");
        boolean circleFilled = scanner.nextBoolean();
        System.out.print("Enter the radius of the circle: ");
        double circleRadius = scanner.nextDouble();
        Circle circle = new Circle(circleColor, circleFilled, circleRadius);
        System.out.println("Created Circle: " + circle);
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());

        // Create a Rectangle object using the parameterized constructor
        System.out.print("Enter the color of the rectangle: ");
        String rectangleColor = scanner.nextLine(); // Consume the previous newline
        rectangleColor = scanner.nextLine();
        System.out.print("Is the rectangle filled? (true/false): ");
        boolean rectangleFilled = scanner.nextBoolean();
        System.out.print("Enter the width of the rectangle: ");
        double rectangleWidth = scanner.nextDouble();
        System.out.print("Enter the length of the rectangle: ");
        double rectangleLength = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(rectangleColor, rectangleFilled, rectangleWidth, rectangleLength);
        System.out.println("Created Rectangle: " + rectangle);
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());

        // Create a Square object using the parameterized constructor
        System.out.print("Enter the color of the square: ");
        String squareColor = scanner.nextLine(); // Consume the previous newline
        squareColor = scanner.nextLine();
        System.out.print("Is the square filled? (true/false): ");
        boolean squareFilled = scanner.nextBoolean();
        System.out.print("Enter the side length of the square: ");
        double squareSide = scanner.nextDouble();
        Square square = new Square(squareColor, squareFilled, squareSide);
        System.out.println("Created Square: " + square);
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter());

        // Close the scanner
        scanner.close();
    }
}
