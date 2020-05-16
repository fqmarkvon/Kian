import com.ezpass.*;
import javax.swing.*;
import java.lang.*; //including Java packages used by this program
import com.ezpass.*;


public class AddTagControl
{
    private AddTagBO SU_BO;

    public AddTagControl(String  TagCode, String TagType, String  IssueDate, String CustomerID) {

		EzTag Ez= new EzTag(TagCode, TagType, IssueDate,CustomerID);
		if (Ez.addTag()){
			 System.out.println("successful!");
			               JOptionPane.showMessageDialog(null, "add Tag is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			            } else{
			            //System.out.println("fail!");
			            JOptionPane.showMessageDialog(null, "Create a Profile failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}