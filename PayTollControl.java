
import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.ezpass.*;
import com.ezpass.*;

public class PayTollControl
{

    public PayTollControl(String TagCode,String TransactionDate, String TransactionTime, String TollPlaza, int TollLaneNumber,Float TollAmount,String CustomerID) {
		//Use CheckingAccount object to invoke method openAcct()

			 Transaction CP = new Transaction(TagCode,TransactionDate,TransactionTime,TollPlaza,TollLaneNumber,TollAmount,CustomerID);
           if (CP.recordTransaction()) {
            System.out.println("successful!");
                JOptionPane.showMessageDialog(null, "Payed!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            } else
            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Create a Profile failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}

}