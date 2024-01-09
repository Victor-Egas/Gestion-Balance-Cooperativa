package com.cooperativa.gestion.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PaymentHistoricalRequest {
    private BigDecimal amount;
    private String date;
    private String dateRecord;
    private String details;
    private Integer ticket;
    private Integer partner;
}
