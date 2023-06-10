package com.cooperativa.gestion.dao;

import com.cooperativa.gestion.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType , Integer> {
}
