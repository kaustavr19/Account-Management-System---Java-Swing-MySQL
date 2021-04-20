package User;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
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

public class depositAmt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					depositAmt frame = new depositAmt();
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
	public depositAmt() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 319, 1014, 460);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTextArea acctnum = new JTextArea();
		acctnum.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		acctnum.setBounds(280, 26, 688, 80);
		contentPane.add(acctnum);
		ButtonGroup btg=new ButtonGroup();

		
		JTextArea depositamt = new JTextArea();
		depositamt.setFont(new Font("Segoe UI", Font.PLAIN, 37));
		depositamt.setBounds(280, 119, 688, 80);
		contentPane.add(depositamt);

		JLabel lblAcctNo = new JLabel("Account No:");
		lblAcctNo.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		lblAcctNo.setBounds(32, 26, 285, 81);
		contentPane.add(lblAcctNo);
		
		
		
		JLabel lblDeposit = new JLabel("Deposit Amt.:");
		lblDeposit.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		lblDeposit.setBounds(32, 130, 285, 81);
		contentPane.add(lblDeposit);
		
		
		
		JButton btnNewButton = new JButton("Deposit");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(btnNewButton,"Are you sure?");
				//JOptionPane.setRootFrame(null);
				if(a==JOptionPane.YES_OPTION){
					
					String AccountNo=acctnum.getText();
					String DepositAmount=depositamt.getText();
					int j=0;
				//String id1=id.getText();
					try{
						System.out.println("add");
						
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","");
						
						PreparedStatement st=(PreparedStatement) con.prepareStatement("SELECT accountno,balance from account where accountno=? ");

					
						st.setString(1, AccountNo);
						
						
						
						ResultSet rs=st.executeQuery();
						if(rs.next())
						{
						
							//i=1;
							
							String updatedBalance=rs.getString("balance");
							updatedBalance = (Integer.parseInt(updatedBalance)+Integer.parseInt(DepositAmount))+"";
							
							st=(PreparedStatement) con.prepareStatement("UPDATE account SET balance=? WHERE accountno=?");

							st.setString(1, updatedBalance);
							st.setString(2, AccountNo);
							
							
							j=st.executeUpdate();
						}
						else{
						
							//i=0;
						}
						
					}
					catch(Exception w1)
					{
					System.out.println(w1);	
					}
					
					int i = 0;
					if(j==1)
					{
						String n="\n";
						
						
						JOptionPane.showMessageDialog(btnNewButton,"Congratulations,"+n+"Money Deposit successful"+n+"Thankyou.");
					}
					else
					{

						JOptionPane.showMessageDialog(btnNewButton,"Please,enter the informations");
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		btnNewButton.setBounds(388, 320, 197, 80);
		contentPane.add(btnNewButton);
		
		
	}
}