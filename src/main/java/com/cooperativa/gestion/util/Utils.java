package com.cooperativa.gestion.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

  public static String convertDateFormatToString(LocalDate inputDate) {
      // Definir el formato de salida
      DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

      // Formatear el LocalDate a una cadena
      String outputDate = inputDate.format(outputFormatter);

      return outputDate;
  }

  public static LocalDate convertDateFormat(String dateString) {
      LocalDate date = LocalDate.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

      try {
          // Convertir el String a LocalDate
          date = LocalDate.parse(dateString, formatter);
          System.out.println("Fecha convertida: " + date);
      } catch (DateTimeParseException e) {
          System.out.println("Formato de fecha inválido: " + e.getMessage());
      }
      return date;
  }

  public static String formatAmount(String amount) {

      BigDecimal bigDecimalValue = new BigDecimal(amount);
      DecimalFormat decimalFormat = new DecimalFormat("0.00");
      String formattedValue = decimalFormat.format(bigDecimalValue);

      return formattedValue;
  }

  /*public static String formatAmount(BigDecimal amount) {
    return amount.compareTo(new BigDecimal("0.00")) ? "0.00" : amount
  }*/

  public static BigDecimal validatedAmount(BigDecimal amount) {
      return amount == null ? new BigDecimal("0.00") : amount;
  }
}
