import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;


class OutPanel extends JPanel implements ActionListener
{
private JButton OutButton;
public OutPanel(){
		OutButton = new JButton("Out");

		add(OutButton);  //add the two buttons on to this panel
        	OutButton.addActionListener(this); //event listener registration
	}
	 public void actionPerformed(ActionEvent evt)  //event handling
	    {
	        //Object source = evt.getSource(); //get who generates this event
	        String arg = evt.getActionCommand();
	        if (arg.equals("Out")) { //determine which button is clicked
			LoginBO login = new LoginBO();
			//login.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			//login.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
			login.setVisible(true);
			//out.setVisible(false);
			//login.setDefaultCloseOperation(login.HIDE_ON_CLOSE);

		}
}
}
public class OutBO extends JFrame
{
    private OutPanel OBA_Panel;

    public OutBO()
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
         OBA_Panel = new OutPanel();
         contentPane.add(OBA_Panel);
         show();

    }
/*
    public static void main(String [] args)
    {
		JFrame frame = new OutBO(); //initialize a JFrame object
      	frame.show(); //display the frame
    }*/
}
