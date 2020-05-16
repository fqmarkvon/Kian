package com.ezpass;
import java.lang.*; //including Java packages used by this program
import java.sql.*;
import java.time.LocalDate;
import com.ezpass.*;

//start
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JScrollPane;

//end

public class Transaction{
	private String TransactionID, TagCode, TransactionDate, TransactionTime, TollPlaza, CustomerID;
	private float TollAmount;
	private int TollLaneNumber;

public Transaction( String CP_TagCode, String CP_Date, String CP_Time,
String CP_TollPlaza,int CP_Number,Float CP_TollAmount, String CP_ID) { //Constructor One with three parameters
		//TransactionID = CP_ID;
		TagCode = CP_TagCode;
		TransactionDate=CP_Date;
		TransactionTime = CP_Time;
		TollPlaza=CP_TollPlaza;
	    TollAmount = CP_TollAmount;
		TollLaneNumber = CP_Number;
		CustomerID=CP_ID;

	}
	public Transaction() {

	}

public String TransactionID(){
	//int random=(int)(Math.random()*1000000); //Math.random() * 1000000  (int)(Math.random()*100);
	//String randoms=String.valueOf(random);
	//1CustomerID=Name+randoms;
	try{
	                 DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		             Connection DBConn = ToDB.openConn();
					 Statement Stmt = DBConn.createStatement();
					 ResultSet Rslt;
					 do {
					 int random2=(int)(Math.random()*1000000);
					 	String randoms2=String.valueOf(random2);
						TransactionID=randoms2;
					 String SQL_Command = "SELECT TransactionID FROM Transaction2 WHERE TransactionID ='"+TransactionID+"'"; //SQL query command
					 //String SQL_Command = "SELECT TransactionID FROM Transaction WHERE TransactionID ='"+TransactionID+"'"; //SQL query command
				     Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				 } while(Rslt.next());
				Stmt.close();
			    ToDB.closeConn();


			 }
	catch(java.sql.SQLException e)
							    {         //done = false;
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
							    {         //done = false;
										 System.out.println("Exception: " + e);
										 e.printStackTrace ();
						    }
	return CustomerID;
	}

public boolean recordTransaction(){
	boolean done=false;
	System.out.println("used paytollfunction");
	System.out.println("generate transaction id");
	TransactionID();

	try{
			if(!done){
				 DBConnection ToDB = new DBConnection(); //Have a connection to the DB
	             Connection DBConn = ToDB.openConn();
				 Statement Stmt = DBConn.createStatement();
				 String SQL_Command;

				  SQL_Command = "INSERT INTO Transaction2(TransactionID,TagCode,TransactionDate,TransactionTime,TollAmount,TollPlaza,TollLaneNumber,CustomerID)"+
				 		       " VALUES ('"+TransactionID+"','"+TagCode+"','"+TransactionDate+"', '"+TransactionTime+"',"+TollAmount+",'"+TollPlaza+"',"+TollLaneNumber+",'"+CustomerID+"')"; //Save the username, password and Name

				  //SQL_Command = "INSERT INTO Transaction(TransactionID,TagCode,TransactionDate,TransactionTime, TollAmount,TollPlaza,TollLaneNumber, CustomerID)"+
				  //" VALUES ('"+TransactionID+"','"+TagCode+"','"+TransactionDate+"','"+TransactionTime+"', '"+TollAmount+"','"+TollPlaza+"','"+TollLaneNumber+"','"+CustomerID+"')"; //Save the username, password and Name
				 Stmt.executeUpdate(SQL_Command);

				done=true;
				 System.out.println("pay toll successfuly");
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
//start
public Vector searchTransactions(String StartingDate, String EndingDate, String CustomerID)
{
     Vector TransFound = new Vector();
     try {

DBConnection ToDB = new DBConnection(); //Have a connection to the DB
Connection DBConn = ToDB.openConn();
Statement Stmt = DBConn.createStatement();
//CustomerID="f123456";
String command = "SELECT * FROM Transaction2 WHERE TransactionDate>='"+StartingDate+
                                                  "' AND TransactionDate<='"+EndingDate+
                                                  "' AND CustomerID='"+CustomerID+"'"; //your condition here;
//String command = "SELECT * FROM Transaction2";
ResultSet results = Stmt.executeQuery(command);
ResultSetMetaData rsmd=results.getMetaData();
while (results.next()) {
   TransFound.addElement(ToDB.getNextRow(results,rsmd));
     }
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
System.out.print("haole");
   return TransFound;

}







//end
}