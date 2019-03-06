package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.chrome.ChromeOptions;

public class Freecrmsignup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\DDrive\\ThirdPartyDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("8801500826");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("103r1a0464.");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.cssSelector("a#privacy-link")).click();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		Thread.sleep(2000);
	
		driver.close(); //Closes only current window
		driver.quit(); //closes all the browsers

	}
}
