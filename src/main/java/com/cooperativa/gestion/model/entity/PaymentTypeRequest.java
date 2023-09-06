package com.cooperativa.gestion.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tipo_ingreso")
public class PaymentTypeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentTypeId;

    private String paymentTypeDetails;

    private String paymentDescription;

    private String paymentAmount;
}
