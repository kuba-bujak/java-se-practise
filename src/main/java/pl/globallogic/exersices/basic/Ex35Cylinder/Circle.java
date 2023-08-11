package pl.globallogic.exersices.basic.Ex35Cylinder;

public class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = Math.max(0, radius);
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }
}
