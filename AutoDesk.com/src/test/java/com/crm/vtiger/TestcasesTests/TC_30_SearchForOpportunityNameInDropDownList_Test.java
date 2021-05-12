package com.crm.vtiger.TestcasesTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.vtiger.genericUtilities.ExcelUtility;
import com.crm.vtiger.genericUtilities.BaseClass;
import com.crm.vtiger.genericUtilities.JavaUtilities;
import com.crm.vtiger.genericUtilities.WebDriverUtilities;
@Listeners(com.crm.vtiger.genericUtilities.ListImgClass.class)
public class TC_30_SearchForOpportunityNameInDropDownList_Test extends BaseClass
{
	@Test(groups="smokeTest")
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
	public void opportunityNameSearch() throws Throwable
	{
		
		//String search = eutil.getExcelDatas("Sheet1", 7, 2);
		//Step 3: Navigate to opportunity
		driver.findElement(By.linkText("Opportunities")).click();
		
		//step 4: Search for opportunity name
		WebElement on = driver.findElement(By.name("search_field"));
		util.selectOptions(on, "Opportunity Name");
		driver.findElement(By.name("submit")).click();
		
	
	}
}