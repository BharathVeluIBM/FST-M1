package seleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println("Home page title: " + driver.getTitle());
        
        String ThirdHeader;
        ThirdHeader=driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println("The 3rd Header is "+ThirdHeader);
        
        String FifthHeaderColor;
        FifthHeaderColor=driver.findElement(By.xpath("//h5[contains(text(),'Fifth header')]")).getCssValue("Color");
        System.out.println("The color of the Fifth Header is "+FifthHeaderColor);
        
        String VioletButton;
        VioletButton=driver.findElement(By.xpath("//button[contains(text(),'Violet')]")).getAttribute("class");
        System.out.println("The Attribute of Violet color button is "+VioletButton);
        
        String GreyButtonText;
        GreyButtonText=driver.findElement(By.xpath("//button[contains(text(),'Grey')]")).getText();
        System.out.println(GreyButtonText);
        
        driver.close();
   
        driver.quit();
        
        
        

	}

}
