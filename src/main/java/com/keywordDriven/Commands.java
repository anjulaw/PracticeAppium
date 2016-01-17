package com.keywordDriven;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import java.net.URL;

/**
 * Created by Anjulaw on 1/15/2016.
 */
public class Commands {

    public static AppiumDriver driver;

    public Commands(){

    }


    public Commands(DesiredCapabilities desiredCapabilities,URL url){

        setDriver(new AndroidDriver(url,desiredCapabilities));
    }


    public AppiumDriver getDriver() {
        return driver;
    }

    public void setDriver(AppiumDriver driver) {
        this.driver = driver;
    }



    //final static Logger logger =

    public static int timeout;

    public static WebElement findElement(By byLocator) {

        WebElement element = (new WebDriverWait(driver,timeout)).until(ExpectedConditions.presenceOfElementLocated(byLocator));

        return element;

    }

    public static void waitForElement(By byLocator){
        findElement(byLocator);
        System.out.println("Waited for the Object " + byLocator + " to Appear");
    }

    public static void click(By byLocator){
        try {
            WebElement element = findElement(byLocator);
            element.click();
            System.out.println("Clicked on the Object " + byLocator);
        }catch (Exception e){
            System.out.println("Cannot click on the Object ");
        }
    }

    public static void type(By byLocator,String text){
        try {
            WebElement element = findElement(byLocator);
            element.sendKeys(text);
            System.out.println("Type the text " + text + " on the " + byLocator);
        } catch (Exception e){
            System.out.println("Unable to type the text " + text + " on " + byLocator);
        }
    }

    public final static void launch(String url){
        try {
            driver.navigate().to(url);
            System.out.println("Open the " + url + " successfully");
        }catch (Exception e){
            System.out.println("Unable to Load " + url );
        }
    }

    public static void select(By byLocator,String text){
        try {
            WebElement element = findElement(byLocator);
            new Select(element).selectByVisibleText(text);
        }catch (Exception e){
            System.out.println("Unable to select " + text + " on " + byLocator);
        }

    }
}
