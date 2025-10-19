package com.dummy.project.domain.client;

public interface ClientRepository {
    
    void saveClient(Client client);

    Client findById(Integer id);

    Client update(Client client);

    void deleteById(Integer id);
}
