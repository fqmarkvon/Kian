
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ezpass.*;" %>

<%
    String CustomerID = new String("");
	
	
	CustomerID = request.getParameter( "CustomerID" );
    
    
%>



<HTML>
	<HEAD>
	<TITLE>Recharge</TITLE>
	</HEAD>
	<BODY BGCOLOR="WHITE">
	
	<h3>Recharge Page</h3><br>
	
	<FORM NAME="RechargePage" ACTION="/CSCI6810/Recharge.jsp" METHOD ="post"> <!-- /OnlineSignUpServlet-->
	
	<table>
	<tr><td>CustomerID:</td><td><INPUT TYPE="TEXT" NAME="IDField" Value='<%= CustomerID %>' SIZE=20></td></tr>
	<tr><td>Balance:</td><td><INPUT TYPE="TEXT" NAME="BalanceField" SIZE=20></td></tr>
	<tr><td>CardNumber:</td><td><INPUT TYPE="TEXT" NAME="CardNumberField" SIZE=20></td></tr>
    <tr><td>Amount:</td><td><INPUT TYPE="TEXT" NAME="AmountField" SIZE=20></td></tr>
	<tr><td>Name:</td><td><INPUT TYPE="TEXT" NAME="NameField" SIZE=20></td></tr>
	<tr><td>Expiration:</td><td><INPUT TYPE="TEXT" NAME="ExpirationField" SIZE=20></td></tr>
	<tr><td>CVV:</td><td><INPUT TYPE="TEXT" NAME="CVVField" SIZE=20></td></tr>
	</table>
	
	<P>
	<INPUT TYPE="BUTTON" VALUE="Recharge" onClick="recharge()">
	</P>
	</FORM>
	</BODY>
	</HTML>
	
	<SCRIPT LANGUAGE="JavaScript">
	document.RechargePage.BalanceField.focus();
	   function recharge()
	   {
		   var Prompts = "";
           Balance= window.document.RechargePage.BalanceField.value;
		   //Password = document.SignUpPage.PasswordField.value;
		   //RePassword = SignUpPage.RePasswordField.value;
		   CustomerID = RechargePage.IDField.value;
		   CardNumber = RechargePage.CardNumberField.value;
		   Amount = RechargePage.AmountField.value;
		   Name = RechargePage.NameField.value;
		   Expiration = RechargePage.ExpirationField.value;
		   CVV = RechargePage.CVVField.value;
		   
	
		   if (CustomerID == "" || Balance == "" || CardNumber  == "" || Amount == ""|| Name == ""|| Expiration == ""|| CVV == "") {
			  if (CustomerID == "")
				 Prompts +="Please enter your CustomerID!\n";
			  if (Balance == "")
				 Prompts +="Please enter your Balance!\n";
			  if (CardNumber == "")
				 Prompts +="Please enter your CardNumber!\n";
			  if (Amount == "")
                 Prompts +="Please enter your Amount!\n";
              if (Name == "")
                 Prompts +="Please enter your Name!\n";
              if (Expiration == "")
                 Prompts +="Please enter your Expiration!\n";
              if (CVV == "")
				 Prompts +="Please enter your CVV!\n";
			  if (Prompts != "")
				 window.alert(Prompts);
		   } else {
			  document.RechargePage.submit();
		   }
	   }
	
	</SCRIPT>
	