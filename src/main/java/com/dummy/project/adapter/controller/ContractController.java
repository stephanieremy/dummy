package com.dummy.project.adapter.controller;

import com.dummy.project.adapter.dto.ContractDTO;
import com.dummy.project.adapter.mapper.ContractMapper;
import com.dummy.project.domain.contract.ContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController()
@RequestMapping(path = "/contracts")
public class ContractController {

    private final ContractService contractService;
    private final ContractMapper contractMapper;

    public ContractController(ContractService contractService, ContractMapper contractMapper) {
        this.contractService = contractService;
        this.contractMapper = contractMapper;
    }

    @PutMapping("/{clientId}")
    public void createContract(@RequestBody ContractDTO contractDTO, @PathVariable Integer clientId) {
        contractService.createContract(contractMapper.toContract(contractDTO), clientId);
    }

    @RequestMapping(value = {"/{clientId}/{updatedDate}", "{clientId}"}, method = RequestMethod.GET)
    public List<ContractDTO> getContractByClient(@PathVariable Integer clientId, @PathVariable(required = false) LocalDate updatedDate) {
        return contractMapper.toContractDTOList(contractService.getContracts(clientId, updatedDate));
    }

    @GetMapping("/sum/{clientId}")
    public Double getContractAmountSumByClient(@PathVariable Integer clientId) {
        return contractService.getContractAmountSum(clientId);
    }

    @PatchMapping("/{id}/{costAmount}")
    public ContractDTO updateContract(@PathVariable Integer id, @PathVariable Double costAmount) {
        return contractMapper.toContractDTO(contractService.updateContract(id, costAmount));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error as occurred.");
    }
}
