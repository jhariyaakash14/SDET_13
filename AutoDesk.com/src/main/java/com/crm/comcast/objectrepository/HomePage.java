package com.crm.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericUtilities.WebDriverUtilities;

public class HomePage extends WebDriverUtilities {
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 
	@FindBy(linkText="Opportunities")
	private WebElement opportunityLink;
	
	@FindBy (xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIMG;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

	public WebElement getAdministratorIMG() {
		return administratorIMG;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getOpportunityLink() {
		return opportunityLink;
	}
	/**
	 * click on opportunity link
	 */
	public void clickOnOpportunityLink()
	{
		opportunityLink.click();
	}
	/**
	 * Signout form app
	 */
	
	public void signOut()
	{
		mouseOver(driver, administratorIMG);
		signOutLink.click();
	}
}
