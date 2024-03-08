package com.gabodev.bankclientbackend.service;

import com.gabodev.bankclientbackend.model.Account;

import java.util.List;
import java.util.ArrayList;

public interface IAccountService {
    String init();
    List<Account> getAccountsByClientId(Integer clientId);
    Account getAccountById(String accountId);
    void registerNewClientAccount(Integer clientId);
    List<Account> getAccountList();

}
