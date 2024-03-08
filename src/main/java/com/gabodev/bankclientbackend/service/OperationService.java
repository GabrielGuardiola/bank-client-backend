package com.gabodev.bankclientbackend.service;

import com.gabodev.bankclientbackend.entity.Account;
import com.gabodev.bankclientbackend.enums.OperationType;
import com.gabodev.bankclientbackend.entity.Operation;
import com.gabodev.bankclientbackend.repository.AccountRepository;
import com.gabodev.bankclientbackend.repository.ClientRepository;
import com.gabodev.bankclientbackend.repository.OperationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OperationService implements IOperationService {

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;
    private final OperationRepository operationRepository;

    public OperationService(AccountRepository accountRepository, ClientRepository clientRepository, OperationRepository operationRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.operationRepository = operationRepository;
    }
    @Override
    public void init() {
        depositAmountToClientAccount(accountRepository.findByClientOwner(1).get(0).getIBAN(), 1000.0, 1);
        withdrawAmountToClientAccount(accountRepository.findByClientOwner(1).get(0).getIBAN(), -100.0, 1);
    }

    @Override
    public void depositAmountToClientAccount(String IBAN, double amount, Integer clientId) {
        Operation operation = new Operation(amount, null, IBAN, LocalDate.now(), OperationType.DEPOSIT);
        updateAccountBalance(IBAN, amount);
        System.out.println("POST /api/operations/deposit triggered");
        operationRepository.save(operation);
    }

    @Override
    public void withdrawAmountToClientAccount(String IBAN, double amount, Integer clientId) {
        Operation operation = new Operation(amount, IBAN, null, LocalDate.now(), OperationType.WITHDRAWAL);
        updateAccountBalance(IBAN, amount);
        System.out.println("POST /api/operations/withdraw triggered");
        operationRepository.save(operation);
    }

    @Override
    public void transferAmountToAnotherAccount(String IBANOrigin, String IBANDestiny, double amount) {
        Operation operation = new Operation(amount, IBANOrigin, IBANDestiny, LocalDate.now(), OperationType.TRANSFER);
        updateAccountBalance(IBANOrigin, -amount);
        updateAccountBalance(IBANDestiny, amount);
        System.out.println("POST /api/operations/transfer triggered");
        operationRepository.save(operation);
    }

    private void chargeDifferentBankTransferFee(String IBANOrigin, String IBANDestiny, double amount) {

    }
    private void updateAccountBalance(String IBAN, double amount) {
        Account account = accountRepository.findByIBAN(IBAN);
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
        System.out.println("Account balance of " + IBAN + " updated: " + account.getBalance() + amount + "€.");
    }
    @Override
    public List<Operation> getOperationsByAccountId(String IBAN) {
        List<Operation> operationsList = operationRepository.findByOriginAccountIdOrDestinationAccountId(IBAN, IBAN);
        System.out.println("GET /api/operations/{IBAN} triggered");
        return operationsList;
    }
}
