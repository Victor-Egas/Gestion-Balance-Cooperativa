package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.Partner;
import com.cooperativa.gestion.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/partner")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PartnerController {

    private final PartnerService service;

    @PostMapping("/save")
    public Partner savePartner(@RequestBody Partner partner) {
        System.out.println("PartnerService : "+partner.getPartnerName());
        return service.savePartner(partner);
    }

    @GetMapping("/findAll")
    public List<Partner> getPartners() {

        return service.getPartners();
    }

}
