package SeleniumHRMProject.HRMProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String title;
        
        
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
        title=driver.getTitle();
        System.out.println("Home page title: " + title);
        
        if(title.equals("OrangeHRM")) {
            System.out.println("Title Matched");
        } else {
            System.out.println("Title Not Matched");
        }

        
        driver.close();
	}

}
