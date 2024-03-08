package com.gabodev.bankclientbackend.entity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "account")
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "IBAN", nullable = false)
    private String IBAN;
    @Column(name = "BALANCE", nullable = false)
    private double balance;
    @Column(name = "CLIENT_OWNER", nullable = false)
    private Integer clientOwner;

    public Account() {
    }

    public Account(String IBAN, double balance, Integer clientOwner) {
        this.IBAN = IBAN;
        this.balance = balance;
        this.clientOwner = clientOwner;
    }
}