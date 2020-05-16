

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.ezpass.*;
import com.ezpass.*;



class ViewTransactionPanel extends JPanel implements ActionListener{
		private JTable table;
		private JButton SearchButton;
	    private String TransactionDate,EndDate;
	    private String CustomerID="f123456";
		private JTextField DateField,EndDateField,IDField;



		public ViewTransactionPanel(String CustomerID)
		{


					SearchButton =new JButton("Search");

					DateField = new JTextField(15);
					//DateField.setText(TransactionDate);
					EndDateField = new JTextField(15);
					//EndDateField.setText(EndDate);
					IDField= new JTextField(15);
					IDField.setText(CustomerID);
					IDField.setEditable(false);

					JLabel DateLabel = new JLabel("Start Date:");
					JLabel EndDateLabel = new JLabel("End Date:");
					JLabel IDLabel = new JLabel("CustomerID:");

					JPanel DatePanel= new JPanel();
					JPanel EndDatePanel= new JPanel();
					JPanel IDPanel= new JPanel();

					DatePanel.add(DateLabel);
					DatePanel.add(DateField);
			        EndDatePanel.add(EndDateLabel);
					EndDatePanel.add(EndDateField);
					IDPanel.add(IDLabel);
					IDPanel.add(IDField);
					//EndDatePanel.add(SearchButton);

					//add(DatePanel);
					//DatePanel.setLocation(3000,2000);

		    SearchButton.addActionListener(this);

 			JPanel TopPanel = new JPanel();
 			TopPanel.add(IDPanel);
 			TopPanel.add(DatePanel);
 			TopPanel.add(EndDatePanel);
 			TopPanel.add(SearchButton);


		setLayout(new BorderLayout());
		//add(TopPanel, BorderLayout.NORTH);
		add(TopPanel,BorderLayout.NORTH);

	}

public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
       String arg = evt.getActionCommand();
       if(arg.equals("Search")){
		   			CustomerID=IDField.getText();
                    TransactionDate=DateField.getText();
                    EndDate = EndDateField.getText(); //You missed ending date
                    //String CustomerID="f123456";
                    Transaction Tran = new Transaction();
                    Vector FoundTrans = Tran.searchTransactions(TransactionDate, EndDate, CustomerID);
                    //here have another Vector to have column names for the transaction table.

                     Vector columnNames = new Vector();
                     String[] month = {"TransactionID", "TagCode", "TransactionDate",
                     "TransactionTime", "TollAmount", "TollPlaza", "TollLaneNumber","CustomerID"};

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
					//p.validate();
}
			}



}


public class ViewTransactionBO extends JFrame
{

private ViewTransactionPanel OBA_Panel;


public ViewTransactionBO(String CustomerID)
{

		setTitle("Transaction");
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
              OBA_Panel = new ViewTransactionPanel(CustomerID);
		      contentPane.add(OBA_Panel);
		      //show();
}
/*
  public static void main(String [] args)
    {
		JFrame frame = new ViewTransactionBO("f123456"); //initialize a JFrame object
      frame.show(); //display the frame
      //ViewTransactionBO.show();
    }*/
}
