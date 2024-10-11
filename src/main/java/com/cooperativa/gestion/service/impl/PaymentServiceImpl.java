package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.model.entity.Partner;
import com.cooperativa.gestion.model.entity.PaymentType;
import com.cooperativa.gestion.model.request.PaymentPendingTypeRequest;
import com.cooperativa.gestion.model.request.PaymentRequest;
import com.cooperativa.gestion.repository.PaymentRepository;
import com.cooperativa.gestion.model.entity.Payment;
import com.cooperativa.gestion.repository.PaymentTypeRepository;
import com.cooperativa.gestion.service.PartnerService;
import com.cooperativa.gestion.service.PaymentService;
import com.cooperativa.gestion.service.PaymentTypeService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PartnerService partnerService;
    private final PaymentTypeService paymentTypeService;

    @Override
    public List<Payment> getPayments() {
        //llamar al metodo de generar reporte
        return paymentRepository.findAll();
    }

    @Override
    public Payment insertPayment(PaymentRequest paymentRequest) {
        Payment paymentSave =Payment.builder()
                .paymentAmount(paymentRequest.getPaymentAmount())
                .paymentDate(paymentRequest.getPaymentDate())
                .paymentDateRecord(LocalDate.now())
                .paymentDetails(paymentRequest.getPaymentDetails())
                .paymentTicket(paymentRequest.getPaymentTicket())
                .paymentType(PaymentType.builder()
                        .paymentTypeId(paymentRequest.getPaymentType())
                        .build())
                .partner(Partner.builder()
                        .partnerId(paymentRequest.getPartner())
                        .build())
                .build();
        return paymentRepository.save(paymentSave);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public BigDecimal getFullPaymentFindById(Integer idPartner) {
        return paymentRepository.getFullPaymentById(idPartner);
    }

    @Override
    public List<Payment> getPaymentsMade() {
        return paymentRepository.findAll();
    }

    @Override
    public PaymentPendingTypeRequest getPaymentPendingTypeForPartner(Integer paymentTypeId) {

        PaymentType paymentType = paymentTypeService.getPaymentTypeById(paymentTypeId);

        return PaymentPendingTypeRequest.builder()
                .partnersPaymentPending(partnerService.getPartnersPaymentPendingById(paymentTypeId))
                .paymentName(paymentType.getPaymentDescription()
                        .concat(" - "+paymentType.getPaymentTypeDetails()))
                .paymentAmount(paymentType.getPaymentAmount())
                .countPartnersPaymentPending(partnerService.getPartnersPaymentPendingById(paymentTypeId).size())
                .build();
    }

    @Override
    public Payment getPaymentById(Integer paymentId) {
        return paymentRepository.findById(paymentId).get();
    }
}
