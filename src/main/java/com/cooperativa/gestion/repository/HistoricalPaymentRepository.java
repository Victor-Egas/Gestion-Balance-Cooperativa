package com.cooperativa.gestion.repository;

import com.cooperativa.gestion.model.entity.HistoricalPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface HistoricalPaymentRepository extends JpaRepository<HistoricalPayment, Integer> {

    @Query(value = "SELECT SUM(MONTO) FROM TB_INGRESO_HISTORICO", nativeQuery = true)
    BigDecimal getFullPaymentHistorical();
}
