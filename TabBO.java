import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.ezpass.*;



public class TabBO extends JFrame{

	//private CreateProfilePanel OBA_Panel;
 	public TabBO(String UName, String CustomerID, String CustomerName){

		        setSize(900, 600);

		         //get screen size and set the location of the frame
		         Toolkit tk = Toolkit.getDefaultToolkit();
		         Dimension d = tk.getScreenSize();
		         int screenHeight = d.height;
		         int screenWidth = d.width;
		         setLocation( screenWidth / 3, screenHeight / 4);



				 JTabbedPane tabbedPane;
				 JPanel tabPanel_1, tabPanel_2, tabPanel_3,tabPanel_4,tabPanel_5,tabPanel_6,tabPanel_7,tabPanel_8;

				tabbedPane = new JTabbedPane();
				tabPanel_1 = new CreateProfilePanel(UName,CustomerName);
				tabPanel_2 = new PayTollPanel(CustomerID);
				tabPanel_3 = new ChangePasswordPanel(UName);
				tabPanel_4 = new RechargePanel(CustomerID);
				tabPanel_5 = new ViewTransactionPanel(CustomerID);
				tabPanel_6 = new AddVehiclePanel(CustomerID);
				tabPanel_7 = new AddTagPanel(CustomerID);
				tabPanel_8 = new OutPanel();
				tabbedPane.addTab("CreatProfile", tabPanel_1); //add GUI components to Tabbed Pane
				tabbedPane.setSelectedIndex(0);
				tabbedPane.addTab("PayToll", tabPanel_2);
				tabbedPane.addTab("ChangePassword", tabPanel_3);
				tabbedPane.addTab("Recharge", tabPanel_4);
				tabbedPane.addTab("ViewTransaction", tabPanel_5);
				tabbedPane.addTab("Vehicle", tabPanel_6);
				tabbedPane.addTab("EzTag", tabPanel_7);
				tabbedPane.addTab("Logout", tabPanel_8);

		add(tabbedPane);

		show();




		}

/*
	public static void main(String [] args)
	    { JFrame frame = new TabBO("1","1","1"); //initialize a JFrame object
	      frame.show(); //display the frame
    }*/
}