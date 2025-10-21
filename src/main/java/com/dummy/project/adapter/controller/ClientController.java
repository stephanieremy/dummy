package com.dummy.project.adapter.controller;

import com.dummy.project.adapter.dto.ClientCreateDTO;
import com.dummy.project.adapter.dto.ClientDTO;
import com.dummy.project.adapter.dto.ClientUpdateDTO;
import com.dummy.project.adapter.mapper.ClientMapper;
import com.dummy.project.domain.client.ClientContractService;
import com.dummy.project.domain.client.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("clients")
public class ClientController {

    private final ClientService clientService;
    private final ClientContractService clientContractService;
    private final ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientContractService clientContractService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientContractService = clientContractService;
        this.clientMapper = clientMapper;
    }

    @GetMapping("{id}")
    public ClientDTO getClient(@PathVariable Integer id) {
        return clientMapper.toClientDTO(clientService.findById(id));
    }

    @PutMapping()
    public void createClient(@RequestBody @Valid ClientCreateDTO clientCreateDTO) {
        clientService.create(clientMapper.toClient(clientCreateDTO));
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientContractService.deleteById(id);
    }

    @PatchMapping("{id}")
    public ClientDTO updateClient(@RequestBody ClientUpdateDTO clientUpdateDTO, @PathVariable Integer id) {
        return clientMapper.toClientDTO(clientService.update(clientMapper.toClient(clientUpdateDTO, id)));
    }

    @ExceptionHandler(ClientService.InvalidClientException.class)
    public ResponseEntity<String> handleException(ClientService.InvalidClientException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error as occurred.");
    }
    
}
