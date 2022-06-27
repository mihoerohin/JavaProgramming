package com.home_work;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AutomationPracticeWebsite {

    @Test
    public void test() throws InterruptedException {

//        - Open "http://automationpractice.com/index.php"
        Driver.getDriver().get(ConfigurationReader.getProperty("automation.practice.usr"));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());

//        - Click twitter from Follow us
        WebElement twitterBtn = Driver.getDriver().findElement(By.xpath("//li[@class='twitter']"));
        actions.moveToElement(twitterBtn).perform();
        twitterBtn.click();

//        - Switch to twitter tab
        ArrayList<String> allWindows = new ArrayList<>(Driver.getDriver().getWindowHandles());
         Driver.getDriver().switchTo().window(allWindows.get(1)); // switch to next Web page

//        for (String each : allWindows){
//            Driver.getDriver().switchTo().window(each);
//            System.out.println(Driver.getDriver().getTitle() + " ==> " + Driver.getDriver().getCurrentUrl());
//        }


//        - Verify title contains "Selenium Framework"
        wait.until(ExpectedConditions.titleContains("Selenium Framework"));
       Assert.assertTrue(Driver.getDriver().getTitle().contains("Selenium Framework"), "Verify title contains \"Selenium Framework\" - FAILED");

//        - Switch to original tab
//       Driver.getDriver().navigate().to(ConfigurationReader.getProperty("automation.practice.usr"));
        Driver.getDriver().switchTo().window(allWindows.get(0));


//        - Verify title equals "My Store"
        Assert.assertTrue(Driver.getDriver().getTitle().contains("My Store"), "Verify title equals \"My Store\" => FAILED");


        //switch with the help of actions class
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform(); // NEXT WEB


        Driver.getDriver().switchTo().window(allWindows.get(1));

        actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform(); // ONE WEB BACK
        System.out.println("switch with the help of actions class - " + Driver.getDriver().getTitle());

        Driver.getDriver().quit();
    }
}
