package com.dummy.project.repository.contract;

import com.dummy.project.repository.client.ClientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "contract")
public class ContractEntity {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    @Column(name = "updated_date")
    @LastModifiedDate
    private LocalDate updatedDate;

    private Double costAmount;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;
}
