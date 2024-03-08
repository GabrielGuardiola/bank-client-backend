package com.gabodev.bankclientbackend.service;

import com.gabodev.bankclientbackend.enums.OperationType;
import com.gabodev.bankclientbackend.entity.Operation;
import com.gabodev.bankclientbackend.repository.AccountRepository;
import com.gabodev.bankclientbackend.repository.ClientRepository;
import com.gabodev.bankclientbackend.repository.OperationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        Operation operation = new Operation(100.0, "1", "1", LocalDate.now(), OperationType.TRANSFER);
        Operation operation1 = new Operation(2000, null, "1",LocalDate.now(), OperationType.WITHDRAWAL);
        operationRepository.save(operation);
        operationRepository.save(operation1);
    }

    @Override
    public void depositAmountToClientAccount(String IBAN, double amount) {

    }

    @Override
    public void withdrawAmountToClientAccount(String IBAN, double amount) {

    }

    @Override
    public void transferAmountToAnotherAccount(String IBANOrigin, String IBANDestiny, double amount) {

    }

    private void chargeDifferentBankTransferFee(String IBANOrigin, String IBANDestiny, double amount) {

    }
}
