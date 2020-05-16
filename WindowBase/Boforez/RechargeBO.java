
import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.ezpass.*;

class RechargePanel extends JPanel implements ActionListener
{
     private JButton OpenButton;
        private String CustomerID,CardNumber,Name,ExpirationDate,CVV;
     	private float Balance;
		private float Amount;
     private JTextField IDField,BalanceField,AmountField,CardNumberField,NameField,ExpirationField;
     private JPasswordField CVVField;

    public RechargePanel(String CustomerID)
    {
		OpenButton = new JButton("Recharge"); //initializing two button references

       IDField= new JTextField(15);
       IDField.setText(CustomerID);
       IDField.setEditable(false);
       BalanceField= new JTextField(15);
       BalanceField.setText("0.00");
       //CardNumber
       CardNumberField= new JTextField(15);
       NameField= new JTextField(15);
       ExpirationField= new JTextField(15);
       CVVField= new JPasswordField(15);
       //CardNumberField.setText(CardNumber);
       AmountField= new JTextField(15);
       AmountField.setText("0.00");


       JLabel IDLabel = new JLabel("CustomerID:");
       JLabel CardNumberLabel = new JLabel("CardNumber:");
       JLabel BalanceLabel = new JLabel("Balance:");
       JLabel AmountLabel = new JLabel("Amount:");
       JLabel NameLabel = new JLabel("Name:");
       JLabel ExpirationLabel = new JLabel("Expiration:");
       JLabel CVVLabel = new JLabel("CVV:");


        JPanel IDPanel = new JPanel();
        JPanel CardNumberPanel = new JPanel();
        JPanel BalancePanel = new JPanel();
        JPanel AmountPanel = new JPanel();
        JPanel NamePanel = new JPanel();
        JPanel ExpirationPanel = new JPanel();
        JPanel CVVPanel = new JPanel();


       IDPanel.add(IDLabel);
       IDPanel.add(IDField);
       CardNumberPanel.add(CardNumberLabel);
       CardNumberPanel.add(CardNumberField);
       BalancePanel.add(BalanceLabel);
       BalancePanel.add(BalanceField);
       AmountPanel.add(AmountLabel);
       AmountPanel.add(AmountField);
       NamePanel.add(NameLabel);
       NamePanel.add(NameField);
       ExpirationPanel.add(ExpirationLabel);
       ExpirationPanel.add(ExpirationField);
       CVVPanel.add(CVVLabel);
       CVVPanel.add(CVVField);



        OpenButton.addActionListener(this); //event listener registration

        JPanel TopPanel = new JPanel();
        TopPanel.add(IDPanel);
        //CardNumber


        JPanel CenterPanel = new JPanel();
        CenterPanel.add(BalancePanel);
        CenterPanel.add(CardNumberPanel);
        CenterPanel.add(AmountPanel);
        CenterPanel.add(NamePanel);
        CenterPanel.add(ExpirationPanel);
        CenterPanel.add(CVVPanel);
        CenterPanel.add(OpenButton);

        setLayout(new BorderLayout());
        add(TopPanel, BorderLayout.NORTH);
        add(CenterPanel, BorderLayout.CENTER);
        //add(OpenButton, BorderLayout.SOUTH);//add the one button on to this panel
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();
        if (arg.equals("Recharge")) { //determine which button is clicked

            String a=BalanceField.getText();
            Balance = Float.parseFloat(a);//Float.parseFloat(text.getText);
	        CardNumber =CardNumberField.getText();
	        String b=AmountField.getText();
            Amount =Float.parseFloat(b);
			CustomerID = IDField.getText(); //take actions
			Name = NameField.getText();
			ExpirationDate = ExpirationField.getText();
			CVV = CVVField.getText();


            System.out.println("click bo");


            RechargeControl OBAcct_Ctrl = new RechargeControl(CardNumber,Name,ExpirationDate,CVV,CustomerID);
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

public class RechargeBO extends JFrame
{
    private RechargePanel OBA_Panel;

    public RechargeBO(String CustomerID)
    {
        setTitle("Open a Bank Account");
        setSize(450, 200);

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
         OBA_Panel = new RechargePanel(CustomerID);
         contentPane.add(OBA_Panel);
         show();
    }
/*
    public static void main(String [] args)
    { JFrame frame = new RechargeBO("f123456"); //initialize a JFrame object
      frame.show(); //display the frame
    }*/
}

