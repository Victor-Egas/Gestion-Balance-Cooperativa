package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.Payment;
import com.cooperativa.gestion.model.PaymentType;
import com.cooperativa.gestion.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentType")
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService service;

    @PostMapping("/save")
    public PaymentType insertPaymentType(@RequestBody PaymentType paymentType) {
        return service.savePaymentType(paymentType);
    }

    @GetMapping("/findAll")
    public List<PaymentType> getPaymentTypes() {
        return service.getPaymentTypes();
    }
}
