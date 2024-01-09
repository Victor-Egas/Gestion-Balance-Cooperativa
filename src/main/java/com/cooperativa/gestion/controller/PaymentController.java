package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.entity.HistoricalPayment;
import com.cooperativa.gestion.model.entity.Partner;
import com.cooperativa.gestion.model.entity.Payment;
import com.cooperativa.gestion.model.request.PaymentHistoricalRequest;
import com.cooperativa.gestion.model.request.PaymentPendingTypeRequest;
import com.cooperativa.gestion.model.request.PaymentRequest;
import com.cooperativa.gestion.service.HistoricalPaymentService;
import com.cooperativa.gestion.service.PartnerService;
import com.cooperativa.gestion.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;
    private final PartnerService partnerService;
    private final HistoricalPaymentService historicalPaymentService;

    /*INGRESO DE DOLARES $5251*/
    /* Registrar nuevos pagos */
    @PostMapping("/save")
    public Payment savePayment(@RequestBody PaymentRequest paymentRequest) {
       return paymentService.insertPayment(paymentRequest);
    }

    /* Listar todos los pagos */
    @GetMapping("/findAll")
    public List<Payment> getPayments() {
        return paymentService.getPayments();
    }

    /* Consultar el monto total de pagos filtrando por su id */
    @GetMapping("/fullPayment")
    public BigDecimal getFullPayment(@RequestParam Integer id) {
        return paymentService.getFullPaymentFindById(id);
    }

    /* Registrar pagos históricos*/
    @PostMapping("/saveHistorical")
    public HistoricalPayment saveHistoricalPayment(@RequestBody PaymentHistoricalRequest paymentRequest) {
        return historicalPaymentService.insertHistoricalPayment(paymentRequest);
    }

    @GetMapping("/partners-payment-pending")
    public ResponseEntity<PaymentPendingTypeRequest> getPaymentPendingType(@RequestParam Integer paymentTypeId){
        return ResponseEntity.ok(paymentService.getPaymentPendingTypeForPartner(paymentTypeId));
    }

    @PutMapping("/{partnerId}")
    public ResponseEntity<Partner> updatePartner(
            @PathVariable Integer paymentId, @RequestBody Payment updatePayment) {
      /*  Payment existingPayment = paymentService.getPaymentById(paymentId);

        if (existingPayment != null) {
            updatePayment.setPaymentAmount(existingPayment.getPaymentAmount());
            updatePayment.setPaymentDate(updatePayment.getPaymentDate());
            updatePayment.setPartner(exis);
            existingPartner.setPartnerName(updatedPartner.getPartnerName());
            Partner updated = service.savePartner(existingPartner);

            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }*/
        return null;
    }

    /*Listado de todos los pagos historicos*/
    @GetMapping("/findAll/historical")
    public List<HistoricalPayment> getHistoricalPayments(){
        return historicalPaymentService.getHistoricalPaymentList();
    }

}
