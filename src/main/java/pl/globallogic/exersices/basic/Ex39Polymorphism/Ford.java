package pl.globallogic.exersices.basic.Ex39Polymorphism;

public class Ford extends Car{
    Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    public String startEngine() {
        return "Ford's engine is starting";
    }

    public String accelerate() {
        return "Ford is accelerating";
    }

    public String brake() {
        return "Ford is braking";
    }
}
