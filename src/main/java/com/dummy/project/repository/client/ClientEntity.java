package com.dummy.project.repository.client;

import com.dummy.project.repository.contract.ContractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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
    @OneToMany(mappedBy = "client", cascade = CascadeType.DETACH)
    private List<ContractEntity> contracts;

    public enum ClientType {
        PERSON, COMPANY
    }
}
