package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCount {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D://DDrive//ThirdPartyDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		//1. Count of all links in webpage
		System.out.println(driver.findElements(By.tagName("a")).size()); 

		//2. Get the count of links in footer section
		//Approach: Limit the webdriver scope to footer section
		WebElement footersection= driver.findElement(By.cssSelector("#gf-BIG"));
		System.out.println(footersection.findElements(By.tagName("a")).size());

		//3. find the footer links in firstcolum
		WebElement firstcolumn = driver.findElement(By.xpath("//td[1]//ul[1]"));
		System.out.println(firstcolumn.findElements(By.tagName("a")).size());

		//4. click on each link in the coloumn and check if the pages are opening-
		for (int i =1 ; i< firstcolumn.findElements(By.tagName("a")).size(); i++){

			String clickonlink =Keys.chord(Keys.CONTROL,Keys.ENTER);
			firstcolumn.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
			//System.out.println(driver.getTitle());
			Thread.sleep(3000L);
		} //open all the tabs


		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles(); //4 tabs needs to handle
		Iterator<String> it = s1.iterator();

		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		driver.quit();
	}

}
