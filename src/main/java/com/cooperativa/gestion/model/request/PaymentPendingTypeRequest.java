package com.cooperativa.gestion.model.request;

import com.cooperativa.gestion.model.entity.Partner;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentPendingTypeRequest {
    private String paymentName;
    private String paymentAmount;
    private Integer countPartnersPaymentPending;
    private List<Partner> partnersPaymentPending;
}
