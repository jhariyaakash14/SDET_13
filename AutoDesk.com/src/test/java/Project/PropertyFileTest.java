package Project;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFileTest 
{
	@Test
	
	public void readData() throws IOException
	{
		FileInputStream fis = new FileInputStream("./data/CommonData.properties");
		  
		  //Step-2: Create an Object for the Properties class and load all the key:value pair
		  
		 Properties p = new Properties();
		  p.load(fis);
		  
		  //Step-3: Read the value using get.properties("key")
		  
		 String URl = p.getProperty("url");
		  String Platform = p.getProperty("Platform");
		  String Username = p.getProperty("username");
		  String Password = p.getProperty("password");
		  
		  System.out.println(URl);
		  System.out.println(Platform);
		  System.out.println(Username);
		  System.out.println(Password);
		  
		/*FileInputStream fis= new FileInputStream("‪./data/commonData.properties");
		
		Properties pObj= new Properties();
		
		pObj.load(fis);
		
		String URL=pObj.getProperty("url");
		String BROWSER=pObj.getProperty("browser");
		String USERNAME=pObj.getProperty("username");
		String PASSWORD=pObj.getProperty("password");
		
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		*/
	}
}
