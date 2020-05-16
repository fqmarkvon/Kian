

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.ezpass.*;




class ViewTransactionPanel2 extends JPanel implements ActionListener{
		private JTable table;
		private JButton SearchButton;
	    private String TransactionDate,EndDate;
		private JTextField DateField,EndDateField;



		public ViewTransactionPanel2(String CustomerID)
		{

					SearchButton =new JButton("Search");

					DateField = new JTextField(15);
					DateField.setText(TransactionDate);
					EndDateField = new JTextField(15);
					EndDateField.setText(EndDate);

					JLabel DateLabel = new JLabel("Start Date:");
					JLabel EndDateLabel = new JLabel("End Date:");

					JPanel DatePanel= new JPanel();
					JPanel EndDatePanel= new JPanel();

					DatePanel.add(DateLabel);
					DatePanel.add(DateField);
			        EndDatePanel.add(EndDateLabel);
					EndDatePanel.add(EndDateField);
					//EndDatePanel.add(SearchButton);

					//add(DatePanel);
					//DatePanel.setLocation(3000,2000);

		    SearchButton.addActionListener(this);

 			JPanel TopPanel = new JPanel();
 			TopPanel.add(DatePanel);
 			TopPanel.add(EndDatePanel);
 			TopPanel.add(SearchButton);


		setLayout(new BorderLayout());
		//add(TopPanel, BorderLayout.NORTH);
		add(TopPanel,BorderLayout.NORTH);

		//return "f123456";
			}

public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
       String arg = evt.getActionCommand();
       if(arg.equals("Search")){
                    TransactionDate=DateField.getText();
                    EndDate = EndDateField.getText(); //You missed ending date
                    String CustomerID="f123456";
                    Transaction Tran = new Transaction();
                    Vector FoundTrans = Tran.searchTransactions(TransactionDate, EndDate, CustomerID);
                    //here have another Vector to have column names for the transaction table.

                     Vector columnHeads = new Vector();


                   //Then initialize JTable TransTable with the two vectors. Add  TransTable to ViewTransactionPanel.
 					JTable table = new JTable(FoundTrans, columnHeads);
 					table.setPreferredScrollableViewportSize(new Dimension(600, 40));
					JScrollPane scrollPane = new JScrollPane(table);
					JPanel p = new JPanel();
					p.add(scrollPane);
					add(p);

			}



}

public class ViewTransactionBO2 extends JFrame
{

private ViewTransactionPanel2 OBA_Panel;


public ViewTransactionBO2(String CustomerID)
{


		setTitle("Transaction");
         setSize(300, 200);
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
              OBA_Panel = new ViewTransactionPanel2(CustomerID);
		      contentPane.add(OBA_Panel);
		      show();



}




}




 public static void main(String [] args)

 	{
	JFrame frame = new ViewTransactionBO2("f123456"); //initialize a JFrame object
	  frame.show();

	}
}