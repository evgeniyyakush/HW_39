 package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;

public class Safari_P2_Implicid {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		//Get rid of Warnings
	    Logger.getLogger("").setLevel(Level.OFF); 
	    
	    //Start the process
		System.out.println("Browser: Safari");
		driver = new SafariDriver();
		
//      Benchmark start		
		final long start = System.currentTimeMillis();
		
//		Implicit Wait Time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		
		System.out.println("Title: " + driver.getTitle());
   	
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("evgeniy.yakush@gmail.com");
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(System.getenv("fb_password"));
		driver.findElement(By.id("u_0_b")).click();
// 		Implicit will not work without Thread.sleep in here
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span/span")).click();

		String friends = driver.findElement(By.xpath("//div/div[3]/div/div[2]/div[3]/ul/li[3]/a/span[1]")).getText();
	
		driver.findElement(By.id("userNavigationLabel")).click();

		driver.findElement(By.linkText("Log Out")).click();
		
//		Benchmark finish
		final long finish = System.currentTimeMillis();
		
		driver.quit();
		
		System.out.println("You have " + friends + " friends");
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");

	}
}
