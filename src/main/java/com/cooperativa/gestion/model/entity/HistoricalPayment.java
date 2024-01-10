package com.cooperativa.gestion.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_ingreso_historico")
public class HistoricalPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer paymentId;
    @Column(name = "nro_recibo")
    private Integer paymentTicket;
    @Column(name = "monto")
    private BigDecimal paymentAmount;
    @Column(name = "fecha_pago")
    private String paymentDate;
    @Column(name = "fecha_registro")
    private String paymentDateRecord;
    @Column(name = "descripcion")
    private String paymentDetails;

    @ManyToOne
    @JoinColumn(name = "partnerId")
    private Partner partner;
}
