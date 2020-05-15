package core;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class App_ClassWorkSheet {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		Logger.getLogger("").setLevel(Level.OFF);
		//In Safari to have no errors we need to have just Logger OFF
		// To have no errors in Chrome we need to have "Silent out and Logger"
		//In Firefox an Edge...we need a special file where we have just one line "--log al $* &> /dev/null" (redirect all this junk into emptiness) with ".sh" example geckodriver with .sh
		//we can these file in usr/local/bin where our drivers are
		
		//System.setProperty("webdriver.chrome.silentOutput", "true");
		//driver = new ChromeDriver();
		
		//In case of Safari we do not need the the next line as Safari has it in itself
		//System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver.sh");
		System.setProperty("webdriver.edge.driver", "/usr/local/bin/msedgedriver");
		
		//driver = new ChromeDriver();
		//driver = new SafariDriver();
		driver = new EdgeDriver();
		//driver = new FirefoxDriver();
		
		
		driver.get("http://alex.academy");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}
}
