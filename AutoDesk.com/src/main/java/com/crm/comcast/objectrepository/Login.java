package com.crm.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="user_name")
	private WebElement usernameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;

	public WebElement getUsername() {
		return usernameTF;
	}

	public WebElement getPassword() {
		return passwordTF;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	/**
	 * Use this method to login to vtiger app
	 * @param username
	 * @param Password
	 */
	
	public void login (String username, String password )
	{
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginbtn.click();
	}

}
