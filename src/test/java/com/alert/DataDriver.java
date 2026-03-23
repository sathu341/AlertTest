package com.alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DataDriver {
	WebDriver driver;
@BeforeSuite
public  void startTest()
{
	 driver = new ChromeDriver();

     driver.get("https://www.saucedemo.com/");
}
@Test
public void  loginTest() {
	try {
		
	

     for(int i=2; i<=3; i++) {

         String username = ExcelData.getExcelData(i, 1);
         System.out.println(username);
         String password = ExcelData.getExcelData(i,2);

         driver.findElement(By.id("user-name")).clear();
         driver.findElement(By.id("password")).clear();

         driver.findElement(By.id("user-name")).sendKeys(username);
         driver.findElement(By.id("password")).sendKeys(password);

         driver.findElement(By.id("login-button")).click();

         System.out.println("Login Attempt with: " + username);
          Thread.sleep(5000);
     
          // Logout if login successful
          if (driver.getCurrentUrl().contains("inventory")) {

              driver.findElement(By.id("react-burger-menu-btn")).click();
              Thread.sleep(2000);

              driver.findElement(By.id("logout_sidebar_link")).click();

              Thread.sleep(2000);
          }

         
     }
	}
     catch (Exception e) {
         System.out.println(e);
     }
    
     }
@AfterSuite
public void  dropBrowser()
{
     driver.quit();
}
}
