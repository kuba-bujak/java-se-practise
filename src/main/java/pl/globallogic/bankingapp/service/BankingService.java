package pl.globallogic.bankingapp.service;

import pl.globallogic.bankingapp.model.Account;

public class BankingService {

    private AccountService accountService;

    public BankingService(AccountService accountService) {
        this.accountService = accountService;
    }

    public BankingService() {

    }
    public void withdraw(int accountId, double amountToWithdraw) {
        Account account = accountService.getAccountById(accountId);
        double currentBalance = account.getBalance();
        if (currentBalance < amountToWithdraw) {
            System.out.println(String.format(
                    "Ammount to withdraw '%s' is greater than account '%s' balance '%s'",
                    amountToWithdraw, account.getAccountNumber(), currentBalance
            ));
            return;
        }
        double newBalance = currentBalance - amountToWithdraw;
        account.setBalance(newBalance);
        accountService.saveAccount(account);
    }
}
