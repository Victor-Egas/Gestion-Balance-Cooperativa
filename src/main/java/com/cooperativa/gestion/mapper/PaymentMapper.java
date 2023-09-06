package com.cooperativa.gestion.mapper;

import com.cooperativa.gestion.model.entity.PaymentTypeRequest;
import com.cooperativa.gestion.model.response.PendingPaymentResponse;

import java.math.BigDecimal;

public class PaymentMapper {

    public static PendingPaymentResponse paymentTypeToPendingPayment(PaymentTypeRequest paymentTypeRequest) {
        PendingPaymentResponse response = new PendingPaymentResponse();
        response.setPaymentAmount(new BigDecimal(paymentTypeRequest.getPaymentAmount()));
        response.setPaymentDetail(paymentTypeRequest.getPaymentTypeDetails().concat("  ")
                .concat(paymentTypeRequest.getPaymentDescription()));
        return response;
    }
}
