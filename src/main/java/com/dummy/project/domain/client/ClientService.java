package com.dummy.project.domain.client;

import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;


    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(Client client) {
        switch (client.getType()) {
            case PERSON -> verifyPerson(client);
            case COMPANY -> {
                verifyCompany(client);
            }
        }
        clientRepository.saveClient(client);
    }

    private void verifyCompany(Client client) {
        if (client.getCompanyIdentifier() == null) {
            throw new InvalidClientException("Company Identifier is required");
        }
        if (client.getBirthDate() != null) {
            throw new InvalidClientException("Birth Date should be null");
        }
    }

    private void verifyPerson(Client client) {
        if (client.getBirthDate() == null) {
            throw new InvalidClientException("Birth Date is required");
        }
        if (client.getCompanyIdentifier() != null) {
            throw new InvalidClientException("Company Identifier should be null");
        }
    }

    public Client update(Client client) {
        return clientRepository.update(client);
    }

    public Client findById(Integer id) {
        return clientRepository.findById(id).orElseThrow(() -> new InvalidClientException("Client not found !"));
    }

    public void deleteById(Client client) {
        clientRepository.deleteById(client.getId());
    }

    public static class InvalidClientException extends RuntimeException {
        public InvalidClientException(String message) {
            super(message);
        }
    }

}
