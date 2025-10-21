package com.dummy.project.domain.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contract {

    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime updatedDate;
    private Double costAmount;

}
