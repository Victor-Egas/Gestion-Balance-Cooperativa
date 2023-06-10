package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.dao.PartnerRepository;
import com.cooperativa.gestion.model.Partner;
import com.cooperativa.gestion.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerServiceImpl implements PartnerService {
    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public Partner savePartner(Partner partner) {
        System.out.println("Partner : "+partner.getPartnerName());
        return partnerRepository.save(partner);
    }

    @Override
    public List<Partner> getPartners() {
        return partnerRepository.findAll();
    }
}
