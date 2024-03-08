package com.gabodev.bankclientbackend.service;

public interface IOperationService {
    void init();
    void depositAmountToClientAccount(String IBAN, double amount);
    void withdrawAmountToClientAccount(String IBAN, double amount);
    void transferAmountToAnotherAccount(String IBANOrigin, String IBANDestiny, double amount);
}
