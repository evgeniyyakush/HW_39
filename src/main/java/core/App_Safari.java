package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class App_Safari {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//to get rid of Warnings
		Logger.getLogger("").setLevel(Level.OFF);
		
		//Start with the driver
		driver = new SafariDriver();
		driver.get("http://alex.academy");
		driver.manage().window().maximize();
		
		//We set "Wait time after every action to let all the info to be downloaded"
		Thread.sleep(1000);
		
		driver.quit();
	}
}