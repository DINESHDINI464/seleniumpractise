package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;

public class JavaAlerts {
	public static void main(String []args) throws InterruptedException{
		/*System.setProperty("webdriver.gecko.driver", "D://DDrive//ThirdPartyDrivers//geckodriver.exe");
	WebDriver driver = new FirefoxDriver();*/
		System.setProperty("webdriver.chrome.driver", "D://DDrive//ThirdPartyDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver; //JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver
		driver.manage().window().maximize();
	
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
		//Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1000)");//To scroll down the web page by pixel.
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='button']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		driver.close();




	}
}
