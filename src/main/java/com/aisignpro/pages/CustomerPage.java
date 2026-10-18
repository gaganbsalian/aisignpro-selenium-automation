package com.aisignpro.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerPage {

 WebDriver driver;
 WebDriverWait wait;

 public CustomerPage(WebDriver driver) {
 this.driver = driver;
 this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
 PageFactory.initElements(driver, this);
 }

 @FindBy(xpath = "//button[text()='Add Customer']")
 WebElement addCustomerButton;

 @FindBy(xpath = "//input[@placeholder='Enter mobile number']")
 WebElement mobileNumberTextField;

 @FindBy(xpath = "//input[@placeholder='Enter contact name']")
 WebElement contactNameTextField;

 @FindBy(xpath = "//input[@placeholder='Enter email ID']")
 WebElement emailIdTextField;

 @FindBy(xpath = "//button[text()='Assign Documents ']")
 WebElement assignDocumentsButton;

 @FindBy(xpath = "//button[@class='rail-user-btn']")
 WebElement qaAutomationButton;

 @FindBy(xpath = "//button[text()=' Sign out ']")
 WebElement signOutButton;

 public void clickAddCustomer() {
 wait.until(ExpectedConditions.elementToBeClickable(addCustomerButton))
 .click();
 }

 public void enterMobileNumber(String mobileNumber) {
 WebElement field = wait.until(
 ExpectedConditions.visibilityOf(mobileNumberTextField));
 field.clear();
 field.sendKeys(mobileNumber);
 }

 public void enterContactName(String contactName) {
 WebElement field = wait.until(
 ExpectedConditions.visibilityOf(contactNameTextField));
 field.clear();
 field.sendKeys(contactName);
 }

 public void enterEmailId(String emailId) {
 WebElement field = wait.until(
 ExpectedConditions.visibilityOf(emailIdTextField));
 field.clear();
 field.sendKeys(emailId);
 }

 public void clickAssignDocuments() {
 wait.until(
 ExpectedConditions.elementToBeClickable(assignDocumentsButton))
 .click();
 }

 public void clickQAautomationButton() {
 wait.until(ExpectedConditions.elementToBeClickable(qaAutomationButton))
 .click();
 }

 public void clickSignOut() {
 wait.until(ExpectedConditions.elementToBeClickable(signOutButton))
 .click();
 }
}