package Bank.Managment.System;

// Importing required libraries for GUI, events, and utilities
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

// SignUp class creates the first page of the bank application form
public class SignUp extends JFrame implements ActionListener {
	
	// Generate random 4-digit application form number
	Random ran = new Random();
	long first4 = (ran.nextLong() % 9000L) + 1000L;
	String first = " " + Math.abs(first4);
	
	// Declare text fields for user input
	JTextField textfather, textname, textemail, textCity, textState, textPin, textaddress;
	
	// Date chooser for selecting date of birth
	JDateChooser datechooser;
		
	// Radio buttons for gender and marital status
	JRadioButton r1, r2 , m1, m2 , m3;
	
	// Button to move to next page
	JButton next;
	
	// Constructor to design the UI
	SignUp() {
		super("APPLICATION FORM");
		
		// Application form number label
		JLabel label1 = new JLabel("APPLICATION FORM NO: " + first);
		label1.setForeground(Color.BLACK);
		label1.setFont(new Font("Raleway", Font.BOLD, 38));
		label1.setBounds(120, 20, 600, 40);
		add(label1);
		
		// Page number label
		JLabel label2 = new JLabel("Page 1");
		label2.setForeground(Color.BLACK);
		label2.setFont(new Font("Raleway", Font.BOLD, 22));
		label2.setBounds(350, 70, 600, 40);
		add(label2);
		
		// Section title
		JLabel label3 = new JLabel("Personal Details: ");
		label3.setForeground(Color.BLACK);
		label3.setFont(new Font("Raleway", Font.BOLD, 22));
		label3.setBounds(300, 100, 600, 40);
		add(label3);
		
		// Name label and text field
		JLabel labelName = new JLabel("Name:");
		labelName.setForeground(Color.BLACK);
		labelName.setFont(new Font("Raleway", Font.BOLD, 20));
		labelName.setBounds(100, 170, 100, 30);
		add(labelName);
		
		textname = new JTextField(15);
		textname.setBounds(300, 170, 250, 30);
		textname.setFont(new Font("Arial", Font.BOLD, 14));
		add(textname);
		
		// Father's name
		JLabel labelfName = new JLabel("Father's Name:");
		labelfName.setForeground(Color.BLACK);
		labelfName.setFont(new Font("Raleway", Font.BOLD, 20));
		labelfName.setBounds(100, 210, 150, 30);
		add(labelfName);
		
		textfather = new JTextField(15);
		textfather.setBounds(300, 210, 250, 30);
		textfather.setFont(new Font("Arial", Font.BOLD, 14));
		add(textfather);
		
		// Date of Birth
		JLabel DOB = new JLabel("Date of Birth:");
		DOB.setForeground(Color.BLACK);
		DOB.setFont(new Font("Raleway", Font.BOLD, 20));
		DOB.setBounds(100, 250, 150, 30);
		add(DOB);
		
		datechooser = new JDateChooser();
		datechooser.setForeground(new Color(105, 105, 105));
		datechooser.setBounds(300, 250, 250,30);
		add(datechooser);
		
		// Gender selection
		JLabel gender = new JLabel("Gender:");
		gender.setForeground(Color.BLACK);
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 150, 30);
		add(gender);
		
		r1 = new JRadioButton("Male");
		r1.setForeground(Color.BLACK);
		r1.setFont(new Font("Raleway", Font.BOLD, 12));
		r1.setBackground(new Color(222, 255, 228));
		r1.setBounds(300, 290, 60, 30);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setForeground(Color.BLACK);
		r2.setFont(new Font("Raleway", Font.BOLD, 12));
		r2.setBackground(new Color(222, 255, 228));
		r2.setBounds(400, 290, 80, 30);
		add(r2);
		
		// Group gender radio buttons
		ButtonGroup buttongroup = new ButtonGroup();
		buttongroup.add(r1);
		buttongroup.add(r2);
		
		// Email field
		JLabel mail = new JLabel("Email Address:");
		mail.setForeground(Color.BLACK);
		mail.setFont(new Font("Raleway", Font.BOLD, 20));
		mail.setBounds(100, 330, 150, 30);
		add(mail);
		
		textemail = new JTextField(15);
		textemail.setBounds(300, 330, 250, 30);
		textemail.setFont(new Font("Arial", Font.BOLD, 14));
		add(textemail);
		
		// Marital status
		JLabel Ms = new JLabel("Marital Status:");
		Ms.setForeground(Color.BLACK);
		Ms.setFont(new Font("Raleway", Font.BOLD, 20));
		Ms.setBounds(100, 370, 150, 30);
		add(Ms);
		
		m1 = new JRadioButton("Married");
		m1.setForeground(Color.BLACK);
		m1.setFont(new Font("Raleway", Font.BOLD, 12));
		m1.setBackground(new Color(222, 255, 228));
		m1.setBounds(300, 370, 90, 30);
		add(m1);
		
		m2 = new JRadioButton("Unmarried");
		m2.setForeground(Color.BLACK);
		m2.setFont(new Font("Raleway", Font.BOLD, 12));
		m2.setBackground(new Color(222, 255, 228));
		m2.setBounds(400, 370, 90, 30);
		add(m2);
		
		m3 = new JRadioButton("Others");
		m3.setForeground(Color.BLACK);
		m3.setFont(new Font("Raleway", Font.BOLD, 12));
		m3.setBackground(new Color(222, 255, 228));
		m3.setBounds(500, 370, 90, 30);
		add(m3);
		
		// Group marital status radio buttons
		ButtonGroup buttongroup1 = new ButtonGroup();
		buttongroup1.add(m1);
		buttongroup1.add(m2);
		buttongroup1.add(m3);
		
		// Address field
		JLabel labeladdress = new JLabel("Address:");
		labeladdress.setForeground(Color.BLACK);
		labeladdress.setFont(new Font("Raleway", Font.BOLD, 20));
		labeladdress.setBounds(100, 410, 150, 30);
		add(labeladdress);
		
		textaddress = new JTextField(15);
		textaddress.setBounds(300, 410, 250, 30);
		textaddress.setFont(new Font("Arial", Font.BOLD, 14));
		add(textaddress);
		
		// State field
		JLabel labelState = new JLabel("State:");
		labelState.setForeground(Color.BLACK);
		labelState.setFont(new Font("Raleway", Font.BOLD, 20));
		labelState.setBounds(100, 450, 150, 30);
		add(labelState);
		
		textState = new JTextField(15);
		textState.setBounds(300, 450, 250, 30);
		textState.setFont(new Font("Arial", Font.BOLD, 14));
		add(textState);
		
		// City field
		JLabel labelCity = new JLabel("City:");
		labelCity.setForeground(Color.BLACK);
		labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
		labelCity.setBounds(100, 490, 150, 30);
		add(labelCity);
		
		textCity = new JTextField(15);
		textCity.setBounds(300, 490, 250, 30);
		textCity.setFont(new Font("Arial", Font.BOLD, 14));
		add(textCity);
		
		// Pin code field
		JLabel labelPin = new JLabel("Pin Code:");
		labelPin.setForeground(Color.BLACK);
		labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
		labelPin.setBounds(100, 530, 150, 30);
		add(labelPin);
		
		textPin = new JTextField(15);
		textPin.setBounds(300, 530, 250, 30);
		textPin.setFont(new Font("Arial", Font.BOLD, 14));
		add(textPin);
		
		// Next button
		next = new JButton("Next");
		next.setForeground(Color.WHITE);
		next.setBackground(Color.BLACK);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(450, 600, 100, 30);
		next.addActionListener(this);
		add(next);
		
		// Bank logo image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/bank.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(10, 10, 100, 100);
		add(image);
		
		// Frame settings
		getContentPane().setBackground(new Color(222, 255, 228));
		setLayout(null);
		setSize(850,700);
		setLocation(250,20);
		setVisible(true);
	}
	
	// Handle button click event
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Collect all user inputs
		String formNo = first;
		String name = textname.getText();
		String fathername = textfather.getText();
		
		String dob = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
		
		// Determine selected gender
		String gender = null;
		if(r1.isSelected()) {
			gender = "Male";
		} else if(r2.isSelected()){
			gender = "Female";
		}
		
		String email = textemail.getText();
		
		// Determine marital status
		String marital = null;
		if(m1.isSelected()) {
			marital = "Married";
		} else if(m2.isSelected()) {
			marital = "Unmarried";
		} else if(m3.isSelected()) {
			marital = "Other";
		}
		
		String address = textaddress.getText();
		String state = textState.getText();
		String city = textCity.getText();
		String pincode = textPin.getText();
		
		try {
			// Basic validation
			if(textname.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Fill all the fields.");
			} else {
				// Insert data into database
				Conn conn1 = new Conn();
				String sql1 = "insert into signUp values('"+formNo+"', '"+name+"', '"+fathername+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+state+"', '"+city+"', '"+pincode+"')";
				conn1.statement.executeUpdate(sql1);
				
				new signUp2(formNo);
				// Move to next page (hide current frame)
				setVisible(false);
			}
		} catch(Exception E) {
			E.printStackTrace();
		}
	}
	
	// Main method to run the application
	public static void main(String[] args) {
		new SignUp();
	}
}