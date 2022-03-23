package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAndLogoutVtigerTest {
	
	@Test
	public void getParameterDuringRunTime() throws Throwable {
		
		String browserNameData = System.getProperty("browserName");
		String urlData = System.getProperty("url");
		String userNameData = System.getProperty("username");
		String passwordData = System.getProperty("password");
		System.out.println(browserNameData);
		System.out.println(urlData);
		System.out.println(userNameData);
		System.out.println(passwordData);
		
		WebDriver driver = null;
		
		if(browserNameData.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}else if(browserNameData.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}else {
			throw new Exception("only two browsers compatible");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(urlData);
		
		driver.findElement(By.name("user_name")).sendKeys(userNameData);
		driver.findElement(By.name("user_password")).sendKeys(passwordData);
		driver.findElement(By.id("submitButton")).click();
		
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
	
	
	
	

}
