package activityFourTestNGtest;

import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

@Test
public class Activity6 {
	WebDriver driver;
    WebDriverWait wait;
 
    @BeforeClass
    public void beforeClass() {
       
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
          
        //Open browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    
    @Parameters({"username", "password"})
    public void loginTestCase(String username, String password) {
        
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        AssertJUnit.assertEquals(loginMessage, "Welcome Back, admin");
    }
    
    @AfterClass
    public void afterClass() {
  	  
  	  driver.close();
    }
 
}
