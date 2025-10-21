package com.dummy.project.domain.client;

import com.dummy.project.domain.contract.ContractService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ContractService contractService;

    public ClientService(ClientRepository clientRepository, ContractService contractService) {
        this.clientRepository = clientRepository;
        this.contractService = contractService;
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
        return clientRepository.findById(id);
    }

    public void deleteById(Integer id) {
        var contracts = contractService.getContracts(id, null);
        contracts.forEach(contract -> contract.setEndDate(LocalDate.now()));
        contractService.updateContracts(contracts);
        clientRepository.deleteById(id);
    }

    public static class InvalidClientException extends RuntimeException {
        public InvalidClientException(String message) {
            super(message);
        }
    }

}
