package com.gabodev.bankclientbackend.dto;

import lombok.Data;

@Data
public class TransferAmountToAnotherAccountRequest {
    private String sourceIBAN;
    private String targetIBAN;
    private double amount;
}
