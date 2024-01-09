package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.entity.BillPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillPaymentService {
    BillPayment getBillPaymentById(Integer id);

    BillPayment saveBillPayment(BillPayment billPayment);
    List<BillPayment> getBillPaymentList();
}
