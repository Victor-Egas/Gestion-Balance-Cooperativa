package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.entity.Partner;
import com.cooperativa.gestion.service.PartnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class PartnerControllerTest {
    @Mock
    private PartnerService service;
    @InjectMocks
    private PartnerController controller;

    @DisplayName("controller - guardar socio")
    @Test
    void savePartnerTest() {
        Partner partner = new Partner();
        partner.setPartnerName("VICTOR EGAS");
        when(service.savePartner(any(Partner.class))).thenReturn(partner);
        ResponseEntity<Partner> response = controller.savePartner(partner);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(partner, response.getBody());
    }

    @DisplayName("controller - obtener todos los socios")
    @Test
    void getPartnersTest() {
        List<Partner> partners = new ArrayList<>();

        Partner partner = new Partner();
        partner.setPartnerName("DOMINICK EGAS");
        Partner partner1 = new Partner();

        partner1.setPartnerName("LUCIA ESQUEN");
        partners.add(partner);
        partners.add(partner1);

        when(service.getPartners()).thenReturn(partners);

        ResponseEntity<List<Partner>> response = controller.getPartners();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @DisplayName("controller - obtener socio por id")
    @Test
    void getPartnerByIdTest() {
        int partnerId = 1;
        Partner partner = new Partner();

        when(service.getPartnerById(eq(partnerId))).thenReturn(partner);

        ResponseEntity<Partner> response = controller.getPartnerById(partnerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(partner, response.getBody());
    }

    @DisplayName("controller - actualizar socio por id")
    @Test
    void updatePartnerTest() {
        int partnerId = 1;
        Partner existingPartner = new Partner();
        Partner updatedPartner = new Partner();

        when(service.getPartnerById(eq(partnerId))).thenReturn(existingPartner);
        when(service.savePartner(any(Partner.class))).thenReturn(updatedPartner);

        ResponseEntity<Partner> response = controller.updatePartner(partnerId, updatedPartner);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedPartner, response.getBody());
    }

    @DisplayName("controller - eliminar socio por id")
    @Test
    void deletePartnerByIdTest() {
        int partnerId = 1;

        when(service.deletePartnerById(eq(partnerId))).thenReturn(true);

        ResponseEntity<String> response = controller.deletePartnerById(partnerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Socio eliminado exitosamente", response.getBody());
    }
}