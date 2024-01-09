package com.cooperativa.gestion.model.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
public class PendingPaymentResponse {

    private String partnerName;
    private BigDecimal totalPaymentAmount;
    private Map<String, BigDecimal> paymentPending;
}
