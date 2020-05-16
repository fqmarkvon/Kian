
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ezpass.*;" %>

<%
    String Customername = new String("");
	String Street = new String("");
	String City = new String("");
    String State = new String("");
    String Zip = new String("");
    String Phone = new String("");
    String Email = new String("");
    float Balance;
	
	Customername = request.getParameter( "NameField" );
    Street = request.getParameter( "StreetField" );
    City = request.getParameter( "CityField" );
    State = request.getParameter( "StateField" );
    Zip = request.getParameter( "ZipField" );
    Phone = request.getParameter( "PhoneField" );
    Email = request.getParameter( "EmailField" );
    String a = request.getParameter("BalanceField");
    Balance = Float.parseFloat(a);
              
    Customer CP = new Customer(Customername,Street,City,State,Zip,Phone,Email,Balance);
%>
<%
	if (CP.CreateProfile())
        out.println("Succesful!");
        else { 
%>

out.println("Account creation failed because of existing username or invalid username. Please try again!");

<%		}
%>
 
