package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.model.entity.Payment;
import com.cooperativa.gestion.service.PaymentService;
import com.cooperativa.gestion.service.ReportService;
import com.cooperativa.gestion.util.StyleUtils;
import com.cooperativa.gestion.util.Utils;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {

    private final PaymentService paymentService;


    @Override
    public String createReport(String initDate, String finalDate) {

            System.out.println("Iniciando reporte");
            String response = "SUCCESS";
            Workbook workbook = createExcelReportWorkbook(getPaymentsByDateRange(Utils.convertDateFormat(initDate),
                    Utils.convertDateFormat(finalDate)));
            try (FileOutputStream fos = new FileOutputStream(
                    "F:\\Repositorio-GitHub\\Gestion-Balance-Cooperativa\\src\\main\\resources\\reports\\report.xlsx")) {
                workbook.write(fos);
            } catch (IOException e) {
                e.printStackTrace();
                response = "FAILLED";
            } finally {
                try {
                    workbook.close();
                    System.out.println("Se cerró con éxito el workbook");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Se presentó error al cerrar el workbook");
                }
            }
        return response;
    }

    private Workbook createExcelReportWorkbook(List<Payment> payments) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Balance de Cooperativa");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("CODIGO");
        headerRow.createCell(1).setCellValue("SOCIO");
        headerRow.createCell(2).setCellValue("TIPO DE PAGO");
        headerRow.createCell(3).setCellValue("FECHA DE PAGO");
        headerRow.createCell(4).setCellValue("NUMERO DE RECIBO");
        headerRow.createCell(5).setCellValue("DESCRIPCION");
        headerRow.createCell(6).setCellValue("MONTO ESPERADO");
        headerRow.createCell(7).setCellValue("MONTO REAL");

        Integer count = 1;
        for(Payment payment : payments) {
            Row row = sheet.createRow(count);
            row.createCell(0).setCellValue(count);
            row.createCell(1).setCellValue(payment.getPartner().getPartnerName());
            row.createCell(2).setCellValue(payment.getPaymentType().getPaymentDescription());

            System.out.println("fecha N°"+count+" : "+payment.getPaymentDate());
            Cell dateCell = row.createCell(3, CellType.NUMERIC);
            dateCell.setCellValue(Utils.convertDateFormatToString(payment.getPaymentDate()));
            dateCell.setCellStyle(StyleUtils.createDateCellStyle(workbook));

            row.createCell(4).setCellValue(payment.getPaymentTicket());
            row.createCell(5).setCellValue(payment.getPaymentDetails());

            Cell actualAmountCell = row.createCell(6);
            actualAmountCell.setCellValue(payment.getPaymentType().getPaymentAmount());
            actualAmountCell.setCellStyle(StyleUtils.createCurrencyCellStyle(workbook));

            Cell expectedAmountCell = row.createCell(7);
            expectedAmountCell.setCellValue(payment.getPaymentAmount().toString());
            expectedAmountCell.setCellStyle(StyleUtils.createCurrencyCellStyle(workbook));

            count++;
        }

        return workbook;
    }

    private List<Payment> getPaymentsByDateRange(LocalDate initDate, LocalDate finalDate) {
        List<Payment> payments = paymentService.getPayments().stream()
                .filter(payment -> isDateInRange(payment.getPaymentDate(), initDate, finalDate))
                .collect(Collectors.toList());

        return payments;
    }

    private boolean isDateInRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return (date.isEqual(startDate) || date.isEqual(endDate) || (date.isAfter(startDate) && date.isBefore(endDate)));
    }

}
