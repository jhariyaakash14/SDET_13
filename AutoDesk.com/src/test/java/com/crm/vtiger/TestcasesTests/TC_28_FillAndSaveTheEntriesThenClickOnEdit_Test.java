package com.crm.vtiger.TestcasesTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.genericUtilities.BaseClass;
import com.crm.vtiger.genericUtilities.JavaUtilities;
import com.crm.vtiger.genericUtilities.WebDriverUtilities;
@Listeners(com.crm.vtiger.genericUtilities.ListImgClass.class)
public class TC_28_FillAndSaveTheEntriesThenClickOnEdit_Test extends BaseClass {



	@Test(groups ="smokeTest")
	public void saveData() throws Throwable
	{
		//util.waitUtilePageLoad(driver);
		//String oppName=eutil.getExcelDatas("Opp",1,2);
		//String relate = eutil.getExcelDatas("Opp",2,2);
		//String potent = eutil.getExcelDatas("Opp", 3, 2);
		driver.findElement(By.linkText("Opportunities")).click();
		
		
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys("TestYantra"+ju.getRandomData());
		driver.findElement(By.name("amount")).sendKeys(ju.getRandomData());
		WebElement sales = driver.findElement(By.name("sales_stage"));
		util.selectOption(sales, 2);
		
		WebElement related = driver.findElement(By.name("related_to_type"));
		util.selectOptions(related, "Organizations");
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		
		util.waitUtilePageLoad(driver);
		util.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("1")).click();
		//Thread.sleep(5000);
		util.switchToWindow(driver, "Potentials");
		
		
		util.waitUtilePageLoad(driver);
		driver.findElement(By.name("button")).click();
	}
	
	@Test(groups="regressionTest")
	public void editData() throws InterruptedException
	{
		
		
		//Step 3: Navigate to opportunity
		driver.findElement(By.linkText("Opportunities")).click();
		
		//Step 4: Create data
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys("Test"+ju.getRandomData());
		driver.findElement(By.name("amount")).sendKeys(ju.getRandomData());
		WebElement sales = driver.findElement(By.name("sales_stage"));
		util.selectOption(sales, 2);
		
		
		WebElement related = driver.findElement(By.name("related_to_type"));
		util.selectOptions(related, "Organizations");
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		util.waitUtilePageLoad(driver);
		
		util.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("1")).click();
		Thread.sleep(5000);
		util.switchToWindow(driver, "Potentials");
		
		//Step 5: Save the data
		driver.findElement(By.name("button")).click();
		driver.findElement(By.name("Edit")).click();
		driver.findElement(By.name("potentialname")).clear();
		driver.findElement(By.name("potentialname")).sendKeys("akash");
		
	}
}

