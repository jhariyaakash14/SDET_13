package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUpdate {


@Test
 public void getExecuteQuery() throws SQLException
 {
	Connection con = null;
  //Step 1: Register the database
  try {
	Driver driverref=new Driver();
  DriverManager.registerDriver(driverref);
  
  //Step 2: establish Connection with database
   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
  
  //Step 3: Issue create statement
  Statement stat=con.createStatement();
  
  //Step 4: Execute any query
  int result = stat.executeUpdate("insert into customer values ('John','Akash','B-13 street','NY', 52005,'USA');");
  
  if (result==1)
  {
	  System.out.println("Table Created passed");
	  
  }
  else
  {
	  System.out.println("Project failed");
  }
  }
  
  catch (Exception e)
  {
	  
  }
 finally { 
  //Step 5: Close database connection
  con.close();
  
  System.out.println("Connection closed");
 }
 }
	
}

