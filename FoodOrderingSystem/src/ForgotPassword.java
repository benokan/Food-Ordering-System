import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ForgotPassword extends JFrame {
    
	private LoginGUI _LoginGUI;
	private JPanel contentPane;
	private JTextField textEnterPhone;
	private JTextField textUsername;
	private ForgotPassword frame;
	

	public   void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//frame = new ForgotPassword();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String newPassword()
	{
		int passwordSize = 8;
		char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < passwordSize; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		return output;
	
	}
	
	
	
	public ForgotPassword(Object LoginGUI) {
		_LoginGUI=(LoginGUI)LoginGUI;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 269, 143);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textEnterPhone = new JTextField();
		textEnterPhone.setBounds(117, 37, 130, 26);
		contentPane.add(textEnterPhone);
		textEnterPhone.setColumns(10);
		
		JLabel lblEnterPhone = new JLabel("Enter Phone :");
		lblEnterPhone.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEnterPhone.setBounds(21, 36, 89, 26);
		contentPane.add(lblEnterPhone);
		
		JButton btnSend = new JButton("Send");
		//btnSend.setBorderPainted(false); 
		//btnSend.setContentAreaFilled(false); 
		//btnSend.setFocusPainted(false); 
		//btnSend.setOpaque(false);
		Image imgLogin=new ImageIcon(this.getClass().getResource("/send-icon.png")).getImage();
		btnSend.setIcon(new ImageIcon(imgLogin));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int cnt=0;
				Connection mysql=null;
				try{
					Class.forName("com.mysql.jdbc.Driver");
					 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
					Statement statement=mysql.createStatement();
					ResultSet result=statement.executeQuery("select * from userprofile");
					Encryption e=null;
					
				    
					while(result.next())
					{
						
						
							if( textUsername.getText().equals(result.getString("name")) && textEnterPhone.getText().equals(result.getString("phone")))
							{   
								String password=newPassword();
								e=new Encryption(password);
								
								String sql="update  user set password= '"+e.MakeToEncrypted()+"' where iduser='"+result.getString("id")+"'  ";                              
							   // SendSms send=new SendSms();
								//send.send(result.getString("phone"),password);
							  	   
							       
								
								statement.executeUpdate(sql);
								JOptionPane.showMessageDialog(null, "Your new password has been sended to your phone!!!");
								dispose();
								_LoginGUI.setDefault();
								
								cnt++;
								
								break;
							}
						
						
						else{
							
							
							
						}
						
						
							//System.out.println(result.getString("iduser")+result.getString("username")+","+result.getString("password"));
					}
					
				}catch(Exception ex){ex.printStackTrace();}
				
				             if(cnt==0)
				             {
				            	 JOptionPane.showMessageDialog(null, "Username or Password are not valid!!!");
				             }
				        	  
				          
				            
				
				
				
				
				
			}
		});
		btnSend.setBounds(84, 79, 98, 27);
		contentPane.add(btnSend);
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		textUsername.setBounds(117, 8, 130, 26);
		contentPane.add(textUsername);
		
		JLabel lblEnterUsername = new JLabel("Enter Name :");
		lblEnterUsername.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEnterUsername.setBounds(21, 7, 89, 26);
		contentPane.add(lblEnterUsername);
	}
}
