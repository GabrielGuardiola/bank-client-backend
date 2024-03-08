package com.gabodev.bankclientbackend.model;

import lombok.Data;
import lombok.Getter;

@Data
public class Client {
    @Getter
    private Integer clientId;
    private String clientName;
    private String clientEmail;

    public Client() {
    }

    public Client(Integer clientId, String clientName, String clientEmail) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

}
