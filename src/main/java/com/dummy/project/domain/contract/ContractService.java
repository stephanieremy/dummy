package com.dummy.project.domain.contract;

import com.dummy.project.domain.client.ClientService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;
    private final ClientService clientService;

    public ContractService(ContractRepository contractRepository, ClientService clientService) {
        this.contractRepository = contractRepository;
        this.clientService = clientService;
    }

    public void createContract(Contract contract, Integer clientId) {
        var client = clientService.findById(clientId);
        setContractStartDate(contract);
        contractRepository.createContract(contract, client);
    }

    public List<Contract> getContracts(Integer clientId, LocalDateTime updatedDate) {
        var client = clientService.findById(clientId);
        return contractRepository.getContracts(client, updatedDate);
    }

    public Contract updateContract(Integer id, Double costAmount) {
        var contract = contractRepository.getContractById(id)
                .orElseThrow(() -> new ContractNotFoundException("Contract not found !"));
        contract.setCostAmount(costAmount);
        return contractRepository.updateContract(contract);
    }

    public Double getContractAmountSum(Integer clientId) {
        var client = clientService.findById(clientId);
        return contractRepository.getContractAmountSum(client);
    }

    public void updateContracts(List<Contract> contracts) {
        contractRepository.saveAllContracts(contracts);
    }

    private void setContractStartDate(Contract contract) {
        if (contract.getStartDate() == null) {
            contract.setStartDate(LocalDate.now());
        }
    }

    public static class ContractNotFoundException extends RuntimeException {
        public ContractNotFoundException(String message) {
            super(message);
        }
    }
}
