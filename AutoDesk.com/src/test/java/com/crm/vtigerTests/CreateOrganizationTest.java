package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.vtiger.genericUtilities.FileUtility;

public class CreateOrganizationTest {

	@Test
	public void createOrganization() throws Throwable
	{
		FileUtility futil=new FileUtility();
		String browser=futil.getDataFromJson("browser");
		String url=futil.getDataFromJson("url");
		String username=futil.getDataFromJson("username");
		String password=futil.getDataFromJson("password");
		WebDriver driver=null;
		//launch the browser
		System.setProperty("webdriver.chrome.driver","./software/chromedriver.exe");
		if(browser.equalsIgnoreCase("chrome"))
		{
		driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//get url
		driver.get(url);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		
		
		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("tech");
		
		//save the organization
		driver.findElement(By.name("button")).click();
		
		String parent = driver.getWindowHandle();
		
		driver.switchTo().window(parent);
		
		//Signout
		
		Thread.sleep(3000);
		WebElement web = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		Actions a=new Actions(driver);
				
		a.moveToElement(web).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		
	}
}
