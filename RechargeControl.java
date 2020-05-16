
import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.ezpass.*;
import com.ezpass.*;

public class RechargeControl
{

    public RechargeControl(String CardNumber,String Name,String ExpirationDate, String CVV,String CustomerID) {
		//Use CheckingAccount object to invoke method openAcct()

			 CreditCard cd = new CreditCard(CardNumber,Name,ExpirationDate,CVV,CustomerID);
           if (cd.recharge()) {
            System.out.println("successful!");
                JOptionPane.showMessageDialog(null, "Recharge is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            } else
            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Create a Profile failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}

}