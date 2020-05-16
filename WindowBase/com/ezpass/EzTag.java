package com.ezpass;
import java.lang.*; //including Java packages used by this program
import java.sql.*;
import java.time.LocalDate;
import com.ezpass.*;

public class EzTag{

private String TagCode, TagType, IssueDate, CustomerID;

public EzTag(String TC, String TT, String IS,String ID) {
		TagCode=TC;
		TagType=TT;
		IssueDate=IS;
		CustomerID=ID;

	}
public boolean addTag(){
	boolean done=false;
	try{
			if(!done){
				 DBConnection ToDB = new DBConnection(); //Have a connection to the DB
	             Connection DBConn = ToDB.openConn();
				 Statement Stmt = DBConn.createStatement();
				 String SQL_Command = "SELECT CustomerID FROM EzTag2 WHERE CustomerID ='"+CustomerID+"'"; //SQL query command
				 ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
			     done = !Rslt.next();
			     System.out.println("in addtag(0 serach id success");
				//if (done) {
				 SQL_Command = "INSERT INTO EzTag2(TagCode, TagType, IssueDate,CustomerID)"+
				 		       " VALUES ('"+TagCode+"','"+TagType+"','"+IssueDate+"','"+CustomerID+"')"; //Save the username, password and Name
				 Stmt.executeUpdate(SQL_Command);
				 System.out.println("in if done entity success");
				 done=true;
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
public boolean removeTag(){
	boolean done=false;
	try{
				if(!done){
					 DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		             Connection DBConn = ToDB.openConn();
					 Statement Stmt = DBConn.createStatement();
					 String SQL_Command = "SELECT TagCode FROM EzTag2 WHERE TagCode ='"+TagCode+"'"; //SQL query command
					 ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				     done = !Rslt.next();
					 //if (done) {
					 SQL_Command = "DELETE FROM EzTag2 WHERE TagCode ='"+TagCode+"'";
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
}