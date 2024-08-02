package SeleniumHRMProject.HRMProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//a. Open the OrangeHRM page and login with credentials provided.

		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();

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

	        //c. Verify that the “Directory” menu item is visible and clickable.
	        //d. If clickable, click on the menu item
	        WebElement Directory =driver.findElement(By.xpath("//b[contains(text(),'Directory')]"));
	        
	        if(Directory.isDisplayed())
	        {
	        	Directory.click();
	        } else {
	        	System.out.println("Directory was not visible");
	        }
	        
	        //e. Verify that the heading of the page matches “Search Directory”.

	        WebElement header=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Search Directory')]")));
	        
	        String Header1=header.getText();
	        if(Header1.equals("Search Directory"))
	        {
	        	System.out.println("Search Directory was getting displayed");
	        }
	        else
	        {
	        	System.out.println("Search Directory was not displayed");
	        }
	        
	        driver.close();
	}

}
