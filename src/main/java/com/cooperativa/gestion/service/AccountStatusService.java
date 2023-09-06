package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.response.PendingPaymentResponse;

import java.math.BigDecimal;
import java.util.List;

public interface AccountStatusService {

    BigDecimal getAccountStatusGlobal();

    List<PendingPaymentResponse> getPaymentsByIdPartner(Integer idPartner);

}
