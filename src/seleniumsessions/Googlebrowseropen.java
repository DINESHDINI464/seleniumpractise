
package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Googlebrowseropen {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\D Drive\\ThirdPartyDrivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		/*File file = new File("D:\\D Drive\\ThirdPartyDrivers\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		WebDriver driver =new FirefoxDriver();*/
		//driver.manage().window().maximize();
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("disable-infobars");
		driver.get("https://www.google.com/");
		 //options.addArguments("--start-maximized");
		 driver.manage().window().maximize();
		//driver.get("https://www.freecrm.com/index.html");
		
		
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("Testing");
		
		//open gmail and do account signup
		driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
		driver.findElement(By.xpath("//a[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")).click();
		//driver.findElement(By.xpath("//span[contains(text(),'Create account')]")).click();
		//driver.findElement(By.xpath("//div[@class='IMH1vc lUHSR Hj2jlf']")).click();
		//driver.findElement(By.xpath("//span[contains(text(),'Create account')]")).click();
		//driver.findElement(By.xpath("//div[@class='IMH1vc lUHSR Hj2jlf']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("lasyaharika");
		
		//driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("103r1a0464.");
		//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]")));
		//driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		//driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
		//driver.findElement(By.xpath("//div[@id='passwordNext']//content[@class='CwaK9']")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.findElement(By.xpath("//span[@class='gb_8a gbii']")).click();
		driver.findElement(By.xpath("//a[@id='gb_71']")).click();
	
		/*driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("fsdf123");
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("fsdf");
		driver.findElement(By.xpath("//input[@name='Username']")).sendKeys("123456789");*/
		
		
		driver.close();
	
		

	}

}
