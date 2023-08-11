package pl.globallogic.exersices.basic;

public class Ex31WallArea {
    double width;
    double height;

    public Ex31WallArea() {}

    public Ex31WallArea(double width, double height) {
        this.width = Math.max(0, width);
        this.height = Math.max(0, height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = Math.max(0, height);
    }

    public void setWidth(double width) {
        this.width = Math.max(0, width);
    }

    public double getArea() {
        return getHeight() * getWidth();
    }

    public static void main(String[] args) {
        Ex31WallArea wall = new Ex31WallArea(5,4);
        System.out.println("area= " + wall.getArea());
        wall.setHeight(-1.5);
        System.out.println("width= " + wall.getWidth());
        System.out.println("height= " + wall.getHeight());
        System.out.println("area= " + wall.getArea());

    }


}
