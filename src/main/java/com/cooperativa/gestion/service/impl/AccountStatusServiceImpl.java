package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.mapper.PaymentMapper;
import com.cooperativa.gestion.model.entity.PaymentTypeRequest;
import com.cooperativa.gestion.model.response.PendingPaymentResponse;
import com.cooperativa.gestion.repository.BillPaymentRepository;
import com.cooperativa.gestion.repository.PaymentRepository;
import com.cooperativa.gestion.repository.PaymentTypeRepository;
import com.cooperativa.gestion.service.AccountStatusService;
import com.cooperativa.gestion.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountStatusServiceImpl implements AccountStatusService {

    private final PaymentRepository paymentRepository;
    private final BillPaymentRepository bilPaymentRepository;
    private final PaymentTypeRepository paymentTypeRepository;


    @Override
    public BigDecimal getAccountStatusGlobal() {

        BigDecimal paymentGlobal = paymentRepository.getFullPayment();
        BigDecimal billPaymentGlobal = bilPaymentRepository.getFullBillPayment();

        BigDecimal statusAccount = paymentGlobal.subtract(billPaymentGlobal);

        return statusAccount;
    }

    @Override
    public List<PendingPaymentResponse> getPaymentsByIdPartner(Integer idPartner) {
        List<PendingPaymentResponse> getPendingPayments = new ArrayList<>();
        List<PaymentTypeRequest> getPaymentsCodeType = paymentTypeRepository.findAll();
        for ( PaymentTypeRequest p : getPaymentsCodeType) {
            for (Integer code : paymentRepository.getPaymentsCodeByIdPartner(idPartner)) {
                if (code != p.getPaymentTypeId()) {
                    getPendingPayments.add(PaymentMapper.paymentTypeToPendingPayment(p));
                }
            }
        }

        return getPendingPayments;
    }
}
