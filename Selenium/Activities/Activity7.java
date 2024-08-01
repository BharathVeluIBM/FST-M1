package seleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions builder= new Actions(driver);
        
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        System.out.println("Home page title: " + driver.getTitle());
        
        WebElement football = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.xpath("//div[contains(text(),'Dropzone 1')]"));
        WebElement dropzone2 = driver.findElement(By.xpath("//div[contains(text(),'Dropzone 2')]"));
        
        builder.clickAndHold(football).moveToElement(dropzone1).pause(2000).release().build().perform();
        
        String dropzone1Verify = dropzone1.findElement(By.tagName("p")).getText();
        if(dropzone1Verify.equals("Dropped!")) {
            System.out.println("Ball was dropped in dropzone 1");
        }
        
        builder.dragAndDrop(football, dropzone2).build().perform();
        
        String dropzone2Verify = dropzone2.findElement(By.tagName("p")).getText();
        if(dropzone2Verify.equals("Dropped!")) {
            System.out.println("Ball was dropped in dropzone 2");
        }
        
        driver.close();
        
	}

}
