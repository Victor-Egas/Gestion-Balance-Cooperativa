package com.cooperativa.gestion.model.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tipo_ingreso")
public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Integer paymentTypeId;
    @Column(name = "tipo_pago")
    private String paymentTypeDetails;
    @Column(name = "tipo_pago_descripcion")
    private String paymentDescription;
    @Column(name = "monto_tipo_pago")
    private String paymentAmount;
}
