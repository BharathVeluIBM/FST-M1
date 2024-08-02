package SeleniumHRMProject.HRMProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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

        //b. Find the “My Info” menu item and click it.

        WebElement MyInfo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[contains(text(),'My Info')]")));
        MyInfo.click();

        //c. On the new page, click the Edit button
        WebElement EditBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Edit']")));
        EditBtn.click();
        
        //d. Fill in the Name, Gender, Nationality, and the DOB fields.
        WebElement FirstName =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='personal_txtEmpFirstName']")));
        FirstName.sendKeys("Hellow");
        
        WebElement LastName=driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']"));
        LastName.sendKeys("World");
        
        WebElement Gender =driver.findElement(By.id("personal_optGender_1"));
        Gender.click();
        
        WebElement Nationality = driver.findElement(By.id("personal_cmbNation"));  
        Select dropdown = new Select(Nationality);  
        dropdown.selectByIndex(5);    
        
        //e. Click Save.
        WebElement saveBtn= driver.findElement(By.id("btnSave"));
        saveBtn.click();
        
        System.out.println("Record edited and saved");
        
        //f. Close the browser
        
        driver.close();
        
        driver.quit();
	}

}
