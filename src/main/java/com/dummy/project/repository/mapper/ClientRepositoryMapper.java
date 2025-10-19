package com.dummy.project.repository.mapper;

import com.dummy.project.domain.client.Client;
import com.dummy.project.repository.client.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientRepositoryMapper {

    Client clientEntityToClient(ClientEntity clientEntity);

    ClientEntity clientToClientEntity(Client client);
}
