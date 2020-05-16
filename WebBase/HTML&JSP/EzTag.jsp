
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ezpass.*;" %>

<%
    String CustomerID = new String("");
	String TagCode = new String("");
	String TagType = new String("");
    String IssueDate = new String("");
   
	
	CustomerID = request.getParameter( "NameField" );
    TagCode = request.getParameter( "TagCodeField" );
    TagType = request.getParameter( "TagTypeField" );
    IssueDate = request.getParameter( "IssueDateField" );
   
              
 
    EzTag Ez= new EzTag(TagCode, TagType, IssueDate,CustomerID);

    String action = request.getParameter("action");
    
%>
<%
	if ("Add".equals(action)){
        
        if(Ez.addTag()){
            out.println("Add Succesful!");}
    else{
%>
        out.println("Account add Succesful because of existing username or invalid username. Please try again!");
<%      }
    }
%>

<%
	if ("Delete".equals(action)){
        
        if(Ez.removeTag()){
            out.println("Delete Succesful!");}
    else{
%>
        out.println("Account delete Succesful because of existing username or invalid username. Please try again!");
<%      }
    }
%>

 