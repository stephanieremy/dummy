package com.dummy.project.domain.contract;

import com.dummy.project.domain.client.Client;

import java.time.LocalDate;
import java.util.List;

public interface ContractRepository {
    void createContract(Contract contract, Client client);

    List<Contract> getContracts(Client client, LocalDate updatedDate);

    Double getContractAmountSum(Client client);

    Contract updateContract(Contract contract);

    Contract getContractById(Integer id);

    void saveAllContracts(List<Contract> contracts);
}
