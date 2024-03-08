package com.gabodev.bankclientbackend.entity;

import com.gabodev.bankclientbackend.enums.OperationType;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity(name = "operation")
@Table(name = "OPERATIONS")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operationId;
    @Column(name = "AMOUNT", nullable = false)
    private double amount;
    @Column(name = "DESTINATION_ACCOUNT_ID")
    private String destinationAccountId;
    @Column(name = "ORIGIN_ACCOUNT_ID")
    private String originAccountId;
    @Column(name = "DATE", nullable = false)
    private LocalDate date;
    @Column
    @Enumerated(EnumType.STRING)
    private OperationType type;

    public Operation() {
    }

    public Operation(double amount, String destinationAccountId, String originAccountId, LocalDate date, OperationType type) {
        this.amount = amount;
        this.destinationAccountId = destinationAccountId;
        this.originAccountId = originAccountId;
        this.date = date;
        this.type = type;
    }
}
