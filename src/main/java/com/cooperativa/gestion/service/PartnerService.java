package com.cooperativa.gestion.service;

import com.cooperativa.gestion.model.entity.Partner;

import java.util.List;

public interface PartnerService {

    Partner savePartner(Partner partner);

    List<Partner> getPartners();

    Partner getPartnerById(Integer id);

    List<Partner> getPartnersPaymentPendingById(Integer id);
    boolean deletePartnerById(Integer id);

}
