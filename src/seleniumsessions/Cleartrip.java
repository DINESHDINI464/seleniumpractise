package seleniumsessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cleartrip {
	public static void main (String [] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://DDrive//ThirdPartyDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);	
		Select adult = new Select(driver.findElement(By.id("Adults")));
		adult.selectByValue("5");

		/*for (int i=0;i<5;i++);
		 * driver.findElement(By.id("Adults")).click();
		 */
		Select child = new Select(driver.findElement(By.id("Infants")));
		child.selectByIndex(5);

		driver.findElement(By.id("MoreOptionsLink")).click();
		// Thread.sleep(5000);
		driver.findElement(By.name("airline")).sendKeys("Indigo");
		//driver.findElement(By.xpath("//input[@placeholder='Airline name']")).sendKeys("Indigo");
		driver.findElement(By.id("SearchBtn")).click();
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText()); //printing error msg in console


		WebElement from = driver.findElement(By.cssSelector("#FromTag"));

		from.clear();
		from.sendKeys("BLR");

		/*Select from= new Select(driver.findElement(By.cssSelector("#FromTag")));
	  Thread.sleep(5000);
		//from.selectByVisibleText(Bangalore, IN - Kempegowda International Airport (BLR));
from.selectByIndex(0);*/

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit wait should not use for sendkeys
		Thread.sleep(5000);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.titleContains("Bangalore, IN - Kempegowda International Airport (BLR)"));
		//wait.until(ExpectedConditions.textMatches("#FromTag","Bangalore, IN - Kempegowda International Airport (BLR)"));
		//wait.until(ExpectedConditions.textToBePresentInElementValue(By.cssSelector("#FromTag"),"Bangalore, IN - Kempegowda International Airport (BLR)"));

		// Wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[contains(text(),'Bangalore, IN - Kempegowda International Airport (BLR)']")));
		System.out.println("click before enter");

		from.sendKeys(Keys.ENTER);

		WebElement to = driver.findElement(By.cssSelector("#ToTag"));

		to.clear();
		to.sendKeys("DEL");
		Thread.sleep(5000);
		from.sendKeys(Keys.ENTER);
		WebElement date = driver.findElement(By.cssSelector("#DepartDate"));
		date.sendKeys(Keys.ENTER);

		driver.findElement(By.id("SearchBtn")).click();
		//driver.close();

	}
}
