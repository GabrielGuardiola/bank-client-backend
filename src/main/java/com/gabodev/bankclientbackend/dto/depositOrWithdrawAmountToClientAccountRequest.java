package com.gabodev.bankclientbackend.dto;

import lombok.Data;

@Data
public class depositOrWithdrawAmountToClientAccountRequest {
    private String IBAN;
    private double amount;
    private Integer clientId;
}
