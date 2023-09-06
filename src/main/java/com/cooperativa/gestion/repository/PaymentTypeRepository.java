package com.cooperativa.gestion.repository;

import com.cooperativa.gestion.model.entity.PaymentTypeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentTypeRepository extends JpaRepository<PaymentTypeRequest, Integer> {
;
}
