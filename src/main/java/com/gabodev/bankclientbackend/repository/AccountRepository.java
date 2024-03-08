package com.gabodev.bankclientbackend.repository;

import com.gabodev.bankclientbackend.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepository implements IAccountRepository {

    private final List<Account> accountList = new ArrayList<>();

    public AccountRepository() {
    }
    @Override
    public Account getAccountById(String accountId) {
        for(Account account : accountList) {
            if(account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }
    @Override
    public List<Account> getAccountsByClientId(Integer clientId) {
        List<Account> accounts = new ArrayList<>();
        for(Account account : accountList) {
            if(account.getClientOwner().equals(clientId)) {
                accounts.add(account);
            }
            System.out.println("Account list Client: " + accounts);
        }
        return accounts;
    }
    @Override
    public void registerNewClientAccount(Integer clientId) {
        Account newAccount = new Account(String.valueOf(accountList.size() + 1), 0, clientId);
        accountList.add(newAccount);
        System.out.println("Account list: " + accountList);
    }

    @Override
    public List<Account> getAccountList() {
        return accountList;
    }


}
