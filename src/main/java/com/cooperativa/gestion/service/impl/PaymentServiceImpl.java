package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.repository.PaymentRepository;
import com.cooperativa.gestion.model.Payment;
import com.cooperativa.gestion.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment insertPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public BigDecimal getFullPaymentFindById(Integer idPartner) {
        return paymentRepository.getFullPaymentById(idPartner);
    }

}
