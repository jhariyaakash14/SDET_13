package com.crm.vtiger.genericUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectrepository.HomePage;
import com.crm.comcast.objectrepository.Login;

public class BaseClass {

	public WebDriverUtilities util=new WebDriverUtilities();
	public JavaUtilities ju= new JavaUtilities();
	public FileUtility futil=new FileUtility();
	public ExcelUtility eutil= new ExcelUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	
	
	@BeforeSuite(groups= {"smokeTest", "regressionTest"})
	public void configBS()
	{
		//launch browser in parallel mode
	}
	
	@BeforeTest(groups= {"smokeTest", "regressionTest"})
	 public void configBT() {
	  //launch browser in parallel mode
	 }
	
	
	//@Parameters("browser")
	@BeforeClass(groups= {"smokeTest", "regressionTest"})
	public void configBC() throws Throwable
	{
		String browser=futil.getPropertyKeyValue("browser");
		System.setProperty("webdriver.chrome.driver","./software/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./software/geckodriver.exe");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		driver=new FirefoxDriver();
		}
		
		
		util.waitUtilePageLoad(driver);
		driver.manage().window().maximize();
		sdriver=driver;
	}
	
	@BeforeMethod(groups= {"smokeTest", "regressionTest"})
	public void setUp() throws Throwable
	{
		String url=futil.getPropertyKeyValue("url");
		String username=futil.getPropertyKeyValue("username");
		String password=futil.getPropertyKeyValue("password");
		driver.get(url);
//		driver.findElement(By.name("user_name")).sendKeys(username);
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).click();
		Login loginPage=new Login(driver);
		loginPage.login(username, password);
	
	}
	
	@AfterMethod(groups= {"smokeTest", "regressionTest"})
	public void tearDown()
	{
		HomePage homePage=new HomePage(driver);
		homePage.signOut();
	}
	
	@AfterClass(groups= {"smokeTest", "regressionTest"})
	 public void configAC()
	{
	  driver.quit();
	 }
	 @AfterTest(groups= {"smokeTest", "regressionTest"})
	 public void configAT() {
	  //close driver ref in parallel mode
	 }
	 
	 @AfterSuite(groups= {"smokeTest", "regressionTest"})
	 public void configAS() {
	  // close DB connection
	 }

	 
}
