package com.ezpass;
import java.lang.*; //including Java packages used by this program
import java.sql.*;
import java.time.LocalDate;
import com.ezpass.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JScrollPane;
import com.ezpass.*;

public class Vehicle{
	private String LicensePlateNumber, Make, Model, Color, TagCode, CustomerID;
	private int Year;

public Vehicle(String LP, String MK, String MD, int YR,String CL, String TC, String ID) { //Constructor One with three parameters

		LicensePlateNumber = LP;
		Make = MK;
		Model=MD;
			    Year = YR;
		Color = CL;
		TagCode=TC;

	    CustomerID = ID;


	}

public Vehicle() {

	}

public boolean addVehicle(){
	boolean done=false;
	System.out.println("use entity function!");
	try{
			if(!done){
				 DBConnection ToDB = new DBConnection(); //Have a connection to the DB
	             Connection DBConn = ToDB.openConn();
				 Statement Stmt = DBConn.createStatement();
				 String SQL_Command = "SELECT CustomerID FROM Vehicle WHERE CustomerID ='"+CustomerID+"'";
				 System.out.println("select customerID succeed and id is"+CustomerID);

				 ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
			     done = !Rslt.next();
				 //if (done) {

SQL_Command = "INSERT INTO Vehicle(LicensePlateNumber, Make, Model, Year,Color,TagCode,CustomerID)"+
						                  " VALUES ('"+LicensePlateNumber+"','"+Make+"','"+Model+"',"+Year+",'"+Color+"','"+TagCode+"', '"+CustomerID+"')";
				 Stmt.executeUpdate(SQL_Command);
				 System.out.println("add successfuly");
				 done= true;
				 			//}
				 Stmt.close();
			     ToDB.closeConn();
				}
			}
			 catch(java.sql.SQLException e)
						    {         done = false;
									 System.out.println("SQLException: " + e);
									 while (e != null)
									 {   System.out.println("SQLState: " + e.getSQLState());
										 System.out.println("Message: " + e.getMessage());
										 System.out.println("Vendor: " + e.getErrorCode());
										 e = e.getNextException();
										 System.out.println("");
									 }
						    }
						    catch (java.lang.Exception e)
						    {         done = false;
									 System.out.println("Exception: " + e);
									 e.printStackTrace ();
						    }
		    return done;




	}

public boolean removeVehicle(){
	boolean done=false;
	try{
				if(!done){
					 DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		             Connection DBConn = ToDB.openConn();
					 Statement Stmt = DBConn.createStatement();
					 String SQL_Command = "SELECT LicensePlateNumber FROM Vehicle WHERE LicensePlateNumber ='"+LicensePlateNumber+"'"; //SQL query command
					 ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				     done = !Rslt.next();
					 //if (done) {
					 SQL_Command = "DELETE FROM Vehicle WHERE LicensePlateNumber ='"+LicensePlateNumber+"'";
					 Stmt.executeUpdate(SQL_Command);
					 			//}
					 Stmt.close();
				     ToDB.closeConn();
				     done=true;
					}
				}
				 catch(java.sql.SQLException e)
							    {         done = false;
										 System.out.println("SQLException: " + e);
										 while (e != null)
										 {   System.out.println("SQLState: " + e.getSQLState());
											 System.out.println("Message: " + e.getMessage());
											 System.out.println("Vendor: " + e.getErrorCode());
											 e = e.getNextException();
											 System.out.println("");
										 }
							    }
							    catch (java.lang.Exception e)
							    {         done = false;
										 System.out.println("Exception: " + e);
										 e.printStackTrace ();
							    }
		    return done;




	}


	public Vector searchVehicle(String CustomerID)
	{
	     Vector TransFound = new Vector();
	     try {

	DBConnection ToDB = new DBConnection(); //Have a connection to the DB
	Connection DBConn = ToDB.openConn();
	Statement Stmt = DBConn.createStatement();
	String command = "SELECT * FROM Vehicle WHERE CustomerID='"+CustomerID+"'"; //your condition here;
	System.out.println("searchV zhaodao");
	ResultSet results = Stmt.executeQuery(command);
	ResultSetMetaData rsmd=results.getMetaData();
	while (results.next()) {
	   TransFound.addElement(ToDB.getNextRow(results,rsmd));
	     }
	     System.out.println(".next()getdao");
	 }
	     catch(java.sql.SQLException e)
	     {
	        System.out.println("SQLException: " + e);
	      while (e != null)
	      {   System.out.println("SQLState: " + e.getSQLState());
	         System.out.println("Message: " + e.getMessage());
	         System.out.println("Vendor: " + e.getErrorCode());
	         e = e.getNextException();
	         System.out.println("");
	      }
	     }
	     catch (java.lang.Exception e)
	     {
	      System.out.println("Exception: " + e);
	      e.printStackTrace ();
	     }
	System.out.println("serchvhaole");
	   return TransFound;

}
}