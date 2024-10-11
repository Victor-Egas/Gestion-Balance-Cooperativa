package com.cooperativa.gestion.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Workbook;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StyleUtils {

  public static CellStyle createCurrencyCellStyle(Workbook workbook) {
    CellStyle currencyStyle = workbook.createCellStyle();
    DataFormat format = workbook.createDataFormat();
    currencyStyle.setDataFormat(format.getFormat("s/#,##0.00"));
    return currencyStyle;
  }

  public static CellStyle createDateCellStyle(Workbook workbook) {
    CellStyle dateCellStyle = workbook.createCellStyle();
    CreationHelper creationHelper = workbook.getCreationHelper();
    dateCellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd/MM/yyyy"));
    return dateCellStyle;
  }


}
