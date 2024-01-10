package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.entity.Payment;
import com.cooperativa.gestion.model.request.PaymentPendingTypeRequest;
import com.cooperativa.gestion.model.request.PaymentRequest;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentService {

     List<Payment> getPayments();
     Payment insertPayment(PaymentRequest payment);
     Payment updatePayment(Payment payment);
     BigDecimal getFullPaymentFindById(Integer idPartner);
     List<Payment> getPaymentsMade();
     PaymentPendingTypeRequest getPaymentPendingTypeForPartner(Integer paymentTypeId);
     Payment getPaymentById(Integer paymentId);
}
