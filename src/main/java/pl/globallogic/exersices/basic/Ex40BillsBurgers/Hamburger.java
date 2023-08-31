package pl.globallogic.exersices.basic.Ex40BillsBurgers;

public class Hamburger {
    private String name, addition1Name, addition2Name, addition3Name, addition4Name;
    private String meat;
    private double price, addition1Price, addition2Price, addition3Price, addition4Price;
    private String breadRollType;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
    }

    public void addHamburgerAddition1(String addition, double price) {
        this.addition1Name = addition;
        this.addition1Price = price;
    }

    public void addHamburgerAddition2(String addition, double price) {
        this.addition2Name = addition;
        this.addition2Price = price;
    }

    public void addHamburgerAddition3(String addition, double price) {
        this.addition3Name = addition;
        this.addition3Price = price;
    }

    public void addHamburgerAddition4(String addition, double price) {
        this.addition4Name = addition;
        this.addition4Price = price;
    }

    public double itemizeHamburger() {
        double totalPrice = price;
        System.out.println(name + " hamburger on a " + breadRollType + " roll with " + meat + ", price is " + price);
        if (addition1Name != null) {
            System.out.println("Added " + addition1Name + " for an extra " + addition1Price);
            totalPrice += addition1Price;
        }
        if (addition2Name != null) {
            System.out.println("Added " + addition2Name + " for an extra " + addition2Price);
            totalPrice += addition2Price;
        }
        if (addition3Name != null) {
            System.out.println("Added " + addition3Name + " for an extra " + addition3Price);
            totalPrice += addition3Price;
        }
        if (addition4Name != null) {
            System.out.println("Added " + addition4Name + " for an extra " + addition4Price);
            totalPrice += addition4Price;
        }
        return totalPrice;
    }
}
