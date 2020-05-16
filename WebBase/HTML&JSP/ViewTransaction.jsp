
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ezpass.*;" %>

<%
    String CustomerID = new String("");
	String StartDate = new String("");
	String EndDate = new String("");
    
   
	
	CustomerID = request.getParameter( "CustomerIDField" );
    StartDate = request.getParameter( "StartDateField" );
    EndDate = request.getParameter( "EndDateField" );
    
   
    

    
    
%>

%>

		<HTML>
            <head>
                <title>Weather Forecast</title>
            </head>
            <body>
            <%
         
            Transaction Tran = new Transaction();
            Vector FoundTrans = Tran.searchTransactions(StartDate, EndDate, CustomerID);
            request.setAttribute("data", FoundTrans);
            //System.out.println(FoundTrans.size()); 
            %>
            
            <table border="1">
                <tr>
                    <th>TransactionID</th>
                    <th>TagCode</th>
                    <th>TransactionDate</th>
                    <th>TransactionTime</th>
                    <th>TollAmount</th>
                    <th>TollPlaza</th>
                    <th>TollLaneNumber</th>
                    <th>CustomerID</th>
                </tr>
                <%for (int k=0; k<FoundTrans.size(); k++) { 
                %>
                    <TR>
                        <TD ALIGN='center'><FONT FACE='Arial' SIZE=-1><%=((Vector)(FoundTrans.get(k))).get(0)%></FONT></TD>
                        <TD ALIGN='center'><FONT FACE='Arial' SIZE=-1><%=((Vector)(FoundTrans.get(k))).get(1)%></FONT></TD>
                        <TD ALIGN='center'><FONT FACE='Arial' SIZE=-1><%=((Vector)(FoundTrans.get(k))).get(2)%></FONT></TD>
                        <TD ALIGN='center'><FONT FACE='Arial' SIZE=-1><%=((Vector)(FoundTrans.get(k))).get(3)%></FONT></TD>
                        <TD ALIGN='center'><FONT FACE='Arial' SIZE=-1><%=((Vector)(FoundTrans.get(k))).get(4)%></FONT></TD>
                        <TD ALIGN='center'><FONT FACE='Arial' SIZE=-1><%=((Vector)(FoundTrans.get(k))).get(5)%></FONT></TD>
                        <TD ALIGN='center'><FONT FACE='Arial' SIZE=-1><%=((Vector)(FoundTrans.get(k))).get(6)%></FONT></TD>
                        <TD ALIGN='center'><FONT FACE='Arial' SIZE=-1><%=((Vector)(FoundTrans.get(k))).get(7)%></FONT></TD>
                        </TR>
                      <%
                      }
                      %>
            </table>
            </body>
		</HTML>

<%

 