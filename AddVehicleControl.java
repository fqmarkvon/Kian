import com.ezpass.*;
import javax.swing.*;
import java.lang.*; //including Java packages used by this program

public class AddVehicleControl
{
    private AddVehicleBO SU_BO;

    public AddVehicleControl(String LicensePlateNumber, String Make, String Model,int Year, String Color, String TagCode,String CustomerID ) {

		Vehicle VC= new Vehicle(LicensePlateNumber, Make, Model, Year,Color, TagCode,CustomerID );
		System.out.println("use control !");
		if (VC.addVehicle()){
							System.out.println("use control successful!");
			               JOptionPane.showMessageDialog(null, "Create a Profile is Successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			            } else{
			            //System.out.println("fail!");
			            JOptionPane.showMessageDialog(null, "Create a Profile failed.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}