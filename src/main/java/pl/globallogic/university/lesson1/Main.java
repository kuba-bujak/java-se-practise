package pl.globallogic.university.lesson1;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Ford Fiesta", "black", 2019);
        Car car2 = new Car("Ford Focus", "red", 2022);
        Car car3 = new Car("Opel Astra", "grey", 2000);
        Car car4 = new Car("Opel Insignia", "green", 2010);

        System.out.println(car1);
        System.out.println(car2.getColor());
        car2.setColor("blue");
        System.out.println(car2.getColor());
    }
}
