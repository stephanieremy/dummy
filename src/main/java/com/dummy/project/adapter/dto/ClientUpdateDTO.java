package com.dummy.project.adapter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientUpdateDTO {

    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String name;
    @NotEmpty
    @Email(regexp = ".+@.+\\..+")
    private String email;

}
