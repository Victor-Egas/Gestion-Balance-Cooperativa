package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.entity.PartnerRequest;
import com.cooperativa.gestion.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partner")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PartnerController {

    private final PartnerService service;

    /* Registro de un nuevo socio */
    @PostMapping("/save")
    public PartnerRequest savePartner(@RequestBody PartnerRequest partnerRequest) {
        System.out.println("PartnerService : "+ partnerRequest.getPartnerName());
        return service.savePartner(partnerRequest);
    }

    /* Consultar todos los socios */
    @GetMapping("/findAll")
    public List<PartnerRequest> getPartners() {

        return service.getPartners();
    }

}
