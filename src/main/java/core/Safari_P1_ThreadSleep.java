package core;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;

public class Safari_P1_ThreadSleep {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		//Get rid of Warnings
	    Logger.getLogger("").setLevel(Level.OFF); 
	    
	    //Start the process
		System.out.println("Browser: Safari");
		
		driver = new SafariDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		
		System.out.println("Title: " + driver.getTitle());
   		Thread.sleep(3000);	
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("evgeniy.yakush@gmail.com");
		Thread.sleep(3000);	
		
		driver.findElement(By.id("pass")).clear();
		//With "System.getenv" I we put password in "Run Configuration" variable. 
		driver.findElement(By.id("pass")).sendKeys(System.getenv("fb_password"));
		Thread.sleep(3000);
		
		driver.findElement(By.id("u_0_b")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span/span")).click();
		Thread.sleep(3000);
		
		String friends = driver.findElement(By.xpath("//div/div[3]/div/div[2]/div[3]/ul/li[3]/a/span[1]")).getText();
		Thread.sleep(3000);
		
		driver.findElement(By.id("userNavigationLabel")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Log Out")).click();
		driver.quit();
		
		System.out.println("You have " + friends + " friends");

	}
}
