package com.gabodev.bankclientbackend.repository;

import com.gabodev.bankclientbackend.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ClientRepository implements IClientRepository {

    private final List<Client> clientList = new ArrayList<>();

    public ClientRepository () {
    }
    @Override
    public Client getClientById(Integer clientId) {

        for(Client client : clientList) {
            if(client.getClientId().equals(clientId)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public void save(Client client) {
        clientList.add(client);
        System.out.println("Client list: " + clientList);
    }


}
