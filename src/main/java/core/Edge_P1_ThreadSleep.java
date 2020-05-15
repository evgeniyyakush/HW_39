package core;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;


public class Edge_P1_ThreadSleep {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		//Get rid of Warnings
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		System.setProperty("webdriver.edge.driver", "/usr/local/bin/msedgedriver.sh");
		
		
		//Start the process
		System.out.println("Browser: Edge");
		driver = new EdgeDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();

		System.out.println("Title: " + driver.getTitle());

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("evgeniy.yakush@gmail.com");
		Thread.sleep(1000);

		driver.findElement(By.id("pass")).clear();
		//With "System.getenv" I we put password in "Run Configuration" variable. 
		driver.findElement(By.id("pass")).sendKeys(System.getenv("fb_password"));
		Thread.sleep(2000);

		driver.findElement(By.id("u_0_b")).click();
		Thread.sleep(4000);

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