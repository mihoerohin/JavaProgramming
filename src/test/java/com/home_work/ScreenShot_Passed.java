package com.home_work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot_Passed {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //  open URL
        driver.get("https://login2.nextbasecrm.com/");
        Thread.sleep(1000);

        //  login Box
        WebElement loginBox = driver.findElement(By.name("USER_LOGIN"));
        Thread.sleep(1000);
        loginBox.sendKeys("helpdesk11@cybertekschool.com");
        Thread.sleep(1000);


        //  password Box
        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys("UserUser");
        Thread.sleep(1000);


        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();
                         // or
      //  passwordBox.sendKeys(Keys.ENTER);


        // System.setProperty("C:\\Users\\mihoe\\OneDrive\\Desktop\\ScreenShots", "C:\\Users\\mihoe\\OneDrive\\Desktop");

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(".//screenShot/screen.png"));


        String expectedTitle = "(58) Portal";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification passed");
        }else{
            System.out.println("Title verification failed");
        }

        driver.quit();












    }
}
