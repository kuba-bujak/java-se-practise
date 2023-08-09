package pl.globallogic.bankingapp.model;

public class Account {
    public final String accountNumber;
    public final int id;
    public double balance;

    public Account(String accountNumber, int id, double balance) {
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
        this.balance = balance;
    }
}
