package com.dummy.project.repository.contract;

import com.dummy.project.domain.client.Client;
import com.dummy.project.domain.contract.Contract;
import com.dummy.project.domain.contract.ContractRepository;
import com.dummy.project.repository.mapper.ClientRepositoryMapper;
import com.dummy.project.repository.mapper.ContractRepositoryMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ContractRepositoryAdaptor implements ContractRepository {

    private final ContractJpaRepository contractJpaRepository;
    private final ContractRepositoryMapper contractRepositoryMapper;
    private final ClientRepositoryMapper clientRepositoryMapper;

    public ContractRepositoryAdaptor(ContractJpaRepository contractJpaRepository, ContractRepositoryMapper contractRepositoryMapper, ClientRepositoryMapper clientRepositoryMapper) {
        this.contractJpaRepository = contractJpaRepository;
        this.contractRepositoryMapper = contractRepositoryMapper;
        this.clientRepositoryMapper = clientRepositoryMapper;
    }

    @Override
    public void createContract(Contract contract, Client client) {

        var contractEntity = contractRepositoryMapper.toContractEntity(contract);
        var clientEntity = clientRepositoryMapper.clientToClientEntity(client);
        contractEntity.setClient(clientEntity);
        contractJpaRepository.save(contractEntity);
    }

    @Override
    public List<Contract> getContracts(Client client, LocalDate updatedDate) {
        return contractRepositoryMapper.toContracts(contractJpaRepository.findByClientId(clientRepositoryMapper.clientToClientEntity(client), updatedDate));
    }

    @Override
    public Double getContractAmountSum(Client client) {
        return contractJpaRepository.getContractAmountSum(clientRepositoryMapper.clientToClientEntity(client));
    }

    @Override
    public Contract updateContract(Contract contract) {
        contractJpaRepository.findById(contract.getId()).orElseThrow(() -> new RuntimeException("Contract not found"));
        var updatedContract = contractJpaRepository.save(contractRepositoryMapper.toContractEntity(contract));
        return contractRepositoryMapper.toContract(updatedContract);
    }

    @Override
    public Contract getContractById(Integer id) {
        contractJpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Contract not found"));
        return contractRepositoryMapper.toContract(contractJpaRepository.findById(id).get());
    }

    @Override
    public void saveAllContracts(List<Contract> contracts) {
        contractJpaRepository.saveAll(contractRepositoryMapper.toContractEntities(contracts));
    }
}
