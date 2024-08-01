package activityFourTestNGtest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Activity9 {
	
	WebDriver driver;
    WebDriverWait wait;
 
  @BeforeMethod
  public void beforeMethod()
  {
	    Reporter.log("Test Case Setup started |");
	    driver.switchTo().defaultContent();
	    }
	
 
  @Test(priority = 0)
  public void simpleAlertTestCase() {
      Reporter.log("simpleAlertTestCase() started |");
      
      driver.findElement(By.id("simple")).click();
      Reporter.log("Simple Alert opened |");

      Alert simpleAlert = driver.switchTo().alert();
      Reporter.log("Switched foucs to alert |");

      String alertText = simpleAlert.getText();
      Reporter.log("Alert text is: " + alertText + " |");
      
      AssertJUnit.assertEquals("This is a JavaScript Alert!", alertText);

      simpleAlert.accept();
      Reporter.log("Alert closed");

      Reporter.log("Test case ended |");
  }

  @Test(priority = 1)
  public void confirmAlertTestCase() {
      Reporter.log("confirmAlertTestCase() started |");
      driver.findElement(By.id("confirm")).click();
      Reporter.log("Confirm Alert opened |");

      Alert confirmAlert = driver.switchTo().alert();
      Reporter.log("Switched foucs to alert |");

      String alertText = confirmAlert.getText();
      Reporter.log("Alert text is: " + alertText + " |");
      
      AssertJUnit.assertEquals("This is a JavaScript Confirmation!", alertText);

      confirmAlert.accept();
      Reporter.log("Alert closed |");

      Reporter.log("Test case ended |");
  }

  @Test(priority = 2)
  public void promptAlertTestCase() {
      Reporter.log("promptAlertTestCase() started |");
      driver.findElement(By.id("prompt")).click();
      Reporter.log("Prompt Alert opened |");

      Alert promptAlert = driver.switchTo().alert();
      Reporter.log("Switched foucs to alert |");

      String alertText = promptAlert.getText();
      Reporter.log("Alert text is: " + alertText + " |");

      promptAlert.sendKeys("Awesome!");
      Reporter.log("Text entered in prompt alert |");
      
      AssertJUnit.assertEquals("This is a JavaScript Prompt!", alertText);

      promptAlert.accept();
      Reporter.log("Alert closed |");

      Reporter.log("Test case ended |");
  }

  @BeforeTest
  public void beforeTest() {
	  
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
	  
      Reporter.log("Starting Test |");
      driver.get("https://v1.training-support.net/selenium/javascript-alerts");
      
      Reporter.log("Opened Browser |");
      Reporter.log("Page title is " + driver.getTitle() + " |");
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }

}
