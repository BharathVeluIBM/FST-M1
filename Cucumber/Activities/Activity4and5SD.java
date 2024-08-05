package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Activity4and5SD {
    WebDriver driver;
    WebDriverWait wait;

    @Given("User is Entered into the Login page")
    public void loginPage() {
        System.out.println("Setting up WebDriver and WebDriverWait instances.");
        // Setup instances
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Use the instance variable
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize the wait variable with Duration

        // Open browser
        System.out.println("Opening login page.");
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @When("User enters username and password")
    public void enterCredential() {
        System.out.println("Entering username and password.");
        // Enter username
        driver.findElement(By.id("username")).sendKeys("admin");
        // Enter password
        driver.findElement(By.id("password")).sendKeys("password");
        // Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        System.out.println("Entering provided username and password.");
        // Enter username from Feature file
        driver.findElement(By.id("username")).sendKeys(username);
        // Enter password from Feature file
        driver.findElement(By.id("password")).sendKeys(password);
        // Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("Read the title of the page and confirmation message")
    public void readTitleAndHeading() {
        System.out.println("Waiting for the confirmation message to be visible.");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));

        // Read the page title and heading
        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();

        // Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);

        // Assertion
        if (confirmMessage.contains("admin")) {
            Assert.assertEquals("Welcome Back, admin", confirmMessage);
        } else {
            Assert.assertEquals("Invalid Credentials", confirmMessage);
        }
    }

    @And("browser Close")
    public void browserClose() {
        System.out.println("Closing the browser.");
        // Close browser
        driver.close();
    }
}
