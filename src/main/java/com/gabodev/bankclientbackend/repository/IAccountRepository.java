package com.gabodev.bankclientbackend.repository;

import com.gabodev.bankclientbackend.model.Account;

import java.util.List;

public interface IAccountRepository {
    Account getAccountById(String accountId);
    List<Account> getAccountsByClientId(Integer clientId);
    void registerNewClientAccount(Integer clientId);
    List<Account> getAccountList();
}
