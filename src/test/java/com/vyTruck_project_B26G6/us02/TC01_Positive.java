package com.vyTruck_project_B26G6.us02;

import com.cydeo.test.base.TestBase;
import com.vyTruck_project_B26G6.logIn.LoginOnVyTruckPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC01_Positive extends TestBase {

    @BeforeMethod
    public void loginSalesManager(){
        LoginOnVyTruckPage.login("storemanager61", "UserUser123");
        //salesmanager116 , salesmanager117 , salesmanager118
        //storemanager61 , storemanager62
        //user16 , user17 , user18

    }
    @AfterMethod
    public void quit(){

     driver.quit();
    }

    @Test (priority = 1)
    public void TC01Positive() throws InterruptedException {
//    1. Store manager or sales manager can see all vehicle information

//      Given I'm on VyTruck as a store manager or sales manager
//      When I click button 'Vehicles' from dropdown displayed on 'Fleet'
//      Then I should be able to see all Vehicle information on 'All - Car' page.

//      When I click button 'Vehicles' from dropdown displayed on 'Fleet'
        WebElement vehiclesBtn = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        Thread.sleep(2000);
        vehiclesBtn.click();

//      Then I should be able to see all Vehicle information on 'All - Car' page.
        WebElement vehiclesBtn1 = driver.findElement(By.xpath("//span[.='Vehicles']"));
        Thread.sleep(2000);
        vehiclesBtn1.click();
        Thread.sleep(2000);

//      Then I should be able to see all Vehicle information on 'All - Car' page.
      Assert.assertTrue(driver.getTitle().contains("All - Car"));
    }


    @Test(priority = 2)
    public void TC02Positive () throws InterruptedException {
//  2. Store manager or sales manager can create car

//        Given I'm on 'All car' page
//        When I click button 'Create Car'
//        And I should be able to see 'Create Car' page populate fields:
//        License Plate', 'Driver', 'Location','Chassis Number', 'Model Year', 'Color ', 'Last Odometer'
//        And select date:
//        Immatriculation Date', 'First Contract Date'
//        And select 'Senior', Sedan'
//        And I click 'Save and Close' button
//        Then 'Entity saved' pop up is displayed

//      Given I'm on 'All car' page
        driver.get("https://qa2.vytrack.com/entity/Extend_Entity_Carreservation");
        Thread.sleep(2000);

//      When I click button 'Create Car'
        WebElement creatCarBtn = driver.findElement(By.xpath("//a[@title= 'Create Car']"));
        creatCarBtn.click();
        Thread.sleep(1000);

//        And I should be able to see 'Create Car' page populate fields:
//        License Plate', 'Driver', 'Location','Chassis Number', 'Model Year', 'Last Odometer '

//      'License Plate'
        WebElement inputLicensePlate = driver.findElement(By.xpath("//input[contains(@id,'LicensePlate')]"));
        inputLicensePlate.clear();
        Thread.sleep(1000);
        inputLicensePlate.sendKeys( "101 NYC");

//        And select 'Senior'
        WebElement selectSenior = driver.findElement(By.xpath("//input[@value='senior']"));
        selectSenior.click();

//        And select 'Sedan'
        WebElement selectSedan = driver.findElement(By.xpath("//input[@value='sedan']"));
        selectSedan.click();

//      'Driver'
        WebElement inputDriver = driver.findElement(By.xpath("//input[contains(@id,'Driver')]"));
        inputDriver.clear();
        inputDriver.sendKeys( "DriverTaxi");

//      'Location'
        WebElement inputLocation = driver.findElement(By.xpath("//input[contains(@id,'Location')]"));
        inputLocation.clear();
        inputLocation.sendKeys( "Brooklyn, NY");

//      'Chassis Number'
        WebElement inputChassisNumber = driver.findElement(By.xpath("//input[contains(@id,'ChassisNumber')]"));
        inputChassisNumber.sendKeys("999888");

//        'Model Year'
        WebElement inputMadelYear = driver.findElement(By.xpath("//input[contains(@id,'ModelYear')]"));
        inputMadelYear.sendKeys("2020");

//       'Last Odometer'
        WebElement inputLastOdometer = driver.findElement(By.xpath("//input[contains(@id,'LastOdometer')]"));
        inputLastOdometer.sendKeys("00023051");

//      'Immatriculation Date'
        WebElement inputImmatriculationDate = driver.findElement(By.xpath("//input[contains(@id,'date_selector_custom_entity_type_ImmatriculationDate')]"));
        inputImmatriculationDate.sendKeys("Jun 8, 2022");

//      'First Contract Date'
        WebElement inputFirstContractDate = driver.findElement(By.xpath("//input[contains(@id,'date_selector_custom_entity_type_FirstContractDate')]"));
        inputFirstContractDate.sendKeys("Jun 5, 2022");
        WebElement clickNumberDate = driver.findElement(By.xpath("//a[.='5']"));
        clickNumberDate.click();

//       'Color'
        WebElement inputColor = driver.findElement(By.xpath("//input[contains(@id,'type_Color')]"));
        inputColor.sendKeys("Red");
        Thread.sleep(2000);

//        And I click 'Save and Close' button
        WebElement saveAndCloseBtn = driver.findElement(By.xpath("//button[@class='btn btn-success action-button']"));
        saveAndCloseBtn.click();
        Thread.sleep(1000);

        //Entity saved
        WebElement actualEntitySavedPopUp = driver.findElement(By.xpath("//div[@class='message']"));
        Assert.assertEquals(actualEntitySavedPopUp.getText(), "Entity saved", "FAILED");
    }


    @Test(priority = 3)
    public void TC03Positive () throws InterruptedException {
//  3. Store manager or sales manager can cancel car.

//      Given I'm on 'Create Car' page
//      When I click button 'Cancel'
//      Then I should be able to see all Vehicle information on 'All - Car' page.

//      Given I'm on 'Create Car' page
        driver.get("https://qa2.vytrack.com/entity/update/Extend_Entity_Carreservation/item");
        Thread.sleep(2000);

//      When I click button 'Cancel'
        WebElement cancelBtn = driver.findElement(By.xpath("//a[@data-action='cancel']"));
        cancelBtn.click();
        Thread.sleep(2000);

//      Then I should be able to see all Vehicle information on 'All - Car' page.
        Assert.assertTrue(driver.getTitle().contains("All - Car"));
    }


    @Test(priority = 4)
    public void TC04Positive () throws InterruptedException {
//  4. Store manager or sales manager can add Vehicle Model

//      Given I'm on 'Create Car' page
//      When I click button '+Add' Vehicle Model
//      And I click on any car on the Grid(Model Name)
//      And I click 'Select' button
//      Then I should see 'Model Name: "Model Name"' on the page

//      Given I'm on 'Create Car' page
        driver.get("https://qa2.vytrack.com/entity/update/Extend_Entity_Carreservation/item");

//      When I click button '+Add' Vehicle Model
        WebElement addBtnVehicleModel = driver.findElement(By.xpath("//div[contains(@id,'Model')]//button[@type='button']"));
        Thread.sleep(2000);
        addBtnVehicleModel.click();
        Thread.sleep(2000);

//      And I click on any car on the Grid
        WebElement clickFirstCarOnGird = driver.findElement(By.xpath("//table//tbody//tr[1]"));
        String modelName = clickFirstCarOnGird.getText();

        WebElement clickAnyCarOnThePage = driver.findElement(By.xpath("//td[.='" + modelName + "']"));
        clickAnyCarOnThePage.click();
        Thread.sleep(1000);

//      And I click 'Select' button
        WebElement selectBtn = driver.findElement(By.xpath("//button[.='Select']"));
        selectBtn.click();

//      Then I should see 'Model Name: Range Rover' on the page
        WebElement actualAddModel = driver.findElement(By.xpath("//div[.='Model Name: " + modelName + "']"));
        Thread.sleep(1000);
        Assert.assertTrue(actualAddModel.getText().contains(modelName));
    }


    @Test(priority = 5)
    public void TC05Positive () throws InterruptedException {
//  5. Store manager or sales manager can add Vehicle Make

//      Given I'm on 'Create Car' page
//      When I click button '+Add' Vehicle Make
//      And I click on first car on the Grid(Model Name)
//      And I click 'Select' button
//      Then I should see 'Make: "Model Name"' on the page

//      Given I'm on 'Create Car' page
        driver.get("https://qa2.vytrack.com/entity/update/Extend_Entity_Carreservation/item");
        Thread.sleep(3000);

//      When I click button '+Add' Vehicle Make
        WebElement addBtnVehicleModel = driver.findElement(By.xpath("//div[contains(@id,'Make')]//button[@type='button']"));
        addBtnVehicleModel.click();
        Thread.sleep(1500);

//      first car on the Grid is "modelName"
        WebElement clickFirstCarOnGird = driver.findElement(By.xpath("//table//tbody//tr[1]"));
        String modelName = clickFirstCarOnGird.getText();

//      And I click on first car on the Grid(Model Name)
        WebElement clickAnyCarOnThePage = driver.findElement(By.xpath("//td[.='" + modelName + "']"));
        clickAnyCarOnThePage.click();
        Thread.sleep(1000);

//      And I click 'Select' button
        WebElement selectBtn = driver.findElement(By.xpath("//button[.='Select']"));
        selectBtn.click();

//      Then I should add 'Make: "Model Name"' on the page
        WebElement actualAddModel = driver.findElement(By.xpath("//div[.='Make: " + modelName + "']"));
        Assert.assertTrue(actualAddModel.getText().contains("Make: " + modelName));

    }


    @Test(priority = 6)
    public void TC06Positive () throws InterruptedException {
//  6. Store manager or sales manager can edit a car info

//        Given I'm on 'All car' page
//        When I click on any car on the Grid
//        And I Click button 'Edit'
//        And I populate fields:
//        'License Plate', 'Driver', 'Location'
//        And select 'Senior', Sedan'
//        And I click 'Save and Close'
//        Then 'Entity saved' pop up is displayed

//        Given I'm on 'All car' page
        driver.get("https://qa2.vytrack.com/entity/Extend_Entity_Carreservation");
        Thread.sleep(2000);

//        When I click on any car on the Grid
        WebElement clickAnyCarOnTheGrid = driver.findElement(By.xpath("//table//tbody//tr[1]"));
        clickAnyCarOnTheGrid.click();

//        And I Click button 'Edit'
        WebElement editBtn = driver.findElement(By.xpath("//a[@title='Edit Car']"));
        editBtn.click();

//        And I populate fields: 'License Plate', 'Driver', 'Location'
//      'License Plate'
        WebElement inputLicensePlate = driver.findElement(By.xpath("//input[contains(@id,'LicensePlate')]"));
        inputLicensePlate.clear();
        Thread.sleep(1000);
        inputLicensePlate.sendKeys( "101 NYC");

//      'Driver'
        WebElement inputDriver = driver.findElement(By.xpath("//input[contains(@id,'Driver')]"));
        inputDriver.clear();
        Thread.sleep(1000);
        inputDriver.sendKeys( "DriverTaxi");

//      'Location'
        WebElement inputLocation = driver.findElement(By.xpath("//input[contains(@id,'Location')]"));
        inputLocation.clear();
        Thread.sleep(1000);
        inputLocation.sendKeys( "Brooklyn, NY");

//        And select 'Senior'
        WebElement selectSenior = driver.findElement(By.xpath("//input[@value='senior']"));
        selectSenior.click();

//        And select 'Sedan'
        WebElement selectSedan = driver.findElement(By.xpath("//input[@value='sedan']"));
        selectSedan.click();

//        And I click 'Save and Close'
        WebElement saveAndCloseBtn = driver.findElement(By.xpath("//button[@class='btn btn-success action-button']"));
        saveAndCloseBtn.click();
        Thread.sleep(1000);

//        Then 'Entity saved' pop up is displayed
        WebElement textPopUp = driver.findElement(By.xpath("//div[.='Entity saved']"));
        String actualText = textPopUp.getText();

        Assert.assertEquals(actualText, "Entity saved", "Entity saved' pop up - FAILED");
    }


    @Test(priority = 7)
    public void TC07Positive () throws InterruptedException {
//7. Store manager or sales manager can delete a car

//        Given I'm on 'All car' page
//        When I click on any car on the Grid
//        And I Click button 'Delete'
//        And I click button 'Yes, Delete'
//        Then 'Car deleted' pop up is displayed

//        Given I'm on 'All car' page
        driver.get("https://qa2.vytrack.com/entity/Extend_Entity_Carreservation");
        Thread.sleep(2000);

//        When I click on any car on the Grid
        WebElement clickAnyCarOnTheGrid = driver.findElement(By.xpath("//table//tbody//tr[3]"));
        clickAnyCarOnTheGrid.click();
        Thread.sleep(1000);

//        And I Click button 'Delete'
        WebElement deleteBtn = driver.findElement(By.xpath("//a[@title='Delete Car']"));
        deleteBtn.click();
        Thread.sleep(1000);

//        And I click button 'Yes, Delete'
        WebElement deleteConfirmation = driver.findElement(By.xpath("//a[.='Yes, Delete']"));
        deleteConfirmation.click();
        Thread.sleep(1000);

//        Then 'Car deleted' pop up is displayed
        WebElement textPopUp = driver.findElement(By.xpath("//div[@class='message']"));
        Assert.assertEquals(textPopUp.getText(), "Car deleted", "'Car deleted' pop up - FAILED");
    }


    @Test(priority = 8)
    public void TC08Positive () throws InterruptedException {
//8. Store manager or sales manager can add event

//        Given I'm on 'All car' page
//        When I click on any car on the Grid
//        And I Click button 'Add Event'
//        And  I'm on 'Add Event' page populate fields:
//        Title', 'Description', 'Organizer display name'
//        And pick 'start' and 'end'
//        And I click 'All-day Event' check mark
//        When I click 'Save' button
//        Then 'Calendar event saved' pop up is displayed

        Thread.sleep(2000);
//        Given I'm on 'All car' page
        driver.get("https://qa2.vytrack.com/entity/Extend_Entity_Carreservation");
        Thread.sleep(2000);

//        When I click on any car on the Grid
        WebElement clickAnyCarOnTheGrid = driver.findElement(By.xpath("//table//tbody//tr[3]"));
        clickAnyCarOnTheGrid.click();
        Thread.sleep(2000);

//        And I Click button 'Add Event"
        WebElement addEventBtn = driver.findElement(By.xpath("//a[@title='Add an event to this record']"));
        addEventBtn.click();
        Thread.sleep(1000);

//        And  I'm on 'Add Event' page populate fields: 'Title', 'Description', 'Organizer display name' 'Organizer email'//
//        'Title'
        WebElement inputTitle = driver.findElement(By.xpath("//input[contains(@id,'title')]"));
        inputTitle.sendKeys("New Year");

//      'Description'
        WebElement inputDescription = driver.findElement(By.xpath("//iframe[contains(@id,'description')]"));
        inputDescription.sendKeys(" The findElement() method is the most important WebElement method. It’s important because we have to first find the WebElement before performing an action on the WebElement. If there are multiple elements with the same locator value then findElement() locates the first WebElement. Therefore, it’s best to find an element by a unique locator value.");

//      'Organizer display name'
        WebElement inputOrganizerDisplayName = driver.findElement(By.xpath("//input[contains(@id,'organizerDisplayName')]"));
        inputOrganizerDisplayName.sendKeys("Selenium WebElement Methods");

//      'Organizer email'
        WebElement inputOrganizerEmail = driver.findElement(By.xpath("//input[contains(@id,'organizerEmail')]"));
        inputOrganizerEmail.sendKeys("cydeo@gmail.com");

//        And pick 'start' and 'end'
        WebElement selectStarDate = driver.findElement(By.xpath("//input[contains(@id,'date_selector_oro_calendar_event_form_start')]"));
        selectStarDate.clear();
        selectStarDate.sendKeys("Dec 22, 2022");
        Thread.sleep(1000);

//      'start'
        WebElement selectEndDate = driver.findElement(By.xpath("//input[contains(@id,'date_selector_oro_calendar_event_form_end')]"));
        selectEndDate.clear();
        selectEndDate.sendKeys("Dec 31, 2022");

//      'end'
        WebElement selectDateFromCalendar = driver.findElement(By.xpath("//a[.='31']"));
        selectDateFromCalendar.click();
        WebElement fieldClick = driver.findElement(By.xpath("//fieldset[@class='form form-horizontal']"));
        fieldClick.click();

//        And I click 'All-day Event' check mark//
        WebElement allDayEventsBtn = driver.findElement(By.xpath("//input[contains(@id,'event_form_allDay')]"));
        allDayEventsBtn.click();

//        When I click 'Save' button
        WebElement saveBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        saveBtn.click();
        Thread.sleep(1000);

//        Then 'Calendar event saved' pop up is displayed
        WebElement calendarEvenSavedPopUp = driver.findElement(By.xpath("//div[@class='message']"));
        Assert.assertEquals(calendarEvenSavedPopUp.getText(), "Calendar event saved", "'Calendar event saved' pop up - FAILED");
    }
}
