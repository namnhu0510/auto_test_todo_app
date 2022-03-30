package org.example;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.*;

public class SmokeTest {

    private WebDriver webDriver;
    @Test
    public void TestMethod() throws InterruptedException {

        BaseSetup baseSetup = new BaseSetup(webDriver);

        //launch browser
        baseSetup.launchBrowser();

        webDriver.findElement(By.cssSelector("a[ng-click='login.loginWithGithub()']")).click();

        Thread.sleep(5000);

        String parent=webDriver.getWindowHandle();

        Set<String> s=webDriver.getWindowHandles();
        // Now iterate using Iterator
        Iterator<String> I1= s.iterator();

        while(I1.hasNext()) {

            String child_window = I1.next();

            if (!parent.equals(child_window)) {
                webDriver.switchTo().window(child_window);
            }
        }
        SignInPage signInPage = new SignInPage(webDriver);

        //enter username
        signInPage.enterUserName(baseSetup.getUSER_NAME_GITHUB());

        //enter password
        signInPage.enterPassword(baseSetup.getPASSWORD());

        //click submit
        signInPage.clickSignIn();

        webDriver.switchTo().window(parent);

        Thread.sleep(5000);

        for (int i = 0; i<=9; i++){
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));

            webDriver.findElement(By.cssSelector("input[ng-model='home.list']")).sendKeys(generatedString);

            webDriver.findElement(By.cssSelector("button[ng-click='home.list && home.add()']")).click();
        }

        webDriver.findElement(By.cssSelector("button[ng-click='home.signOut()']")).click();

        //Log in again
        webDriver.findElement(By.cssSelector("a[ng-click='login.loginWithGithub()']")).click();

        Thread.sleep(9000);

        //Delete from 5 to 10
        List<WebElement> listNote = webDriver.findElements(By.xpath("//ul[@class='list-group']/li//button"));

        for (int j = 5; j<=9; j++){
            listNote.get(j).click();
        }

        webDriver.findElement(By.cssSelector("button[ng-click='home.signOut()']")).click();


    }
}
