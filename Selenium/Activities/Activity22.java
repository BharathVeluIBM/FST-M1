package seleniumActivities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Actions builder = new Actions(driver);
	        
	        driver.get("https://v1.training-support.net/selenium/popups");
	        System.out.println("Home page title: " + driver.getTitle());
	        
	        WebElement button = driver.findElement(By.className("orange"));
	        
	        builder.moveToElement(button).build().perform();
	       
	        String tooltipMessage = button.getAttribute("data-tooltip");
	        System.out.println(tooltipMessage);

	        
	        button.click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

	     
	        WebElement username = driver.findElement(By.id("username"));
	        WebElement password = driver.findElement(By.id("password"));
	        
	        username.sendKeys("admin");
	        password.sendKeys("password");
	        
	        driver.findElement(By.xpath("//button[text()='Log in']")).click();

	        
	        String message = driver.findElement(By.id("action-confirmation")).getText();
	        System.out.println("Login message: " + message);

	        driver.quit();
	        

	}

}
