package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.model.entity.BillPayment;
import com.cooperativa.gestion.repository.BillPaymentRepository;
import com.cooperativa.gestion.service.BillPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BillPaymentServiceImpl implements BillPaymentService {

    private final BillPaymentRepository repository;

    @Override
    public BillPayment getBillPaymentById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public BillPayment saveBillPayment(BillPayment billPayment) {
        BillPayment billPaymentResponse = repository.save(billPayment);
        return billPaymentResponse;
    }

    @Override
    public List<BillPayment> getBillPaymentList() {
        return repository.findAll();
    }
}
