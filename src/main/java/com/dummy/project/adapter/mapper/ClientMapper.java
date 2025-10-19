package com.dummy.project.adapter.mapper;

import com.dummy.project.adapter.dto.ClientCreateDTO;
import com.dummy.project.adapter.dto.ClientDTO;
import com.dummy.project.adapter.dto.ClientUpdateDTO;
import com.dummy.project.domain.client.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toClientDTO(Client client);

    Client toClient(ClientUpdateDTO clientUpdateDTO, Integer id);

    Client toClient(ClientCreateDTO clientCreateDTO);
}
