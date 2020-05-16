import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.ezpass.*;



public class CreateProfileControl
{

    public CreateProfileControl(String  Name, String Street, String  City, String  State, String Zip, String  Phone, String Email,Float Balance) {
		//Use CheckingAccount object to invoke method openAcct()

			Customer CP = new Customer(Name,Street,City,State,Zip,Phone,Email,Balance);
           if (CP.CreateProfile()) {
            System.out.println("successful!");
                JOptionPane.showMessageDialog(null, "Create a Profile is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            } else
            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Create a Profile failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}

}