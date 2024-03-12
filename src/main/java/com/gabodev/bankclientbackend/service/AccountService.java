package com.gabodev.bankclientbackend.service;

import com.gabodev.bankclientbackend.entity.Account;
import com.gabodev.bankclientbackend.entity.Client;
import com.gabodev.bankclientbackend.repository.*;
import com.gabodev.bankclientbackend.utils.LogUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public AccountService(AccountRepository accountRepository, ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    public void init() {
        Client client = new Client("Gabriel", "example@example2.com");
        Client client1 = new Client("Gaben", "example@valvesoftware.com");
        clientRepository.save(client);
        clientRepository.save(client1);
        this.registerNewClientAccount(clientRepository.findByClientEmail("example@example2.com").getClientId());
        this.registerNewClientAccount(clientRepository.findByClientEmail("example@valvesoftware.com").getClientId());
        LogUtils.logInfo("Accounts initialized");
    }
    @Override
    public void registerNewClientAccount(Integer clientId) {
        Account newAccount = new Account(String.valueOf(UUID.randomUUID()), 0, clientId);
        accountRepository.save(newAccount);
    }

    @Override
    public List<Account> getAccountsByClientId(Integer clientId) {
        System.out.println("GET /api/accounts/{clientId} triggered");
        return accountRepository.findByClientOwner(clientId);
    }

    @Override
    public Account getAccountById(String accountId) {
        System.out.println("GET /api/accounts/{accountId}");
        return accountRepository.findByIBAN(accountId);
    }
    @Override
    public List<Account> getAccountList() {
        List<Account> fetchedAccounts = accountRepository.findAll();
        System.out.println("GET /api/accounts/all triggered");
        return fetchedAccounts;
    }
}
