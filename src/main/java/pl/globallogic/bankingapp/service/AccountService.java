package pl.globallogic.bankingapp.service;

import pl.globallogic.bankingapp.dao.AccountDao;
import pl.globallogic.bankingapp.model.Account;

public class AccountService {

    private AccountDao dao;
    public static int accountSavingCounter = 0;

    public AccountService(AccountDao dao) {
        this.dao = dao;
    }

    public Account getAccountById(int accountId) {
        return dao.getAccountById(accountId);
    }

    public void saveAccount(Account account) {
        dao.saveAccount(account);
        accountSavingCounter++;
    }
}
