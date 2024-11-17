package com.cooperativa.gestion.model.dto;

import com.cooperativa.gestion.model.entity.Partner;
import lombok.*;

import java.math.BigDecimal;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartnerPaymentContribution {

    private Partner partner;
    private BigDecimal amount;
}
