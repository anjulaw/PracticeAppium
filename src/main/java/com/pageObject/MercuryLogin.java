package com.pageObject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Anjulaw on 1/15/2016.
 */
public class MercuryLogin {

    AppiumDriver driver;

    @FindBy(how = How.NAME,using = "userName")
    private WebElement userName;

    @FindBy(how = How.NAME,using = "password")
    private WebElement password;

    @FindBy(how = How.NAME,using = "login")
    private WebElement logIn;

    @FindBy(how = How.LINK_TEXT,using = "SIGN-ON")
    private WebElement btnSignOn;

    @FindBy(how = How.LINK_TEXT,using = "REGISTER")
    private WebElement btnRegister;

    public void logIn(String uName,String pwd){

        userName.sendKeys(uName);
        password.sendKeys(pwd);
        logIn.click();

    }

    public String getBtnSignOnText(){
        String linkText = btnSignOn.getText();
        return linkText;
    }

    public void gotoRegistration(){
        btnRegister.click();
    }
}
