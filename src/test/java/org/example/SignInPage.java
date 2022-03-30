package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    private WebDriver driver;

    private By userNameTextField = By.xpath("input[name='login");

    private By passwordTextField = By.xpath("input[name='password']");

    private By signInButton = By.xpath("input[name='commit']");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName (String username){
        driver.findElement(userNameTextField).sendKeys(username);
    }

    public void enterPassword (String password){
        driver.findElement(passwordTextField).sendKeys(password);
    }

    public void clickSignIn (){
        driver.findElement(signInButton).click();
    }





}
