

import java.io.*;
import javax.servlet.*;  //package for GenericServlet
import javax.servlet.http.*;  //package for HttpServlet
import java.util.*;
import com.ezpass.*;

public class PayTollServlet extends HttpServlet {
   private String TransactionID, TagCode, Date, Time, Plaza, CustomerID;
   private float TollAmount;
   private int TollNumber;
   private PrintWriter output;

   //a method called automatically to initialize the servlet
   public void init( ServletConfig config )
      throws ServletException
   {
      super.init( config );

    CustomerID = new String("");
	TagCode = new String("");
	Date = new String("");
    Time = new String("");
    Plaza = new String("");

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


      CustomerID = req.getParameter( "IDField" );
      TagCode = req.getParameter( "TagCodeField" );
      Date = req.getParameter( "DateField" );
      Time = req.getParameter( "TimeField" );
      Plaza = req.getParameter( "PlazaField" );
      String b = req.getParameter("TollNumberField");
      TollNumber=Integer.parseInt(b);
      String a = req.getParameter("TollAmountField");
      TollAmount = Float.parseFloat(a);

      Transaction CP = new Transaction(TagCode,Date,Time,Plaza,TollNumber,TollAmount,CustomerID);
      if (CP.recordTransaction())
      output.println("Success!");

      else
           output.println("Account creation failed because of existing username or invalid username. Please try again!");
   }



   //this "cleanup" method is called when a servlet is terminated by the server
   public void destroy() {
       output.close();
   }
}