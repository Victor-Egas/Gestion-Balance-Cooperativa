package com.cooperativa.gestion.repository;

import com.cooperativa.gestion.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface PaymentRepository extends JpaRepository<Payment , Integer> {

    @Query(value = "select sum(payment_amount) from tb_ingreso \n" +
            "where partner_id = :idPartner", nativeQuery = true)
    BigDecimal getFullPaymentById(Integer idPartner);

    @Query(value = "SELECT SUM(PAYMENT_AMOUNT) FROM TB_INGRESO", nativeQuery = true)
    BigDecimal getFullPayment();
}
