package User;

import java.awt.Color;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AccountLogin extends JFrame {

	private JPanel contentPane;
	static JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private String user[]={"Kaustav","Kroy"};
	private String pass[]={"abcd","abcde"};
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel label_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountLogin frame = new AccountLogin();
					frame.setTitle("Bank Account Management System");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AccountLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Management Login");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Ubuntu", Font.BOLD, 36));
		lblNewLabel.setBounds(308, 13, 504, 126);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField.setBounds(481, 170, 281, 68);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		passwordField.setBounds(481, 286, 281, 68);
		contentPane.add(passwordField);
		
		JLabel lblacctnum = new JLabel("Account No.");
		lblacctnum.setBackground(Color.BLACK);
		lblacctnum.setForeground(Color.BLACK);
		lblacctnum.setFont(new Font("Ubuntu", Font.PLAIN, 31));
		lblacctnum.setBounds(250, 178, 193, 52);
		contentPane.add(lblacctnum);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBackground(Color.CYAN);
		lblPassword.setFont(new Font("Ubuntu", Font.PLAIN, 31));
		lblPassword.setBounds(250, 286, 193, 52);
		contentPane.add(lblPassword);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnNewButton.setBounds(538, 392, 224, 73);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=0,j=0;
				
				String ustr=textField.getText();
				String pstr=passwordField.getText();
				try{
					System.out.println("add");
					
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
					
					PreparedStatement st=(PreparedStatement) con.prepareStatement("Select accountno,pass from account where accountno=? and pass=?");
					
					st.setString(1,ustr);
					st.setString(2,pstr);
					ResultSet rs=st.executeQuery();
					if(rs.next())
					{
					
						i=1;
					}
					else{
					
						i=0;
					}
				}
				catch(Exception w1)
				{
				System.out.println(w1);	
				}
				
				if(i==1)
				{
					dispose();
					 UserHome ah=new  UserHome();
					ah.setTitle("Faculty Home");
					ah.setVisible(true);
					JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
				}
			}
		});
	
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Add us=new Add();
				us.setTitle("New User Login");
				us.setVisible(true);
			}
		});
		
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnNewButton_1.setBounds(250, 393, 262, 73);
		contentPane.add(btnNewButton_1);
		
		
		
		label_1 = new JLabel("");

		label_1.setBounds(0, 0, 1008, 562);
		contentPane.add(label_1);
	}

}