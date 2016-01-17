package com.pageObject;

import com.keywordDriven.Commands;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anjulaw on 1/15/2016.
 */
public class MercuryPageObjectTestCases {

    String baseUrl = "http://newtours.demoaut.com";

    AppiumDriver driver;

    @BeforeSuite
    public void initDevice() throws Exception  {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    public void registerUser(){
        MercuryLogin homepage = PageFactory.initElements(driver, MercuryLogin.class);
        homepage.gotoRegistration();
        MercuryRegistrationPage registrationPage = PageFactory.initElements(driver, MercuryRegistrationPage.class);
        registrationPage.register("Anjula","Weerasooriya","0771234567","anjulaw","Test Street 1","Test Street 2",
                "Colombo","Western","123456","SRI LANKA ","waaanjula@gmail.com","anjula@123","anjula@123");
    }

    @Test(priority = 1)
    public void successLogIn(){
        MercuryLogin homepageOne = PageFactory.initElements(driver, MercuryLogin.class);
        homepageOne.logIn("anjulaw","anjula@123");
    }

    @Test(priority = 2)
    public void errorLogin(){
        MercuryLogin homepageOne = PageFactory.initElements(driver, MercuryLogin.class);
        homepageOne.logIn("anjulaw","1234");
        String actualResult = String.valueOf(driver.findElements(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b")));
        String expectedResult = "Welcome back to Mercury Tours!";
        Assert.assertEquals(actualResult, expectedResult);
    }


    @AfterSuite
    public void closeDevice(){
        driver.close();
        driver.quit();
    }



}
