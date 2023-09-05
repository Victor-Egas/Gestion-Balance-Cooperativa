package com.cooperativa.gestion.repository;

import com.cooperativa.gestion.model.BillPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface BillPaymentRepository extends JpaRepository<BillPayment, Integer> {

    @Query(value = "SELECT SUM(BILL_PAYMENT_AMOUNT) FROM TB_EGRESO", nativeQuery = true)
    BigDecimal getFullBillPayment();
}
