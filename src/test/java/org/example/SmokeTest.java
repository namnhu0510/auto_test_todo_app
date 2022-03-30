package org.example;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.example.BaseSetup;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.*;

public class SmokeTest extends BaseSetup {

    private WebDriver driver;
    public SignInPage signInPage;
    public ToDoListPage toDoListPage ;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }
    @Test()
    public void TestMethod() throws InterruptedException {

        signInPage = new SignInPage(driver);

        Thread.sleep(10000);
        //click sign it with Github
        signInPage.clickSignInWithGitHub();

        Thread.sleep(5000);

        String parent=driver.getWindowHandle();

        Set<String> s=driver.getWindowHandles();
        // Now iterate using Iterator
        Iterator<String> I1= s.iterator();

        while(I1.hasNext()) {

            String child_window = I1.next();

            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }

        //enter username
        signInPage.enterUserName("sutrix.nam.nd@gmail.com");
        //enter password
        signInPage.enterPassword("Chucthanhcong123!@#");
        //click sign in
        signInPage.clickSignIn();

        driver.switchTo().window(parent);

        Thread.sleep(5000);

        toDoListPage = new ToDoListPage(driver);
        //set 10 Note
        toDoListPage.set10Note();
        //click sign out
        toDoListPage.clickSignOut();
        //Log in again
        signInPage.clickSignInWithGitHub();
        Thread.sleep(9000);
        //Delete from 5 to 10
        toDoListPage.delete5To10();
        //click sign out
        toDoListPage.clickSignOut();

    }
}
