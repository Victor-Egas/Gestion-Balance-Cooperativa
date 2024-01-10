package com.cooperativa.gestion.repository;

import com.cooperativa.gestion.model.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {
}
