<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ezpass.*;" %>

<%
    String Username = new String("");
	
   
	
	Username = request.getParameter( "Username" );
    
   
     
    
%>



<HTML>
    <HEAD>
    <TITLE>ChangePassword</TITLE>
    </HEAD>
    <BODY BGCOLOR="WHITE">
    
    <h3>ChangePassword</h3><br>
    
    <FORM NAME="ChangePasswordPage" ACTION="/CSCI6810/ChangePassword.jsp" METHOD ="post"> <!-- /OnlineChangePasswordServlet-->
    
    <table>
    <tr><td>Username:</td><td><INPUT TYPE="TEXT" NAME="UsernameField" Value='<%= Username %>'  SIZE=20></td></tr>
    <tr><td>OldPassword:</td><td><INPUT TYPE="PASSWORD" NAME="OldPasswordField" SIZE=20></td></tr>
    <tr><td>Password:</td><td><INPUT TYPE="PASSWORD" NAME="PasswordField" SIZE=20></td></tr>
    <tr><td>Re-enter Password:</td><td><INPUT TYPE="PASSWORD" NAME="RePasswordField" SIZE=20></td></tr>
    </table>
    
    <P>
    <INPUT TYPE="BUTTON" VALUE="Change" onClick="checkInputs()">
    </P>
    <A HREF='/CSCI6810/Withdraw.jsp?UserID=someone@yahoo.com'>Withdraw</A>
    </FORM>
    </BODY>
    </HTML>
    
    <SCRIPT LANGUAGE="JavaScript">
    document.ChangePasswordPage.OldPasswordField.focus();
       function checkInputs()
       {
           var Prompts = "";
           Username = window.document.ChangePasswordPage.UsernameField.value;
           OldPassword = document.ChangePasswordPage.OldPasswordField.value;
           Password = document.ChangePasswordPage.PasswordField.value;
           RePassword = document.ChangePasswordPage.RePasswordField.value;
        
           if (Username == "" || OldPassword == "" ||Password == "" || RePassword == "" ) {
              if (Username == "")
                 Prompts +="Please enter your username!\n";
              if (OldPassword == "")
                 Prompts +="Please enter your password!\n";
              if (Password == "")
                 Prompts +="Please enter your password!\n";
              if (RePassword == "")
                 Prompts +="Please re-enter your password!\n";
              if (Prompts != "")
                 window.alert(Prompts);
           } else if (RePassword != Password) {
                 window.alert("Your entered passwords are not same. Please enter the same one!");
           }else {
              document.ChangePasswordPage.submit();
           }
       }
    
    </SCRIPT>
    