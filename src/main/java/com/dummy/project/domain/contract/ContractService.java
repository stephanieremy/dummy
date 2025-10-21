package com.dummy.project.domain.contract;

import com.dummy.project.domain.client.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;
    private final ClientRepository clientRepository;

    public ContractService(ContractRepository contractRepository, ClientRepository clientRepository) {
        this.contractRepository = contractRepository;
        this.clientRepository = clientRepository;
    }

    public void createContract(Contract contract, Integer clientId) {
        var client = clientRepository.findById(clientId);
        verifyContract(contract);
        contractRepository.createContract(contract, client);
    }

    public List<Contract> getContracts(Integer clientId, LocalDate updatedDate) {
        var client = clientRepository.findById(clientId);
        return contractRepository.getContracts(client, updatedDate);
    }

    public Contract updateContract(Integer id, Double costAmount) {
        var contract = contractRepository.getContractById(id);
        contract.setCostAmount(costAmount);
        return contractRepository.updateContract(contract);
    }

    public Double getContractAmountSum(Integer clientId) {
        var client = clientRepository.findById(clientId);
        return contractRepository.getContractAmountSum(client);
    }

    public void updateContracts(List<Contract> contracts) {
        contractRepository.saveAllContracts(contracts);
    }

    private void verifyContract(Contract contract) {
        if (contract.getStartDate() == null) {
            contract.setStartDate(LocalDate.now());
        }
    }
}
