package com.crm.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Akash Jhariya
 *
 */
public class OpportunityPage {

	public OpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement createOpportunityIMG;

	public WebElement getCreateOpportunityIMG() {
		return createOpportunityIMG;
	}
	
	/**
	 * click on create opportunity image
	 */
	public void clickOnCreateOpportunityIMG()
	{
		createOpportunityIMG.click();
	}
}
