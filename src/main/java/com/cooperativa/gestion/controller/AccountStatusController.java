package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.service.AccountStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/status-account")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AccountStatusController {

    private final AccountStatusService accountService;

    @GetMapping("/global")
    public BigDecimal getAccountStatusGlobal() {
        return accountService.getAccountStatusGlobal();
    }
}
