package com.dummy.project.adapter.mapper;

import com.dummy.project.adapter.dto.ContractDTO;
import com.dummy.project.adapter.dto.CostAmountDTO;
import com.dummy.project.domain.contract.Contract;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    ContractDTO toContractDTO(Contract contract);

    Contract toContract(ContractDTO contractDTO);

    List<ContractDTO> toContractDTOList(List<Contract> contracts);

    CostAmountDTO toCostAmountDTO(Double costAmount);
}
