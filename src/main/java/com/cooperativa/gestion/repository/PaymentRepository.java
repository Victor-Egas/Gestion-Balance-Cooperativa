package com.cooperativa.gestion.repository;

import com.cooperativa.gestion.model.entity.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentRequest, Integer> {

    @Query(value = "select sum(payment_amount) from tb_ingreso \n" +
            "where partner_id = :idPartner", nativeQuery = true)
    BigDecimal getFullPaymentById(@Param("idPartner") Integer idPartner);

    @Query(value = "SELECT SUM(PAYMENT_AMOUNT) FROM TB_INGRESO", nativeQuery = true)
    BigDecimal getFullPayment();

    @Query(value = "SELECT PAYMENT_TYPE_ID FROM TB_INGRESO\n" +
            "WHERE PARTNER_ID = :idPartner", nativeQuery = true)
    List<Integer> getPaymentsCodeByIdPartner(@Param("idPartner") Integer idPartner);

}
