package com.cooperativa.gestion.service.impl;

import com.cooperativa.gestion.model.entity.Payment;
import com.cooperativa.gestion.repository.PartnerRepository;
import com.cooperativa.gestion.model.entity.Partner;
import com.cooperativa.gestion.repository.PaymentRepository;
import com.cooperativa.gestion.service.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;
    private final PaymentRepository paymentRepository;
    @Override
    public Partner savePartner(Partner partner) {
        System.out.println("Partner : "+ partner.getPartnerName());
        return partnerRepository.save(partner);
    }
    @Override
    public List<Partner> getPartners() {
        log.info("Inicia la capa de servicio de consula de socios");
        return partnerRepository.findAll();
    }
    @Override
    public Partner getPartnerById(Integer id) {return partnerRepository.findById(id).get();}

    @Override
    public List<Partner> getPartnersPaymentPendingById(Integer id) {
        List<Integer> partnersId = new ArrayList<>();


        for(Partner partner : partnerRepository.findAll()){
            for(Payment payment: paymentRepository.getPartnersPaymentPending(id)){
                if(payment.getPartner().getPartnerId().equals(partner.getPartnerId())){
                    partnersId.add(partner.getPartnerId());
                }
            }
        }

        List<Partner> partnersPaymentPending =  partnerRepository.findAll().stream()
                .filter(partner -> !partnersId.contains(partner.getPartnerId()))
                .collect(Collectors.toList());


        return partnersPaymentPending;
    }

    @Override
    public boolean deletePartnerById(Integer id) {
        boolean isExistsPartner = false;
        if(partnerRepository.existsById(id)){
            partnerRepository.delete(partnerRepository.findById(id).get());
            isExistsPartner = true;}
        return isExistsPartner;
    }

}
