package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



public class Chrome_P2_Implicit {
	static WebDriver driver;

	public static void main(String[] cla) throws InterruptedException {
//      Get rid of Warnings
		Logger.getLogger("").setLevel(Level.OFF);
		System.setProperty("webdriver.chrome.silentOutput", "true"); 

//		Process
		System.out.println("Browser: Chrome");
		driver = new ChromeDriver();
		
//		Implicit Wait Time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("http://facebook.com");
		driver.manage().window().maximize();  
		
		System.out.println("Title: " + driver.getTitle());
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("evgeniy.yakush@gmail.com");
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(System.getenv("fb_password"));
		driver.findElement(By.id("u_0_b")).click();
		driver.findElement(By.xpath("//div/div/div[1]/div/div/ul/li/div/a/div[1]")).click();
// 		Implicit will not work without Thread.sleep in here
		Thread.sleep(3000);
		
		String friends = driver.findElement(By.xpath("//a[3]/div/span/div/span")).getText();
		
		driver.findElement(By.xpath("//div[1]/div/div/div[1]/div[4]/div[1]/span/div/div[1]")).click();
		driver.findElement(By.xpath("//div/div/div[1]/div[3]/div/div[5]/div/div[1]")).click();
		driver.quit();
		
		System.out.println("You have " + friends + " friends");

	}
}