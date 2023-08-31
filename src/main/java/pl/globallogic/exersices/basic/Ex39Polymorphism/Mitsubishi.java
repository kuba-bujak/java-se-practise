package pl.globallogic.exersices.basic.Ex39Polymorphism;

public class Mitsubishi extends Car {

    Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    public String startEngine() {
        return "Mitsubishi's engine is starting";
    }

    public String accelerate() {
        return "Mitsubishi is accelerating";
    }

    public String brake() {
        return "Mitsubishi is braking";
    }
}
