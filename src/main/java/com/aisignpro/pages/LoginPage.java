package com.aisignpro.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

 WebDriver driver;
 WebDriverWait wait;

 public LoginPage(WebDriver driver) {
 this.driver = driver;
 this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
 PageFactory.initElements(driver, this);
 }

 // Mobile number field
 @FindBy(xpath = "//input[@id='phone']")
 WebElement mobileNumberField;

 // Terms and conditions checkbox
 @FindBy(xpath = "//input[@formcontrolname='termsAndConditions']")
 WebElement termsCheckbox;

 // Sign In button
 @FindBy(xpath = "//div[@class='form-group terms-checkbox mb-2']/following-sibling::button")
 WebElement signInButton;
 
 // OTP text fields
 @FindBy(xpath = "//input[@name='otp1']")
 WebElement otpField1;
 
 @FindBy(xpath = "//input[@name='otp2']")
 WebElement otpField2;
 
 @FindBy(xpath = "//input[@name='otp3']")
 WebElement otpField3;
 
 @FindBy(xpath = "//input[@name='otp4']")
 WebElement otpField4;
 
 
 @FindBy(xpath = "//input[@name='otp5']")
 WebElement otpField5;
 
 @FindBy(xpath = "//input[@name='otp6']")
 WebElement otpField6;
 

 // Verify Button
 @FindBy(xpath = "//button[@class='verify-button']")
 WebElement verifyButton;


 // Actions
 public void enterMobileNumber(String mobileNumber) {
	    wait.until(ExpectedConditions.visibilityOf(mobileNumberField)).sendKeys(mobileNumber);
	}

 public void acceptTerms() {
 WebElement checkbox = wait.until(
 ExpectedConditions.elementToBeClickable(termsCheckbox));

 if (!checkbox.isSelected()) {
 checkbox.click();
 }
 }

 public void clickSignIn() {
 signInButton.click();
 }
 
 
 public void enterOTP(String otp) {
	 if(otp==null || otp.length()!=6)
	 {
		throw new IllegalArgumentException("OTP must contans exactly 6 digits") ;
		
	 }
	 wait.until(ExpectedConditions.visibilityOf(otpField1))
	 .sendKeys(String.valueOf(otp.charAt(0)));
	 otpField2.sendKeys(String.valueOf(otp.charAt(1)));
	 otpField3.sendKeys(String.valueOf(otp.charAt(2)));
	 otpField4.sendKeys(String.valueOf(otp.charAt(3)));
	 otpField5.sendKeys(String.valueOf(otp.charAt(4)));
	 otpField6.sendKeys(String.valueOf(otp.charAt(5)));
 }
 
 
 public void clickVerify() {
	 wait.until(ExpectedConditions.elementToBeClickable(verifyButton))
	 .click();
	 }
	
 
 public void waitForOTPPage() {
	 wait.until(ExpectedConditions.visibilityOf(otpField1));
	 }
 
}
