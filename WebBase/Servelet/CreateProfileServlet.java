

import java.io.*;
import javax.servlet.*;  //package for GenericServlet
import javax.servlet.http.*;  //package for HttpServlet
import java.util.*;
import com.ezpass.*;

public class CreateProfileServlet extends HttpServlet {
   private String Customername, Street, City, State,Zip,Phone,Email;
   private Float Balance;
   private PrintWriter output;

   //a method called automatically to initialize the servlet
   public void init( ServletConfig config )
      throws ServletException
   {
      super.init( config );
    Customername = new String("");
	Street = new String("");
	City = new String("");
    State = new String("");
    Zip = new String("");
    Phone = new String("");
    Email = new String("");
    Balance = new Float("");

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


    Customername = req.getParameter( "NameField" );
    Street = req.getParameter( "StreetField" );
    City = req.getParameter( "CityField" );
    State = req.getParameter( "StateField" );
    Zip = req.getParameter( "ZipField" );
    Phone = req.getParameter( "PhoneField" );
    Email = req.getParameter( "EmailField" );
    String a = req.getParameter("BalanceField");
    Balance = Float.parseFloat(a);

    Customer CP = new Customer(Customername,Street,City,State,Zip,Phone,Email,Balance);
      if (CP.CreateProfile())
      output.println("Success!");

      else
           output.println("Account creation failed because of existing username or invalid username. Please try again!");
   }



   //this "cleanup" method is called when a servlet is terminated by the server
   public void destroy() {
       output.close();
   }
}