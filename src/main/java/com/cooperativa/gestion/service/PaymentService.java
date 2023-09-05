package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.Payment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PaymentService {

     List<Payment> getPayments();
     Payment insertPayment(Payment payment);
     Payment updatePayment(Payment payment);
     BigDecimal getFullPaymentFindById(Integer idPartner);
}
