package pl.globallogic.bankingapp.dao;

import pl.globallogic.bankingapp.model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccountDao {

    //ArrayList<Account> accounts = new ArrayList<>();
    Map<Integer, Account> accounts = new HashMap<>();

    public AccountDao() {
        accounts.put(1, new Account(1, "000001", 280.00));
        accounts.put(2, new Account(2, "000002", 300.00));
        accounts.put(3, new Account(3, "000003", 280.00));
    }

    public Account getAccountById(int accountId) {
        return accounts.get(accountId);
    }

    public void saveAccount(Account account) {
        accounts.put(account.getId(), account);
    }
}
