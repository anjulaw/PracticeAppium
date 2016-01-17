package com.keywordDriven;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anjulaw on 1/15/2016.
 */
public class MercuryKeywordTestCase extends Commands {

    AppiumDriver driver;

    String baseUrl = "http://newtours.demoaut.com";

    private Commands commands;



    @BeforeSuite
    public void initDevice() throws Exception  {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        commands = new Commands(desiredCapabilities,url);
        driver = commands.getDriver();
//        driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    public void registerUser() {
//        commands = new Commands();
        launch(baseUrl);
        click(MercuryRegistrationPage.registration_link);
        type(MercuryRegistrationPage.firstName, "Anjula");
        type(MercuryRegistrationPage.lastName, "Weerasooriya");
        type(MercuryRegistrationPage.phone, "0771234567");
        type(MercuryRegistrationPage.email, "waaanjula@gmail.com");
        type(MercuryRegistrationPage.address_1, "Test Street 1");
        type(MercuryRegistrationPage.address_2, "Test Street 2");
        type(MercuryRegistrationPage.city, "Colombo");
        type(MercuryRegistrationPage.province, "Western");
        type(MercuryRegistrationPage.postalCode, "123456");
        select(MercuryRegistrationPage.country, "SRI LANKA ");
        type(MercuryRegistrationPage.userName, "anjulaw");
        type(MercuryRegistrationPage.password, "anjula@123");
        type(MercuryRegistrationPage.confirm_password, "anjula@123");
        click(MercuryRegistrationPage.btn_submit);
    }

    @Test(priority = 1)
    public void logIn(){
//        commands = new Commands();
        launch(baseUrl);
        type(MercuryLoginPage.userName, "anjulaw");
        type(MercuryLoginPage.password, "anjula@123");
        click(MercuryLoginPage.btnLogin);
    }

    @Test(priority = 2)
    public void wrongLogin(){
        launch(baseUrl);
        type(MercuryLoginPage.userName,"anjulaw");
        type(MercuryLoginPage.password,"1234");
        click(MercuryLoginPage.btnLogin);
        String actualResult = String.valueOf(driver.findElements(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b")));
        String expectedResult = "Welcome back to Mercury Tours!";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @AfterSuite
    public void closeDevice(){
        driver.close();
        driver.quit();
    }

}
