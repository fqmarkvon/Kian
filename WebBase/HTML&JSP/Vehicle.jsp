
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.ezpass.*;" %>

<%
    String CustomerID = new String("");
	String LicensPlateNumber = new String("");
	String Make = new String("");
    String Model = new String("");
    String Color = new String("");
    String TagCode = new String("");
    int Year;
	
	CustomerID = request.getParameter( "CustomerIDField" );
    LicensPlateNumber = request.getParameter( "LicensPlateNumberField" );
    Make = request.getParameter( "MakeField" );
    Model = request.getParameter( "ModelField" );
    Color = request.getParameter( "ColorField" );
    TagCode = request.getParameter( "TagCodeField" );
    String a = request.getParameter("YearField");
    Year = Integer.parseInt(a);
              
    Vehicle VC= new Vehicle(LicensPlateNumber, Make, Model, Year,Color, TagCode,CustomerID );

    String action = request.getParameter("action");

%>
<%
	if ("Create".equals(action)){
        
        if(VC.addVehicle()){
            out.println("Add Succesful!");}
    else{
%>
        out.println("Account add Succesful because of existing username or invalid username. Please try again!");
<%      }
    }
%>



<%
	if ("Delete".equals(action)){
        
        if(VC.removeVehicle()){
            out.println("Delete Succesful!");}
    else{
%>
        out.println("Account delete Succesful because of existing username or invalid username. Please try again!");
<%      }
    }
%>



%>

		<HTML>
            <head>
               
            </head>
            <body>
            <%
         
            Vehicle Tran= new Vehicle();
			Vector FoundTrans=Tran.searchVehicle(CustomerID);
            //request.setAttribute("data", FoundTrans);
            //System.out.println(FoundTrans.size()); 
            %>
            
            <table border="1">
                <tr>
                    <th>LicensePlateNumber</th>
                    <th>Make</th>
                    <th>Model</th>
                    <th>Year</th>
                    <th>Color</th>
                    <th>TagCode</th>
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
                        </TR>
                      <%
                      }
                      %>
            </table>
            </body>
		</HTML>

<%
 
