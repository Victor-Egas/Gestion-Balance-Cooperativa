package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.entity.PaymentRequest;
import com.cooperativa.gestion.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /* Registrar nuevos pagos */
    @PostMapping("/save")
    public PaymentRequest savePayment(@RequestBody PaymentRequest paymentRequest) {
       return paymentService.insertPayment(paymentRequest);
    }

    /* Listar todos los pagos */
    @GetMapping("/findAll")
    public List<PaymentRequest> getPayments() {
        return paymentService.getPayments();
    }

    /* Consultar el monto total de pagos filtrando por su id */
    @GetMapping("/fullPayment")
    public BigDecimal getFullPayment(@RequestParam Integer id) {
        return paymentService.getFullPaymentFindById(id);
    }


}
