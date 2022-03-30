package org.example;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.*;

public class BaseSetup  {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String appURL) {
        driver = initChromeDriver(appURL);
    }

    private static WebDriver initChromeDriver(String appURL) {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(appURL);
        driver.manage().window().maximize();
        return driver;
    }
    @Parameters({"appURL"})
    @BeforeClass
    public void initializeTestBaseSetup(String appURL) {
        try {
            setDriver(appURL);
        } catch (Exception e) {
            System.out.println("Error..." + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

}
