package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtil1 {

	@Test
	public void Assignment() throws SQLException
	{
		Connection conn=null;
		//Connection the database
		Driver driverreg=new Driver();
		DriverManager.registerDriver(driverreg);
		
	//establish connection with database
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Customers", "root", "root");
		
		// Create Statement
		Statement state=conn.createStatement();
		
		//Execute any query
		ResultSet result=state.executeQuery("select * from Customer;");
		
		String s="Akash";
	
		while(result.next())
		{
			String myName= result.getString(1);
			System.out.println(myName);
			if (myName.equalsIgnoreCase(s)) {
				
				System.out.println("My name is there");
			}
			else
			{
				System.out.println("Name not present");
			}
		}
		
		//Close the connection
		conn.close();
	}
}
