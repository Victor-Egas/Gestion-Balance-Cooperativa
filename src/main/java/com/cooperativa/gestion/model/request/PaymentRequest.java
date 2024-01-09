package com.cooperativa.gestion.model.request;

import com.cooperativa.gestion.model.entity.Partner;
import com.cooperativa.gestion.model.entity.PaymentType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PaymentRequest {

    private Integer paymentId;
    private BigDecimal paymentAmount;
    private LocalDate paymentDate;
    private LocalDate paymentDateRecord;
    private String paymentDetails;
    private Integer paymentTicket;
    private Integer partner;
    private Integer paymentType;
}
