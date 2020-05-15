package core;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App_Firefox {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException  {
		//to get rid of Warnings
		Logger.getLogger("").setLevel(Level.OFF);  
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver.sh");
		
		//Start with the driver
		//We should set this path if we did not locate our driver in the path...it works without this line if the driver is in the path
		//System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://alex.academy");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.quit();
	}
}

