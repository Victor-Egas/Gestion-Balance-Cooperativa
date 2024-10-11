package com.cooperativa.gestion.repository;

import com.cooperativa.gestion.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query(value = "select sum(MONTO) from tb_ingreso \n" +
            "where partner_id = :idPartner", nativeQuery = true)
    BigDecimal getFullPaymentById(@Param("idPartner") Integer idPartner);

    @Query(value = "SELECT SUM(MONTO) FROM TB_INGRESO", nativeQuery = true)
    BigDecimal getFullPayment();

    @Query(value = "SELECT * FROM TB_INGRESO\n" +
            "WHERE PARTNER_ID = :idPartner", nativeQuery = true)
    List<Payment> getPaymentsCodeByIdPartner(@Param("idPartner") Integer idPartner);

    @Query(value = "select * from cooperativa_balance.tb_ingreso\n" +
            "where payment_type_id = :paymentTypeId", nativeQuery = true)
    List<Payment> getPartnersPaymentPending(Integer paymentTypeId);

}
