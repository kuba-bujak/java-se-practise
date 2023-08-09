package pl.globallogic.bankingapp;

import pl.globallogic.bankingapp.dao.AccountDao;
import pl.globallogic.bankingapp.model.Account;
import pl.globallogic.bankingapp.service.AccountService;
import pl.globallogic.bankingapp.service.BankingService;

public class BankingAppRunner {
    public static void main(String[] args) {
        final AccountDao accountDao = new AccountDao();
        final AccountService accountService = new AccountService();
        final BankingService service = new BankingService();
        int accountId = 1;
        //Withdraw test
        service.withdraw(accountId, 100.00);
        final Account acc1 = accountService.getAccountById(1);
        double expectedBalanceAfterWithdraw = 900.00;
        System.out.println(acc1.getBalance() == expectedBalanceAfterWithdraw);
        //Save account test
        accountService.saveAccount(acc1);
        final Account acc2 = accountService.getAccountById(1);
        System.out.println(acc1.getBalance() == expectedBalanceAfterWithdraw);
        //Withdraw test
        double amountToWithdraw = 2000.20;
        service.withdraw(accountId, amountToWithdraw);
        final Account acc3 = accountService.getAccountById(1);
        System.out.println(acc3.getBalance() == expectedBalanceAfterWithdraw);
    }
}
