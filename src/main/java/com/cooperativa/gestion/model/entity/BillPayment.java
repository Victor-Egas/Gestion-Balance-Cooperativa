package com.cooperativa.gestion.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_egreso")
public class BillPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer billPaymentId;
    @Column(name = "fecha_egreso")
    private LocalDate billPaymentDate;
    @Column(name = "fecha_registro")
    private LocalDate billPaymentDateRecord;
    @Column(name = "monto")
    private BigDecimal billPaymentAmount;
    @Column(name = "descripcion")
    private String billPaymentDetails;
    @Column(name = "ticket")
    private String ticket;
}
