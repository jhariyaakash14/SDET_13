package selenium_grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridPractice {
	
	RemoteWebDriver driver;
	@Parameters("Browser")
	@BeforeClass
	public void cofigBeforeClass(String Browser) throws MalformedURLException
	{
		URL remoteAddress=new URL("");
		DesiredCapabilities dc=new DesiredCapabilities();
		
		if (Browser.equals("chrome"))
		{
			dc.setPlatform(Platform.WINDOWS);
			dc.setBrowserName("chrome");
			
		}
		else if (Browser.equals("firefox"))
		{
			dc.setPlatform(Platform.WINDOWS);
			dc.setBrowserName("firefox");
		}
		driver =new RemoteWebDriver(remoteAddress, dc);
	}
	
	@Test
	public void remoteExecution()
	{
		driver.get("https://mail.google.com/");
	}
}
