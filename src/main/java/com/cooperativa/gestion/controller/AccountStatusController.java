package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.response.PendingPaymentFullResponse;
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
    @GetMapping("/full")
    public BigDecimal getAccountStatusGlobal() {
        return accountService.getAccountStatusGlobal();
    }

    /* Consulta de pagos pendientes del socio*/
    @GetMapping("/pending-payment/{idPartner}")
    public PendingPaymentResponse getPendingPayments(@PathVariable Integer idPartner) {
        return accountService.getPaymentsByIdPartner(idPartner);
    }

    @GetMapping("/pending-payment/full/{idPartner}")
    public PendingPaymentFullResponse getFullPendingPayments(@PathVariable Integer idPartner) {
        return accountService.getFullPaymentAmountByIdPartner(idPartner);
    }
}
