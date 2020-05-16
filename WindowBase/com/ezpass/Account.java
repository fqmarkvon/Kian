package com.ezpass;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import java.time.LocalDate;
import com.ezpass.*;



public class Account{

	private String Username, Password, Password1, Name,CustomerID;
	private String LastLogin="";
	private int ThreeConsecutiveFailures;
	private String Password2;
	//private String Username, Password,CustomerID,Name;

public Account(String UN, String PassW, String PassW1, String NM) {
		Username = UN;
		Password = PassW;
		Password1 = PassW1;
		Name = NM;
	}

	public Account(String UN, String PassW) {
		Username = UN;
		Password = PassW;
	}
public Account(String UN ,String ID, String PassW) {
		Username = UN;
		CustomerID = ID;
		Password = PassW;
		//Name = NM;


	}

	public Account() {

	}

public String []SignIn(){
				String []CustInfo=new String[2];
				try {		//20
							        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
							        Connection DBConn = ToDB.openConn();
							        Statement Stmt = DBConn.createStatement();
							        //String SQL_Command = "SELECT Name FROM Account WHERE Username ='"+Username+ "'AND Password ='"+Password+"'"; //SQL query command to get Name.
						            String SQL_Command =  "SELECT Name, CustomerID FROM Account WHERE Username ='"+Username+ "'AND Password ='"+Password+"'";
						            ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.

							        while (Rslt.next()) {
									CustInfo[0] = Rslt.getString(1);
									CustInfo[1] = Rslt.getString(2);
									//CustInfo[2]	= Rslt.getString(3);

							        }



							        //if (Rslt.next()) {
										//SQL_Command ="SELECT * FROM Account WHERE Username =? AND Password =? ";
										//SQL_Command ="SELECT * FROM Account WHERE Username=? AND Password=?";
									    //Stmt.executeUpdate(SQL_Command);
								Stmt.close();
								ToDB.closeConn();

									//}
						}
						catch(java.sql.SQLException e)		//5
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
				    return CustInfo;
	}
public Boolean signIn(){
				boolean done=true;
				String name="";
				try {		//20
							if (done){
							        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
							        Connection DBConn = ToDB.openConn();
							        Statement Stmt = DBConn.createStatement();
							        //String SQL_Command = "SELECT Name FROM Account WHERE Username ='"+Username+ "'AND Password ='"+Password+"'"; //SQL query command to get Name.
						            String SQL_Command = "SELECT Name, CustomerID FROM Account WHERE Username ='"+Username+ "'AND Password ='"+Password+"'";
						            ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.

							        while (Rslt.next()) {
									name = Rslt.getString(1);
							        }
							        //if (Rslt.next()) {
										//SQL_Command ="SELECT * FROM Account WHERE Username =? AND Password =? ";
										//SQL_Command ="SELECT * FROM Account WHERE Username=? AND Password=?";
									    //Stmt.executeUpdate(SQL_Command);
								Stmt.close();
								ToDB.closeConn();

							}		//}
						}
						catch(java.sql.SQLException e)		//5
							    {
										 done = false;
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
										 done = false;
										 System.out.println("Exception: " + e);
										 e.printStackTrace ();
				    }
				    return done;
	}
public boolean signUp() {
		boolean done = !Username.equals("") && !Password.equals("") && !Password1.equals("") && Password.equals(Password1);
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Username FROM Account WHERE Username ='"+Username+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Account(Username, Password, Name) VALUES ('"+Username+ "','"+Password+"','"+Name+"')"; //Save the username, password and Name
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
public boolean changePassword(String NewPassword) {	//5
		boolean done = false;
		try {		//20
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT * FROM Account WHERE Username ='"+Username+ "'AND Password ='"+Password+"'"; //SQL query command
		        System.out.println("selct username "+Username);
		        System.out.println("selct password "+Password);
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		         done = !Rslt.next();
		        //if (Rslt.next()) {
				    SQL_Command = "UPDATE Account SET Password='"+NewPassword+"' WHERE Username ='"+Username+"'"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
			        Stmt.close();
			        ToDB.closeConn();
                    done=true;
                    System.out.println("Change password succeed"+NewPassword);
				//}
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

}