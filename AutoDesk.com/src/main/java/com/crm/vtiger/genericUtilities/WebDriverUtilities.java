package com.crm.vtiger.genericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/*
 * this class contains webdriver specific generic libraries
 * @Akash
 */
public class WebDriverUtilities {
/*
 * this method wait for 20 sec till the page is loaded
 * @param driver
 */
	public void waitUtilePageLoad(WebDriver driver)
	
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/*
	 * This method wait for the element to be visible
	 * @param driver, element
	 */
	public void waitForElementVisibility(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/*
	 * This method will wait for the element to be clicked
	 * @param element
	 * @Throws Throwable
	 */
	
	public void waitAndClick( WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<40)
		{
			try {
				element.click();
				break;
			}
			catch(Throwable e)
			{
				Thread.sleep(5000);
				count++;
			}
		}
	}
	/*
	 * this method enable user to handle dropdowns using visible text
	 * @ param element
	 * @param option
	 */
	public void selectOptions(WebElement element, String option)
	{
		Select s=new Select(element);
		s.selectByVisibleText(option);
	}
	
	/*
	 * this method enable user to handle dropdowns using index
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/*
	 * this method will perform mouse action
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	
	public void alert(WebDriver driver, WebElement element)
	{
      Alert a1 = driver.switchTo().alert();
		
		a1.accept();
	}
	
	/*
	 * this method perform right click opertaion
	 * @driver
	 * @element
	
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/*
	 * this method will help in switching form one window to another
	 * @param driver
	 * @param partialWinTitlle
	 * 
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle )
	{
		Set<String> child = driver.getWindowHandles();
		Iterator<String> it = child.iterator();
		while (it.hasNext())
		{
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle))
			{
				break;
			}
		}
	
	}
	
	/*
	 * Accept alert
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	
	/*
	 * Cancel alert
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/*
	 * this method is for scrolling action in a webpage
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	
	public void switchFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	public void switchFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchFrame(WebDriver driver, String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
	
	public void takeScreenShot(WebDriver driver, String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot"+screenShotName+".PNG");
		Files.copy(src, dest);
	}
	
	
	public void pressEnterKey() throws AWTException
	{
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}
}
