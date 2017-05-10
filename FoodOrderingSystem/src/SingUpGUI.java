import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class SingUpGUI extends JFrame {
    private LoginGUI _loginGUI;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textSurname;
	private JTextField textEmail;
	private JTextField textNickname;
	private JTextField textPhone;
	private JTextField textAddress;
	private SingUpGUI frame;
	private JPasswordField passwordField;

	
	
	
	public  void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 //frame = new SingUpGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SingUpGUI(Object loginGUI) {
		
		_loginGUI=(LoginGUI)loginGUI;
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnCancel = new JButton("Cancel");
		Image imgCancel=new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();
		btnCancel.setIcon(new ImageIcon(imgCancel));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)throws  NullPointerException {
				
			
				
				_loginGUI.setDefault();
				setVisible(false); 
				dispose();
			}
		});
		
		btnCancel.setBounds(266, 227, 101, 23);
		contentPane.add(btnCancel);
		
		textName = new JTextField();
		textName.setBounds(85, 11, 101, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textSurname = new JTextField();
		textSurname.setBounds(266, 11, 101, 20);
		contentPane.add(textSurname);
		textSurname.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblName.setBounds(36, 13, 39, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblSurname.setBounds(198, 13, 58, 14);
		contentPane.add(lblSurname);
		
		textEmail = new JTextField();
		textEmail.setBounds(85, 40, 282, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEmail.setBounds(31, 42, 44, 14);
		contentPane.add(lblEmail);
		
		textNickname = new JTextField();
		textNickname.setBounds(85, 140, 101, 20);
		contentPane.add(textNickname);
		textNickname.setColumns(10);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblNickname.setBounds(9, 142, 66, 14);
		contentPane.add(lblNickname);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblPassword.setBounds(198, 142, 66, 14);
		contentPane.add(lblPassword);
		
		textPhone = new JTextField();
		textPhone.setBounds(85, 104, 101, 20);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblPhone.setBounds(31, 106, 44, 14);
		contentPane.add(lblPhone);
		
		JLabel lblLogo = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/info.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		
		lblLogo.setBounds(0, 167, 101, 53);
		contentPane.add(lblLogo);
		
		textAddress = new JTextField();
		textAddress.setBounds(85, 71, 282, 20);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		JLabel lbladress = new JLabel("Address");
		lbladress.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lbladress.setBounds(21, 74, 54, 14);
		contentPane.add(lbladress);
		
		JLabel lblCopyright1 = new JLabel("Copyright \u00A9 2017  All rights reserved by");
		lblCopyright1.setVerticalAlignment(SwingConstants.TOP);
		lblCopyright1.setBounds(111, 167, 244, 14);
		contentPane.add(lblCopyright1);
		
		JLabel lblCopyright2 = new JLabel("Mustafa Teyfik AVKAN");
		lblCopyright2.setBounds(111, 181, 244, 14);
		contentPane.add(lblCopyright2);
		
		JLabel lblCopright3 = new JLabel("Benokan KAFKAS");
		lblCopright3.setBounds(111, 195, 244, 14);
		contentPane.add(lblCopright3);
		
		String [] age = new String[100];
		for(int i=0;i<100;i++)
		{
			age[i]=String.valueOf(i);
		}
		ComboBoxModel mycombo = new DefaultComboBoxModel(age);
		
		JComboBox comboBoxAge = new JComboBox();
		comboBoxAge.setModel(mycombo);
		comboBoxAge.setBounds(266, 104, 101, 20);
		contentPane.add(comboBoxAge);
		
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblAge.setBounds(230, 107, 26, 14);
		contentPane.add(lblAge);
		
		
		
		
		
		
		JButton btnSave = new JButton("Save");
		Image imgSave=new ImageIcon(this.getClass().getResource("/save.png")).getImage();
		btnSave.setIcon(new ImageIcon(imgSave));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	            String name=textName.getText();
	            String surname=textSurname.getText();
				String nickname=textNickname.getText();
				String email=textEmail.getText();
				String address=textAddress.getText();
				String phone=textPhone.getText();
				String age=(String) comboBoxAge.getSelectedItem();
				Encryption e=new Encryption(String.valueOf(passwordField.getPassword()));
				String password = null;
				try {
					password = e.MakeToEncrypted();
				} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Connection mysql=null;
				try{
				
					
					 Class.forName("com.mysql.jdbc.Driver");
					 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
					Statement statement=mysql.createStatement();
					String sql="insert into userprofile"
							  +"(name,surname,nickname,email,address,phone,age)"
							  +"values('"+name+"','"+surname+"','"+nickname+"','"+email+"','"+address+"','"+phone+"','"+age+"')";
					
					String sql2="insert into user"
							  +"(username,password)"
							  +"values('"+nickname+"','"+password+"')";
					
					statement.execute(sql);
					statement.execute(sql2);
					
					JOptionPane.showMessageDialog(null, "You are successfully registered :)");
					dispose();
					
					
					
					
				}catch(Exception ex){ex.printStackTrace();}
				
				_loginGUI.setDefault();
			}
		});
		btnSave.setBounds(85, 227, 101, 23);
		contentPane.add(btnSave);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(266, 140, 101, 20);
		contentPane.add(passwordField);
		
		
		
		
	}
}
