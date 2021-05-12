package Project;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateCustomerTest {

	
	
	@Test
	
	public void create()
	{

		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		String URL=System.getProperty("url");
		System.out.println("Execute Test1");
		System.out.println("======>"+USERNAME);
		System.out.println("======>"+PASSWORD);
		System.out.println("======>"+URL);
		
		
		
		
	}
	
}
