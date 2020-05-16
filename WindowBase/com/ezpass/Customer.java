package com.ezpass;
import java.lang.*; //including Java packages used by this program
import java.sql.*;
import java.time.LocalDate;
import com.ezpass.*;
import java.util.UUID;
import java.util.Random;

public class Customer
{
	private String CustomerID, Name, Street, City, State, Zip, Phone, Email;
	private Float Balance;
	private Float Amount;


public Customer(String CP_Name, String CP_Street, String CP_City, String CP_State, String CP_Zip, String CP_Phone ,String CP_Email,Float CP_Balance) { //Constructor One with three parameters
		//CustomerID = CP_ID;
		Name = CP_Name;
		Street = CP_Street;
		City=CP_City;
		State = CP_State;
		Zip=CP_Zip;
	    Phone = CP_Phone;
		Email = CP_Email;
		Balance =CP_Balance;


	}

	public Customer(String ID, Float Bl, Float Am) {
			CustomerID = ID;
			Balance = Bl;
			Amount = Am;

	}
	public Customer(String ID, Float Bl) {
				CustomerID = ID;
				Balance = Bl;


	}
	public Customer(String NM, String ID) {
					Name=NM;
					CustomerID = ID;



	}
	public Customer(String NM) {
						Name=NM;




	}



public String CreateCustomerID(){
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
						CustomerID=Name+randoms2;

					 String SQL_Command = "SELECT CustomerID FROM Customer WHERE CustomerID ='"+CustomerID+"'"; //SQL query command
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



public boolean CreateProfile(){
	boolean done= false;
	System.out.println("used function");
	CustomerID=CreateCustomerID();
		try{
			if(!done){
				 DBConnection ToDB = new DBConnection(); //Have a connection to the DB
	             Connection DBConn = ToDB.openConn();
				 Statement Stmt = DBConn.createStatement();
				 String SQL_Command;


				 SQL_Command = "INSERT INTO Customer(CustomerID,Name, Street, City, State, Zip, Phone, Email, Balance)"+
				 		       " VALUES ('"+CustomerID+"','"+Name+"','"+Street+"','"+City+"', '"+State+"','"+Zip+"','"+Phone+"','"+Email+"',"+Balance+")"; //Save the username, password and Name
				 Stmt.executeUpdate(SQL_Command);
				 System.out.println("add successfuly in entity");
				 String SQL_Command2= "UPDATE Account SET CustomerID ='"+CustomerID+"' WHERE Name='"+Name+"'";
				 System.out.println("transfer to account");
				 System.out.println("account customerID is"+CustomerID);
				 System.out.println("account Name is "+Name);
				 Stmt.executeUpdate(SQL_Command2);
					done=true;
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

    public String getCustomerID(String Name) {  //Method to return a CheckingAccount balance
			try {
			        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			        Connection DBConn = ToDB.openConn();
			        Statement Stmt = DBConn.createStatement();
			        String SQL_Command = "SELECT CustomerID FROM Customer WHERE Name ='"+Name+"'"; //SQL query command
			        ResultSet Rslt = Stmt.executeQuery(SQL_Command);

			        while (Rslt.next()) {
						Name = Rslt.getString(1);
				    }
				    Stmt.close();
				    ToDB.closeConn();
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
		    System.out.println("CustomerID=:"+CustomerID);
		    return CustomerID;
	}



	public boolean updateAddress(){
	boolean done = false;
	try {
				      DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				Connection DBConn = ToDB.openConn();
				        Statement Stmt = DBConn.createStatement();
				    String SQL_Command = "SELECT Customer FROM CustomerID WHERE CustomerID ='"+CustomerID+"'";
			        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				        if (Rslt.next()) {
						    SQL_Command = "UPDATE Customer SET Name='"+Name+"',Street='"+Street+"',City='"+City+"',State='"+State+"',Zip='"+Zip+"',Phone='"+Phone+"',Email='"+Email+"' ,Balance="+Balance+"WHERE CustomerID ='"+CustomerID+"'"; //Save the username, password and Name
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
	public boolean updatePhone(){
	boolean done = false;
	try {
					      DBConnection ToDB = new DBConnection(); //Have a connection to the DB
									        Connection DBConn = ToDB.openConn();
					        Statement Stmt = DBConn.createStatement();
					    String SQL_Command = "SELECT Customer FROM CustomerID WHERE CustomerID ='"+CustomerID+"'";
				        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
					        if (Rslt.next()) {
							    SQL_Command = "UPDATE Customer SET Phone='"+Phone+"' WHERE CustomerID ='"+CustomerID+"'"; //Save the username, password and Name
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
	public float getBalance() {  //Method to return a CheckingAccount balance
			try {
			        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			        Connection DBConn = ToDB.openConn();
			        Statement Stmt = DBConn.createStatement();
			        String SQL_Command = "SELECT CustomerID FROM Customer WHERE CustomerID ='"+CustomerID+"'"; //SQL query command
			        ResultSet Rslt = Stmt.executeQuery(SQL_Command);

			        while (Rslt.next()) {
						Balance = Rslt.getFloat(1);
				    }
				    Stmt.close();
				    ToDB.closeConn();
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
		    return Balance;
	}


	public boolean updateEmail(){
	boolean done = false;
	try {
					      DBConnection ToDB = new DBConnection(); //Have a connection to the DB
									        Connection DBConn = ToDB.openConn();
					        Statement Stmt = DBConn.createStatement();
					    String SQL_Command = "SELECT Customer FROM CustomerID WHERE CustomerID ='"+CustomerID+"'";
				        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
					        if (Rslt.next()) {
							    SQL_Command = "UPDATE Customer SET Email='"+Email+"' WHERE CustomerID ='"+CustomerID+"'"; //Save the username, password and Name
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
	public boolean recharge(float amount){
	boolean done = false;
	return done;
	}

}

