<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ezpass.*;" %>

<%
    String CustomerID = new String("");
	
	
	CustomerID = request.getParameter( "CustomerID" );
    

    String action = request.getParameter("action");

%>



<HTML>
	<HEAD>
	<TITLE>Vehicle</TITLE>
	</HEAD>
	<BODY BGCOLOR="WHITE">
	
	<h3>Vehicle Page</h3><br>
	
	<FORM NAME="VehiclePage" ACTION="/CSCI6810/Vehicle.jsp" METHOD ="post"> <!-- /OnlineSignUpServlet-->
	
	<table>
    <tr><td>CustomerID:</td><td><INPUT TYPE="TEXT" NAME="CustomerIDField" Value='<%= CustomerID %>' SIZE=20></td></tr>    
	<tr><td>LicensPlateNumber:</td><td><INPUT TYPE="TEXT" NAME="LicensPlateNumberField" SIZE=20></td></tr>
    <tr><td>Make:</td><td><INPUT TYPE="TEXT" NAME="MakeField" SIZE=20></td></tr>
	<tr><td>Model:</td><td><INPUT TYPE="TEXT" NAME="ModelField" SIZE=20></td></tr>
	<tr><td>Year:</td><td><INPUT TYPE="TEXT" NAME="YearField" SIZE=20></td></tr>
	<tr><td>Color:</td><td><INPUT TYPE="TEXT" NAME="ColorField" SIZE=20></td></tr>
	<tr><td>TagCode:</td><td><INPUT TYPE="TEXT" NAME="TagCodeField" SIZE=20></td></tr>
	</table>
	
	<P>
    <INPUT  TYPE="submit" name="ACTION" VALUE="Create" onClick="create()">
    <INPUT  TYPE="submit" name="ACTION" VALUE="Delete" onClick="deleted()">
	</P>
	</FORM>
	</BODY>
	</HTML>
	
	<SCRIPT LANGUAGE="JavaScript">
	document.VehiclePage.LicensPlateNumberField.focus();
	   function create()
	   {
        
        var Prompts = "";
		   LicensPlateNumber = window.document.VehiclePage.LicensPlateNumberField.value;
		   //Password = document.SignUpPage.PasswordField.value;
		   //RePassword = SignUpPage.RePasswordField.value;
		   CustomerID = document.VehiclePage.CustomerIDField.value;
		   Make = document.VehiclePage.MakeField.value;
		   Model = document.VehiclePage.ModelField.value;
		   Year = document.VehiclePage.YearField.value;
		   Color = document.VehiclePage.ColorField.value;
		   TagCode = document.VehiclePage.TagCodeField.value;
	
		   if (LicensPlateNumber == ""  || CustomerID == "" || Make == ""|| Model == ""|| Year == ""|| Color == ""|| TagCode == "") {
			  if (LicensPlateNumber == "")
				 Prompts +="Please enter your LicensPlateNumber!\n";
			  if (CustomerID == "")
				 Prompts +="Please enter your CustomerID!\n";
			  if (Make == "")
                 Prompts +="Please enter your Make!\n";
              if (Model == "")
                 Prompts +="Please enter your Model!\n";
              if (Year == "")
                 Prompts +="Please enter your Year!\n";
              if (Color == "")
                 Prompts +="Please enter your Color!\n";
              if (TagCode == "")
				 Prompts +="Please enter your TagCode!\n";   
			  if (Prompts != "")
				 window.alert(Prompts);
		   } else {
			  document.VehiclePage.submit();
		   }
       }

       function deleted()
	   {
           var Prompts2 = "";
		   LicensPlateNumber = window.document.VehiclePage.LicensPlateNumberField.value;
		   //Password = document.SignUpPage.PasswordField.value;
		   //RePassword = SignUpPage.RePasswordField.value;
		   CustomerID = document.VehiclePage.CustomerIDField.value;
		   Make = document.VehiclePage.MakeField.value;
		   Model = document.VehiclePage.ModelField.value;
		   Year = document.VehiclePage.YearField.value;
		   Color = document.VehiclePage.ColorField.value;
		   TagCode = document.VehiclePage.TagCodeField.value;
	
		   if (LicensPlateNumber == ""  || CustomerID == "" || Make == ""|| Model == ""|| Year == ""|| Color == ""|| TagCode == "") {
			  if (LicensPlateNumber == "")
				 Prompts2 +="Please enter your LicensPlateNumber!\n";
			  if (CustomerID == "")
				 Prompts2 +="Please enter your CustomerID!\n";
			  if (Make == "")
                 Prompts2 +="Please enter your Make!\n";
              if (Model == "")
                 Prompts2 +="Please enter your Model!\n";
              if (Year == "")
                 Prompts2 +="Please enter your Year!\n";
              if (Color == "")
                 Prompts2 +="Please enter your Color!\n";
              if (TagCode == "")
				 Prompts +="Please enter your TagCode!\n";   
			  if (Prompts2 != "")
				 window.alert(Prompts2);
		   } else {
			  document.VehiclePage.submit();
		   }
	   }

    </SCRIPT>  
    
 
	