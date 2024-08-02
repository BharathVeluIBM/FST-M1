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
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebElement dashboard;

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
        dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Dashboard')]")));

        // Check if the dashboard is displayed
        if (dashboard.isDisplayed()) {
            System.out.println("Landed into the HomePage");
        } else {
            System.out.println("User still not landed into the HomePage");
        }

        // Close the browser
        driver.close();
        driver.quit();
    }
}
