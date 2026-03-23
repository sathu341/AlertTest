package com.alert;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InValidTest {
	WebDriver driver;
@BeforeSuite
public void startTesting()
{
	this.driver=new ChromeDriver();
	this.driver.get("https://www.saucedemo.com/");
	this.driver.manage().window().maximize();
}
@Test(dataProvider="invalid")
public void invalidTesting(String user,String password) throws InterruptedException
{
	this.driver.findElement(By.id("user-name"))
	.sendKeys(user);
	this.driver.findElement(By.id("password"))
	.sendKeys(password);
	this.driver.findElement(By.id("login-button"))
	.click();
//	Thread.sleep(2000);
	String actulResult=this.driver.findElement(By.xpath("//h3[@data-test='error']"))
			.getText();

	Assert.assertTrue(actulResult.contains("Epic sadface: Username and password do not match any user in this service"));
	System.out.println("Invalid UserName Testing: "+user);
}

@DataProvider(name="invalid")
public Object[][] getData(){
	Object[][] data=null;
	
	String path="C:\\Users\\Dell\\Documents\\invalidlogin_test_data.xlsx";
	try {
		FileInputStream file=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		data=new Object[rows][cols];
		for(int i=1;i<=rows;i++)
		{
			for(int j=0;j<cols;j++)
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
public void closeBrowser()
{
	this.driver.close();
	System.out.println("Test Completed");
}
}
