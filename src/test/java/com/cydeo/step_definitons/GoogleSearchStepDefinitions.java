package com.cydeo.step_definitons;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleSearchStepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage() ;

    @Given("user is on google home page")
    public void userIsOnGoogleHomePage() {

        Driver.getDriver().get("https://www.google.com");


    }

    @When("user searches for {string} capital")
    public void userSearchesForCapital(String country) {

        googleSearchPage.searchBox.sendKeys("capital city of " + country + Keys.ENTER);
    }

    @Then("user should see {string} result")
    public void userShouldSeeResult(String capital) {

        Assert.assertEquals(capital , googleSearchPage.capitalResult.getText() );


    }
}
