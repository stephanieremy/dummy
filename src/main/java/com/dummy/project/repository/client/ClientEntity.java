package com.dummy.project.repository.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class ClientEntity {

    @GeneratedValue
    @Id
    private Long id;
    private ClientType type;
    private String phoneNumber;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String companyIdentifier;

    public enum ClientType {
        PERSON, COMPANY
    }
}
