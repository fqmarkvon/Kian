
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ezpass.*;" %>

<%
    String CustomerID = new String("");
	String TagCode = new String("");
	String TagType = new String("");
    String IssueDate = new String("");
   
	
	CustomerID = request.getParameter( "CustomerID" );
  
   
              
 
    
%>


<HTML>
    <HEAD>
    <TITLE>EzTag</TITLE>
    </HEAD>
    <BODY BGCOLOR="WHITE">
    
    <h3>EzTag</h3><br>
    
    <FORM NAME="EzTagPage" ACTION="/CSCI6810/EzTag.jsp" METHOD ="post"> <!-- /OnlineEzTagServlet-->
    
    <table>
    <tr><td>CustomerID:</td><td><INPUT TYPE="TEXT" Name="CustomerIDField" Value='<%= CustomerID %>' SIZE=20></td></tr>
    <tr><td>TagCode:</td><td><INPUT TYPE="TEXT" Name="TagCodeField" SIZE=20></td></tr>
    <tr><td>TagType:</td><td><INPUT TYPE="TEXT" Name="TagTypeField" SIZE=20></td></tr>
    <tr><td>IssueDate:</td><td><INPUT TYPE="TEXT" Name="IssueDateField" SIZE=20></td></tr>
    </table>
    
    <P>
    <INPUT  TYPE="submit" name="ACTION" VALUE="Add" onClick="add()">
    <INPUT  TYPE="submit" name="ACTION" VALUE="Delete" onClick="deleted()">        
    </P>
    <A HREF='/CSCI6810/Withdraw.jsp?UserID=someone@yahoo.com'>Withdraw</A>
    </FORM>
    </BODY>
    </HTML>
    
    <SCRIPT LANGUAGE="JavaScript">
    document.EzTagPage.TagCodeField.focus();
       function add()
       {
           var Prompts = "";
           TagCode = window.document.EzTagPage.TagCodeField.value;
           CustomerID = document.EzTagPage.CustomerIDField.value;
           TagType = document.EzTagPage.TagTypeField.value;
           IssueDate = document.EzTagPage.IssueDateField.value;
           if (TagCode == "" || CustomerID == "" || TagType == "" || IssueDate == "") {
              if (TagCode == "")
                 Prompts +="Please enter your TagCode!\n";
              if (CustomerID == "")
                 Prompts +="Please enter your CustomerID!\n";
              if (TagType == "")
                 Prompts +="Please enter your TagType!\n";
              if (IssueDate == "")
                 Prompts +="Please enter your IssueDate!\n";
              if (Prompts != "")
                 window.alert(Prompts);
           } else {
              document.EzTagPage.submit();
           }
       }
       function deleted()
       {
           var Prompts = "";
           TagCode = window.document.EzTagPage.TagCodeField.value;
           CustomerID = document.EzTagPage.CustomerIDField.value;
           TagType = document.EzTagPage.TagTypeField.value;
           IssueDate = document.EzTagPage.IssueDateField.value;
           if (TagCode == "" || CustomerID == "" || TagType == "" || IssueDate == "") {
              if (TagCode == "")
                 Prompts +="Please enter your TagCode!\n";
              if (CustomerID == "")
                 Prompts +="Please enter your CustomerID!\n";
              if (TagType == "")
                 Prompts +="Please enter your TagType!\n";
              if (IssueDate == "")
                 Prompts +="Please enter your IssueDate!\n";
              if (Prompts != "")
                 window.alert(Prompts);
           } else {
              document.EzTagPage.submit();
           }
       }
    
    </SCRIPT>
    