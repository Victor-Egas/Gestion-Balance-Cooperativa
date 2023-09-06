package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.repository.PaymentTypeRepository;
import com.cooperativa.gestion.model.entity.PaymentTypeRequest;
import com.cooperativa.gestion.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    private PaymentTypeRepository repository;

    @Override
    public PaymentTypeRequest savePaymentType(PaymentTypeRequest paymentTypeRequest) {
        return repository.save(paymentTypeRequest);
    }

    @Override
    public List<PaymentTypeRequest> getPaymentTypes() {
        return repository.findAll();
    }
}
