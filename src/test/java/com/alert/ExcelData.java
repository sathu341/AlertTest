package com.alert;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
public static String getExcelData(int row,int col)
{
	String path="C://Users/Dell/Documents/testlogin.xlsx";
	String data = "";

    try {

        FileInputStream file = new FileInputStream(path);

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        data = sheet.getRow(row).getCell(col).toString();

        workbook.close();

    } catch (Exception e) {
        System.out.println(e);
    }

    return data;
}
}
