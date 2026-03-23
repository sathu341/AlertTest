package com.alert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestAlert {
 WebDriver driver;
 WebDriverWait  wait;

 @BeforeSuite
 public void startTest()
 {
	 this.driver=new ChromeDriver();
	 this.driver.manage().window().maximize();
	 this.driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	 this.wait=new WebDriverWait(this.driver,Duration.ofSeconds(10));
	
	 
 }
 
 @Test(priority=1)
 public void testAlert() throws InterruptedException
 {  
	 
	 this.driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
	 Alert alert=this.wait.until(
			 ExpectedConditions.alertIsPresent()
			 );
	 String message=alert.getText();
	 System.out.println("JS Message:"+message);
	 alert.accept();
 }
 @Test(priority=2)
 public  void  testConfirm()
 {
	 this.driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	 Alert alert=this.wait.until(
			 ExpectedConditions.alertIsPresent()
			 );
	 String msg=alert.getText();
	 System.out.println("Confirm Message"+msg);
	alert.dismiss();
 }
 @Test(priority=3)
 public void testPrompt()
 {
	 this.driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	 Alert alert=this.wait.until(
			 ExpectedConditions.alertIsPresent()
			 );
	 String msg=alert.getText();
	 System.out.println("Prompt Message"+msg);
	 alert.sendKeys("Hello");
	 alert.accept();
 }
 @AfterSuite 
 public  void downTest()
 {
	 this.driver.quit();
 }
}
