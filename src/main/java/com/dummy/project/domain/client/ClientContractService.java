package com.dummy.project.domain.client;

import com.dummy.project.domain.contract.ContractService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClientContractService {
    private final ContractService contractService;
    private final ClientService clientService;

    public ClientContractService(ContractService contractService, ClientService clientService) {
        this.contractService = contractService;
        this.clientService = clientService;
    }

    public void deleteById(Integer id) {
        var client = clientService.findById(id);
        var contracts = contractService.getContracts(client.getId(), null);
        contracts.forEach(contract -> contract.setEndDate(LocalDate.now()));
        contractService.updateContracts(contracts);
        clientService.deleteById(client);
    }
}
