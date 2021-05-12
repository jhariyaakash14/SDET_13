package com.crm.vtiger.genericUtilities;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public  class RetryAnalyzer implements IRetryAnalyzer {

	int count=0;
	int retryLimit=4;
	
	public boolean retry(ITestResult result)
	{
		if(count<retryLimit)
		{
			count++;
			return true;
		}
		return false;
	}
	
}
