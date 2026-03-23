package com.alert;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExceldata {
public static String TestExcel(int row,int col)
{  
	String data="";
	try {
	String path="C:\\Users\\Dell\\Documents\\testlogin.xlsx";
	FileInputStream file=new FileInputStream(path);
	XSSFWorkbook workbook= new XSSFWorkbook(file);
	XSSFSheet sheet=workbook.getSheet("sheet1");
	data=sheet.getRow(row).getCell(col).toString();
	workbook.close();
} 
 catch(Exception e)
{
	 System.out.println(e);
}
	return data;
}
}
