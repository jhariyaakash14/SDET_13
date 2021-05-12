package Project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Organization3 {


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
		String expData="SDET";
		//Boolean flag=false;
		int actRowCount=0;
		
		//Step: Capture all the organization
		
		String x="//table[@class='lvt small']/tbody/tr[*]/td[3]/a";
		List<WebElement> list = driver.findElements(By.xpath(x));
		
		for(WebElement wb : list )
		{
			String actData = wb.getText();
			if(expData.equals(actData))
			{
				driver.findElement(By.linkText("del")).click();
				//flag=true;
				break;
			}
			actRowCount++;
		}
		System.out.println(actRowCount);
		
		//driver.close();
		
	}
}
