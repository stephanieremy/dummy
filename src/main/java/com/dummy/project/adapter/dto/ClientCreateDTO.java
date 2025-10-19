package com.dummy.project.adapter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class ClientCreateDTO {

    @Schema(description = "Client type", example = "Company")
    @NotNull
    private ClientType type;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    private String email;
    private LocalDate birthDate;
    private String companyIdentifier;

}
