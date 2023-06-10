package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.Partner;

import java.util.List;

public interface PartnerService {

    public Partner savePartner(Partner partner);

    public List<Partner> getPartners();
}
