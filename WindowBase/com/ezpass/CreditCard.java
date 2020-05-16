package com.ezpass;
import java.lang.*; //including Java packages used by this program
import java.sql.*;
import java.time.LocalDate;
import com.ezpass.*;


public class CreditCard{
	private String CardNumber, Name, ExpirationDate, CVV, CustomerID;
	private String NewCardNumber="";

public CreditCard(String TC, String TT, String IS,String ET,String ID) {
		CardNumber=TC;
		Name=TT;
		ExpirationDate=IS;
		CVV=ET;
		CustomerID=ID;

	}
public boolean addCreditCard(){
	boolean done= false;
	try{
		if(!done){
			 DBConnection ToDB = new DBConnection(); //Have a connection to the DB
             Connection DBConn = ToDB.openConn();
			 Statement Stmt = DBConn.createStatement();
			 String SQL_Command = "SELECT CustomerID FROM CreditCard WHERE CustomerID ='"+CustomerID+"'"; //SQL query command
			 ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		     done = !Rslt.next();
			 if (done) {
			 SQL_Command = "INSERT INTO CreditCard(CardNumber, Name, ExpirationDate, CVV,CustomerID)"+
			 		       " VALUES ('"+CardNumber+"','"+Name+"','"+ExpirationDate+"', '"+CVV+"','"+CustomerID+"')"; //Save the username, password and Name
			 Stmt.executeUpdate(SQL_Command);
			 			}
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


public boolean removeCreditCard(){
	boolean done= false;
		try{
			if(!done){
				 DBConnection ToDB = new DBConnection(); //Have a connection to the DB
	             Connection DBConn = ToDB.openConn();
				 Statement Stmt = DBConn.createStatement();
				 String SQL_Command = "SELECT CardNumber FROM CreditCard WHERE CardNumber ='"+CardNumber+"'"; //SQL query command
				 ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
			     done = !Rslt.next();
				 if (done) {
				 SQL_Command = "DELETE FROM CreditCard WHERE CardNumber ='"+CardNumber+"'";
				 Stmt.executeUpdate(SQL_Command);
				 			}
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


public boolean updateCreditCard(String NewCardNumber){
boolean done = false;
	try {
			      DBConnection ToDB = new DBConnection(); //Have a connection to the DB
							        Connection DBConn = ToDB.openConn();
			        Statement Stmt = DBConn.createStatement();
			    String SQL_Command = "SELECT CardNumber FROM CreditCard WHERE CardNumber ='"+CardNumber+"'";
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
			        if (Rslt.next()) {
					    SQL_Command = "UPDATE CreditCard SET CardNumber='"+NewCardNumber+"' WHERE CardNumber ='"+CardNumber+"'"; //Save the username, password and Name
					    Stmt.executeUpdate(SQL_Command);
				        Stmt.close();
				        ToDB.closeConn();
	                    done=true;
					}
		}
		catch(java.sql.SQLException e)		//5
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

	public boolean recharge(){
		boolean done=false;
		try{
				if(!done){
					 DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		             Connection DBConn = ToDB.openConn();
					 Statement Stmt = DBConn.createStatement();
					 String SQL_Command = "SELECT CustomerID FROM CreditCard WHERE CustomerID ='"+CustomerID+"'"; //SQL query command
					 ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				     done = !Rslt.next();
				     System.out.println("in addtag(0 serach id success");
					//if (done) {
					 SQL_Command = "INSERT INTO CreditCard(CardNumber, Name, ExpirationDate,CVV,CustomerID)"+
					 		       " VALUES ('"+CardNumber+"','"+Name+"','"+ExpirationDate+"','"+CVV+"','"+CustomerID+"')"; //Save the username, password and Name
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

}
