package User;

import java.awt.BorderLayout;



import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.UIManager;
public class UserHome extends AccountLogin {

	private JPanel contentPane;
	private JFrame jf;
	JButton btnNewButton_1;
	private JTextArea textArea;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 UserHome frame = new  UserHome();
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
	public  UserHome() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 650);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(btnNewButton,"Are you sure?");
				//JOptionPane.setRootFrame(null);
				if(a==JOptionPane.YES_OPTION){
						
				dispose();
				AccountLogin ms=new AccountLogin();
				ms.setTitle("Account Login");
				ms.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(899, 39, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton add = new JButton("DEPOSIT");
		add.setBackground(UIManager.getColor("Button.light"));
		add.setFont(new Font("Ubuntu", Font.PLAIN, 45));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add obj=new Add();
				obj.setVisible(true);
			}
		});
		
		JLabel lblTitle = new JLabel("Account Home ------------------");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Ubuntu", Font.BOLD, 36));
		lblTitle.setBounds(28, -3, 504, 126);
		contentPane.add(lblTitle);
		
		
		
		btnNewButton_1 = new JButton("Get Balance");
		btnNewButton_1.setBounds(835, 417, 127, 51);
		contentPane.add(btnNewButton_1);
		add.setBounds(40, 100, 329, 260);
		contentPane.add(add);
		
		JButton btnAllEvents = new JButton("WITHDRAW");
		btnAllEvents.setFont(new Font("Ubuntu", Font.PLAIN, 45));
		btnAllEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawAmt obj=new withdrawAmt();
				obj.setVisible(true);
			}
		});
		btnAllEvents.setBounds(405, 99, 548, 262);
		contentPane.add(btnAllEvents);
		
		JLabel lblAcctNo = new JLabel("Enter Acct. No. again");
		lblAcctNo.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		lblAcctNo.setBounds(32, 383, 285, 81);
		contentPane.add(lblAcctNo);
		
		JLabel lblAcctNo_1 = new JLabel("(for verification)");
		lblAcctNo_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblAcctNo_1.setBounds(32, 400, 285, 81);
		contentPane.add(lblAcctNo_1);
		
		JLabel lblbalance = new JLabel("Balance");
		lblbalance.setFont(new Font("Ubuntu", Font.PLAIN, 35));
		lblbalance.setBounds(32, 480, 285, 81);
		contentPane.add(lblbalance);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textArea.setBounds(190, 500, 590, 51);
		contentPane.add(textArea);
		textArea.setColumns(10);
		

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField.setBounds(190, 417, 630, 51);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String ustr=textField.getText();
				try
				{
					System.out.println("add");
					
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
					
					PreparedStatement st=(PreparedStatement) con.prepareStatement("SELECT accountno,balance from account where accountno=? ");
									
					st.setString(1, ustr);

		            ResultSet rs = st.executeQuery();			
		            if(rs.next())
					{
					
						//i=1
						textArea.append(rs.getString("balance"));
						
					}
					else{
					
						//i=0;
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}			
			}  });
					
				
		
		JLabel label = new JLabel("");
		label.setBackground(Color.BLACK);
		
		label.setBounds(0, 26, 1008, 536);
		contentPane.add(label);	
	}
}
			