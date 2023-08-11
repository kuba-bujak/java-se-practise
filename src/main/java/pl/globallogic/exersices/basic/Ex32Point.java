package pl.globallogic.exersices.basic;

public class Ex32Point {
    int x;
    int y;

    public Ex32Point() {

    }

    public Ex32Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        return Math.sqrt((Math.pow((getX()), 2) + Math.pow(getY(), 2)));
    }

    public double distance(int x, int y) {
        return Math.sqrt((Math.pow(x - getX(), 2) + Math.pow(y - getY(), 2)));
    }

    public double distance(Ex32Point another) {
        return Math.sqrt((Math.pow(another.getX() - getX(), 2) + Math.pow(another.getY() - getY(), 2)));
    }

    public static void main(String[] args) {
        Ex32Point first = new Ex32Point(6, 5);
        Ex32Point second = new Ex32Point(3, 1);
        System.out.println("distance(0,0)= " + first.distance());
        System.out.println("distance(second)= " + first.distance(second));
        System.out.println("distance(2,2)= " + first.distance(2, 2));
        Ex32Point point = new Ex32Point();
        System.out.println("distance()= " + point.distance());

    }
}
