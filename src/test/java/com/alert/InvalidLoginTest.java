package com.alert;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class InvalidLoginTest {
	@BeforeSuite
	public void startTest()
	{
		
	}
@DataProvider(name="invalid")
public Object[][] getData()
{
	String path="C:\\Users\\Dell\\Documents\\testlogin.xlsx";
	Object[][] data=null;
	try {
		FileInputStream file=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int row=sheet.getLastRowNum();
		int col=sheet.getRow(0).getLastCellNum();
		data=new Object[row][col];
		for(int i=1;i<row; i++)
		{
			for(int j=0;j<col; j++)
			{
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		workbook.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return data;
}
@AfterSuite
public void  closeTest() {
	
}
}
