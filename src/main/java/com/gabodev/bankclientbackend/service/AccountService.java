package com.gabodev.bankclientbackend.service;

import com.gabodev.bankclientbackend.enums.OperationType;
import com.gabodev.bankclientbackend.model.Account;
import com.gabodev.bankclientbackend.model.Client;
import com.gabodev.bankclientbackend.model.Operation;
import com.gabodev.bankclientbackend.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;
    private final IOperationRepository operationRepository;

    public AccountService(AccountRepository accountRepository, ClientRepository clientRepository, IOperationRepository operationRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.operationRepository = operationRepository;
    }

    public String init() {
        Client client = new Client("Gabriel", "example@example2.com");
        clientRepository.save(client);
        this.registerNewClientAccount(clientRepository.findByClientEmail("example@example2.com").getClientId());
        Operation operation = new Operation("1", 100.0, "1", "2","10-10-1999", OperationType.TRANSFER);
        Operation operation1 = new Operation("2", 2000, null, "3","10-11-2000", OperationType.WITHDRAWAL);
        operationRepository.save(operation);
        operationRepository.save(operation1);
        return "Init OK";
    }
    @Override
    @Transactional
    public void registerNewClientAccount(Integer clientId) {
        Account newAccount = new Account(String.valueOf(UUID.randomUUID()), 0, clientId);
        accountRepository.save(newAccount);
    }

    @Override
    public List<Account> getAccountsByClientId(Integer clientId) {
        System.out.println("/api/accounts/{clientId} triggered: " + accountRepository.findByClientOwner(clientId));
        return accountRepository.findByClientOwner(clientId);
    }

    @Override
    public Account getAccountById(String accountId) {
        System.out.println("/api/accounts/{accountId} triggered: " + accountRepository.findByIBAN(accountId));
        return accountRepository.findByIBAN(accountId);
    }
    @Override
    public List<Account> getAccountList() {
        List<Account> fetchedAccounts = accountRepository.findAll();
        System.out.println("/api/accounts/all triggered: " + fetchedAccounts.get(0).getIBAN());
        return fetchedAccounts;
    }
}
