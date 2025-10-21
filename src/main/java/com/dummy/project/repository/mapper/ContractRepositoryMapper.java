package com.dummy.project.repository.mapper;

import com.dummy.project.domain.contract.Contract;
import com.dummy.project.repository.contract.ContractEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractRepositoryMapper {
    ContractEntity toContractEntity(Contract contract);

    Contract toContract(ContractEntity contractEntity);

    List<Contract> toContracts(List<ContractEntity> contractEntities);


    List<ContractEntity> toContractEntities(List<Contract> contracts);
}
