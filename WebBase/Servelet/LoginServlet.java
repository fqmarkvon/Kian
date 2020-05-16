

import java.io.*;
import javax.servlet.*;  //package for GenericServlet
import javax.servlet.http.*;  //package for HttpServlet
import java.util.*;
import com.ezpass.*;

public class LoginServlet extends HttpServlet {
   private String Username, Password, Re_enterPassword, CustomerName;
   private PrintWriter output;

   //a method called automatically to initialize the servlet
   public void init( ServletConfig config )
      throws ServletException
   {
      super.init( config );
      Username = new String("");
      Password = new String("");


   }

   //a method included in class HttpServlet to respond
   //to post requests from a client.
   public void doGet ( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException
   {	doPost(req, res);
   }

   //a method included in class HttpServlet to respond
   //to post requests from a client.
   public void doPost ( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException
   {
      //obtains a character-based output stream that enables
      //text data to be sent to the client
      output = res.getWriter();

      //specifies the MIME type of the response to the browser
      res.setContentType( "text/html" );

      //returns the value associated with a parameter sent to
      //the servlet as part of a post request
      Username = req.getParameter( "UsernameField" );
      Password = req.getParameter( "PasswordField" );


      Account Acct = new Account(Username,Password);
      String [] customerarray = Acct.SignIn();
	  String customername = customerarray[0];
	  String CustomerID=customerarray[1];
		boolean CustomerName = Acct.signIn();
      if (CustomerName){
      output.println("success");
      showSuccess();


      }else{
           output.println("Account creation failed because of existing username or invalid username. Please try again!");
        }
     }

   public void showSuccess()
   {
        StringBuffer Buf = new StringBuffer();
		Buf.append("<HTML><HEAD></HEAD>\n");
		Buf.append("<BODY bgcolor='#F1F1FD'>\n");
		Buf.append("<h4 ALIGN='center'>TabBO</h4>\n");
			Buf.append("<FORM NAME=\"LoginSrvlet\" ACTION=\"/CSCI6810/preCreateProfile.jsp\" METHOD =\"POST\">\n");


                Buf.append("<a href='/CSCI6810/preCreateprofile.jsp?Username="+Username+"' >Create Profile2</a>");

		   Buf.append("</FORM>\n");
		Buf.append("</BODY>\n");
		Buf.append("</HTML>\n");
		output.println(Buf.toString());
   }

   //this "cleanup" method is called when a servlet is terminated by the server
   public void destroy() {
       output.close();
   }
}