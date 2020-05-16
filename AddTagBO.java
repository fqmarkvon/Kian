import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.ezpass.*;



class AddTagPanel extends JPanel implements ActionListener
{
    private JButton AddButton,DeleteButton;
    private JTextField TagCodeField, TagTypeField, IssueDateField,IDField;
   // private CustomerIDField;
    private String TagCode, TagType,IssueDate;
    private String CustomerID="f123456";
    private EzTag Ez;
    //private JComboBox TypeBox;

    public AddTagPanel(String CustomerID)
    {
        //TypeBox= new JComboBox();

        AddButton = new JButton("Add"); //initializing two button references
        DeleteButton = new JButton("Delete"); //initializing two button references
        TagCodeField = new JTextField(15);
        TagTypeField = new JTextField(15);
        IssueDateField = new JTextField(15);
        IDField = new JTextField(15);
        IDField.setText(CustomerID);
		IDField.setEditable(false);

        JLabel TagCodeLabel = new JLabel("TagCode: ");
        JLabel TagTypeLabel = new JLabel("TagType:");
        JLabel IssueDateLabel = new JLabel("IssueDate:");
        JLabel IDLabel = new JLabel("CustomerID:");


        JPanel TagCodePanel = new JPanel();
        JPanel TagTypePanel = new JPanel();
        JPanel IssueDatePanel = new JPanel();
        JPanel IDPanel = new JPanel();


        TagCodePanel.add(TagCodeLabel);
        TagCodePanel.add(TagCodeField);
        TagTypePanel.add(TagTypeLabel);
        TagTypePanel.add(TagTypeField);
        IssueDatePanel.add(IssueDateLabel);
        IssueDatePanel.add(IssueDateField);
        IDPanel.add(IDLabel);
        IDPanel.add(IDField);


        //add(UsernamePanel);
        add(IDPanel);
        add(TagCodePanel);
        add(TagTypePanel);
        add(IssueDatePanel);
        //add(NamePanel);

        add(AddButton);
        add(DeleteButton);//add the two buttons on to this panel
        AddButton.addActionListener(this); //event listener registration
        DeleteButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();
        if (arg.equals("Add")) { //determine which button is clicked
			System.out.print("Hi");
			CustomerID= IDField.getText();
            TagCode =TagCodeField.getText();
            TagType = TagTypeField.getText();
            IssueDate = IssueDateField.getText();

			System.out.println("Click button and TagType = "+TagType);
					            System.out.println("Click button and IssueDate= "+IssueDate);
					            System.out.println("Click button and TagCode = "+TagCode);
		            System.out.println("Click button and id = "+CustomerID);


            Ez = new EzTag(TagCode, TagType,IssueDate,CustomerID);
            if (Ez.addTag())
                JOptionPane.showMessageDialog(null, "created!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Account creation failed due to an invalid email address or unmatched passwords or the email address exists.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}

		 if (arg.equals("Delete")) { //determine which button is clicked
					System.out.print("Hi");
		            TagCode =TagCodeField.getText();
		            TagType = TagTypeField.getText();
		            IssueDate = IssueDateField.getText();


		            Ez = new EzTag(TagCode, TagType,IssueDate,CustomerID);
		            if (Ez.removeTag())
		                JOptionPane.showMessageDialog(null, "Delete!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		            else
		                JOptionPane.showMessageDialog(null, "Account creation failed due to an invalid email address or unmatched passwords or the email address exists.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
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

public class AddTagBO extends JFrame
{
    private AddTagPanel SU_Panel;

    public AddTagBO(String CustomerID)
    {
        setTitle("Sign Up");
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
         SU_Panel = new AddTagPanel(CustomerID);
         contentPane.add(SU_Panel);
         show();
    }
/*
    public static void main(String [] args)
    { JFrame frame = new AddTagBO("f123456"); //initialize a JFrame object
      frame.show(); //display the frame
    }*/
}

