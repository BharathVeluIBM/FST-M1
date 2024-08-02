package SeleniumHRMProject.HRMProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4 {

    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");

        // Print home page title
        String title = driver.getTitle();
        System.out.println("Home page title: " + title);

        // Wait for the username field to be visible and then interact with it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUsername")));
        username.sendKeys("orange");

        // Wait for the password field to be visible and then interact with it
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("orangepassword123");

        // Wait for the login button to be visible and then click it
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();

        // Wait for the dashboard element to be visible
        WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Dashboard')]")));

        // Check if the dashboard is displayed
        if (dashboard.isDisplayed()) {
            System.out.println("Landed into the HomePage");
        } else {
            System.out.println("User still not landed into the HomePage");
        }

        // Click on the PIM menu item
        WebElement PIM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[contains(text(),'PIM')]")));
        PIM.click();

        // Checking if user landed on the Employee List page
        WebElement EmployeeList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Employee List')]")));
        if (EmployeeList.isDisplayed()) {
            System.out.println("User Landed into the Employee List Page");
        }

        // Clicking the Add button
        WebElement AddBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAdd")));
        AddBtn.click();

        // Entering values in Name fields
        WebElement FirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        WebElement LastName = driver.findElement(By.id("lastName"));
        WebElement SaveBtn = driver.findElement(By.id("btnSave"));

        FirstName.sendKeys("Ramya");
        LastName.sendKeys("Velu");
        SaveBtn.click();

        // Verify user is on the Personal Details page
        WebElement PersonalDtls = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Personal Details')]")));

        if (PersonalDtls.isDisplayed()) {
            System.out.println("User Landed into the Personal Details Page");
        }

        
        PIM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[contains(text(),'PIM')]")));
        PIM.click();

        // Search for the employee details
        WebElement EMPNameSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empsearch_employee_name_empName")));
        EMPNameSearch.sendKeys("Ramya Velu");

        WebElement SearchBtn = driver.findElement(By.id("searchBtn"));
        SearchBtn.click();
        System.out.println("User can search for the employee");

        // Close the browser
        driver.close();
    }
}
