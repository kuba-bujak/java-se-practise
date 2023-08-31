package pl.globallogic.bankingapp;

import pl.globallogic.bankingapp.dao.AccountDao;
import pl.globallogic.bankingapp.enums.TransactionType;
import pl.globallogic.bankingapp.model.Account;
import pl.globallogic.bankingapp.service.AccountService;
import pl.globallogic.bankingapp.service.BankingService;

public class BankingAppRunner {
    public static void main(String[] args) {
        final AccountDao accountDao = new AccountDao();
        final AccountService accountService = new AccountService(accountDao);
        final BankingService service = new BankingService(accountService);
        int accountId = 1;
        //Withdraw test - happy path
        service.withdraw(accountId, 100.00);
        final Account testAccountForWithdrawHP = accountService.getAccountById(1);
        double expectedBalanceAfterWithdraw = 180.00;
        System.out.println(testAccountForWithdrawHP.getBalance() == expectedBalanceAfterWithdraw);
        //Save account test - happy path
        final Account saveAccountTestHP = accountService.getAccountById(1);
        System.out.println(saveAccountTestHP.getBalance() == expectedBalanceAfterWithdraw);
        //Withdraw test - edge case ( amount > balance )
        double amount = 200.50;
        service.withdraw(accountId, amount);
        final Account accountForWithdrawEC = accountService.getAccountById(1);
        System.out.println(accountForWithdrawEC.getBalance() == expectedBalanceAfterWithdraw);
        //deposit test - happy path
        double amountToDeposit = 500.00;
        service.depositTo(accountId, amountToDeposit);
        final Account accountDepositTest = accountService.getAccountById(1);
        System.out.println(accountDepositTest.getBalance() == 680.00);
        //transfer test - happy path
        double amountToTransfer = 100.00;
        int accountFromId = 3;
        int accountToId = 2;
        service.transfer(accountFromId, accountToId, amountToTransfer);
        final Account acc1 = accountService.getAccountById(3);
        final Account acc2 = accountService.getAccountById(2);
        System.out.println(acc1.getBalance() == 180.00);
        System.out.println(acc2.getBalance() == 400.00);
        //transfer test - edge case
        String type = "MONEY_DEPOSIT";
        TransactionType typeEnum = TransactionType.valueOf(type);
    }
}
