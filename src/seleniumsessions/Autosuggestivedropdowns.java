package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestivedropdowns {
	//enter beng in from place 
	// search for beng internaltional airpot and select that in suggestion box
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webDriver.chrome.driver", "D://DDrive//ThirdPartyDrivers//chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		/*System.setProperty("webdriver.gecko.driver","D://DDrive//ThirdPartyDrivers//geckodriver.exe");

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities); */
		driver.get("https://ksrtc.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("beng");
		Thread.sleep(1000L);
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

		//System.out.println(driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText()); --> this line wont print bcoz webelement is in hidden state

		//Javascript DOM can extract hidden elements
		//selenium cannot access hidden things bcoz of ajax implementation
		//investigate the properties of object if we have any hidden text 

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = " return document.getElementById(\"fromPlaceName\").value;"; //to print text so we use return
		//syntax: String abc = "hello";
		String text=(String) js.executeScript(script);
		System.out.println(text);
		int i =0;
		//syntax: while(true)
		while(!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT"))
		{
			i++;
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			text=(String) js.executeScript(script);
			System.out.println(text);
			if(i>10)
			{
				break;
			}
		}
		if(i>10)
		{
			System.out.println("element not found");
		}
		else 
		{
			System.out.println("element found");
		}
	}
	

}





