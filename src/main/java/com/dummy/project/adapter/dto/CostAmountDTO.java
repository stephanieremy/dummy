package com.dummy.project.adapter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CostAmountDTO {

    @Schema(type = "number", example = "1200.00")
    @NotNull
    @PositiveOrZero
    Double costAmount;
}
