package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.entity.PartnerRequest;

import java.util.List;

public interface PartnerService {

    public PartnerRequest savePartner(PartnerRequest partnerRequest);

    public List<PartnerRequest> getPartners();
}
