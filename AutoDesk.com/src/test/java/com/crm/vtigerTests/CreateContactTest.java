package com.crm.vtigerTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.vtiger.genericUtilities.FileUtility;


public class CreateContactTest {

	@Test
	public void organizationName() throws Throwable
	
	{
		FileUtility futil=new FileUtility();
		String browserName=futil.getPropertyKeyValue("browser");
		String url=futil.getPropertyKeyValue("url");
		String username=futil.getPropertyKeyValue("username");
		String password=futil.getPropertyKeyValue("password");
		System.setProperty("webdriver.chrome.driver","./software/chromedriver.exe");
		WebDriver driver=null;
		
		//launch browser
		if(browserName.equalsIgnoreCase("chrome")) {
		 driver=new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
		}
		
		else
		{
			System.out.println("No Such Browser Present!!!...");
		}
		//Step: Get Url
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Step: Enter UN, PW and login
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Create contacts
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("abcd");
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		String parent = driver.getWindowHandle();
		Set<String> Child = driver.getWindowHandles();
		System.out.println(Child);
		
		
		for ( String b:Child)
		{
			driver.switchTo().window(b);
			
		}
		driver.findElement(By.linkText("TestYantra")).click();
		
		driver.switchTo().window(parent);
		//save the contact
		driver.findElement(By.name("button")).click();
		
		//Signout
		WebElement web = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		Actions a=new Actions(driver);				
		a.moveToElement(web).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
}
}