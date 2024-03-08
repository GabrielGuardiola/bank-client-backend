package com.gabodev.bankclientbackend.repository;

import com.gabodev.bankclientbackend.model.Client;

public interface IClientRepository {
    Client getClientById(Integer clientId);
    void save(Client client);

}
