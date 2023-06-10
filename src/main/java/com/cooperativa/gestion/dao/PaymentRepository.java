package com.cooperativa.gestion.dao;

import com.cooperativa.gestion.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment , Integer> {

}
