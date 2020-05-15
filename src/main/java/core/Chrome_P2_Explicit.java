package core;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Chrome_P2_Explicit {
	static WebDriver driver;

	public static void main(String[] cla) throws InterruptedException {
//      Get rid of Warnings
		Logger.getLogger("").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.silentOutput", "true"); 

//		Process
		System.out.println("Browser: Chrome");
		driver = new ChromeDriver();
		
//		Explicit Wait Time
		WebDriverWait wait = new WebDriverWait(driver, 15);
		final long start = System.currentTimeMillis();

		
		driver.get("http://facebook.com");
		driver.manage().window().maximize();  
		
		System.out.println("Title: " + driver.getTitle());

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("evgeniy.yakush@gmail.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).sendKeys(System.getenv("fb_password"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("u_0_b"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div[1]/div/div/ul/li/div/a/div[1]"))).click();
		
		String friends = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[3]/div/span/div/span"))).getText();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[1]/div/div/div[1]/div[4]/div[1]/span/div/div[1]"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/div[1]/div[3]/div/div[5]/div/div[1]"))).click();
		
		final long finish = System.currentTimeMillis();
		
		driver.quit();
	
		System.out.println("You have " + friends + " friends");
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");

	}
}
