package pl.globallogic.bankingapp.model;

public class Account {
    public final String accountNumber;
    public final int id;
    public double balance;

    public Account(int id, String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.id = id;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Balance can't be negative");
            return;
        }
        this.balance = balance;
    }
}
