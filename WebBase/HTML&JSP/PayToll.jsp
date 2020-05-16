
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ezpass.*;" %>

<%
    String CustomerID = new String("");
	String TagCode = new String("");
	String Date = new String("");
    String Time = new String("");
    String Plaza = new String("");
    int TollNumber;
    float TollAmount;
	
	CustomerID = request.getParameter( "IDField" );
    TagCode = request.getParameter( "TagCodeField" );
    Date = request.getParameter( "DateField" );
    Time = request.getParameter( "TimeField" );
    Plaza = request.getParameter( "PlazaField" );
    String b = request.getParameter("TollNumberField");
    TollNumber=Integer.parseInt(b);
    String a = request.getParameter("TollAmountField");
    TollAmount = Float.parseFloat(a);
              
 
    Transaction CP = new Transaction(TagCode,Date,Time,Plaza,TollNumber,TollAmount,CustomerID);
    
%>
<%
	if (CP.recordTransaction())
        out.println("Succesful!");
        else { 
%>

out.println("Account creation failed because of existing username or invalid username. Please try again!");

<%		}
%>
 