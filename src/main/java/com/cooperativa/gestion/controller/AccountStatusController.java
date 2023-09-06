package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.response.PendingPaymentResponse;
import com.cooperativa.gestion.service.AccountStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/status-account")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AccountStatusController {

    private final AccountStatusService accountService;

    /* Consulta de balance total de ingresos y egresos */
    @GetMapping("/global")
    public BigDecimal getAccountStatusGlobal() {
        return accountService.getAccountStatusGlobal();
    }

    @GetMapping("/pending-payment/{idPartner}")
    public List<PendingPaymentResponse> getPendingPayments(@PathVariable Integer idPartner) {
        System.out.println("ENTRO");
        return accountService.getPaymentsByIdPartner(idPartner);
    }
}
