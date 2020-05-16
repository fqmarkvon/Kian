


import java.io.*;
import javax.servlet.*;  //package for GenericServlet
import javax.servlet.http.*;  //package for HttpServlet
import java.util.*;
import com.ezpass.*;

public class ViewTransactionServlet extends HttpServlet {
   private String CustomerID, StartDate, EndDate;
   private PrintWriter output;


   //a method called automatically to initialize the servlet
   public void init( ServletConfig config )
      throws ServletException
   {
      super.init( config );

    CustomerID = new String("");
	StartDate = new String("");
	EndDate = new String("");



   }

   //a method included in class HttpServlet to respond
   //to post requests from a client.
   public void doGet ( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException
   {	
      doPost(req, res);


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


      CustomerID = req.getParameter( "NameField" );
      StartDate = req.getParameter( "StartDateField" );
      EndDate = req.getParameter( "EndDateField" );

      Transaction Tran = new Transaction();
      Vector FoundTrans = Tran.searchTransactions(StartDate, EndDate, CustomerID);

       Vector columnNames = new Vector();
       String[] month = {"TransactionID", "TagCode", "TransactionDate",
       "TransactionTime", "TollAmount", "TollPlaza", "TollLaneNumber","CustomerID"};

       for (int i = 0; i <month.length; i++ ) {
         columnNames.addElement(month[i]);
         }



         req.setAttribute("Names",columnNames);
         req.getRequestDispatcher("http://localhost/CSCI6810/ViewTransaction.jsp").forward(req,res);
         req.setAttribute("Data",FoundTrans);
         req.getRequestDispatcher("http://localhost/CSCI6810/ViewTransaction.jsp").forward(req, res);

        


         //request.getRequestDispatcher("/index.jsp").forward(req, response);




   }



   //this "cleanup" method is called when a servlet is terminated by the server
   public void destroy() {
       output.close();
   }
}