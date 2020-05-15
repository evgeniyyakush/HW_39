package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App_Chrome {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException  {
		//to get rid of Warnings
		Logger.getLogger("").setLevel(Level.OFF);  
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		//Start with the driver
		driver = new ChromeDriver();
		driver.get("http://alex.academy");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.quit();
	}
}
