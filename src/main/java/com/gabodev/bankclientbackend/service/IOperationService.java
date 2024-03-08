package com.gabodev.bankclientbackend.service;

import com.gabodev.bankclientbackend.entity.Operation;

import java.util.List;

public interface IOperationService {
    void init();
    void depositAmountToClientAccount(String IBAN, double amount, Integer clientId);
    void withdrawAmountToClientAccount(String IBAN, double amount, Integer clientId);
    void transferAmountToAnotherAccount(String IBANOrigin, String IBANDestiny, double amount);
    List<Operation> getOperationsByAccountId(String IBAN);
}
