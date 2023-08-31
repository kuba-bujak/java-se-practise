package pl.globallogic.bankingapp.service;

import pl.globallogic.bankingapp.model.Account;

public class BankingService {

    private AccountService accountService;

    public BankingService(AccountService accountService) {
        this.accountService = accountService;
    }

    public BankingService() {

    }

    public void withdraw(int accountId, double amountToWithdraw){
        if(validateAmount(amountToWithdraw)){
            Account account = accountService.getAccountById(accountId);
            processWithdraw(amountToWithdraw, account);
            accountService.saveAccount(account);
        }
    }

    private boolean validateAmount(double amountToWithdraw) {
        return amountToWithdraw > 0;
    }

    private static void processWithdraw(double amountToWithdraw, Account account) {
        double currentBalance = account.getBalance();
        if (currentBalance < amountToWithdraw) {
            logInvalidWithdraw(amountToWithdraw, account, currentBalance);
            return;
        }
        double newBalance = currentBalance - amountToWithdraw;
        account.setBalance(newBalance);
    }

    private static void logInvalidWithdraw(double amountToWithdraw, Account account, double currentBalance) {
        System.out.println(String.format(
                "Amount to withdraw '%s' is greater than account '%s' balance '%s'",
                amountToWithdraw, account.getAccountNumber(), currentBalance));
    }

    public void depositTo(int accountId, double amountToDeposit) {
        Account account = accountService.getAccountById(accountId);
        double currentBalance = account.getBalance();
        if (amountToDeposit > 0){
            account.setBalance(currentBalance + amountToDeposit);
        }
        accountService.saveAccount(account);
        //transactionService.saveTransaction(new Transaction(accountId, amountToDeposit, DEPOSIT))
    }

    public void transfer(int accountFromId, int accountToId, double amountToTransfer) {
        withdraw(accountFromId, amountToTransfer);
        depositTo(accountToId, amountToTransfer);
    }
}
