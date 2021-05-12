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
public class OpportunityInformationPage {

	public OpportunityInformationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement opportunityInfo;
	
	public WebElement getOpportunityInfo() {
		return opportunityInfo;
	} 
	
	/*
	 * this method is use to verify the information provided
	 */
	public String getOpportunityText()
	{
		return opportunityInfo.getText();
	}
}
