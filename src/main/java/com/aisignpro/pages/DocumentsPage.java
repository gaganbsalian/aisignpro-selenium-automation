package com.aisignpro.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocumentsPage {

 WebDriver driver;
 WebDriverWait wait;

 public DocumentsPage(WebDriver driver) {
 this.driver = driver;
 this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
 PageFactory.initElements(driver, this);
 }

 // Customers button on the Documents page
 @FindBy(xpath = "//span[text()='Customers']")
 WebElement customersButton;

 public void clickCustomers() {
 wait.until(ExpectedConditions.visibilityOf(customersButton));
 wait.until(ExpectedConditions.elementToBeClickable(customersButton))
 .click();
 }
}
