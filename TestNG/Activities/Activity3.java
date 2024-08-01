package testNGActivities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	
	WebDriver driver;
  @Test
  public void login() {
	  
	  WebElement username = driver.findElement(By.id("username"));
      WebElement password = driver.findElement(By.id("password"));
      
      username.sendKeys("admin");
      password.sendKeys("password");
      
      driver.findElement(By.xpath("//button[text()='Log in']")).click();
      
      String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
      Assert.assertEquals("Welcome Back, admin", loginMessage);
  

  }
  
  
  @BeforeClass
  public void beforeClass() {
	  
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.get("https://v1.training-support.net/selenium/login-form");
  
  }

  @AfterClass
  public void afterClass() {
  }

}
