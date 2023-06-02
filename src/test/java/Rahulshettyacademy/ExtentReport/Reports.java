package Rahulshettyacademy.ExtentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Reports {
  
	
	@Test
  public void loginOrm() {
	  

	  System.setProperty("webdriver.chrome.driver",
				"C:\\Chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	    WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
		String Title = driver.getTitle();
		System.out.println("Title is "+Title );
	
		driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
		
	
	}
}
