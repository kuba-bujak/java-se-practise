package pl.globallogic.exersices.basic.Ex46Banking;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<Double>((int) initialTransaction);
    }

    public String getName() {
        return name;
    }
}
