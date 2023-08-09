package pl.globallogic.bankingapp.dao;

import pl.globallogic.bankingapp.model.Account;

public class AccountDao {
    private Account[] accounts = new Account[20];

    public AccountDao() {
        this.accounts[1] = new Account(1, "352163812", 280);
    }

    public Account getAccountById (int accountId) {
        return accounts[accountId];
    }

    public void saveAccount(Account account) {
        int id = account.getId();
        accounts[id] = account;
    }
}
