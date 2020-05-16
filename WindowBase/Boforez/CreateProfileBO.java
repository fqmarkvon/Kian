import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.ezpass.*;


class CreateProfilePanel extends JPanel implements ActionListener
{
     private JButton OpenButton;
     //private String CustomerID, Name, Street,City, State, Zip, Phone, Email;
     private String Name, Street,City, State, Zip, Phone, Email,CustomerID;
     private Float Balance;
     private JTextField UsernameField,IDField,NameField, StreetField, CityField, StateField, ZipField, PhoneField, EmailField,BalanceField;


    //private JTextField UsernameField, NameField, AccountNumberField, BalanceField;
	//private JComboBox CheckingOrSavingsBox;
    //private String UName, AccountNumber, Balance, Name, AccountType;
    public CreateProfilePanel(String UName, String CustomerName)
    {
		OpenButton = new JButton("Open"); //initializing two button references


		UsernameField = new JTextField(15);
        UsernameField.setText(UName);
        UsernameField.setEditable(false);
       NameField= new JTextField(CustomerName);
       NameField.setEditable(false);
       //IDField= new JTextField(15);
       //IDField.setEditable(false);
       StreetField= new JTextField(15);
       //StreetField.setText(Street);
       CityField= new JTextField(15);
       //CityField.setText(City);
       StateField= new JTextField(15);
       //StateField.setText(State);
       ZipField= new JTextField(15);
       //ZipField.setText(Zip);
       PhoneField= new JTextField(15);
       //PhoneField.setText(Phone);
       EmailField= new JTextField(15);
       //EmailField.setText(Email);
       BalanceField= new JTextField(15);
       BalanceField.setText("0.00");
       //Balance


       JLabel NameLabel = new JLabel("Customer Name:");
       //JLabel IDLabel = new JLabel("CustomerID:");
       JLabel UsernameLabel = new JLabel("Username:");
       JLabel StreetLabel = new JLabel("Street:");
       JLabel CityLabel = new JLabel("City:");
       JLabel StateLabel = new JLabel("State:");
       JLabel ZipLabel = new JLabel("Zip:");
       JLabel PhoneLabel = new JLabel("Phone:");
       JLabel EmailLabel = new JLabel("Email:");
       JLabel BalanceLabel = new JLabel("Balance:");
       //Balance

        //JPanel IDPanel = new JPanel();
        JPanel NamePanel = new JPanel();
        //Street
        JPanel UsernamePanel = new JPanel();
        JPanel StreetPanel = new JPanel();
        JPanel CityPanel = new JPanel();
        JPanel StatePanel = new JPanel();
        JPanel ZipPanel = new JPanel();
        JPanel PhonePanel = new JPanel();
        JPanel EmailPanel = new JPanel();
        JPanel BalancePanel = new JPanel();
        //Balance


	   //IDPanel.add(IDLabel);
	   //IDPanel.add(IDField);
	   UsernamePanel.add(UsernameLabel);
        UsernamePanel.add(UsernameField);
       NamePanel.add(NameLabel);
       NamePanel.add(NameField);
       StreetPanel.add(StreetLabel);
       StreetPanel.add(StreetField);
       CityPanel.add(CityLabel);
       CityPanel.add(CityField);
       StatePanel.add(StateLabel);
       StatePanel.add(StateField);
       ZipPanel.add(ZipLabel);
       ZipPanel.add(ZipField);
       PhonePanel.add(PhoneLabel);
       PhonePanel.add(PhoneField);
       EmailPanel.add(EmailLabel);
       EmailPanel.add(EmailField);
       BalancePanel.add(BalanceLabel);
       BalancePanel.add(BalanceField);
       //Balance

        OpenButton.addActionListener(this); //event listener registration



        JPanel TopPanel = new JPanel();

        //TopPanel.add(IDPanel);
        TopPanel.add(NamePanel);
        TopPanel.add(UsernamePanel);
		//TopPanel.add(IDPanel);
        JPanel CenterPanel = new JPanel();


        //Street
        CenterPanel.add(StreetPanel);
        CenterPanel.add(CityPanel);
        CenterPanel.add(StatePanel);
        CenterPanel.add(ZipPanel);
        CenterPanel.add(PhonePanel);
        CenterPanel.add(EmailPanel);
        CenterPanel.add(BalancePanel);
        CenterPanel.add(OpenButton);

        //Balance
        setLayout(new BorderLayout());
        add(TopPanel, BorderLayout.NORTH);
        add(CenterPanel, BorderLayout.CENTER);
        //add(OpenButton, BorderLayout.SOUTH);//add the one button on to this panel
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();
        if (arg.equals("Open")) { //determine which button is clicked
			//CustomerID = IDField.getText();
            Name = NameField.getText(); //take actions
            Street = StreetField.getText();
            City = CityField.getText();
            State = StateField.getText();
            Zip = ZipField.getText();
            Phone = PhoneField.getText();
            Email = EmailField.getText();
            String a=BalanceField.getText();
            Balance = Float.parseFloat(a);//Float.parseFloat(text.getText);
            //Balance
            System.out.println("click bo");

            CreateProfileControl OBAcct_Ctrl = new CreateProfileControl(Name, Street, City, State, Zip, Phone, Email, Balance);
}

    }
/*
    public String getUsername() {
		return UName;
	};

	public String getPassword() {
	    return PsWord;
	}

	public String getPassword1() {
	    return PsWord1;
	}*/
}

public class CreateProfileBO extends JFrame
{
    private CreateProfilePanel OBA_Panel;

    public CreateProfileBO(String UName, String CustomerName)
    {
        setTitle("Open a Bank Account");
        setSize(900, 600);

         //get screen size and set the location of the frame
         Toolkit tk = Toolkit.getDefaultToolkit();
         Dimension d = tk.getScreenSize();
         int screenHeight = d.height;
         int screenWidth = d.width;
         setLocation( screenWidth / 3, screenHeight / 4);

/*
		 JTabbedPane tabbedPane;
		 JPanel tabPanel_1, tabPanel_2, tabPanel_3,tabPanel_4,tabPanel_5;

		tabbedPane = new JTabbedPane();
		tabPanel_1 = new CreateProfilePanel(CustomerID,CustomerName);
		//tabPanel_2 = new PayTollPanel("1","1");
		tabPanel_3 = new ChangePasswordPanel(CustomerName);
		//tabPanel_4 = new RechargePanel(CustomerID,0.1f);
		tabPanel_5 = new ViewTransactionPanel(CustomerID);
		tabbedPane.addTab("CreatProfile", tabPanel_1); //add GUI components to Tabbed Pane
		tabbedPane.setSelectedIndex(0);
		//tabbedPane.addTab("PayToll", tabPanel_2);
		tabbedPane.addTab("ChangePassword", tabPanel_3);
		//tabbedPane.addTab("Recharge", tabPanel_4);
		tabbedPane.addTab("ViewTransaction", tabPanel_5);

		add(tabbedPane);

*/








         Container contentPane = getContentPane(); //add a panel to a frame
         OBA_Panel = new CreateProfilePanel(UName, CustomerName);
         contentPane.add(OBA_Panel);
         //show();
    }
/*
    public static void main(String [] args)
    { JFrame frame = new CreateProfileBO("1","1"); //initialize a JFrame object
      frame.show(); //display the frame
    }*/
}

