package com.vyTruck_project_B26G6.logIn;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginOnVyTruckPage extends TestBase {

    @Test
    public static void login(String username, String password){
//        Given I'm on VyTruck Log in page
//        When I enter truck driver user name
//        And I enter truck driver password
//        And I click log in button 'Log in'
//        Then I should see "Quick Launchpad" account logged in

        driver.get("https://qa2.vytrack.com/user/login");

        WebElement inputUsername = driver.findElement(By.id("prependedInput"));
        inputUsername.sendKeys(username);

        WebElement inputPassword = driver.findElement(By.id("prependedInput2"));
        inputPassword.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.id("_submit"));
        loginBtn.click();
    }
}
