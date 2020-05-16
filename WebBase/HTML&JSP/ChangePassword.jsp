
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ezpass.*;" %>

<%
    String Username = new String("");
	String OldPassword = new String("");
	String Password = new String("");
    String RePassword = new String("");
   
	
	Username = request.getParameter( "NameField" );
    OldPassword = request.getParameter( "OldPasswordField" );
    Password = request.getParameter( "PasswordField" );
    RePassword = request.getParameter( "RePasswordField" );
   
              
 
    Account Acct = new Account(OldPassword, Password);
    
%>
<%
	if (Acct.changePassword(Password))
        out.println("Succesful!");
        else { 
%>

out.println("Account creation failed because of existing username or invalid username. Please try again!");

<%		}
%>
 