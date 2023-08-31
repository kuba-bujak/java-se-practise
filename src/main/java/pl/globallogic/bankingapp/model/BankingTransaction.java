package pl.globallogic.bankingapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class BankingTransaction {
    private final LocalDate transactionDate;
    private final String accountNumber;
    private final double amount;
    //refactor to enum
    private final String transactionType;

    public BankingTransaction(LocalDate transactionDate, String accountNumber, double amount, String transactionType) {
        this.transactionDate = transactionDate;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingTransaction that = (BankingTransaction) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(transactionType, that.transactionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionDate, accountNumber, amount, transactionType);
    }

    @Override
    public String toString() {
        return "BankingTransaction{" +
                "transactionDate=" + transactionDate +
                ", accountNumber='" + accountNumber + '\'' +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}
