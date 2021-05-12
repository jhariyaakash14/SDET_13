package com.crm.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericUtilities.WebDriverUtilities;
/**
 * 
 * @author Akash Jhariya
 *
 */
public class CreateOpportunityPage extends WebDriverUtilities {
	WebDriver driver;
	public CreateOpportunityPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="potentialname")
	private WebElement opportunityNameTF;
	
	@FindBy(id="related_to_type")
	private WebElement relatedToDropDown;
	
	public WebElement getOrgName() {
		return orgName;
	}

	@FindBy(xpath="//img[@title='Select']")
	private WebElement relatedToBtn;
	
	@FindBy(id="1")
	private WebElement orgName;

	
	@FindBy (name="button")
	private WebElement saveBtn;
	
	public WebElement getOpportunityNameTF() {
		return opportunityNameTF;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getRelatedToBtn() {
		return relatedToBtn;
	}

	//public WebElement getRelatedToDropDown() {
		//return relatedToDropDown;
//	}

	/**
	 * use this method to create opportunity
	 * @param opportunityName
	 */
	public void createOpportunity(String opportunityName)
	{
		opportunityNameTF.sendKeys(opportunityName);
	}
	
	
	/**
	 * use this method to select related to dropdown and Organization name
	 * @param opportunityName
	 * @param related
	 * @throws InterruptedException 
	 */
	public void createOpportunity(String opportunityName, String related, String childWindow, String parentWindow) throws InterruptedException
	{
		opportunityNameTF.sendKeys(opportunityName);
		selectOptions(relatedToDropDown, related);
		
		relatedToBtn.click();
		switchToWindow(driver, childWindow);
		waitAndClick(orgName);
		orgName.click();
		switchToWindow(driver, parentWindow);
		saveBtn.click();
	}
}
