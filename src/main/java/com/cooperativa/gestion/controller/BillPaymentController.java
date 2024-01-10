package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.entity.BillPayment;
import com.cooperativa.gestion.service.BillPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RequiredArgsConstructor
@RequestMapping("/billPayment")
@RestController
public class BillPaymentController {

    private final BillPaymentService service;

    @GetMapping("/{id}")
    public BillPayment getBillPaymentById(@PathVariable Integer id){
        return service.getBillPaymentById(id);
    }

    @PostMapping
    public BillPayment saveBillPayment(@RequestBody BillPayment billPaymentRequest) {
        return service.saveBillPayment(billPaymentRequest);
    }

    /*Listado de todos los egresos*/
    @GetMapping("/findAll")
    public List<BillPayment> getBillPayments(){
        return service.getBillPaymentList();
    }
}
