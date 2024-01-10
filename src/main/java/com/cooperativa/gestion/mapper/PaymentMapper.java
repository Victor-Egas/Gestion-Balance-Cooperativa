package com.cooperativa.gestion.mapper;

import com.cooperativa.gestion.model.entity.PaymentType;
import com.cooperativa.gestion.model.response.PendingPaymentResponse;

import java.math.BigDecimal;

public class PaymentMapper {

    /*public static PendingPaymentResponse paymentTypeToPendingPayment(PaymentType paymentType) {
        PendingPaymentResponse response = new PendingPaymentResponse();
        response.setIdPaymentCode(paymentType.getPaymentTypeId());
        response.setPaymentAmount(new BigDecimal(paymentType.getPaymentAmount()));
        response.setPaymentDetail(paymentType.getPaymentTypeDetails().concat("  ")
                .concat(paymentType.getPaymentDescription()));
        return response;
    }*/
}
