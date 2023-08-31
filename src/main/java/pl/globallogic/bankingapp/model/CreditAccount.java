package pl.globallogic.bankingapp.model;

public class CreditAccount extends Account {

    private double creditRate;

    private int periodInMonth;

    public CreditAccount(int id, String accountNumber, double balance, double creditRate, int periodInMonth) {
        super(id, accountNumber, balance);
        this.creditRate = creditRate;
        this.periodInMonth = periodInMonth;
    }

    public double getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(double creditRate) {
        this.creditRate = creditRate;
    }

    public int getPeriodInMonth() {
        return periodInMonth;
    }

    public void setPeriodInMonth(int periodInMonth) {
        this.periodInMonth = periodInMonth;
    }
}
