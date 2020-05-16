

import java.io.*;
import javax.servlet.*;  //package for GenericServlet
import javax.servlet.http.*;  //package for HttpServlet
import java.util.*;
import com.ezpass.*;

public class VehicleServlet extends HttpServlet {
   private String CustomerID, LicensPlateNumber, Make, Model,Color,TagCode;
   private int Year;
   private PrintWriter output;

   //a method called automatically to initialize the servlet
   public void init( ServletConfig config )
      throws ServletException
   {
      super.init( config );
    CustomerID = new String("");
	LicensPlateNumber = new String("");
	Make = new String("");
    Model = new String("");
    Color = new String("");
    TagCode = new String("");


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


    CustomerID = req.getParameter( "NameField" );
    LicensPlateNumber = req.getParameter( "LicensPlateNumberField" );
    Make = req.getParameter( "MakeField" );
    Model = req.getParameter( "ModelField" );
    Color = req.getParameter( "ColorField" );
    TagCode = req.getParameter( "TagCodeField" );
    String a = req.getParameter("YearField");
    Year = Integer.parseInt(a);

    Vehicle VC= new Vehicle(LicensPlateNumber, Make, Model, Year,Color, TagCode,CustomerID );
      if (VC.addVehicle())  {
      output.println("Success!");
      }else if(VC.removeVehicle()){
      output.println("Delete Succesful!");

      }else
           output.println("Account creation failed because of existing username or invalid username. Please try again!");
   }



   //this "cleanup" method is called when a servlet is terminated by the server
   public void destroy() {
       output.close();
   }
}