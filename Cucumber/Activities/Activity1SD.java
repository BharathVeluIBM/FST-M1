package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1SD {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Google Home Page$")
    public void givenFunctionName() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.google.com");
    }

    @When("User types in Cheese and hits ENTER")
    public void whenFunctionName() {
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
    }

    @Then("Show how many search results were shown")
    public void thenFunctionName() {
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
    }

    @And("Close the browser")
    public void closeTheBrowser() throws Throwable {
        driver.quit();
    }
}
