package com.cooperativa.gestion.controller;


import com.cooperativa.gestion.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping
    public String generateReport(@RequestParam("initDate") String starDate, @RequestParam("finalDate") String endDate) {
        return reportService.createReport(starDate, endDate);
    }
}
