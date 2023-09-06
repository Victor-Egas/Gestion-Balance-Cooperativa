package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.entity.PaymentRequest;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentService {

     List<PaymentRequest> getPayments();
     PaymentRequest insertPayment(PaymentRequest paymentRequest);
     PaymentRequest updatePayment(PaymentRequest paymentRequest);
     BigDecimal getFullPaymentFindById(Integer idPartner);
}
