package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Spicejet {

	public static void main(String [] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D://DDrive//ThirdPartyDrivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		//select from BLR in dynamic-drop down
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click(); 	
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //selecty by index
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); //parent child relation
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active")).click();//select current date in calender
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled()); //this is not working.
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); //click round-trip radio button
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("Return Date calender Enabled");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Return Date calender not Enabled");
			Assert.assertTrue(false);
		}

		//*********click passengers button and select 5 adults******************
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000L);

		/*int i =1;
		while (i<5){
			driver.findElement(By.cssSelector("#hrefIncAdt")).click();
			i++;
		}*/

		for (int i=1; i<5; i++){
			driver.findElement(By.cssSelector("#hrefIncAdt")).click();
		}

		driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		//*********select senior citizen radio -button*******/
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size()); //find the total count of check-boxes in UI
		driver.close();
	}
}

