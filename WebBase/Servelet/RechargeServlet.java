




import java.io.*;
import javax.servlet.*;  //package for GenericServlet
import javax.servlet.http.*;  //package for HttpServlet
import java.util.*;
import com.ezpass.*;

public class RechargeServlet extends HttpServlet {
   private String CardNumber, Name, Expiration, CVV, CustomerID;
   private float Amount;
   private float Balance;
   private PrintWriter output;

   //a method called automatically to initialize the servlet
   public void init( ServletConfig config )
      throws ServletException
   {
      super.init( config );

    CustomerID = new String("");
	CardNumber = new String("");
	Name = new String("");
    Expiration = new String("");
    CVV = new String("");

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
      CardNumber = req.getParameter( "CardNumberField" );
      Name = req.getParameter( "NameField" );
      Expiration = req.getParameter( "ExpirationField" );
      CVV = req.getParameter( "CVVField" );
      String b = req.getParameter("BalanceField");
      Balance=Float.parseFloat(b);
      String a = req.getParameter("AmountField");
      Amount = Float.parseFloat(a);

      CreditCard cd = new CreditCard(CardNumber,Name,Expiration,CVV,CustomerID);
      if (cd.recharge())
      output.println("Success!");

      else
           output.println("Account creation failed because of existing username or invalid username. Please try again!");
   }



   //this "cleanup" method is called when a servlet is terminated by the server
   public void destroy() {
       output.close();
   }
}