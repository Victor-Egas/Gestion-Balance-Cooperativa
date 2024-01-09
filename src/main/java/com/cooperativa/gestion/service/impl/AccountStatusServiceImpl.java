package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.model.entity.PaymentType;
import com.cooperativa.gestion.model.response.PendingPaymentFullResponse;
import com.cooperativa.gestion.model.response.PendingPaymentResponse;
import com.cooperativa.gestion.repository.*;
import com.cooperativa.gestion.service.AccountStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AccountStatusServiceImpl implements AccountStatusService {

    private final PaymentRepository paymentRepository;
    private final BillPaymentRepository bilPaymentRepository;
    private final PaymentTypeRepository paymentTypeRepository;
    private final PartnerRepository partnerRepository;
    private final HistoricalPaymentRepository historicalPaymentRepository;


    @Override
    public BigDecimal getAccountStatusGlobal() {

        BigDecimal fullPayment = paymentRepository.getFullPayment();
        System.out.println("Monto acumulado : "+fullPayment);
        BigDecimal fullPaymentHistorical = historicalPaymentRepository.getFullPaymentHistorical();
        System.out.println("Monto acumulado Historico : "+fullPaymentHistorical);
        BigDecimal billPaymentGlobal = bilPaymentRepository.getFullBillPayment();
        System.out.println("Monto acumulado de egreso : "+billPaymentGlobal);

        BigDecimal statusAccount = (fullPayment.add(fullPaymentHistorical)).subtract(billPaymentGlobal);

        return statusAccount;
    }

    @Override
    public PendingPaymentResponse getPaymentsByIdPartner(Integer idPartner) {

        List<PaymentType> getPaymentsCodeType = getPaymentsType();
        List<Integer> getPaymentsCodeOfPartner = getPaymentsCodeByIdPartner(idPartner);

        LinkedHashMap<String, BigDecimal> paymentPending = new LinkedHashMap<>();
        BigDecimal totalPaymentAmount = new BigDecimal(0) ;

        for (PaymentType p : getPaymentsCodeType ) {
            Integer countPendingPayment = 0;
            for (Integer paymentCodePartner : getPaymentsCodeOfPartner) {
                if (p.getPaymentTypeId() == paymentCodePartner) {
                    countPendingPayment ++;
                }
            }

            if (countPendingPayment == 0) {
                paymentPending.put(p.getPaymentTypeDetails()+" - "+p.getPaymentDescription(),
                        new BigDecimal(p.getPaymentAmount()));
                totalPaymentAmount = totalPaymentAmount.add(new BigDecimal(p.getPaymentAmount()));
            }
        }

        PendingPaymentResponse pendingPaymentResponse = new PendingPaymentResponse();
        pendingPaymentResponse.setPartnerName(getNamePartnerById(idPartner));
        pendingPaymentResponse.setPaymentPending(paymentPending);
        pendingPaymentResponse.setTotalPaymentAmount(totalPaymentAmount);


        return pendingPaymentResponse;
    }

    @Override
    public PendingPaymentFullResponse getFullPaymentAmountByIdPartner(Integer idPartner) {
        /*List<PaymentType> getPaymentsCodeType = getPaymentsType();
        List<Integer> getPaymentsCodeOfPartner = getPaymentsCodeByIdPartner(idPartner);
        PendingPaymentFullResponse paymentFull = new PendingPaymentFullResponse();
        BigDecimal amount = new BigDecimal(0);

        for(PendingPaymentResponse payment :getPayments(getPaymentsCodeType, getPaymentsCodeOfPartner)) {
            amount = amount.add(payment.getPaymentAmount());
        }
        paymentFull.setFullAmount(amount);*/
        return null;//paymentFull;
    }

    private List<Integer> getPaymentsCodeByIdPartner (Integer idPartner) {
        return paymentRepository.getPaymentsCodeByIdPartner(idPartner);
    }

    private List<PaymentType> getPaymentsType() {
        return paymentTypeRepository.findAll();
    }

    private String getNamePartnerById(Integer id){
        return partnerRepository.findById(id).get().getPartnerName();
    }
}
