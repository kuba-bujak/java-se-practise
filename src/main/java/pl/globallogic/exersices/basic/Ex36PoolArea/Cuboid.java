package pl.globallogic.exersices.basic.Ex36PoolArea;

public class Cuboid extends Rectangle {
    double height;

    public Cuboid(double width, double length, double height) {
        super(width, length);
        this.height = Math.max(0, height);
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return getArea() * getHeight();
    }
}
