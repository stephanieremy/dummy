package com.dummy.project.repository.contract;

import com.dummy.project.repository.client.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ContractJpaRepository extends JpaRepository<ContractEntity, Integer> {

    @Query("select c from ContractEntity c where (c.client = :client and c.endDate >= current_date) and ( cast(:updatedDate as date) is null or c.updatedDate = :updatedDate) ")
    List<ContractEntity> findByClientId(@Param("client") ClientEntity client, @Param("updatedDate") LocalDate updatedDate);

    @Query("select sum(c.costAmount) from ContractEntity c where c.client = :client and c.endDate >= current_date")
    Double getContractAmountSum(@Param("client") ClientEntity client);
}
