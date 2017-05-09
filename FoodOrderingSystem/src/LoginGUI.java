import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;

public class LoginGUI {

	private JFrame frame;
	private JTextField textUsername;
	private JLabel labelLogo;
	private JPasswordField passwordField;
	
	
	
	
	
	public LoginGUI() {
		
		initialize();
		frame.setVisible(true);
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton loginButton = new JButton("Login");
		Image imgLogin=new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		loginButton.setIcon(new ImageIcon(imgLogin));
		loginButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int cnt=0;
				Connection mysql=null;
				try{
					 Class.forName("com.mysql.jdbc.Driver");
					 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
					Statement statement=mysql.createStatement();
					ResultSet result=statement.executeQuery("select * from user");
					
					while(result.next())
					{
						
						if(textUsername.getText().equals(result.getString("username")) && String.valueOf(passwordField.getPassword()).equals(result.getString("password")))
						{
							//textPassword.getText();
							JOptionPane.showMessageDialog(null, "Access Granted");
							frame.dispose();
							LoginedGUI logined=new LoginedGUI(result.getString("iduser"));
							logined.setVisible(true);
							
							frame.setVisible(false);
							cnt=1;
							break;
						}
						
							//System.out.println(result.getString("iduser")+result.getString("username")+","+result.getString("password"));
					}
					
				}catch(Exception ex){ex.printStackTrace();}
				
				          if(cnt!=1)
				          {
				        	  JOptionPane.showMessageDialog(null, "Access Denied!!!");
				          }
				            
				
				
				
				
				
			}
		});
		loginButton.setBounds(179, 177, 107, 23);
		frame.getContentPane().add(loginButton);
		
		JButton signupbutton = new JButton("Sign Up");
		Image imgSignup=new ImageIcon(this.getClass().getResource("/signuplogo.png")).getImage();
		signupbutton.setIcon(new ImageIcon(imgSignup));
		signupbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//frame.dispose();
				SingUpGUI singuped=new SingUpGUI();
				singuped.setVisible(true);
				
			}
		});
		signupbutton.setBounds(296, 177, 107, 23);
		frame.getContentPane().add(signupbutton);
		
		textUsername = new JTextField();
		textUsername.setBounds(179, 115, 224, 20);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblUsername.setBounds(97, 118, 81, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblPassword.setBounds(97, 149, 81, 14);
		frame.getContentPane().add(lblPassword);
		
		labelLogo = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/foodorderlogo.png")).getImage();
		labelLogo.setIcon(new ImageIcon(img));
		labelLogo.setBounds(5, 100, 87, 86);
		frame.getContentPane().add(labelLogo);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(179, 146, 224, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		Image imgMainLogo=new ImageIcon(this.getClass().getResource("/foodordering-logo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgMainLogo));
		lblNewLabel.setBounds(115, 11, 260, 93);
		frame.getContentPane().add(lblNewLabel);
	}
}
