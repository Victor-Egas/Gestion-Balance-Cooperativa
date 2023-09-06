package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.entity.PaymentTypeRequest;
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
    public PaymentTypeRequest insertPaymentType(@RequestBody PaymentTypeRequest paymentTypeRequest) {
        return service.savePaymentType(paymentTypeRequest);
    }

    /* Consultar todos los tipos de pagos */
    @GetMapping("/findAll")
    public List<PaymentTypeRequest> getPaymentTypes() {
        return service.getPaymentTypes();
    }
}
