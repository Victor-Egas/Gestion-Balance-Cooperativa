package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    public List<Payment> getPayments();
    public Payment insertPayment(Payment payment);

    public Payment updatePayment(Payment payment);
}
