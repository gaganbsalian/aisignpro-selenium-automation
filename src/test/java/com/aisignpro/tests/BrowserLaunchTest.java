package com.aisignpro.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aisgnpro.base.BaseClass;
import com.aisignpro.utils.ConfigReader;

public class BrowserLaunchTest extends BaseClass {

    @Test
    public void launchApplication() {
        String expectedHost = ConfigReader.getProperty("baseUrl")
                .replace("https://", "").replace("http://", "").replaceAll("/$", "");

        Assert.assertTrue(driver.getCurrentUrl().contains(expectedHost),
                "Application did not open the expected URL. Actual: " + driver.getCurrentUrl());
        Assert.assertFalse(driver.getTitle().isBlank(), "Page title is empty");
    }
}