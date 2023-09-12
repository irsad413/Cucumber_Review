package com.cydeo.step_definitons;

import com.cydeo.page.WebtableLoginPage;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class WebtableLoginStepDefinitions {

  WebtableLoginPage webtableLoginPage = new WebtableLoginPage() ;
    @Given("user is on the login page og webtable app")
    public void userIsOnTheLoginPageOgWebtableApp() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user enters username Test")
    public void userEntersUsernameTest() {
        webtableLoginPage.username.sendKeys("Test");
    }

    @And("user enters password Tester")
    public void userEntersPasswordTester() {
        webtableLoginPage.password.sendKeys("Tester");
    }

    @And("user clicks to login button")
    public void userClicksToLoginButton() {

        webtableLoginPage.loginBtn.click();
    }

    @Then("user should see url contains orders")
    public void userShouldSeeUrlContainsOrders() {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("orders"));


    }

    @When("user enters username incorrect")
    public void userEntersUsernameIncorrect() {

        webtableLoginPage.username.sendKeys("incorrect");
    }

    @And("user enters password incorrect")
    public void userEntersPasswordIncorrect() {

        webtableLoginPage.password.sendKeys("incorrect");
    }

    @Then("user should see url contains login")
    public void userShouldSeeUrlContainsLogin() {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));

    }


    @When("user enters username {string}")
    public void user_enters_username(String username) {

        webtableLoginPage.username.sendKeys(username);

    }
    @When("user enters password {string}")
    public void user_enters_password(String password) {

        webtableLoginPage.password.sendKeys(password);

    }

    @When("user enters username {string} password {string} and logins")
    public void user_enters_username_password_and_logins(String username, String password) {

        webtableLoginPage.login(username , password);

    }

    @When("user enter below credentials")
    public void user_enter_below_credentials(Map<String , String> credentials) {



        webtableLoginPage.login(credentials.get("username") , credentials.get("password"));

    }



}
