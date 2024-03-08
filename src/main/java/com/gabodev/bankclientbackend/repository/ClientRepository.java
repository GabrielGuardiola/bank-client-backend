package com.gabodev.bankclientbackend.repository;

import com.gabodev.bankclientbackend.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByClientId(Integer clientId);

    Client findByClientEmail(String ClientEmail);
}