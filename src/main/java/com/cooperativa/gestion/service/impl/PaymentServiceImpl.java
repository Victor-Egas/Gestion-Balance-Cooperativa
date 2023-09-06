package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.repository.PaymentRepository;
import com.cooperativa.gestion.model.entity.PaymentRequest;
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
    public List<PaymentRequest> getPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public PaymentRequest insertPayment(PaymentRequest paymentRequest) {
        return paymentRepository.save(paymentRequest);
    }

    @Override
    public PaymentRequest updatePayment(PaymentRequest paymentRequest) {
        return paymentRepository.save(paymentRequest);
    }

    @Override
    public BigDecimal getFullPaymentFindById(Integer idPartner) {
        return paymentRepository.getFullPaymentById(idPartner);
    }

}
