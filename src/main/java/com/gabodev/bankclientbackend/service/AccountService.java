package com.gabodev.bankclientbackend.service;

import com.gabodev.bankclientbackend.enums.OperationType;
import com.gabodev.bankclientbackend.model.Account;
import com.gabodev.bankclientbackend.model.Client;
import com.gabodev.bankclientbackend.model.Operation;
import com.gabodev.bankclientbackend.repository.AccountRepository;
import com.gabodev.bankclientbackend.repository.IAccountRepository;
import com.gabodev.bankclientbackend.repository.IClientRepository;
import com.gabodev.bankclientbackend.repository.IOperationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    private final IAccountRepository accountRepository;
    private final IClientRepository clientRepository;
    private final IOperationRepository operationRepository;

    public AccountService(IAccountRepository accountRepository, IClientRepository clientRepository, IOperationRepository operationRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.operationRepository = operationRepository;
    }

    public String init() {
        Client client = new Client(1, "Gabriel", "example@example2.com");
        clientRepository.save(client);
        accountRepository.registerNewClientAccount(client.getClientId());
        Operation operation = new Operation("1", 100.0, "1", "2","10-10-1999", OperationType.TRANSFER);
        Operation operation1 = new Operation("2", 2000, null, "3","10-11-2000", OperationType.WITHDRAWAL);
        operationRepository.save(operation);
        operationRepository.save(operation1);
        return "Init OK";
    }
    @Override
    public void registerNewClientAccount(Integer clientId) {
        accountRepository.registerNewClientAccount(clientId);
    }

    @Override
    public List<Account> getAccountsByClientId(Integer clientId) {
        return accountRepository.getAccountsByClientId(clientId);
    }

    @Override
    public Account getAccountById(String accountId) {
        return accountRepository.getAccountById(accountId);
    }
    @Override
    public List<Account> getAccountList() {
        return accountRepository.getAccountList();
    }
}
