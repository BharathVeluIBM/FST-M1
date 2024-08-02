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
        
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        //a. Open the OrangeHRM page and login with credentials provided

        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");

        String title = driver.getTitle();
        System.out.println("Home page title: " + title);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUsername")));
        username.sendKeys("orange");

        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("orangepassword123");

         WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();

         WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Dashboard')]")));

         if (dashboard.isDisplayed()) {
            System.out.println("Landed into the HomePage");
        } else {
            System.out.println("User still not landed into the HomePage");
        }

        //b. Find the PIM option in the menu and click it.

        WebElement PIM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[contains(text(),'PIM')]")));
        PIM.click();

        WebElement EmployeeList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Employee List')]")));
        if (EmployeeList.isDisplayed()) {
            System.out.println("User Landed into the Employee List Page");
        }

        //c. Click the Add button to add a new Employee.

        WebElement AddBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAdd")));
        AddBtn.click();
        
        //d. Fill in the required fields and click Save.

         WebElement FirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        WebElement LastName = driver.findElement(By.id("lastName"));
        WebElement SaveBtn = driver.findElement(By.id("btnSave"));

        FirstName.sendKeys("Ramya");
        LastName.sendKeys("Velu");
        SaveBtn.click();

         WebElement PersonalDtls = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Personal Details')]")));

        if (PersonalDtls.isDisplayed()) {
            System.out.println("User Landed into the Personal Details Page");
        }

        //e. Navigate back to the PIM page (Employee List tab) and verify the creation of your employee.
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
