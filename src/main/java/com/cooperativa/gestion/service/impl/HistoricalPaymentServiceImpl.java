package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.model.entity.HistoricalPayment;
import com.cooperativa.gestion.model.entity.Partner;
import com.cooperativa.gestion.model.request.PaymentHistoricalRequest;
import com.cooperativa.gestion.repository.HistoricalPaymentRepository;
import com.cooperativa.gestion.service.HistoricalPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HistoricalPaymentServiceImpl implements HistoricalPaymentService {

    private final HistoricalPaymentRepository repository;
    @Override
    public HistoricalPayment insertHistoricalPayment(PaymentHistoricalRequest payment) {
        return repository.save(HistoricalPayment.builder()
                .paymentAmount(payment.getAmount())
                .paymentDetails(payment.getDetails())
                .paymentTicket(payment.getTicket())
                .paymentDate(payment.getDate())
                .paymentDateRecord(payment.getDateRecord())
                .partner(Partner.builder()
                        .partnerId(payment.getPartner())
                        .build())
                .build());
    }

    @Override
    public List<HistoricalPayment> getHistoricalPaymentList() {
        return repository.findAll();
    }
}
