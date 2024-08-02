package SeleniumHRMProject.HRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity3 {

    public static void main(String[] args) throws InterruptedException {
        
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebElement dashboard;

        //a. Open the browser to the login page of OrangeHRM site.

        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");

        String title = driver.getTitle();
        System.out.println("Home page title: " + title);

        //b. Find and select the username and password fields
        //c. Enter login credentials into the respective fields
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUsername")));
        username.sendKeys("orange");

        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("orangepassword123");
        
        //d. Click login

       WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();

        //e. Verify that the homepage has opened.
        dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Dashboard')]")));

        // Check if the dashboard is displayed
        if (dashboard.isDisplayed()) {
            System.out.println("Landed into the HomePage");
        } else {
            System.out.println("User still not landed into the HomePage");
        }
        
        //f.. Close the browser.

        driver.close();
        driver.quit();
    }
}
