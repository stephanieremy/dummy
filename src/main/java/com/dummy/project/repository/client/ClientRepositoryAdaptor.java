package com.dummy.project.repository.client;

import com.dummy.project.domain.client.Client;
import com.dummy.project.domain.client.ClientRepository;
import com.dummy.project.repository.mapper.ClientRepositoryMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientRepositoryAdaptor implements ClientRepository {

    private final ClientJpaRepository clientJpaRepository;
    private final ClientRepositoryMapper clientRepositoryMapper;

    public ClientRepositoryAdaptor(ClientJpaRepository clientJpaRepository, ClientRepositoryMapper clientRepositoryMapper) {
        this.clientJpaRepository = clientJpaRepository;
        this.clientRepositoryMapper = clientRepositoryMapper;
    }

    @Override
    public Client findById(Integer id) {
        clientJpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        var createdClient = clientJpaRepository.findById(id).get();
        return clientRepositoryMapper.clientEntityToClient(createdClient);
    }

    @Override
    public Client update(Client client) {
        clientJpaRepository.findById(client.getId()).orElseThrow(() -> new RuntimeException("Client not found"));
        var savedClient = clientJpaRepository.save(clientRepositoryMapper.clientToClientEntity(client));
        return clientRepositoryMapper.clientEntityToClient(savedClient);
    }

    @Override
    public void deleteById(Integer id) {
        clientJpaRepository.deleteById(id);
    }

    @Override
    public void saveClient(Client client) {
        clientJpaRepository.save(clientRepositoryMapper.clientToClientEntity(client));
    }

}
