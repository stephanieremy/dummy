package com.dummy.project.adapter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
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

    @Schema(type = "date", example = "2023-12-31")
    private LocalDate startDate;
    @Schema(type = "date", example = "2028-12-30")
    private LocalDate endDate;
    @Schema(type = "number", example = "1200.00")
    @NotNull
    @PositiveOrZero
    private Double costAmount;
}
