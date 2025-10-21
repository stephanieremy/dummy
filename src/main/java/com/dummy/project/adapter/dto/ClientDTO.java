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
    @Schema(type = "string", example = "+41 234 56 77")
    private String phoneNumber;
    @Schema(type = "string", example = "Edouard Leclerc")
    private String name;
    @Schema(type = "string", example = "test@mail.com")
    private String email;
    @Schema(type = "date", example = "2000-10-10")
    private LocalDate birthDate;
    @Schema(type = "string", example = "GVA-12")
    private String companyIdentifier;

}
