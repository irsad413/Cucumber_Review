package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static void sleep(int second){

        second *= 1000 ;

        try {
            Thread.sleep(second);
        }catch (InterruptedException e) {

        }
    }


    public static void switchWindowAndVerify( String expectedInUrl , String expectedTitle){

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles() ;

        for (String each : allWindowHandles) {

            Driver.getDriver().switchTo().window(each) ;

            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {

                break;
            }


        }

        String  actualTitle = Driver.getDriver().getTitle() ;



        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }


    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }

    /**
     *
     * this method will accept a String as expected value and verify actual URL CONTAINS the value
     * @param expectedInURL
     */

    public static void  verifyURLContains (String expectedInURL){

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));


    }

    /**
     *
     *
     * this method will accept a dropdown a WebElement
     * and return all the options' text in a List of Stirng
     *
     * @param dropdownElement
     * @return
     */


    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){

        Select select = new Select(dropdownElement) ;

        List<WebElement> actualOptionAsWebElement = select.getOptions();

        List<String> actualOptionAsString = new ArrayList<>() ;

        for (WebElement each : actualOptionAsWebElement) {

            actualOptionAsString.add(each.getText()) ;

        }

        return actualOptionAsString ;


    }


    /**
     *
     * This method will accept a group radio buttons as a List of WebElements
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons , String attributeValue) {



        for (WebElement each : radioButtons) {

            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                each.click();
            }
        }
    }
}
