import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.ezpass.*;


class ChangePasswordPanel extends JPanel implements ActionListener
{
    private JButton ChangeButton;
    private JPasswordField PasswordField, PasswordField1,PasswordField2;
    private String PsWord, PsWord1,PsWord2;
    private Account Acct;
    private JTextField UsernameField;
    private String Uname;
    //private JTextField UsernameField


    public ChangePasswordPanel(String UName)
    {
        ChangeButton = new JButton("Change"); //initializing two button references

        UsernameField = new JTextField(15);
        UsernameField.setText(UName);
        UsernameField.setEditable(false);
        PasswordField = new JPasswordField(15);
        PasswordField1 = new JPasswordField(15);
        PasswordField2 = new JPasswordField(15);

        JLabel PasswordLabel = new JLabel("OldPassword: ");
        JLabel PasswordLabel1 = new JLabel("NewPassword");
        JLabel PasswordLabel2 = new JLabel("Re-enter");
        JLabel UsernameLabel = new JLabel("Username: ");


        JPanel PasswordPanel = new JPanel();
        JPanel PasswordPanel1 = new JPanel();
        JPanel PasswordPanel2 = new JPanel();
        JPanel UsernamePanel = new JPanel();

        PasswordPanel.add(PasswordLabel);
        PasswordPanel.add(PasswordField);
        PasswordPanel1.add(PasswordLabel1);
        PasswordPanel1.add(PasswordField1);
        PasswordPanel2.add(PasswordLabel2);
        PasswordPanel2.add(PasswordField2);
        UsernamePanel.add(UsernameLabel);
        UsernamePanel.add(UsernameField);


        //add(UsernamePanel);
        add(UsernamePanel);
        add(PasswordPanel);
        add(PasswordPanel1);
        add(PasswordPanel2);
        //add(NamePanel);

        add(ChangeButton);  //add the two buttons on to this panel
        ChangeButton.addActionListener(this); //event listener registration
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();
        if (arg.equals("Change")) { //determine which button is clicked

            PsWord =PasswordField.getText();
            PsWord1 = PasswordField1.getText();
            PsWord2 = PasswordField1.getText();


            Acct = new Account(PsWord, PsWord1);
            if (Acct.changePassword(PsWord1))
                JOptionPane.showMessageDialog(null, "Change!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
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

public class ChangePasswordBO extends JFrame
{
    private ChangePasswordPanel SU_Panel;

    public ChangePasswordBO(String UName)
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
         SU_Panel = new ChangePasswordPanel(UName);
         contentPane.add(SU_Panel);
         show();
    }
/*
    public static void main(String [] args)
    { JFrame frame = new ChangePasswordBO("2"); //initialize a JFrame object
      frame.show(); //display the frame
    }*/
}

