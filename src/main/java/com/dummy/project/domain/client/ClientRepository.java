package com.dummy.project.domain.client;

import java.util.Optional;

public interface ClientRepository {

    void saveClient(Client client);

    Optional<Client> findById(Integer id);

    Client update(Client client);

    void deleteById(Integer id);
}
