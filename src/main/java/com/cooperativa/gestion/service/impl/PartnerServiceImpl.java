package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.repository.PartnerRepository;
import com.cooperativa.gestion.model.entity.PartnerRequest;
import com.cooperativa.gestion.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerServiceImpl implements PartnerService {
    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public PartnerRequest savePartner(PartnerRequest partnerRequest) {
        System.out.println("Partner : "+ partnerRequest.getPartnerName());
        return partnerRepository.save(partnerRequest);
    }

    @Override
    public List<PartnerRequest> getPartners() {
        return partnerRepository.findAll();
    }

}
