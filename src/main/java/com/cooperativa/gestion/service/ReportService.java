package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.entity.PaymentType;

import java.util.List;

public interface ReportService {

    String createReport(String initDate, String finalDate);

    List<PaymentType> findAllPaymentTypeReports();
}
