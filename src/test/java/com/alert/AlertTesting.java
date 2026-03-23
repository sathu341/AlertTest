package com.alert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AlertTesting {

WebDriver driver;
WebDriverWait wait;

@BeforeSuite
public void startTesting() {

driver = new ChromeDriver();
driver.manage().window().maximize();

wait = new WebDriverWait(driver, Duration.ofSeconds(10));

driver.get("https://the-internet.herokuapp.com/javascript_alerts");

}

@Test(priority=1)
public void alertTesting() throws InterruptedException {

// SIMPLE ALERT

WebElement btn = wait.until(
ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Alert']"))
);

btn.click();

Alert alert = wait.until(ExpectedConditions.alertIsPresent());

System.out.println("Alert Message: " + alert.getText());

alert.accept();

Thread.sleep(2000);


// CONFIRM ALERT

WebElement btn2 = wait.until(
ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Confirm']"))
);

btn2.click();

Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());

System.out.println("Confirm Message: " + alert2.getText());

alert2.accept();

Thread.sleep(2000);

}


@Test(priority=2)
public void promptTest() {

// PROMPT ALERT

WebElement btn = wait.until(
ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Prompt']"))
);

btn.click();

Alert alert = wait.until(ExpectedConditions.alertIsPresent());

alert.sendKeys("Hello");

alert.accept();

}


@AfterSuite
public void dropTest() {

driver.quit();

}

}