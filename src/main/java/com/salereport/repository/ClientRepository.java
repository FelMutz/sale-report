package com.salereport.repository;

import com.salereport.model.ClientModel;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class ClientRepository {
    @Getter
    private Set<ClientModel> clients;
    @Getter
    private static final ClientRepository clientRepository = new ClientRepository();

    public ClientRepository() {
        this.clients = new HashSet<>();
    }
}
