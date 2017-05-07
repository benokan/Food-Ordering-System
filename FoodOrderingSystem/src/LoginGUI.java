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

public class LoginGUI {

	private JFrame frame;
	private JTextField textUsername;
	private JTextField textPassword;
	private JLabel labelLogo;
	
	
	
	
	
	public LoginGUI() {
		
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
				
				Connection mysql=null;
				try{
					 Class.forName("com.mysql.jdbc.Driver");
					 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
					Statement statement=mysql.createStatement();
					ResultSet result=statement.executeQuery("select * from user");
					
					while(result.next())
					{
						System.out.println(result.getString("username")+","+result.getString("password"));
					}
					
				}catch(Exception ex){ex.printStackTrace();}
				
				JOptionPane.showMessageDialog(null, "Username and password is correct");
				frame.dispose();
				LoginedGUI logined=new LoginedGUI();
				logined.setVisible(true);
				
				frame.setVisible(false);
				
			}
		});
		loginButton.setBounds(179, 146, 107, 23);
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
		signupbutton.setBounds(296, 146, 107, 23);
		frame.getContentPane().add(signupbutton);
		
		textUsername = new JTextField();
		textUsername.setBounds(179, 68, 224, 20);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(179, 100, 224, 20);
		frame.getContentPane().add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(91, 70, 87, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(91, 101, 87, 14);
		frame.getContentPane().add(lblPassword);
		
		labelLogo = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/foodorderlogo.png")).getImage();
		labelLogo.setIcon(new ImageIcon(img));
		labelLogo.setBounds(0, 57, 87, 86);
		frame.getContentPane().add(labelLogo);
	}
}
