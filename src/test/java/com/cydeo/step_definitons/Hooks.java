package com.cydeo.step_definitons;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setupScenario(){
        System.out.println("Setting up browser using cucumber @Before each scenario");
    }





    @After
    public void teardownScenario(Scenario scenario){
        //s y s  tem.out.println("It will be closing browser using cucumber @After each scenario");

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES) ;
            scenario.attach(screenshot,"image/png" , scenario.getName());
        }

        Driver.closeDriver();
    }
}
