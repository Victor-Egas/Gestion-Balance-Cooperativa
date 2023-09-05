package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.Payment;
import com.cooperativa.gestion.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/save")
    public Payment savePayment(@RequestBody Payment payment) {
       return paymentService.insertPayment(payment);
    }

    @GetMapping("/findAll")
    public List<Payment> getPayments() {
        return paymentService.getPayments();
    }

    @GetMapping("/fullPayment")
    public BigDecimal getFullPayment(@RequestParam Integer id) {
        return paymentService.getFullPaymentFindById(id);
    }


}
