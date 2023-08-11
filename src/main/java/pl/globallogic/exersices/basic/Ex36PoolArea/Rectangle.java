package pl.globallogic.exersices.basic.Ex36PoolArea;

public class Rectangle {
    double width;
    double length;

    public Rectangle(double width, double length) {
        this.width = Math.max(0, width);
        this.length = Math.max(0, length);
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getArea() {
        return getLength() * getWidth();
    }
}
