package com.gabodev.bankclientbackend.model;

import com.gabodev.bankclientbackend.enums.OperationType;
import lombok.Data;

@Data
public class Operation {
    private String operationId;
    private double amount;
    private String destinationAccountId;
    private String originAccountId;

    private String date;

    private OperationType type;

    public Operation(String operationId, double amount, String destinationAccountId, String originAccountId, String date, OperationType type) {
        this.operationId = operationId;
        this.amount = amount;
        this.destinationAccountId = destinationAccountId;
        this.originAccountId = originAccountId;
        this.date = date;
        this.type = type;
    }
}
