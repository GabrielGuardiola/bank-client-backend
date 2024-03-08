package com.gabodev.bankclientbackend.service;

import com.gabodev.bankclientbackend.entity.Account;

import java.util.List;

public interface IAccountService {
    void init();
    List<Account> getAccountsByClientId(Integer clientId);
    Account getAccountById(String accountId);
    void registerNewClientAccount(Integer clientId);
    List<Account> getAccountList();

}
