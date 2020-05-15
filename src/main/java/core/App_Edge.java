package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class App_Edge {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException  {
		//to get rid of Warnings
		Logger.getLogger("").setLevel(Level.OFF);  
		
		//Start with the driver
		System.setProperty("webdriver.edge.driver", "/usr/local/bin/msedgedriver");
		//to get rid of Warnings in order to work it must be here and not before the previous  "System.setProperty".
		System.setProperty("webdriver.edge.driver", "/usr/local/bin/msedgedriver.sh");
		
		driver = new EdgeDriver();
		driver.get("http://alex.academy");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.quit();
	}
}
