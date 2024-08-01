package seleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions builder= new Actions(driver);
        
        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println("Home page title: " + driver.getTitle());
        
        System.out.println("Left click");
        builder.click().pause(5000).perform();
        String frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);
        
        System.out.println("Double click");
        builder.doubleClick().pause(5000).perform();
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);
        
        System.out.println("Right click");
        builder.contextClick().pause(5000).perform();
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);
        
        System.out.println("Performed all the operations");
        driver.close();

	}

}
