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
@Table(name = "tb_ingreso")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer paymentId;
    @Column(name = "monto")
    private BigDecimal paymentAmount;
    @Column(name = "fecha_pago")
    private LocalDate paymentDate;
    @Column(name = "fecha_registro")
    private LocalDate paymentDateRecord;
    @Column(name = "descripcion")
    private String paymentDetails;
    @Column(name = "nro_recibo")
    private Integer paymentTicket;

    @ManyToOne
    @JoinColumn(name = "partnerId")
    private Partner partner;

    @ManyToOne
    @JoinColumn(name = "paymentTypeId")
    private PaymentType paymentType;

}
