package pl.globallogic.exersices.basic.Ex39Polymorphism;

public class Holden extends Car{
    Holden(int cylinders, String name) {
        super(cylinders, name);
    }

    public String startEngine() {
        return "Holden's engine is starting";
    }

    public String accelerate() {
        return "Holden is accelerating";
    }

    public String brake() {
        return "Holden is braking";
    }
}
