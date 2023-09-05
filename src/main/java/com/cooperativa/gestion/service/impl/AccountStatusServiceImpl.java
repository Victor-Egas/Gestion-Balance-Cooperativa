package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.repository.BillPaymentRepository;
import com.cooperativa.gestion.repository.PaymentRepository;
import com.cooperativa.gestion.service.AccountStatusService;
import com.cooperativa.gestion.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountStatusServiceImpl implements AccountStatusService {

    private final PaymentRepository paymentRepository;

    private final BillPaymentRepository bilPaymentRepository;

    @Override
    public BigDecimal getAccountStatusGlobal() {

        BigDecimal paymentGlobal = paymentRepository.getFullPayment();
        BigDecimal billPaymentGlobal = bilPaymentRepository.getFullBillPayment();

        BigDecimal statusAccount = paymentGlobal.subtract(billPaymentGlobal);

        return statusAccount;
    }
}
