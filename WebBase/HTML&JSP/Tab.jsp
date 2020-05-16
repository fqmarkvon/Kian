<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ezpass.*;" %>

<%
	String Username = new String("");
	String Password = new String("");
	
	Username = request.getParameter( "Username" );
	Password = request.getParameter( "Password" );

       
   


%>

<%
Account Acct = new Account(Username,Password);
String [] customerarray = Acct.SignIn();
String customername = customerarray[0];
String CustomerID=customerarray[1];

boolean CustomerName = Acct.signIn();


//request.setAttribute("Customername",customername);
%>
<%
	if (!CustomerName)
            out.println("Account creation failed because of existing username or invalid username. Please try again!");
        else { 
%> 

		<HTML>
        <HEAD></HEAD>
		<BODY bgcolor='#F1F1FD'>
		<h4 ALIGN='center'>TabBO </h4>
        <FORM NAME="TabPage" ACTION="/CSCI6810/preCreateProfile.jsp" METHOD ="POST">
            <INPUT TYPE='HIDDEN' NAME='UserName' Value='<%= Username %>' SIZE='15' focused>
            <INPUT TYPE='HIDDEN' NAME='CustomerID' Value='<%= CustomerID %>' SIZE='15' >
            <INPUT TYPE='HIDDEN' NAME='CustomerName' Value='<%= customername %>' SIZE='15' >
            <a href='/CSCI6810/preCreateprofile.jsp?Username=<%= Username %>&CustomerName=<%= customername %>' >Create Profile</a>
            <A HREF='/CSCI6810/prePayToll.jsp?CustomerID=<%= CustomerID %>'>PayToll</A>
            <A HREF='/CSCI6810/preChangePassword.jsp?Username=<%= Username %>'>ChangePassword</A>
            <A HREF='/CSCI6810/preRecharge.jsp?CustomerID=<%= CustomerID %>'>Recharge</A>
            <A HREF='/CSCI6810/preViewTransaction.jsp?CustomerID=<%= CustomerID %>'>ViewTransaction</A>
            <A HREF='/CSCI6810/preVehicle.jsp?CustomerID=<%= CustomerID %>'>Vehicle</A>
            <A HREF='/CSCI6810/preEzTag.jsp?CustomerID=<%= CustomerID %>'>EzTag</A>
		</FORM>
        </BODY>
        <SCRIPT LANGUAGE="JavaScript"> 
            function checkInputs()
            {
            var Prompts = "";
            Username = window.document.LoginPage.UserName.value;
            Password = window.document.LoginPage.PassWord.value;
            if (Username == "" || Password == "") {
            if (Username == "")
            Prompts +="Please enter your username!\n";
            if (Password == "")
            Prompts +="Please enter your password!\n";
            if (Prompts != "")
            window.alert(Prompts);
            } else {
            document.LoginPage.submit();
            }
            }
            </SCRIPT>
		</HTML>

<%		}
%>