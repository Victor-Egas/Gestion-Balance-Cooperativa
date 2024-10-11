package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.model.entity.Payment;
import com.cooperativa.gestion.model.entity.PaymentType;
import com.cooperativa.gestion.model.response.PendingPaymentFullResponse;
import com.cooperativa.gestion.model.response.PendingPaymentResponse;
import com.cooperativa.gestion.repository.*;
import com.cooperativa.gestion.service.AccountStatusService;
import com.cooperativa.gestion.util.StyleUtils;
import com.cooperativa.gestion.util.Utils;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
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
        List<Payment> getPaymentsCodeOfPartner = getPaymentsCodeByIdPartner(idPartner);

        LinkedHashMap<String, BigDecimal> paymentPending = new LinkedHashMap<>();
        BigDecimal totalPaymentAmount = new BigDecimal(0) ;

        for (PaymentType p : getPaymentsCodeType ) {
            Integer countPendingPayment = 0;
            BigDecimal pendingAmount = new BigDecimal(0);
            for (Payment paymentCodePartner : getPaymentsCodeOfPartner) {
                if (p.getPaymentTypeId() == paymentCodePartner.getPaymentType().getPaymentTypeId()
                        && (new BigDecimal(p.getPaymentAmount())).compareTo(paymentCodePartner.getPaymentAmount()) == 0) {
                    countPendingPayment ++;
                } else
                    if (p.getPaymentTypeId() == paymentCodePartner.getPaymentType().getPaymentTypeId()
                            && (new BigDecimal(p.getPaymentAmount())).compareTo(paymentCodePartner.getPaymentAmount()) != 0) {
                        pendingAmount = (new BigDecimal(p.getPaymentAmount())).subtract(paymentCodePartner.getPaymentAmount());
                    }
            }

            if (countPendingPayment == 0 ) {
                paymentPending.put(p.getPaymentTypeDetails()+" - "+p.getPaymentDescription() + (pendingAmount.intValue() == 0 ? "" : " ## Monto pendiente"),
                        pendingAmount.intValue() == 0 ? new BigDecimal(p.getPaymentAmount()) : pendingAmount);
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

    private List<Payment> getPaymentsCodeByIdPartner (Integer idPartner) {
        List<Payment> paymentsByPartner = paymentRepository.getPaymentsCodeByIdPartner(idPartner);
        return paymentsByPartner;
    }

    private List<PaymentType> getPaymentsType() {
        return paymentTypeRepository.findAll();
    }

    private String getNamePartnerById(Integer id){
        return partnerRepository.findById(id).get().getPartnerName();
    }

}
