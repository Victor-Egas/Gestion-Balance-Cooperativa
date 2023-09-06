package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.entity.PaymentTypeRequest;

import java.util.List;

public interface PaymentTypeService {

    public PaymentTypeRequest savePaymentType(PaymentTypeRequest paymentTypeRequest);

    public List<PaymentTypeRequest> getPaymentTypes();
}
