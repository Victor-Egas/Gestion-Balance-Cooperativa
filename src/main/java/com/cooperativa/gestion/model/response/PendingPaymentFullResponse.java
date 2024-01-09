package com.cooperativa.gestion.model.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PendingPaymentFullResponse {

    private BigDecimal fullAmount;
}
