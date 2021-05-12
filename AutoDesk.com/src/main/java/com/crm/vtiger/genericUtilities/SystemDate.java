package com.crm.vtiger.genericUtilities;

import java.util.Date;

import org.testng.annotations.Test;

public class SystemDate {
@Test
public void main()
{
	String currentSysDate = new Date().toString().replace(":", "_").replace(" ", "_");
	System.out.println(currentSysDate);
	}

}
