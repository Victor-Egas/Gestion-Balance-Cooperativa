package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.PaymentType;

import java.util.List;

public interface PaymentTypeService {

    public PaymentType savePaymentType(PaymentType paymentType);

    public List<PaymentType> getPaymentTypes();
}
