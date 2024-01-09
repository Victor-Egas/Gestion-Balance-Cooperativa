package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.entity.PaymentType;

import java.util.List;

public interface PaymentTypeService {

    PaymentType savePaymentType(PaymentType paymentType);

    List<PaymentType> getPaymentTypes();
    PaymentType getPaymentTypeById(Integer paymentTypeId);

}
