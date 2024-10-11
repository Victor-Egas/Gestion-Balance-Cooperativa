package com.cooperativa.gestion.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

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
}
