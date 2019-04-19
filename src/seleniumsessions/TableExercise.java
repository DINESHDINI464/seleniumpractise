package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableExercise {

	public static void main(String[] args) {
		int sum =0;
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D://DDrive//ThirdPartyDrivers//chromedriver.exe");
		//driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22469/dc-vs-mi-34th-match-indian-premier-league-2019");
		driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");
		driver.manage().window().maximize();
		WebElement table =driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
	int rowcount=table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
	//System.out.println(rowcount);
	int count=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
	//System.out.println(count);
	
	for (int i =0 ; i<count-2;i++ )
	{
		String value=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
		int valueinteger=Integer.parseInt(value);//convert string to value
		sum=sum+valueinteger; 	
	}
	System.out.println( "batsman score" + sum);
	//taking the extras value from from different css having same parent class
String Extras=driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText(); //getting the text of sibling 
int extrasvalue=Integer.parseInt(Extras);
int totalsumvalue=sum+extrasvalue;
System.out.println(totalsumvalue);

//compare actual total and our execution total
String ActualTotal=driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
int actualtotalval=Integer.parseInt(ActualTotal);
if(actualtotalval==totalsumvalue)
{
	System.out.println("count matches");
	}
else
{
	System.out.println("count not matches");	
}

		driver.close();
	}

}
