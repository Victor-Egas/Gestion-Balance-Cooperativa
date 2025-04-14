package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.entity.Partner;
import com.cooperativa.gestion.service.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/partner")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PartnerController {
    private final PartnerService service;
    @PostMapping("/save")
    public ResponseEntity<Partner> savePartner(@RequestBody Partner partner) {
        System.out.println("PartnerService : " + partner.getPartnerName());
        Partner savedPartner = service.savePartner(partner);
        return ResponseEntity.ok(savedPartner);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<Partner>> getPartners() {
        log.info("Inicia la consulta de todos los socios");
        List<Partner> partners = service.getPartners();
        HttpHeaders headers = new HttpHeaders();
        headers.add("opn-number", "2");
        headers.add("region", "Lima");
        return ResponseEntity.ok()
                .headers(headers)
                .body(partners);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartnerById(@PathVariable Integer id) {
        Partner partner = service.getPartnerById(id);
        if (partner != null) {
            return ResponseEntity.ok(partner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Partner> updatePartner(@PathVariable Integer id, @RequestBody Partner updatedPartner) {
        Partner existingPartner = service.getPartnerById(id);

        if (existingPartner != null) {
            updatedPartner.setPartnerId(id);
            existingPartner.setPartnerName(updatedPartner.getPartnerName());
            Partner updated = service.savePartner(existingPartner);

            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePartnerById(@PathVariable Integer id) {
        boolean deleted = service.deletePartnerById(id);
        if (deleted) {
            return ResponseEntity.ok("Socio eliminado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/pending-payment")
    public ResponseEntity<List<Partner>> getPartnersPendingPaymentById(@RequestParam Integer paymentId) {
        return ResponseEntity.ok(service.getPartnersPaymentPendingById(paymentId));
    }

}
