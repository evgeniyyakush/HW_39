package core;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//In case if we would use "ChromeOptions"
//import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_P1_ThreadSleep {
	static WebDriver driver;

	public static void main(String[] cla) throws InterruptedException {
		//Get rid of Warnings
		Logger.getLogger("").setLevel(Level.OFF);
		//System.setProperty("webdriver.gecko.driver", "/usr/local/bin/chromedriver");
		System.setProperty("webdriver.chrome.silentOutput", "true"); 
//		In some cases we would use "ChromeOptions"
//		ChromeOptions option = new ChromeOptions();                         
//		option.addArguments("disable-infobars");                                     
//		option.addArguments("--disable-notifications");    
		
		//Start the process
		System.out.println("Browser: Chrome");
		
		// If we would use "ChromeOptions"
		//driver = new ChromeDriver(option);
		driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();      
		
		System.out.println("Title: " + driver.getTitle());
		Thread.sleep(3000);
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("evgeniy.yakush@gmail.com");
		Thread.sleep(1000);
		
		driver.findElement(By.id("pass")).clear();
		//With "System.getenv" I we put password in "Run Configuration" variable. 
		driver.findElement(By.id("pass")).sendKeys(System.getenv("fb_password"));
		Thread.sleep(2000);
		
		driver.findElement(By.id("u_0_b")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div/div/div[1]/div/div/ul/li/div/a/div[1]")).click();
		Thread.sleep(3000);
		
		String friends = driver.findElement(By.xpath("//div/div[1]/div/div/div/div[1]/a[3]/div/span/div/span")).getText();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[1]/div/div/div[1]/div[4]/div[1]/span/div/div[1]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div/div/div[1]/div[3]/div/div[5]/div/div[1]")).click();
		driver.quit();
		System.out.println("You have " + friends + " friends");

	}
}