package com.cooperativa.gestion.repository;

import com.cooperativa.gestion.model.entity.PartnerRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<PartnerRequest, Integer> {
}
