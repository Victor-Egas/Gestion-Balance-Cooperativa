package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.entity.HistoricalPayment;
import com.cooperativa.gestion.model.request.PaymentHistoricalRequest;

import java.util.List;

public interface HistoricalPaymentService {

    HistoricalPayment insertHistoricalPayment(PaymentHistoricalRequest payment);
    List<HistoricalPayment> getHistoricalPaymentList();
}
