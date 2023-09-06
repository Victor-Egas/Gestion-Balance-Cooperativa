package com.cooperativa.gestion.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tb_ingreso")
public class PaymentRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private BigDecimal paymentAmount;
    private LocalDateTime paymentDate;
    private String paymentDetails;

    @ManyToOne
    @JoinColumn(name = "paymentTypeId")
    private PaymentTypeRequest paymentTypeRequest;

    @ManyToOne
    @JoinColumn(name = "partnerId")
    private PartnerRequest partnerRequest;
}
