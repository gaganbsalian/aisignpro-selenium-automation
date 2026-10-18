package com.aisignpro.tests;

import org.testng.annotations.Test;

import com.aisgnpro.base.BaseClass;
import com.aisignpro.pages.LoginPage;
import com.aisignpro.pages.DocumentsPage;
import com.aisignpro.pages.CustomerPage;
import com.aisignpro.pages.AgreementPage;

public class AgreementWorkFlowTest extends BaseClass {

 @Test
 public void createCustomerAndSendAgreement() {

 try {
 // 1. Login

 LoginPage loginPage = new LoginPage(driver);

 loginPage.enterMobileNumber("6664446664");
 loginPage.acceptTerms();
 loginPage.clickSignIn();
 
//2. Wait for OTP page, enter OTP, and verifys
loginPage.waitForOTPPage();
loginPage.enterOTP("123456");
loginPage.clickVerify();

// 3. Navigate to Customers
DocumentsPage documentsPage = new DocumentsPage(driver);
documentsPage.clickCustomers();

// 4. Create customer
CustomerPage customerPage = new CustomerPage(driver);

customerPage.clickAddCustomer();
customerPage.enterMobileNumber(randomNumber());
customerPage.enterContactName(randomString());
customerPage.enterEmailId(randomString()+"@gmail.com");
customerPage.clickAssignDocuments();

//5. Handle customer-created confirmation
AgreementPage agreementPage = new AgreementPage(driver);

agreementPage.clickSuccessAlertOk();

//6. Select the first document

agreementPage.selectFirstDocument();

// 7. Place signature
agreementPage.dragAndDropSignature();

// 8. Send the agreement
agreementPage.clickSendMail();

// 9. Handle sending confirmation popups
agreementPage.clickSendAnyway();
agreementPage.clickContinueToSendMail();
agreementPage.clickFinalContinue();

// 10. Sign out
customerPage.clickQAautomationButton();
customerPage.clickSignOut();
 } 
 finally {
 tearDown();
 }
 }
}

