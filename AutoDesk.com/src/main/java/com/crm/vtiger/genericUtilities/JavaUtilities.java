package com.crm.vtiger.genericUtilities;

import java.util.Date;
import java.util.Random;
/*
 * this class contains java specific generic libraries
 * @Akash
 */

public class JavaUtilities {

	/*
	 * Generate random number
	 * @Akash
	 */
	
	public String getRandomData()
	{
		Random random =new Random();
		int ran=random.nextInt(1000);
		return ""+ran;
	}

	/*
	 * Generate current system date
	 * @Akash
	 */

	public String getCurrentSystemDate()
	{
		Date date= new Date();
		String CurrentDate=date.toString();
		return CurrentDate;
		
	}
	
}