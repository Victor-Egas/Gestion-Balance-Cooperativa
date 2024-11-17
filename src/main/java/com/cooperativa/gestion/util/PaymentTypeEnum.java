package com.cooperativa.gestion.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum PaymentTypeEnum {
    SOCIO(0, " SOCIO "),
    MANTENIMIENTO(1, "MANTENIMIENTO - LOCAL"),
    ARQUITECTO_ONE(2, "ARQUITECTO - PAGO 1"),
    LUZ_INVASORES(3, "LUZ INVASORES"),
    ARQUITECTO_TWO(4, "ARQUITECTO - PAGO FINAL"),
    APORTACIONES(40, "APORTACIONES"),
    PROYECTO_LUZ_1000(41, "PROYECTO LUZ - PAGO 1"),
    PROYECTO_LUZ_500(42, "PROYECTO LUZ - PAGO 2"),
    ARQUITECTO_THREE(43, "ARQUITECTO - LUZ"),
    AUTOVALUO_2021(44, "AUTOVALUO - 2021"),
    OTROS(45, "OTROS"),
    AUTOVALUO_2022(46, "AUTOVALUO -  2022"),
    PROYECTO_LUZ_FINAL(47, "PROYECTO LUZ - PAGO 3"),
    PORTON_LADO_A(48, "PORTON - LADO A");

    private final Integer code;
    private final String description;

    public static String getPaymentTypeDescription(Integer code) {
        return Arrays.stream(PaymentTypeEnum.values())
                .filter(paymentType -> paymentType.getCode() == code)
                .collect(Collectors.toList())
                .get(0).getDescription();
    }



}
