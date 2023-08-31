package pl.globallogic.exersices.basic.Ex40BillsBurgers;

public class HealthyBurger extends Hamburger {
    private String healthyExtra1Name, healthyExtra2Name;
    private double healthyExtra1Price, healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy Burger", meat, price, "Brown Rye");
    }

    public void addHealthyAddition1(String addition, double price) {
        this.healthyExtra1Name = addition;
        this.healthyExtra1Price = price;
    }

    public void addHealthyAddition2(String addition, double price) {
        this.healthyExtra2Name = addition;
        this.healthyExtra2Price = price;
    }

    public double itemizeHamburger() {
        double totalPrice = super.itemizeHamburger();
        if (healthyExtra1Name != null) {
            System.out.println("Added " + healthyExtra1Name + " for an extra " + healthyExtra1Price);
            totalPrice += healthyExtra1Price;
        }
        if (healthyExtra2Name != null) {
            System.out.println("Added " + healthyExtra2Name + " for an extra " + healthyExtra2Price);
            totalPrice += healthyExtra2Price;
        }
        return totalPrice;
    }
}
