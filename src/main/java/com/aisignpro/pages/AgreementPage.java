package com.aisignpro.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgreementPage {

 WebDriver driver;
 WebDriverWait wait;
 Actions actions;

 public AgreementPage(WebDriver driver) {
 this.driver = driver;
 this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
 this.actions = new Actions(driver);
 PageFactory.initElements(driver, this);
 }

 // Customer created successfully - OK button
 @FindBy(xpath = "//button[text()='OK']")
 WebElement successAlertOkButton;

 // Documents dropdown / menu
 @FindBy(xpath = "//div[@title='Show documents']")
 WebElement documentsDropdown;

 // First document checkbox in the side menu
 @FindBy(xpath = "//div[contains(@class, 'aa-doc-list')]/div[1]//input[@type='checkbox']")
 WebElement firstDocumentCheckbox;

 // Signature field in the toolbar
 @FindBy(xpath = "//span[text()='Signature']")
 WebElement signatureButton;

 // Destination where the signature should be dropped
 @FindBy(xpath = "//div[@class='fpe-doc-area fpe-place-zone']")
 WebElement signatureDropTarget;

 // Send Mail button
 @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
 WebElement sendMailButton;

 // Send Anyway button
 @FindBy(xpath = "//button[text()='Send anyway']")
 WebElement sendAnywayButton;

 // Continue to Send Mail button
 @FindBy(xpath = "//button[text()='Continue to Send Mail ']")
 WebElement continueToSendMailButton;

 // Final Continue button in the next 
 @FindBy(xpath = "//button[text()='Continue']")
 WebElement finalContinueButton;

 public void clickSuccessAlertOk() {
 wait.until(
 ExpectedConditions.elementToBeClickable(successAlertOkButton))
 .click();
 }

 public void hoverOnDocumentsDropdown() {
 WebElement dropdown = wait.until(
 ExpectedConditions.visibilityOf(documentsDropdown));

 actions.moveToElement(dropdown).perform();
 }

 public void selectFirstDocument() {
 WebElement checkbox = wait.until(
 ExpectedConditions.elementToBeClickable(firstDocumentCheckbox));

 if (!checkbox.isSelected()) {
 checkbox.click();
 }
 }

 public void dragAndDropSignature() {
 WebElement source = wait.until(
 ExpectedConditions.visibilityOf(signatureButton));

 WebElement target = wait.until(
 ExpectedConditions.visibilityOf(signatureDropTarget));

 actions.dragAndDrop(source, target).perform();
 }

 public void clickSendMail() {
 wait.until(ExpectedConditions.elementToBeClickable(sendMailButton))
 .click();
 }

 public void clickSendAnyway() {
 wait.until(ExpectedConditions.elementToBeClickable(sendAnywayButton))
 .click();
 }

 public void clickContinueToSendMail() {
 wait.until(
 ExpectedConditions.elementToBeClickable(continueToSendMailButton))
 .click();
 }

 public void clickFinalContinue() {
 wait.until(
 ExpectedConditions.elementToBeClickable(finalContinueButton))
 .click();
 }
}
