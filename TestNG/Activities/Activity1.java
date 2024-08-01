package testNGActivities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity1 {
	
	WebDriver driver;
	
  @Test
  public void firstActivity() {
	  
	  String title = driver.getTitle();
      System.out.println("Page title is: " + title);
      
      Assert.assertEquals("Training Support", title);
                  
      driver.findElement(By.id("about-link")).click();
                  
      System.out.println("New page title is: " + driver.getTitle());
      
      Assert.assertEquals(driver.getTitle(), "About Training Support");
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://v1.training-support.net");
	    
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
