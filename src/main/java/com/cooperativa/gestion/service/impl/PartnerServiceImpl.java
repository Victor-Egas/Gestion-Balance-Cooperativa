package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.dao.PartnerRepository;
import com.cooperativa.gestion.model.Partner;
import com.cooperativa.gestion.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Scheduled(cron = "0 30 20 * * 6")
    public void scheduleTaskUsingCron() {
        long now = System.currentTimeMillis()/1000;
        System.out.println("Ejecuto el scheduler : OK"+"\t"+"hora : "+ LocalDateTime.now());
    }
}
