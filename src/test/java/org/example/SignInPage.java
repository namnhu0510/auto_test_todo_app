package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    private WebDriver driver;

    private By signInWithGitHub = By.cssSelector("a[ng-click='login.loginWithGithub()']");

    private By userNameTextField = By.cssSelector("input[name='login']");

    private By passwordTextField = By.cssSelector("input[name='password']");

    private By signInButton = By.cssSelector("input[name='commit']");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignInWithGitHub (){driver.findElement(signInWithGitHub).click();}

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
