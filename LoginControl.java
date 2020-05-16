import java.lang.*; //including Java packages used by this program
import javax.swing.*;
//import com.ezpass.*;
import com.ezpass.*;



//import Client.*;



public class LoginControl
{
    private Account Acct;

    public LoginControl(String UName,String PWord) {
//public LoginControl() {
//String CustomerID;
Acct = new Account(UName,PWord);
String [] customerarray = Acct.SignIn();
String customername = customerarray[0];
String CustomerID=customerarray[1];
boolean CustomerName = Acct.signIn();
//String CustomerName = Acct.signIn();
        //if (!CustomerName.equals("")) {
if (CustomerName) {
           System.out.println("successful!");
            JOptionPane.showMessageDialog(null, "Login is successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
           TabBO CBO = new TabBO(UName,CustomerID, customername);


        } else{
            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Login failed because of invalid username or password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
}

}
}

