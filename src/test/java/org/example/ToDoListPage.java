package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

public class ToDoListPage {
    private WebDriver driver;

    private By signOutButton = By.cssSelector("button[ng-click='home.signOut()']");

    private By homeList = By.cssSelector("input[ng-model='home.list']");

    private By addToDoListButton = By.cssSelector("button[ng-click='home.list && home.add()']");

    private By Note = By.xpath("//ul[@class='list-group']/li//button");


    public ToDoListPage(WebDriver driver) {
        System.out.println("driver la");
        System.out.println(driver);
        this.driver = driver;
    }

    public void set10Note(){
        for (int i = 0; i<=9; i++){
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));

            driver.findElement(homeList).sendKeys(generatedString);

            driver.findElement(addToDoListButton).click();
        }
    }

    public void clickSignOut(){
        driver.findElement(signOutButton).click();
    }

    public void  delete5To10(){
        List<WebElement> listNote = driver.findElements(Note);
        for (int j = 5; j<=9; j++){
            listNote.get(j).click();
        }
    }
}
