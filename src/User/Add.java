package User;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Add() {
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 319, 1014, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAcctNo = new JLabel("Account No.");
		lblAcctNo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblAcctNo.setBounds(59, 25, 145, 32);
		contentPane.add(lblAcctNo);
		
		JLabel lblName = new JLabel("Acct. Holder Name ");
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblName.setBounds(59, 107, 164, 32);
		contentPane.add(lblName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblGender.setBounds(59, 184, 145, 32);
		contentPane.add(lblGender);
		
		JTextArea acctnum = new JTextArea();
		acctnum.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		acctnum.setBounds(235, 26, 166, 37);
		contentPane.add(acctnum);
		
		JTextArea acctholdername = new JTextArea();
		acctholdername.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		acctholdername.setBounds(235, 102, 166, 37);
		contentPane.add(acctholdername);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(235, 172, 75, 44);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBounds(235, 213, 138, 40);
		contentPane.add(rdbtnNewRadioButton_1);
		ButtonGroup btg=new ButtonGroup();
		btg.add(rdbtnNewRadioButton_1);
		btg.add(rdbtnNewRadioButton);
		
		
		JLabel lblDob = new JLabel("Date of Birth");
		lblDob.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDob.setBounds(481, 25, 158, 32);
		contentPane.add(lblDob);
		
		JComboBox date = new JComboBox();
		for(int i=1;i<=31;i++)
		{
			String str=String.valueOf(i);
			date.addItem(str);
		}
		date.setBounds(662, 32, 48, 27);
		contentPane.add(date);
		
		JComboBox month = new JComboBox();
		month.setBounds(739, 32, 75, 27);
		month.addItem("Jan");
		month.addItem("Feb");
		month.addItem("Mar");
		month.addItem("Apr");
		month.addItem("May");
		month.addItem("Jun");
		month.addItem("Jul");
		month.addItem("Aug");
		month.addItem("Sep");
		month.addItem("Oct");
		month.addItem("Nov");
		month.addItem("Dec");
		contentPane.add(month);
		
		JComboBox year = new JComboBox();
		for(int i=1901;i<=2018;i++)
		{
			String str=String.valueOf(i);
			year.addItem(str);
		}
		year.setBounds(841, 32, 109, 27);
		contentPane.add(year);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblAddress.setBounds(481, 184, 158, 32);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNo = new JLabel("Phone Number");
		lblPhoneNo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblPhoneNo.setBounds(481, 261, 145, 32);
		contentPane.add(lblPhoneNo);
		
		JTextArea location = new JTextArea();
		location.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		location.setBounds(662, 185, 166, 37);
		contentPane.add(location);
		
		JLabel lblIdNo = new JLabel("ID No.");
		lblIdNo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblIdNo.setBounds(481, 107, 169, 32);
		contentPane.add(lblIdNo);
		
		JTextArea phno = new JTextArea();
		phno.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		phno.setBounds(662, 262, 166, 37);
		contentPane.add(phno);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblPass.setBounds(59, 261, 145, 32);
		contentPane.add(lblPass);
		
		JTextArea passwd = new JTextArea();
		passwd.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		passwd.setBounds(235, 262, 166, 37);
		contentPane.add(passwd);

		JTextArea idnum = new JTextArea();
		idnum.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		idnum.setBounds(662, 110, 166, 37);
		contentPane.add(idnum);
		
		JLabel lblDeposit = new JLabel("Min. Deposit");
		lblDeposit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDeposit.setBounds(59, 350, 200, 32);
		contentPane.add(lblDeposit);
		
		JTextArea depositamt = new JTextArea();
		depositamt.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		depositamt.setBounds(235, 350, 166, 37);
		contentPane.add(depositamt);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(btnNewButton,"Are you sure?");
				//JOptionPane.setRootFrame(null);
				if(a==JOptionPane.YES_OPTION){
				
					String accountno=acctnum.getText();
					String name= acctholdername.getText();

					String  gender="";
					if(rdbtnNewRadioButton.isSelected())
					{
						gender="Male";
						
					}
					else if(rdbtnNewRadioButton_1.isSelected())
					{
						gender="Female";
						
					}
					int i=1;
					
					String address=location.getText();
					String phone=phno.getText();
					String idno=idnum.getText();
					String pass=passwd.getText();
					String depositamount=depositamt.getText(); 
					
					String dt=(String) date.getSelectedItem();
					String mnth=(String) month.getSelectedItem();
					String yr=(String) year.getSelectedItem();
					
					String dob=dt+"/"+mnth+"/"+yr;
					try{
						System.out.println("add");
						
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
						
						PreparedStatement st=(PreparedStatement) con.prepareStatement("INSERT INTO account(accountno,name,gender,dob,idno,address,phone, pass,balance ) values(?,?,?,?,?,?,?,?,?)");
						
						st.setString(1, accountno);
						st.setString(2, name);
						st.setString(3, gender);
						st.setString(4, dob);
						st.setString(5, idno);
						st.setString(6, address);
						st.setString(7, phone);
						st.setString(8, pass);
						st.setString(9, depositamount);
						
						int j=0;
						j=st.executeUpdate();
						
					}
					catch(Exception w1)
					{
					System.out.println(w1);	
					}
					
					
					if(i==1)
					{
						String n="\n";
						
						
						JOptionPane.showMessageDialog(btnNewButton,"Congratulations,"+n+"Account is created sucessfully"+n+"Thankyou.");
					}
					else
					{

						JOptionPane.showMessageDialog(btnNewButton,"Please,enter the informations");
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnNewButton.setBounds(376, 418, 197, 80);
		contentPane.add(btnNewButton);
		
	}
}