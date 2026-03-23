package com.alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MouseOverTest {
    WebDriver driver;
    Actions act;

    @BeforeSuite
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        act = new Actions(driver);
    }

    //@Test
    //public void testMouseHover() {
//        driver.get("https://demoqa.com/menu");
//
//        WebElement mainItem2 = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
//        WebElement subList = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
//
//        act.moveToElement(mainItem2).perform();
//
//        // Assert submenu is displayed
//        Assert.assertTrue(subList.isDisplayed(), "Sub List should be visible after hover");
    //}
    @Test(priority=1)
    public void doubleClickTest() throws InterruptedException
    {
    	driver.get("https://demoqa.com/buttons");
    	Thread.sleep(5000);
    	WebElement dBtn=driver.findElement(By.id("doubleClickBtn"));
    	act.doubleClick(dBtn).perform();
    	Thread.sleep(5000);
    	WebElement msg=driver.findElement(By.id("doubleClickMessage"));
    	System.out.println(msg);
    	Assert.assertTrue(msg.isDisplayed(), "You have done a double click");
        
        
    }
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
