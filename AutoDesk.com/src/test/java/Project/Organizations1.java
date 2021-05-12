package Project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Organizations1 
{

	@Test
	public void organizationCheckBox()
	
	{
		System.setProperty("webdriver.chrome.driver","./software/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//Step: Get Url
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Step: Enter UN, PW and login
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step: Goto organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step: Capture all the organization
		
		String x="//table[@class='lvt small']/tbody/tr[*]/td[1]/input";
		List<WebElement> list = driver.findElements(By.xpath(x));
		
		for(int i=1; i<list.size(); i++ )
		{
			list.get(i).click();
			
		}
		
		driver.close();
		
	}
}

