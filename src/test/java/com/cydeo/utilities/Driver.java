package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {

    private  Driver(){}

    //  private  static WebDriver driver ;

    private static  InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>() ;


    public static WebDriver getDriver() {

        if (driverPool.get() == null) {

            String browserType = ConfigurationReader.getProperty("browser") ;

            switch (browserType) {

                case "chrome" :
                    WebDriverManager.chromedriver().setup();

                    driverPool.set(new ChromeDriver() );

                    driverPool.get().manage().window().maximize();

                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;

                    break;

                case "safari" :

                    WebDriverManager.safaridriver().setup();

                    driverPool.set(new SafariDriver());

                    driverPool.get().manage().window().maximize();

                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;

                    break;

            }

        }

        return driverPool.get() ;


    } ;

    public static void closeDriver(){

        if (driverPool.get() != null) {

            driverPool.get().quit(); ;

            driverPool.remove();
        }
    }
}
