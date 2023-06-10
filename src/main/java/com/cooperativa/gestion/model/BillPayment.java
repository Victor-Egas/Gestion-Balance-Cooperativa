package com.cooperativa.gestion.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tb_egreso")
public class BillPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billPaymentId;

    private LocalDateTime billPaymentDate;

    private BigDecimal billPaymentAmount;

    private String billPaymentDetails;
}
