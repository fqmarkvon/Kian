import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.ezpass.*;
import java.util.*;


class AddVehiclePanel extends JPanel implements ActionListener
{
     private JButton AddButton,DeleteButton,RefreshButton,ClearButton;
	        // private String TransactionID, TagCode, TransactionDate, TransactionTime, TollPlaza, CustomerID;
	      	private String LicensePlateNumber, Make, Model, Color, TagCode,CustomerID;
	      	private JTable table;
	      	private int Year;
	 		private JTextField NumberField, MakeField, ModelField, ColorField, TagField, YearField,IDField;
	 		private Vehicle vehicle;
    public AddVehiclePanel(String CustomerID)
    {
		AddButton = new JButton("Add");
				DeleteButton = new JButton("Delete");//initializing two button references
				RefreshButton=new JButton("Refresh");
				ClearButton= new JButton("Clear");

		       IDField= new JTextField(15);
		       IDField.setText(CustomerID);
		       IDField.setEditable(false);
		       NumberField= new JTextField(15);
		       MakeField= new JTextField(15);
		       ModelField= new JTextField(15);
		       ColorField= new JTextField(15);
		       TagField= new JTextField(15);
		       YearField= new JTextField(15);
       			YearField.setText("0");


          JLabel IDLabel = new JLabel("CustomerID:");
	          JLabel NumberLabel = new JLabel("LicensePlateNumber:");
	          JLabel MakeLabel = new JLabel("Make:");
	          JLabel ModelLabel = new JLabel("Model:");
	          JLabel ColorLabel = new JLabel("Color:");
	          JLabel TagLabel = new JLabel("TagCode:");
       JLabel YearLabel = new JLabel("Year:");
       //Balance

           JPanel IDPanel = new JPanel();
		        JPanel NumberPanel = new JPanel();
		        JPanel MakePanel = new JPanel();
		        JPanel ModelPanel = new JPanel();
		        JPanel ColorPanel = new JPanel();
		        JPanel TagPanel = new JPanel();
        JPanel YearPanel = new JPanel();
        //Balance



	    	NumberPanel.add(NumberLabel);
	          NumberPanel.add(NumberField);
	          MakePanel.add(MakeLabel);
	          MakePanel.add(MakeField);
	          ModelPanel.add(ModelLabel);
	          ModelPanel.add(ModelField);
	          ColorPanel.add(ColorLabel);
	          ColorPanel.add(ColorField);
	          TagPanel.add(TagLabel);
	          TagPanel.add(TagField);
	          YearPanel.add(YearLabel);
	          YearPanel.add(YearField);
	          IDPanel.add(IDLabel);
       IDPanel.add(IDField);
       //Balance

         AddButton.addActionListener(this); //event listener registration
         RefreshButton.addActionListener(this);
		        DeleteButton.addActionListener(this);
		        ClearButton.addActionListener(this);

		        JPanel TopPanel = new JPanel();
		        TopPanel.add(IDPanel);
		        TopPanel.add(NumberPanel);

		        JPanel CenterPanel = new JPanel();
		        CenterPanel.add(MakePanel);
		        CenterPanel.add(ModelPanel);
		        CenterPanel.add(YearPanel);
		        CenterPanel.add(ColorPanel);
		        CenterPanel.add(TagPanel);
		        CenterPanel.add(AddButton);
		        CenterPanel.add(DeleteButton);
		        CenterPanel.add(RefreshButton);
		        CenterPanel.add(ClearButton);

		        setLayout(new BorderLayout());
		        add(TopPanel, BorderLayout.NORTH);
        add(CenterPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        			 //Object source = evt.getSource(); //get who generates this event
					        String arg = evt.getActionCommand();
        if (arg.equals("Add"))
        { //determine which button is clicked

        			LicensePlateNumber = NumberField.getText(); //take actions
		            Make = MakeField.getText();
		            Model = ModelField.getText();
		            String b=YearField.getText();
		            Year =Integer.parseInt(b);
		            Color = ColorField.getText();
		            TagCode = TagField.getText();
		            CustomerID =IDField.getText();
		            /*
		            System.out.println("Click button and LicensePlateNumber = "+LicensePlateNumber);
		            System.out.println("Click button and Make = "+Make);
		            System.out.println("Click button and Model = "+Model);
		            System.out.println("Click button and Year = "+Year);
		            System.out.println("Click button andColor= "+Color);
		            System.out.println("Click button and TagCode = "+TagCode);
		            System.out.println("Click button and id = "+CustomerID);*/


			//Ez = new EzTag(TagCode, TagType,IssueDate,CustomerID);
			Vehicle vehicle= new Vehicle(LicensePlateNumber, Make, Model,Year, Color, TagCode, CustomerID);
			if (vehicle.addVehicle())
			                JOptionPane.showMessageDialog(null, "created!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			            else
			                JOptionPane.showMessageDialog(null, "Account creation failed due to an invalid email address or unmatched passwords or the email address exists.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);


 			//AddVehicleControl OBAcct_Ctrl = new AddVehicleControl(LicensePlateNumber, Make, Model,Year, Color, TagCode, CustomerID);
			}
			  else if (arg.equals("Refresh"))
			        { //determine which button is clicked
			         CustomerID =IDField.getText();
							     System.out.println("in refresh button Re:id = "+CustomerID);
		    			Vehicle Tran= new Vehicle();
						Vector FoundTrans=Tran.searchVehicle(CustomerID);
						Vector columnNames = new Vector();
						                     String[] month = {"LicensePlateNumber", "Make", "Model",
						                     "Year", "Color", "TagCode", "CustomerID"};
											 for (int i = 0; i <month.length; i++ ) {
											   columnNames.addElement(month[i]);
											   }
						                   //Then initialize JTable TransTable with the two vectors. Add  TransTable to ViewTransactionPanel.
						 					JTable TransTable = new JTable(FoundTrans, columnNames);
						 					TransTable.setPreferredScrollableViewportSize(new Dimension(600, 400));
											JScrollPane scrollPane = new JScrollPane(TransTable);
											JPanel p = new JPanel();
											//JTextField hh= new JTextField(100);
											p.add(scrollPane);
											//p.add(hh);
								add(p);
			}
			else if (arg.equals("Delete"))
			        {
						LicensePlateNumber = NumberField.getText(); //take actions
								            Make = MakeField.getText();
								            Model = ModelField.getText();
								            String b=YearField.getText();
								            Year =Integer.parseInt(b);
								            Color = ColorField.getText();
								            TagCode = TagField.getText();
								            CustomerID =IDField.getText();
								            /*
								            System.out.println("Click button and LicensePlateNumber = "+LicensePlateNumber);
								            System.out.println("Click button and Make = "+Make);
								            System.out.println("Click button and Model = "+Model);
								            System.out.println("Click button and Year = "+Year);
								            System.out.println("Click button andColor= "+Color);
								            System.out.println("Click button and TagCode = "+TagCode);
								            System.out.println("Click button and id = "+CustomerID);*/

 			Vehicle vehicle= new Vehicle(LicensePlateNumber, Make, Model,Year, Color, TagCode, CustomerID);
						if (vehicle.removeVehicle())
						                JOptionPane.showMessageDialog(null, "Delete!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
						            else
						                JOptionPane.showMessageDialog(null, "Account creation failed due to an invalid email address or unmatched passwords or the email address exists.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);


			}

				else if (arg.equals("Clear"))
					 {
System.out.println("Clear");
									Vector columRows= new Vector();
									Vector columnNames = new Vector();
									String[]profit=new String[10];
						         String[] month = {"LicensePlateNumber", "Make", "Model",
							   "Year", "Color", "TagCode", "CustomerID"};
						//for(int j=0; j<data.length; j++){
							//columRows.addElement(data[j]);
							Vector row= new Vector();
							for(int i  =0; i <month.length; i++){//
								for (int j = 0; j<profit.length; j++ ){
							//Double temp = new Double(profit[i]);
							//row.addElement(profit[i]);
							columRows.addElement(profit[i]);
							}

columnNames.addElement(month[i]);
						 }
						//Then initialize JTable TransTable with the two vectors. Add  TransTable to ViewTransactionPanel.
							JTable TransTablex = new JTable(columRows, columnNames);
								TransTablex.setPreferredScrollableViewportSize(new Dimension(600, 400));
								JScrollPane scrollPane = new JScrollPane(TransTablex);
									JPanel p = new JPanel();
										//JTextField hh= new JTextField(100);
										p.add(scrollPane);
									//p.add(hh);
												add(p);

			}

}
}
public class AddVehicleBO extends JFrame
{
        private AddVehiclePanel OBA_Panel;

        public AddVehicleBO(String CustomerID)
    {
            setTitle("Open a Bank Account");
		        setSize(900, 600);

		         //get screen size and set the location of the frame
		         Toolkit tk = Toolkit.getDefaultToolkit();
		         Dimension d = tk.getScreenSize();
		         int screenHeight = d.height;
		         int screenWidth = d.width;
		         setLocation( screenWidth / 3, screenHeight / 4);

		         addWindowListener (new WindowAdapter()  //handle window event
		            {
				       public void windowClosing (WindowEvent e)
					                  { System.exit(0);
		               }
            });

 		 Container contentPane = getContentPane(); //add a panel to a frame
         OBA_Panel = new AddVehiclePanel(CustomerID);
         contentPane.add(OBA_Panel);
         show();
    }

    public static void main(String [] args)
    { JFrame frame = new AddVehicleBO("f123456"); //initialize a JFrame object
      frame.show(); //display the frame
    }
}

