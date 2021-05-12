package com.crm.vtiger.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImgClass implements ITestListener{
 
	public void onTestFailure(ITestResult result)
	{
		String currentSysDate = new Date().toString().replace(":", "_").replace(" ", "_");
		String failedTestName = result.getMethod().getMethodName();
		EventFiringWebDriver ed= new EventFiringWebDriver(BaseClass.sdriver);
		File src = ed.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+failedTestName+"_"+currentSysDate+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {}
	}
}
