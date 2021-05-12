package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOrganizationWithIndustry {

	
	@Test
	public void organizationName() throws InterruptedException
	
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
		
		
		//navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Automation");
		WebElement org = driver.findElement(By.name("industry"));	
		Select s= new Select(org);
		s.selectByValue("Banking");
		
		
		//Save the organization
		driver.findElement(By.name("button")).click();
		
		//Signout
		Thread.sleep(3000);
		WebElement web = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		Actions a=new Actions(driver);
		
		a.moveToElement(web).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		
}
}