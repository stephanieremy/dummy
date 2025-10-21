package com.dummy.project.domain.client;

import com.dummy.project.repository.mapper.ClientRepositoryMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static com.dummy.project.domain.client.ClientService.InvalidClientException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Spy
    ClientRepositoryMapper clientRepositoryMapper;
    @Mock
    ClientRepository clientRepository;
    @InjectMocks
    ClientService clientService;

    @Test
    void createClient_should_throw_invalid_birthday_if_null_and_person() {
        var client = Client.builder()
                .id(1)
                .name("name")
                .email("email")
                .type(Client.ClientType.PERSON)
                .birthDate(null)
                .companyIdentifier(null)
                .phoneNumber("+41 121 87 87")
                .build();
        assertThrows(InvalidClientException.class, () -> clientService.create(client));
    }

    @Test
    void createClient_should_throw_invalid_company_if_null_and_company() {
        var client = Client.builder()
                .id(1)
                .name("name")
                .email("email")
                .type(Client.ClientType.PERSON)
                .birthDate(null)
                .companyIdentifier(null)
                .phoneNumber("+41 121 87 87")
                .build();
        assertThrows(InvalidClientException.class, () -> clientService.create(client));
    }

    @Test
    void getClient_should_return_client() {
        var client = Client.builder()
                .id(1)
                .name("name")
                .email("email")
                .type(Client.ClientType.PERSON)
                .birthDate(LocalDate.now())
                .companyIdentifier(null)
                .phoneNumber("+41 121 87 87")
                .build();
        when(clientRepository.findById(1)).thenReturn(Optional.ofNullable(client));
        var foundClient = clientService.findById(1);
        assertEquals("name", foundClient.getName());
    }

    @Test
    void createClient_should_create_client() {
        var client = Client.builder()
                .id(1)
                .name("name")
                .email("email")
                .type(Client.ClientType.PERSON)
                .birthDate(LocalDate.now())
                .companyIdentifier(null)
                .phoneNumber("+41 121 87 87")
                .build();
        assertDoesNotThrow(() -> clientService.create(client));
    }
}
