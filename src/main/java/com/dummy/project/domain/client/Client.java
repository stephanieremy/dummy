package com.dummy.project.domain.client;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {

    private Integer id;
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