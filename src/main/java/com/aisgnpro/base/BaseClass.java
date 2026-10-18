package com.aisgnpro.base;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseClass {

 protected WebDriver driver;
 public WebDriver getDriver() {
	    return driver;
	}
 public String randomString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
 public String randomNumber()
	{
		String generatedstring=RandomStringUtils.randomNumeric(10);
		return generatedstring;
	}
	
 @BeforeMethod
 public void setUp() {
 driver = new ChromeDriver();
 driver.manage().window().maximize();
 driver.get("https://cpastaging.aisignpro.com/");
 }

 @AfterMethod
 public void tearDown() {
 if (driver != null) {
 driver.quit();
 }
 
 }
}
