
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ezpass.*;" %>

<%
    String CustomerID = new String("");
	String CardNumber = new String("");
	String Name = new String("");
    String Expiration = new String("");
    String CVV = new String("");
    float Balance;
    float Amount;
	
	CustomerID = request.getParameter( "IDField" );
    CardNumber = request.getParameter( "CardNumberField" );
    Name = request.getParameter( "NameField" );
    Expiration = request.getParameter( "ExpirationField" );
    CVV = request.getParameter( "CVVField" );
    String b = request.getParameter("BalanceField");
    Balance= Float.parseFloat(b);
    String a = request.getParameter("AmountField");
    Amount = Float.parseFloat(a);
              
 
    CreditCard cd = new CreditCard(CardNumber,Name,Expiration,CVV,CustomerID);
    
%>
<%
	if (cd.recharge())
        out.println("Succesful!");
        else { 
%>

out.println("Account creation failed because of existing username or invalid username. Please try again!");

<%		}
%>
 