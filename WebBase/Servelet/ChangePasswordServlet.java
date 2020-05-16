

import java.io.*;
import javax.servlet.*;  //package for GenericServlet
import javax.servlet.http.*;  //package for HttpServlet
import java.util.*;
import com.ezpass.*;

public class ChangePasswordServlet extends HttpServlet {
   private String Username, OldPassword, Password, RePassword;
   private PrintWriter output;
   private Account Acct;

   //a method called automatically to initialize the servlet
   public void init( ServletConfig config )
      throws ServletException
   {
      super.init( config );

    Username = new String("");
	OldPassword = new String("");
	Password = new String("");
    RePassword = new String("");


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


      Username = req.getParameter( "NameField" );
      OldPassword = req.getParameter( "OldPasswordField" );
      Password = req.getParameter( "PasswordField" );
      RePassword = req.getParameter( "RePasswordField" );


        Acct = new Account(OldPassword, Password);

      if (Acct.changePassword(Password))
      output.println("Success!");

      else
           output.println("Account creation failed because of existing username or invalid username. Please try again!");
   }



   //this "cleanup" method is called when a servlet is terminated by the server
   public void destroy() {
       output.close();
   }
}