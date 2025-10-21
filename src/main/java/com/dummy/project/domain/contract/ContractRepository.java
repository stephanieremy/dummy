package com.dummy.project.domain.contract;

import com.dummy.project.domain.client.Client;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ContractRepository {
    void createContract(Contract contract, Client client);

    List<Contract> getContracts(Client client, LocalDateTime updatedDate);

    Double getContractAmountSum(Client client);

    Contract updateContract(Contract contract);

    Optional<Contract> getContractById(Integer id);

    void saveAllContracts(List<Contract> contracts);
}
