package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.repository.PaymentTypeRepository;
import com.cooperativa.gestion.model.PaymentType;
import com.cooperativa.gestion.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    private PaymentTypeRepository repository;

    @Override
    public PaymentType savePaymentType(PaymentType paymentType) {
        return repository.save(paymentType);
    }

    @Override
    public List<PaymentType> getPaymentTypes() {
        return repository.findAll();
    }
}
