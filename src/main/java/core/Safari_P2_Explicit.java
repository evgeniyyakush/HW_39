package core;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Safari_P2_Explicit {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		//Get rid of Warnings
	    Logger.getLogger("").setLevel(Level.OFF); 
	    
	    //Start the process
		System.out.println("Browser: Safari");
		driver = new SafariDriver();
		
//		Explicit Wait Time
		WebDriverWait wait = new WebDriverWait(driver, 15);
//      Benchmark start	
		final long start = System.currentTimeMillis();

		
		driver.get("http://facebook.com");
		driver.manage().window().maximize();  
		
		System.out.println("Title: " + driver.getTitle());

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("evgeniy.yakush@gmail.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).sendKeys(System.getenv("fb_password"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("u_0_b"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span/span"))).click();
		
		String friends = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div[3]/div/div[2]/div[3]/ul/li[3]/a/span[1]"))).getText();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userNavigationLabel"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log Out"))).click();
		
//		Benchmark finish
		final long finish = System.currentTimeMillis();
		
		driver.quit();
	
		System.out.println("You have " + friends + " friends");
//		Benchmark finish
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");

	}
}

