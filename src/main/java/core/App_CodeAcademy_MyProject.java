package core;

import java.util.logging.Logger;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App_CodeAcademy_MyProject {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		Logger.getLogger("").setLevel(Level.OFF);
		
		driver = new ChromeDriver();
		driver.get("https://www.codecademy.com/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.id("user_login")).clear();
		driver.findElement(By.id("user_login")).sendKeys("evgeniy.yakush@gmail.com");
		Thread.sleep(2000);	
		
		driver.findElement(By.id("login__user_password")).clear();
		driver.findElement(By.id("login__user_password")).sendKeys("codeacademy_password");
		Thread.sleep(2000);	
		
		driver.findElement(By.id("user_submit")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("06113292939558919-1")).click();
		Thread.sleep(2000);
		
		//Clicking "Learn Java"
		driver.findElement(By.xpath("//*/div[4]/div/a/div/div/div/div/div[4]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*/button/div/div[4]/a")).click();
		Thread.sleep(3000);
		
		//Clicking the Skip
		driver.findElement(By.xpath("//*/div[3]/button")).click();
		Thread.sleep(3000);
		
		driver.quit();
		
	}
}
