package com.cooperativa.gestion.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.cooperativa.gestion.model.entity.Partner;
import com.cooperativa.gestion.repository.PartnerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PartnerServiceImplTest {

    @Mock
    private PartnerRepository partnerRepository;
    @InjectMocks
    private PartnerServiceImpl partnerService;


    @DisplayName("registrar socio")
    @Test
    void savePartnerTest() {
        Partner partnerToSave = new Partner();
        partnerToSave.setPartnerName("Linus Torval");

        when(partnerRepository.save(any(Partner.class))).thenReturn(partnerToSave);

        Partner savedPartner = partnerService.savePartner(partnerToSave);

        assertNotNull(savedPartner);
        assertEquals("Linus Torval", savedPartner.getPartnerName());
    }

    @DisplayName("buscar a todos los socios")
    @Test
    void getPartnersTest() {
        List<Partner> partners = new ArrayList<>();
        partners.add(new Partner(3, "java"));
        partners.add(new Partner(4, "phyton"));

        when(partnerRepository.findAll()).thenReturn(partners);

        List<Partner> retrievedPartners = partnerService.getPartners();

        assertNotNull(retrievedPartners);
        assertEquals("phyton", retrievedPartners.get(1).getPartnerName());
    }

    @DisplayName("obtener socio por id")
    @Test
    void getPartnerByIdTest() {
        int partnerId = 1;
        Partner partner = new Partner();
        partner.setPartnerId(partnerId);
        partner.setPartnerName("jmeter");

        when(partnerRepository.findById(eq(partnerId))).thenReturn(Optional.of(partner));

        Partner retrievedPartner = partnerService.getPartnerById(partnerId);

        assertNotNull(retrievedPartner);
        assertEquals("jmeter", retrievedPartner.getPartnerName());
    }

    @DisplayName("eliminar socio")
    @Test
    void deletePartnerByIdTest() {
        int partnerId = 1;
        when(partnerRepository.existsById(eq(partnerId))).thenReturn(false);

        boolean deleted = partnerService.deletePartnerById(partnerId);
        assertFalse(deleted);
        verify(partnerRepository, never()).delete(any());
    }
}