
import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.ezpass.*;

class PayTollPanel extends JPanel implements ActionListener
{
     private JButton OpenButton;
        private String TransactionID, TagCode, TransactionDate, TransactionTime, TollPlaza, CustomerID;
     	private float TollAmount;
	private int TollLaneNumber;
     private JTextField TagField, DateField, TimeField, PlazaField, TollAmountField, NumberField,IDField;

    public PayTollPanel(String CustomerID)
    {
		OpenButton = new JButton("PayToll"); //initializing two button references

		IDField= new JTextField(15);
		IDField.setText(CustomerID);
		IDField.setEditable(false);
       TagField= new JTextField(15);
       //TagField.setText(TagCode);
       DateField= new JTextField(15);
       //DateField.setText(TransactionDate);
       TimeField= new JTextField(15);
       //TimeField.setText(TransactionTime);
       PlazaField= new JTextField(15);
       //PlazaField.setText(TollPlaza);
       TollAmountField= new JTextField(15);
       TollAmountField.setText("0.00");
       NumberField= new JTextField(15);
       NumberField.setText("0");


       JLabel IDLabel = new JLabel("CustomerID:");
       JLabel TagLabel = new JLabel("TagCode:");
       JLabel DateLabel = new JLabel("Date:");
       JLabel TimeLabel = new JLabel("Time:");
       JLabel PlazaLabel = new JLabel("Plaza:");
       JLabel TollAmountLabel = new JLabel("TollAmount:");
       JLabel NumberLabel = new JLabel("Number:");


        JPanel IDPanel = new JPanel();
        JPanel TagPanel = new JPanel();
        JPanel DatePanel = new JPanel();
        JPanel TimePanel = new JPanel();
        JPanel PlazaPanel = new JPanel();
        JPanel TollAmountPanel = new JPanel();
        JPanel NumberPanel = new JPanel();


       IDPanel.add(IDLabel);
       IDPanel.add(IDField);
       TagPanel.add(TagLabel);
       TagPanel.add(TagField);
       DatePanel.add(DateLabel);
       DatePanel.add(DateField);
       TimePanel.add(TimeLabel);
       TimePanel.add(TimeField);
       PlazaPanel.add(PlazaLabel);
       PlazaPanel.add(PlazaField);
       TollAmountPanel.add(TollAmountLabel);
       TollAmountPanel.add(TollAmountField);
       NumberPanel.add(NumberLabel);
       NumberPanel.add(NumberField);



        OpenButton.addActionListener(this); //event listener registration

        JPanel TopPanel = new JPanel();
        TopPanel.add(IDPanel);
        TopPanel.add(TagPanel);



        JPanel CenterPanel = new JPanel();
        CenterPanel.add(DatePanel);
        CenterPanel.add(TimePanel);
        CenterPanel.add(PlazaPanel);
        CenterPanel.add(TollAmountPanel);
        CenterPanel.add(NumberPanel);
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
        if (arg.equals("PayToll")) { //determine which button is clicked

            TagCode = TagField.getText(); //take actions
            TransactionDate = DateField.getText();
            TransactionTime = TimeField.getText();
            TollPlaza = PlazaField.getText();
            String a=TollAmountField.getText();
            TollAmount = Float.parseFloat(a);//Float.parseFloat(text.getText);
			String b=NumberField.getText();
            TollLaneNumber =Integer.parseInt(b);
			CustomerID =IDField.getText();

            System.out.println("click bo");

	PayTollControl OBAcct_Ctrl = new PayTollControl(TagCode,TransactionDate,TransactionTime,TollPlaza,TollLaneNumber,TollAmount,CustomerID);
            //PayTollControl OBAcct_Ctrl = new PayTollControl(TagCode, TransactionDate, TransactionTime, TollPlaza, TollLaneNumber, TollAmount,CustomerID);
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

public class PayTollBO extends JFrame
{
    private PayTollPanel OBA_Panel;

    public PayTollBO(String CustomerID)
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
         OBA_Panel = new PayTollPanel(CustomerID);
         contentPane.add(OBA_Panel);
         show();
    }
/*
    public static void main(String [] args)
    { JFrame frame = new PayTollBO("f123456"); //initialize a JFrame object
      frame.show(); //display the frame
    }*/
}

