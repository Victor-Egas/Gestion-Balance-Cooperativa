package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.response.PendingPaymentFullResponse;
import com.cooperativa.gestion.model.response.PendingPaymentResponse;

import java.math.BigDecimal;
import java.util.List;

public interface AccountStatusService {

    BigDecimal getAccountStatusGlobal();

    PendingPaymentResponse getPaymentsByIdPartner(Integer idPartner);

    PendingPaymentFullResponse getFullPaymentAmountByIdPartner(Integer idPartner);

}
