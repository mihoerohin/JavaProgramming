package com.home_work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot_Failed {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://login2.nextbasecrm.com/");
        Thread.sleep(1000);

        WebElement loginBox = driver.findElement(By.name("USER_LOGIN"));
        Thread.sleep(1000);

        loginBox.sendKeys("helpdesk11@cybertekschool.com");

        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));
        Thread.sleep(1000);

        passwordBox.sendKeys("IncorrectPassword");
        Thread.sleep(1000);

        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();
        Thread.sleep(3000);


        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(".//screenShot/screenFailed.png"));


        String expectedTitle = "(58) Portal";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification passed");
        } else {
            System.out.println("Title verification failed");
        }

       // driver.quit();
    }
}
