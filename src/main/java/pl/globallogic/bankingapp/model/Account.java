package pl.globallogic.bankingapp.model;

public class Account {
    protected final String accountNumber;
    protected final int id;
    protected double balance;

    public Account(int id, String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.id = id;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
