package pl.globallogic.exersices.basic.Ex39Polymorphism;

public class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }

    public String startEngine() {
        return "Car's engine is starting";
    }

    public String accelerate() {
        return "Car is accelerating";
    }

    public String brake() {
        return "Car is braking";
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}
