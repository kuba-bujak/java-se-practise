package pl.globallogic.exersices.basic.Ex40BillsBurgers;

public class DeluxeBurger extends Hamburger {
    public DeluxeBurger() {
        super("Deluxe Burger", "Sausage & Bacon", 14.54, "White");
        super.addHamburgerAddition1("Chips", 2.75);
        super.addHamburgerAddition2("Drink", 1.81);
    }

    @Override
    public void addHamburgerAddition1(String addition, double price) {
        System.out.println("Cannot add additional items to a deluxe burger.");
    }
    public void addHamburgerAddition2(String addition, double price) {
        System.out.println("Cannot add additional items to a deluxe burger.");
    }
    public void addHamburgerAddition3(String addition, double price) {
        System.out.println("Cannot add additional items to a deluxe burger.");
    }
    public void addHamburgerAddition4(String addition, double price) {
        System.out.println("Cannot add additional items to a deluxe burger.");
    }
}
