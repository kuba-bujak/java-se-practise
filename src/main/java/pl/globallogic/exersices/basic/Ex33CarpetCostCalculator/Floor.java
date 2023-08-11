package pl.globallogic.exersices.basic.Ex33CarpetCostCalculator;

public class Floor {
    private double width;
    private double length;

    public Floor(double width, double length) {
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
        return getWidth() * getLength();
    }
}
