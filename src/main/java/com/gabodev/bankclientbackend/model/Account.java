package com.gabodev.bankclientbackend.model;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Data
public class Account {

    private String accountId;
    private double balance;
    @Getter
    private Integer clientOwner;

    public Account() {
    }

    public Account(String accountId, double balance, Integer clientOwner) {
        this.accountId = accountId;
        this.balance = balance;
        this.clientOwner = clientOwner;
    }

}
