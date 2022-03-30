package org.example;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.*;

public class BaseSetup  {

    private WebDriver driver;
    private final String USER_NAME_GITHUB = "sutrix.nam.nd@gmail.com";
    private final String PASSWORD = "Chucthanhcong123!@#";

    public BaseSetup(WebDriver driver) {
        this.driver = driver;
    }


    public String getUSER_NAME_GITHUB() {
        return USER_NAME_GITHUB;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void launchBrowser (){
        ChromeDriverManager.getInstance().setup();
        // Instantiate a ChromeDriver class.
        driver = new ChromeDriver();

        // Launch Website
        driver.navigate().to("https://todo-list-login.firebaseapp.com");

        //Maximize the browser
        driver.manage().window().maximize();

    }


}
