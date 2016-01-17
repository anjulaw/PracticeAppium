package com.pageObject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Anjulaw on 1/15/2016.
 */
public class MercuryRegistrationPage {

    AppiumDriver driver;

    @FindBy(how = How.NAME,using = "firstName")
    private WebElement firstName;

    @FindBy(how = How.NAME,using = "lastName")
    private WebElement lastName;

    @FindBy(how = How.NAME,using = "phone")
    private WebElement phone;

    @FindBy(how = How.NAME,using = "userName")
    private WebElement userName;

    @FindBy(how = How.NAME,using = "address1")
    private WebElement address1;

    @FindBy(how = How.NAME,using = "address2")
    private WebElement address2;

    @FindBy(how = How.NAME,using = "city")
    private WebElement city;

    @FindBy(how = How.NAME,using = "state")
    private WebElement state;

    @FindBy(how = How.NAME,using = "postalCode")
    private WebElement postalCode;

    @FindBy(how = How.NAME,using = "country")
    private WebElement country;

    @FindBy(how = How.NAME,using = "email")
    private WebElement email;

    @FindBy(how = How.NAME,using = "password")
    private WebElement password;

    @FindBy(how = How.NAME,using = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(how = How.NAME,using = "register")
    private WebElement btn_submit;

    public void register(String fName,String lName,String phone,String uName,String add1,String add2,String city,
                         String state, String postalCode,String country,String email, String pwd,String confirmPwd) {

        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        this.phone.sendKeys(phone);
        this.userName.sendKeys(uName);
        this.address1.sendKeys(add1);
        this.address2.sendKeys(add2);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.postalCode.sendKeys(postalCode);
        this.email.sendKeys(email);
        this.password.sendKeys(pwd);
        this.confirmPassword.sendKeys(confirmPwd);
        btn_submit.click();
    }

}
