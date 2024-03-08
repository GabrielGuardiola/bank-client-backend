package com.gabodev.bankclientbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "client")
@Table(name = "CLIENTS")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    @Column(name = "CLIENT_NAME", nullable = false)
    private String clientName;
    @Column(name = "CLIENT_EMAIL", nullable = false)
    private String clientEmail;

    public Client() {
    }

    public Client(String clientName, String clientEmail) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

}
