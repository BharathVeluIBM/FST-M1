package testNGActivities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {
	
	WebDriver driver;
	
  @Test
  public void testCase1() {
      //This test case will pass
      String title = driver.getTitle();
      System.out.println("Title is: " + title);
      Assert.assertEquals(title, "Target Practice");
  }
  
  @Test
  public void testCase2() {
      //This test case will Fail
      WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
      Assert.assertTrue(blackButton.isDisplayed());
      Assert.assertEquals(blackButton.getText(), "black");
  }
  
  @Test(enabled = false)
  public void testCase3() {
      //This test will be skipped and not counted
      String subHeading = driver.findElement(By.className("sub")).getText();
      Assert.assertTrue(subHeading.contains("Practice"));
  }
  
  @Test
  public void testCase4() {
      //This test will be skipped and will be be shown as skipped
      throw new SkipException("Skipping test case");      
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.get("https://v1.training-support.net/selenium/target-practice");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
