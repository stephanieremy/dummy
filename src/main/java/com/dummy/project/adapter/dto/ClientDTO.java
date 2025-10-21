package com.dummy.project.adapter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Schema
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {

    private Integer id;
    @Schema(type = "string", allowableValues = {"PERSON", "COMPANY"})
    private ClientType type;
    private String phoneNumber;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String companyIdentifier;

}
