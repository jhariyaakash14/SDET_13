package com.crm.vtiger.TestcasesTests;


import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.genericUtilities.BaseClass;
@Listeners(com.crm.vtiger.genericUtilities.ListImgClass.class)
public class TC_26_FillAllTheEntriesAndClickOnSave_Test extends BaseClass {

	
	@Test(priority =1)
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
	

	@Test(priority =2)
	public void cancleData  () throws Throwable
	{
		
		//String oppName = eutil.getExcelDatas("Opp",6,2);
		//String relate = eutil.getExcelDatas("Opp",7,2);
		//String potent = eutil.getExcelDatas("Opp", 8, 2);
		driver.findElement(By.linkText("Opportunities")).click();
		
		//Step 4: Create data
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys("SDET"+ju.getRandomData());
		driver.findElement(By.name("amount")).sendKeys(ju.getRandomData());
		WebElement sales = driver.findElement(By.name("sales_stage"));
		util.selectOption(sales, 2);
		
		
		 WebElement related = driver.findElement(By.name("related_to_type"));
		util.selectOptions(related,"Organizations");
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		util.waitUtilePageLoad(driver);
		util.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("1")).click();
		Thread.sleep(5000);
		util.switchToWindow(driver, "Potentials");
		
		//Step 5: cancel the opportunity
		driver.findElement(By.xpath("//input[@value='  Cancel  ']")).click();
		
		
	}
	
	@Test(priority =3)
	public void editData() throws Throwable
	{
		
		//String oppName = eutil.getExcelDatas("Opp",11,2);
		//String relate = eutil.getExcelDatas("Opp",12,2);
		//String potent = eutil.getExcelDatas("Opp", 13, 2);
		//Step 3: Navigate to opportunity
		driver.findElement(By.linkText("Opportunities")).click();
		
		//Step 4: Create data
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys("Automation"+ju.getRandomData());
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
	

	@Test(priority =4)
	public void deleteData() throws InterruptedException
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
		driver.findElement(By.name("Delete")).click();
		Alert a1 = driver.switchTo().alert();
		a1.accept();
		
	}
}