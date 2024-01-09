package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.entity.PaymentType;
import com.cooperativa.gestion.service.PaymentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentType")
@RequiredArgsConstructor
public class PaymentTypeController {

    private final PaymentTypeService service;

    /* Registrar nuevos tipos de pagos */
    @PostMapping("/save")
    public PaymentType insertPaymentType(@RequestBody PaymentType paymentType) {
        return service.savePaymentType(paymentType);
    }

    /* Consultar todos los tipos de pagos */
    @GetMapping("/findAll")
    public List<PaymentType> getPaymentTypes() {
        return service.getPaymentTypes();
    }
}
