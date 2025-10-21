package com.dummy.project.adapter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
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

    @Schema(description = "Client type", example = "PERSON")
    @NotNull
    private ClientType type;
    @NotEmpty
    @Pattern(regexp = "\\+\\d*")
    private String phoneNumber;
    @NotEmpty
    @Size(min = 2)
    private String name;
    @NotEmpty
    @Email(regexp = ".+@.+\\..+")
    private String email;
    private LocalDate birthDate;
    private String companyIdentifier;

}
