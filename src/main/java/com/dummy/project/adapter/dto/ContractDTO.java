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
public class ContractDTO {

    private LocalDate startDate;
    private LocalDate endDate;
    private Double costAmount;
}
