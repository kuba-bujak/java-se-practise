package pl.globallogic.bankingapp.service;

import pl.globallogic.bankingapp.model.Account;

public class BankingService {
    public void withdraw(Account account, double ammountToWithdraw) {
        double currentBalance = account.getBalance();
        if (currentBalance < ammountToWithdraw) {
            System.out.println(String.format(
                    "Ammount to withdraw '%s' is greater than account '%s' balance '%s'",
                    ammountToWithdraw, account.getAccountNumber(), currentBalance
            ));
        }
        double newBalance = currentBalance - ammountToWithdraw;
        account.setBalance(newBalance);
    }
}
