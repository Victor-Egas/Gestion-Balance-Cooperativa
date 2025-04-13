package com.cooperativa.gestion.service.impl;

import antlr.StringUtils;
import com.cooperativa.gestion.model.dto.PartnerPayment;
import com.cooperativa.gestion.model.dto.PartnerPaymentContribution;
import com.cooperativa.gestion.model.entity.Partner;
import com.cooperativa.gestion.model.entity.Payment;
import com.cooperativa.gestion.model.entity.PaymentType;
import com.cooperativa.gestion.repository.PaymentRepository;
import com.cooperativa.gestion.service.PartnerService;
import com.cooperativa.gestion.service.PaymentService;
import com.cooperativa.gestion.service.PaymentTypeService;
import com.cooperativa.gestion.service.ReportService;
import com.cooperativa.gestion.util.PaymentTypeEnum;
import com.cooperativa.gestion.util.StyleUtils;
import com.cooperativa.gestion.util.Utils;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {

    private final PaymentService paymentService;
    private final PaymentTypeService paymentTypeService;
    private final PartnerService partnerService;
    private final PaymentRepository paymentRepository;


    @Override
    public String createReport(String initDate, String finalDate) {

            System.out.println("Iniciando reporte");
            String response = "SUCCESS";
            Workbook workbook = createExcelReportWorkbook(getPaymentsByDateRange(Utils.convertDateFormat(initDate),
                    Utils.convertDateFormat(finalDate)), findAllPaymentTypeReports(),
                    partnerService.getPartners());
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

    @Override
    public List<PaymentType> findAllPaymentTypeReports() {

        List<PaymentType> paymentTypes = new ArrayList<>();

        PaymentType paymentTypePartner = new PaymentType();
        paymentTypePartner.setPaymentTypeId(0);
        paymentTypePartner.setPaymentTypeDetails("SOCIO");

        paymentTypes.add(paymentTypePartner);
        for(PaymentType paymentType : paymentTypeService.getPaymentTypes()) {
            if(paymentType.getPaymentTypeDetails().equalsIgnoreCase("APORTACIONES")){
                if(paymentType.getPaymentTypeId() == 40) {
                    paymentType.setPaymentDescription("");
                    paymentTypes.add(paymentType);
                }
            }
            else {
                paymentTypes.add(paymentType);
            }
        }

        return paymentTypes;
    }

    private Workbook createExcelReportWorkbook(List<Payment> payments,
                                               List<PaymentType> paymentTypes,
                                               List<Partner> partners) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Balance de Cooperativa");

        // Combina las celdas (ejemplo: fila 0, de columna 0 a 9)
        CellRangeAddress cellRangeAddress = new CellRangeAddress(1, 1, 1, paymentTypes.size());
        sheet.addMergedRegion(cellRangeAddress);

        // Crea un estilo para la cabecera
        CellStyle headerStyle = workbook.createCellStyle();
        // Alineación centrada
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        // Establece los bordes
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);

        // Establece la fuente
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 20);
        headerStyle.setFont(font);

        // Crea la fila para la cabecera
        Row headerRowTittle = sheet.createRow(1);

        for(int i = 1 ; i <= paymentTypes.size() ; i++) {

            Cell headerCell1 = headerRowTittle.createCell(i);
            headerCell1.setCellStyle(headerStyle);
            headerCell1.setCellValue(i == 1 ? "BALANCE COOPERATIVA" : "");

        }
        // Crea un estilo de celda con bordes
        CellStyle borderStyle = workbook.createCellStyle();
        //Fuente pra las cabeceras
        Font fontHeader = workbook.createFont();
        fontHeader.setBold(true);
        // Establece los bordes
        borderStyle.setBorderTop(BorderStyle.THIN);
        borderStyle.setBorderBottom(BorderStyle.THIN);
        borderStyle.setBorderLeft(BorderStyle.THIN);
        borderStyle.setBorderRight(BorderStyle.THIN);
        borderStyle.setFont(fontHeader);

        Row headerRowColumn = sheet.createRow(2);

        int countPaymentType = 1;
        for(PaymentType type : paymentTypes) {

            Cell headerCell1 = headerRowColumn.createCell(countPaymentType);
            headerCell1.setCellStyle(borderStyle);
            headerCell1.setCellValue(PaymentTypeEnum
                    .getPaymentTypeDescription(type.getPaymentTypeId()));
            sheet.autoSizeColumn(countPaymentType);

            countPaymentType++;
        }

        int countRow = 3;

        for(PartnerPayment partnerPayment : getPaymentSetForPartners(paymentTypes, partners)) {
            Row row = sheet.createRow(countRow);
            row.createCell(1).setCellValue(partnerPayment.getFullName());
            row.createCell(2).setCellValue(partnerPayment.getPaymentOne());
            row.createCell(3).setCellValue(partnerPayment.getPaymentTwo());
            row.createCell(4).setCellValue(partnerPayment.getPaymentThree());
            row.createCell(5).setCellValue(partnerPayment.getPaymentFour());
            row.createCell(6).setCellValue(partnerPayment.getPaymentFive());
            row.createCell(7).setCellValue(partnerPayment.getPaymentSix());
            row.createCell(8).setCellValue(partnerPayment.getPaymentSeven());
            row.createCell(9).setCellValue(partnerPayment.getPaymentEight());
            row.createCell(10).setCellValue(partnerPayment.getPaymentNine());
            row.createCell(11).setCellValue(partnerPayment.getPaymentTen());
            row.createCell(12).setCellValue(partnerPayment.getPaymentEleven());
            row.createCell(13).setCellValue(partnerPayment.getPaymentTwelve());
            row.createCell(14).setCellValue(partnerPayment.getPaymentThirteen());

            countRow++;
        }

        return workbook;
    }

    private List<Payment> getPaymentsByDateRange(LocalDate initDate, LocalDate finalDate) {
        List<Payment> payments = paymentService.getPayments().stream()
                .filter(payment -> isDateInRange(payment.getPaymentDate(), initDate, finalDate))
                .sorted(Comparator.comparing(Payment::getPaymentDate))
                .collect(Collectors.toList());

        return payments;
    }

    private boolean isDateInRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return (date.isEqual(startDate) || date.isEqual(endDate) || (date.isAfter(startDate) && date.isBefore(endDate)));
    }

    private List<PartnerPayment> getPaymentSetForPartners(List<PaymentType> paymentList,
                                                          List<Partner> partners) {
        getContributions(partners);
        List<PartnerPayment> partnerPayments = new ArrayList<>();
        for(Partner partner : partnerService.getPartners()) {
            List<Payment> paymentsByIdPartner = paymentRepository.getPaymentsCodeByIdPartner(partner
                    .getPartnerId());
            PartnerPayment partnerPayment = new PartnerPayment();
            partnerPayment.setFullName(partner.getPartnerName());
            List<String> paymentOfPartners = new ArrayList<>();
            //paymentOfPartners.add(partner.getPartnerName());
            for (PaymentType type : paymentList) {
                boolean isExists = false;
                for (Payment payment : paymentsByIdPartner) {
                    if (payment.getPaymentType().getPaymentTypeId().equals(type.getPaymentTypeId())) {
                        paymentOfPartners.add(payment.getPaymentAmount().toString());
                        isExists = true;
                    }
                }

                if (!isExists)
                paymentOfPartners.add("-");
            }

            partnerPayment.setPaymentOne(paymentOfPartners.get(1));
            partnerPayment.setPaymentTwo(paymentOfPartners.get(2));
            partnerPayment.setPaymentThree(paymentOfPartners.get(3));
            partnerPayment.setPaymentFour(paymentOfPartners.get(4));
            partnerPayment.setPaymentFive(paymentOfPartners.get(5));
            partnerPayment.setPaymentSix(paymentOfPartners.get(6));
            partnerPayment.setPaymentSeven(paymentOfPartners.get(7));
            partnerPayment.setPaymentEight(paymentOfPartners.get(8));
            partnerPayment.setPaymentNine(paymentOfPartners.get(9));
            partnerPayment.setPaymentTen(paymentOfPartners.get(10));
            partnerPayment.setPaymentEleven(paymentOfPartners.get(11));
            partnerPayment.setPaymentTwelve(paymentOfPartners.get(12));
            partnerPayment.setPaymentThirteen(paymentOfPartners.get(13));

            partnerPayments.add(partnerPayment);
        }
        return partnerPayments;
    }


    private List<PartnerPaymentContribution> getContributions(List<Partner> partners) {

        List<Payment> paymentForContributions = paymentRepository.getPaymentAllContribution();
        List<PartnerPaymentContribution> paymentContributions = new ArrayList<>();
        for (Partner partner : partners) {
            PartnerPaymentContribution partnerContribution = new PartnerPaymentContribution();
            double amountTotal = 0;
                for (Payment payment : paymentForContributions) {
                    if(payment.getPartner().getPartnerId().equals(partner.getPartnerId())) {
                        amountTotal = amountTotal + payment.getPaymentAmount().doubleValue();
                    }
                }

                if (amountTotal != 0) {
                    partnerContribution.setPartner(partner);
                    partnerContribution.setAmount(new BigDecimal(amountTotal));
                    System.out.println("El Objeto es : " + partnerContribution);
                    paymentContributions.add(partnerContribution);
                }
        }
        return paymentContributions;
    }

}
