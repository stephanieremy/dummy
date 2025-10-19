package com.dummy.project.adapter.controller;

import com.dummy.project.adapter.dto.ClientCreateDTO;
import com.dummy.project.adapter.dto.ClientDTO;
import com.dummy.project.adapter.dto.ClientUpdateDTO;
import com.dummy.project.adapter.mapper.ClientMapper;
import com.dummy.project.domain.client.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path = "/clients")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @GetMapping("/{id}")
    public ClientDTO getClient(@PathVariable Integer id) {
        return clientMapper.toClientDTO(clientService.findById(id));
    }

    @PutMapping()
    public void createClient(@RequestBody ClientCreateDTO clientCreateDTO) {
        clientService.create(clientMapper.toClient(clientCreateDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id) {
        // TODO : attention aux contrats
        clientService.deleteById(id);
    }

    @PatchMapping("/{id}")
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
