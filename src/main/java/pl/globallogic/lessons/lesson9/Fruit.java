package pl.globallogic.lessons.lesson9;

public class Fruit {
    private String name;
    private String country;
    private double wage;

    Fruit(String name, String country, double wage) {
        this.name = name;
        this.country = country;
        this.wage = wage;
    }

    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", origin='" + country + '\'' +
                ", wage=" + wage +
                '}';
    }
}
