package Project;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtil {


@Test
 public void getExecuteQuery() throws SQLException
 {
  //Step 1: Register the database
  Driver driverref=new Driver();
  DriverManager.registerDriver(driverref);
  
  //Step 2: establish Connection with database
  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
  
  //Step 3: Issue create statement
  Statement stat=con.createStatement();
  
  //Step 4: Execute any query
  ResultSet result = stat.executeQuery("select * from customer;");
  
  while(result.next())
  {
	 
   System.out.println(result.getString(1) + "/t" + result.getString(2) +"/t" +result.getString(3) + "/t" + result.getString(4) + "/t" + result.getString(5) + "/t" + result.getString(6) );
  }
  
  //Step 5: Close database connection
  con.close();
 }

	
}
