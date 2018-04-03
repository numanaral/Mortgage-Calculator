import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class View extends JFrame {
	private JTextField numOfPayments;
    private JTextField principal;
    private JTextField intRate;
    private JTextField freq;
    // text field variables
    
    private JButton blendedPayment;
    private JButton totIntPaid;
    private JButton totIntandPrincipal;
    private JButton intOverPrincipal;
    private JButton avgIntPaidY;
    private JButton avgIntPaidM;
    private JButton amorizationInYears;
    private JButton timeFrameConv;
    private JButton timeFrameConv2;
    private JButton timeFrameConv3;
    private JButton compFreq;
    private JButton annualAmortTab;
    // Buttons variables
    
    private JLabel output;
    private JLabel temp;
    // Label variables 
    
	private JPanel mPanel;
	private JPanel mPanel2;
	private JPanel mPanel3;
	// Panel variables
	
	private int compCounter = 0;
	private int compCounter2 = 0;
	private int compFrq;
	// to avoid multiple text fields for manual compound
	
	public int getNumOfPayments() {
		return Integer.parseInt(numOfPayments.getText());
		// get the input from user and convert it to an integer
	}
	
	public double getPrincipal() {
		return Double.parseDouble(principal.getText());
		// get the input from user and convert it to an integer
	}	
	
	public double getIntRate() {
		return Double.parseDouble(intRate.getText());
		// get the input from user and convert it to an integer
	}	
	
	public void setCompRate(String st) {
		compFrq = Integer.parseInt(st);
	}
	
	public View()
	// constructor
	{
		super("Mortgage Calculator");
		// the title bar
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//exit on "close"
		setSize(410,600);
		// size for the frame
		
		numOfPayments = new JTextField(8);
		principal     = new JTextField(8);
		intRate       = new JTextField(8);
		// initiating/creating the text fields which user inputs values on
		
		blendedPayment     	= new JButton("Blended Payment");
		totIntPaid         	= new JButton("Total Interest Paid");
	    totIntandPrincipal 	= new JButton("Total Interest and Principal");
	    intOverPrincipal   	= new JButton("Interest/Principal Ratio");
	    avgIntPaidY        	= new JButton("Avg Interest Paid (Yearly)");
	    avgIntPaidM        	= new JButton("Avg Interest Paid (Monthly)");
	    amorizationInYears 	= new JButton("Amorization in Years");
	    timeFrameConv		= new JButton("Monthly Payments");
	    timeFrameConv2		= new JButton("BI-Weekly Payments");
	    timeFrameConv3		= new JButton("Weekly Payments");
	    compFreq			= new JButton("Compund Frequency");
	    annualAmortTab		= new JButton("Annual Ammortization");
	    // initiating/creating buttons so that that the program makes specific calculations
	    // depending on the button clicked
	    
	    HandlerClass handler = new HandlerClass();
	    blendedPayment.		addActionListener(handler);
	    totIntPaid.			addActionListener(handler);
	    totIntandPrincipal.	addActionListener(handler);
	    intOverPrincipal.	addActionListener(handler);
	    avgIntPaidY.		addActionListener(handler);
	    avgIntPaidM.		addActionListener(handler);
	    amorizationInYears.	addActionListener(handler);
	    timeFrameConv.		addActionListener(handler);
	    timeFrameConv2.		addActionListener(handler);
	    timeFrameConv3.		addActionListener(handler);
	    compFreq.			addActionListener(handler);
//	    compFreq.addActionListener(new ActionListener( ) 
//	    	{ 
//	    		public void actionPerformed(ActionEvent e) { 
//	    				System.out.println("Action entered: " + e.getActionCommand( ));
//	    		}
//	    	} 
//	    );
	    annualAmortTab. 	addActionListener(handler);
	    // handler class object which allows button to have specific actions, ActionListener.
	    // the object is sent as a parameter to get the actionlistener
	    
	    getContentPane().setLayout(new FlowLayout());
	    // our content pane with flow layout
		getContentPane().add(new JLabel ("                                                           "));
		getContentPane().add(new JLabel ("           %%%%%%		                           M        C"));
		getContentPane().add(new JLabel ("       %%%%%%%%%		                      O        A"));
		getContentPane().add(new JLabel ("   %%%%%%%%%%%%%	              R        L"));
		getContentPane().add(new JLabel ("%%%%%%%%%%%%%%%	           T        C"));
		getContentPane().add(new JLabel ("  ||  _____                     ||	               G        U"));
		getContentPane().add(new JLabel ("  ||  |    |    |      ____      ||	               A        L"));
		getContentPane().add(new JLabel ("  ||  |---|---|      |       |      ||	               G        A"));
		getContentPane().add(new JLabel ("  ||  *******     |      -|      ||	               E        T"));
		getContentPane().add(new JLabel ("  ||                   |       |      ||	                         O"));
		getContentPane().add(new JLabel ("*************************	                       R"));
		// ascii on the content page for a good look
		
		
		mPanel  = new JPanel(new GridLayout(3,1));
		mPanel2 = new JPanel(new GridLayout(0,2,5,5));
		mPanel3 = new JPanel();	
		output  = new JLabel("Choose one of the options above");
		// initiating/creating panels so that we can add our stuff on them
		// initiating/creating Label which tells us (through the program) what's happening
		
		mPanel.add(new JLabel("Number of Payments        "));
		mPanel.add(numOfPayments);
		mPanel.add(new JLabel("Principal                              "));
		mPanel.add(principal);
		mPanel.add(new JLabel("Annual Interest Rate (%)   "));
		mPanel.add(intRate);
		// adding out text fields with specific writings next to them to the calculator
				
		mPanel2.add(blendedPayment);
		mPanel2.add(totIntPaid);
		mPanel2.add(totIntandPrincipal);
		mPanel2.add(intOverPrincipal);
		mPanel2.add(avgIntPaidY);
		mPanel2.add(avgIntPaidM);
		mPanel2.add(amorizationInYears);
		mPanel2.add(timeFrameConv);
		mPanel2.add(timeFrameConv2);
		mPanel2.add(timeFrameConv3);
		mPanel2.add(compFreq);
		mPanel2.add(annualAmortTab);
		// adding our buttons to the panel
		
		mPanel3.add(output);
		mPanel3.setBackground(Color.YELLOW);
		output.setFont(new Font("Serif", Font.BOLD + Font.CENTER_BASELINE, 18));
		// adding the label, changing its color and font
		
		
		add(mPanel);
		add(mPanel2);
		add(mPanel3);
		// adding panels to the pane
				
		setVisible(true);
		// sets the visibility true so that we can see the buttons and panels etc. on the screen
		
	}
	
	
	private class HandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// a class which handles the actions performed on the buttons
			Object src 		= e.getSource();
			// gets the click source
			String ac		= String.format("=> %s: ", e.getActionCommand());
			// returns a string based on the button clicked
			int times 		= getNumOfPayments();
			double amount 	= getPrincipal();			
			double intrRate = getIntRate();
			// values from the inputs, to be used in creating the object from the Model class
			
			if (compCounter == 1){
			mPanel3.remove(freq);
			mPanel3.remove(temp);
			mPanel3.revalidate();
            mPanel3.repaint();
            compCounter--;
            }
			
			int button = (	src == blendedPayment 		? 1:
							src == totIntPaid			? 2:
							src == totIntandPrincipal	? 3:
							src == intOverPrincipal 	? 4:
							src == avgIntPaidY			? 5:
							src == avgIntPaidM			? 6:	
							src == amorizationInYears 	? 7: 
							src == timeFrameConv		? 8:
							src == timeFrameConv2		? 9:
							src == timeFrameConv3		? 10:
							src == compFreq				? 11:
							src == annualAmortTab		? 12: 13);
			
			// conditional operator to check which button is clicked
			
			if (button ==9){
				Model m	= new Model((int) times*2, amount, intrRate, 2, 24);
				Swch(m, button, ac);
			}else if (button == 10){
				Model m	= new Model((int) times*4, amount, intrRate, 2, 48);
				Swch(m, button, ac);
			}else {			
				Model m	= new Model((int) times, amount, intrRate, 2, 12);
				Swch(m, button, ac);
			}
			
			// to have different payment value for monthly, biweekly and weekly, 3 different options
			// which call for the Swch method to calculate whatever is needed
			
		}
			public void Swch(Model m, int b, String a){
				
			String ac = a;
			int button = b;
			switch(button){
				case 1:
					String s1 = String.format("%s$%.2f", ac, m.calculateBlendedPayment());
					output.setText(s1);
					// to have specific result in the output, we use string format, in this case 
					// two decimals, with a dollar sign, including the name for the button clicked
					// for easier understanding of what's going on in the program
					break;
				case 2:
					m.calculateBlendedPayment();
					m.calculateTotalInterestandPrincipal(); 
					String s2 = String.format("%s $%.2f", ac, m.calculateTotalInterestPaid());
					output.setText(s2);				
					break;
				case 3:
					m.calculateBlendedPayment();
					String s3 = String.format("%s $%.2f", ac, m.calculateTotalInterestandPrincipal());
					output.setText(s3); 
					break;
				case 4:
					m.calculateBlendedPayment();
					m.calculateTotalInterestandPrincipal();
					m.calculateTotalInterestPaid();	
					String s4 = String.format("%s $%.2f", ac, m.calculateInterestOverPrincipalRatio());
					output.setText(s4);
					break;
				case 5:
					m.calculateBlendedPayment();
					m.calculateTotalInterestandPrincipal();
					m.calculateTotalInterestPaid();	
					String s5 = String.format("%s $%.2f", ac, m.calculateAverageInterestPaidYearly());
					output.setText(s5);
					break;
				case 6:
					m.calculateBlendedPayment();
					m.calculateTotalInterestandPrincipal();
					m.calculateTotalInterestPaid();	
					String s6 = String.format("%s $%.2f", ac, m.calculateAverageInterestPaidMonthly());
					output.setText(s6);
					break;
				case 7:
					String s7 = String.format("%s%s", ac, m.calculateAmorizationInYears());
					output.setText(s7);
					break;
				case 8:
					String s8 = String.format("%s $%.2f", ac, m.calculateBlendedPayment());
					output.setText(s8);
					break;
				case 9:					
					double p = m.timeFrameConverter(1);
					String s9 = String.format("%s $%.2f", ac, p);
					output.setText(s9);
					break;
				case 10:					
					double k = m.timeFrameConverter(2);
					String s10 = String.format("%s $%.2f", ac, k);
					output.setText(s10);
					break;
				case 11:
					freq = new JTextField(5);
					freq.addActionListener(new ActionListener( ) 
			    	{ 
			    		public void actionPerformed(ActionEvent e) { 
			    				//System.out.println("Action entered: " + e.getActionCommand());
			    				setCompRate(e.getActionCommand());
			    				mPanel3.revalidate();
				                mPanel3.repaint();
				                String sf = String.format("Frequency changed to %s", compFrq);
				                output.setText(sf);
				                m.changeCompoundFrequency(compFrq);
				                int times 		= getNumOfPayments();
				    			double amount 	= getPrincipal();			
				    			double intrRate = getIntRate();
				                Model m = new Model((int) times, amount, intrRate, compFrq, 12);
				                // is there a way to reupdate the object?
			    		}
			    	} 
					);
					temp = new JLabel("Compound Frequency");
					output.setText("");
					// create a new text field so that the user can enter a new compound rate
					
					mPanel3.add(temp);
					mPanel3.add(freq);
					compCounter++;
					mPanel3.revalidate();
	                mPanel3.repaint();
	                
//	                if (compCounter2 == 0);
//	                String cfm = freq.getText();
//	                int kl = Integer.parseInt(cfm);
//	                System.out.println(kl);
					// int cf = m.changeCompoundFrequency(freq.getText());
	                //int kl = getCompRate();
	                
//					mPanel3.remove(freq);
//					mPanel3.remove(temp);
					
					break;
					
					// I am keeping those up as commented out for you to see what i have tried
					// I managed to get the textfield to come up right away
					// It doesn't create multiple ones
					// It's removed properly if another button is clicked
					// Though it gives AWT error "For input string "" "
					
					// if you change getCompRate to return string function and parse it here, the error becomes
					// "empty string", i am assuming a button implemented has a chance of fixing it, but it's 
					// about the time i send it
					
					// create a new JTextField for user to input his specific value
					// add the textfield to the panel
					// call for the function which changes the compound
					// refresh the screen and remove it after 
					
				case 12:
					output.setText(ac);
					JOptionPane.showMessageDialog(null, "Not yet implemented" );
					break;
			
					
					
			// 12 cases for 12 different calculations which run on clicks on buttons
			// some cases have more than one function, it's because the program needs to get
			// specific values to be able to calculate what's needed
			}
			

		}
	}
}