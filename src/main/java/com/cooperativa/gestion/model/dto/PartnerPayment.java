package com.cooperativa.gestion.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerPayment {

    private String fullName;
    private BigDecimal paymentOne;
    private BigDecimal paymentTwo;
    private BigDecimal paymentThree;
    private BigDecimal paymentFour;
    private BigDecimal paymentFive;
    private BigDecimal paymentSix;
    private BigDecimal paymentEight;
    private BigDecimal paymentNine;
    private BigDecimal paymentTen;
    private BigDecimal paymentEleven;
    private BigDecimal paymentTwelve;
    private BigDecimal paymentThirteen;

}
