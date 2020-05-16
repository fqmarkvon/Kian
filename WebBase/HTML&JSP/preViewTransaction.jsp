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
    <TITLE>ViewTransaction</TITLE>
    </HEAD>
    <BODY BGCOLOR="WHITE">
    
    <h3>ViewTransaction</h3><br>
    
    <FORM NAME="ViewTransactionPage" ACTION="/CSCI6810/ViewTransaction.jsp" METHOD ="post"> <!-- /OnlineViewTransactionServlet-->
    
    <table>
    <tr><td>CustomerID:</td><td><INPUT TYPE="TEXT" NAME="CustomerIDField" Value='<%= CustomerID %>' SIZE=20></td></tr>
    <tr><td>Start Date:</td><td><INPUT TYPE="EndDate" NAME="StartDateField" SIZE=20></td></tr>
    <tr><td>End Date:</td><td><INPUT TYPE="EndDate" NAME="EndDateField" SIZE=20></td></tr>
    </table>
    
    <P>
    <INPUT TYPE="BUTTON" VALUE="Search" onClick="checkInputs()">
    </P>
    <A HREF='/CSCI6810/Withdraw.jsp?UserID=someone@yahoo.com'>Withdraw</A>
    </FORM>
    </BODY>
    </HTML>
    
    <SCRIPT LANGUAGE="JavaScript">
    document.ViewTransactionPage.StartDateField.focus();
       function checkInputs()
       {
           var Prompts = "";
           CustomerID = window.document.ViewTransactionPage.CustomerIDField.value;
           StartDate = document.ViewTransactionPage.StartDateField.value;
           EndDate = document.ViewTransactionPage.EndDateField.value;
           
        
           if (CustomerID == "" || StartDate == "" ||EndDate == "" ) {
              if (CustomerID == "")
                 Prompts +="Please enter your CustomerID!\n";
              if (StartDate == "")
                 Prompts +="Please enter your EndDate!\n";
              if (EndDate == "")
                 Prompts +="Please enter your EndDate!\n";
              if (Prompts != "")
                 window.alert(Prompts);
           }else {
              document.ViewTransactionPage.submit();
           }
       }
    
    </SCRIPT>
    