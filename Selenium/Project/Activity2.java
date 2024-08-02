package SeleniumHRMProject.HRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String title;
        String Image;
        
        
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
        title=driver.getTitle();
        System.out.println("Home page title: " + title);
        
        Image = driver.findElement(By.xpath("//div[@id='divLogo']/img")).getAttribute("src");
        System.out.println(Image);
       
        driver.close();

	}

}
