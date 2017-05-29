import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.joda.time.format.DateTimeFormat;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;

public class LoginedGUI extends JFrame {
    
	private String _id;
	private String _username;
	private JPanel contentPane;
	private JTextField textName,textEditName;
	private JTextField textSurname,textEditSurname;
	private JTextField textEmail,textEditEmail;
	private JTextField textPhone,textEditPhone;
	private JTextField textAge;
	private JTextField textBalance;
	private JTextField textNowBalance;
	private JTextField textPayment;
	private LoginedGUI frame;
	private JComboBox comboEditBoxAge;
	private JTextField textEditAddress;
	private JTable table;
	private JScrollPane scrollPane;
	private JPasswordField passwordPassword;
	private JTextField textOrderId;
	private Encryption en;
	
	public LoginedGUI getLoginedGUI(){return this;}
	
	
	public void updateOrderedFood(){
		Connection mysql=null;
		java.sql.PreparedStatement pst=null;
		try{
			 Class.forName("com.mysql.jdbc.Driver");
			 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");				 
			 String sql = "select orderId,restaurant,food,number,price,date from orderedfood where iduser = '"+_id+"'   ";
			 pst=mysql.prepareStatement(sql);
			ResultSet result=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(result));
			//scrollPane.setModel JScrollPane scrollPane
			
			
		}catch(Exception ex){ex.printStackTrace();}
	}
    public void setinfo(){
    	
    	Connection mysql=null;
		try{
			 Class.forName("com.mysql.jdbc.Driver");
			 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
			Statement statement=mysql.createStatement();
			ResultSet result=statement.executeQuery("select * from userprofile");
			
			while(result.next())
			{
				
				if(_id.equals(result.getString("id")) )
				{
					
					textName.setText(result.getString("name"));
					textSurname.setText(result.getString("surname"));
					textEmail.setText(result.getString("email"));
					textPhone.setText(result.getString("phone"));
					textAge.setText(result.getString("age"));
					textBalance.setText(result.getString("loadbalance"));
					textNowBalance.setText(result.getString("loadbalance"));
					break;
				}
				
					//System.out.println(result.getString("iduser")+result.getString("username")+","+result.getString("password"));
			}
			
		}catch(Exception ex){ex.printStackTrace();}
		
		        
    	
    }
    
    
    
    public void setEdit(){
    	
    	Connection mysql=null;
		try{
			 Class.forName("com.mysql.jdbc.Driver");
			 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
			Statement statement=mysql.createStatement();
			ResultSet result=statement.executeQuery("select * from userprofile");
			
			while(result.next())
			{
				
				if(_id.equals(result.getString("id")) )
				{
					
					textEditName.setText(result.getString("name"));
					textEditSurname.setText(result.getString("surname"));
					textEditEmail.setText(result.getString("email"));
					textEditPhone.setText(result.getString("phone"));
					textEditAddress.setText(result.getString("address"));
					comboEditBoxAge.setSelectedItem(result.getString("age"));
					textNowBalance.setText(result.getString("loadbalance"));
					
					
					break;
				}
				
					//System.out.println(result.getString("iduser")+result.getString("username")+","+result.getString("password"));
			}
			
		}catch(Exception ex){ex.printStackTrace();}
		
		        
    	
    }
    void update(){
    	setinfo();
    }
    
    
	
    
	public  void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				   // frame = new LoginedGUI(int id, String username ,String password);
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LoginedGUI(String id) {
		
		_id=id; 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setToolTipText("teetet");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbeMainoptions = new JTabbedPane(JTabbedPane.TOP);
		tabbeMainoptions.setBounds(10, 0, 420, 255);
		contentPane.add(tabbeMainoptions);
		
		JPanel panelUserInfo = new JPanel();
		tabbeMainoptions.addTab("User Info", null, panelUserInfo, null);
		panelUserInfo.setLayout(null);
		
		JTabbedPane tabbedPaneUseroptions = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneUseroptions.setBounds(2, 0, 402, 220);
		panelUserInfo.add(tabbedPaneUseroptions);
		
		JPanel panelProfile = new JPanel();
		tabbedPaneUseroptions.addTab("Profile", null, panelProfile, null);
		panelProfile.setLayout(null);
		
		textName = new JTextField();
		textName.setBounds(75, 11, 98, 20);
		panelProfile.add(textName);
		textName.setColumns(10);
		
		textSurname = new JTextField();
		textSurname.setBounds(282, 11, 86, 20);
		panelProfile.add(textSurname);
		textSurname.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(75, 42, 293, 20);
		panelProfile.add(textEmail);
		textEmail.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setBounds(75, 73, 98, 20);
		panelProfile.add(textPhone);
		textPhone.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(282, 73, 86, 20);
		panelProfile.add(textAge);
		textAge.setColumns(10);
		
		textBalance = new JTextField();
		textBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		textBalance.setBounds(178, 115, 98, 20);
		panelProfile.add(textBalance);
		textBalance.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblName.setBounds(34, 13, 40, 14);
		panelProfile.add(lblName);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEmail.setBounds(29, 44, 46, 14);
		panelProfile.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblPhone.setBounds(32, 75, 46, 14);
		panelProfile.add(lblPhone);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblAge.setBounds(250, 75, 26, 14);
		panelProfile.add(lblAge);
		
		JLabel lblBalance = new JLabel("Load Balance");
		lblBalance.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblBalance.setBounds(85, 117, 88, 14);
		panelProfile.add(lblBalance);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblSurname.setBounds(217, 13, 58, 14);
		panelProfile.add(lblSurname);
		
		
		
		
		
		
		JPanel panelEdit = new JPanel();
		tabbedPaneUseroptions.addTab("Edit", null, panelEdit, null);
		panelEdit.setLayout(null);
	
		
		textEditName = new JTextField();
		textEditName.setBounds(55, 11, 75, 20);
		panelEdit.add(textEditName);
		textEditName.setColumns(10);
		
		textEditSurname = new JTextField();
		textEditSurname.setBounds(216, 11, 75, 20);
		panelEdit.add(textEditSurname);
		textEditSurname.setColumns(10);
		
		textEditEmail = new JTextField();
		textEditEmail.setBounds(55, 42, 332, 20);
		panelEdit.add(textEditEmail);
		textEditEmail.setColumns(10);
		
		textEditPhone = new JTextField();
		textEditPhone.setBounds(55, 104, 75, 20);
		panelEdit.add(textEditPhone);
		textEditPhone.setColumns(10);
		
		
		
		
		
		JLabel lblEditSurname = new JLabel("Surname");
		lblEditSurname.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEditSurname.setBounds(148, 13, 58, 14);
		panelEdit.add(lblEditSurname);
		
		JLabel lblEditEmail= new JLabel("E-Mail");
		lblEditEmail.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEditEmail.setBounds(0, 44, 46, 14);
		panelEdit.add(lblEditEmail);
		
		JLabel lblEditPhone = new JLabel("Phone");
		lblEditPhone.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEditPhone.setBounds(0, 106, 46, 14);
		panelEdit.add(lblEditPhone);
		
		
		
		JLabel lblEditName = new JLabel("Name");
		lblEditName.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEditName.setBounds(0, 13, 39, 14);
		panelEdit.add(lblEditName);
		
		
		
		String [] age = new String[100];
		for(int i=0;i<100;i++)
		{
			age[i]=String.valueOf(i);
		}
		ComboBoxModel mycombo = new DefaultComboBoxModel(age);
		
		
		 comboEditBoxAge = new JComboBox();
		comboEditBoxAge.setBounds(348, 11, 39, 20);
		comboEditBoxAge.setModel(mycombo);
		panelEdit.add(comboEditBoxAge);
		
		JLabel lblEditAge = new JLabel("Age");
		lblEditAge.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEditAge.setBounds(312, 13, 26, 14);
		panelEdit.add(lblEditAge);
		
		JButton btnUserUpdate = new JButton("Update Information");
		Image imgUpdate=new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnUserUpdate.setIcon(new ImageIcon(imgUpdate));
		btnUserUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Connection mysql=null;
				try{
					 Class.forName("com.mysql.jdbc.Driver");
					 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
					Statement statement=mysql.createStatement();
					ResultSet result=statement.executeQuery("select * from userprofile");
					
					
					
					
					while(result.next())
					{
						
						if(_id.equals(result.getString("id")) )
						{
							
						    String sql="update  userprofile set name= '"+textEditName.getText()+"', surname= '"+textEditSurname.getText()+"',email='"+textEditEmail.getText()+"',address='"+textEditAddress.getText()+"',phone='"+textEditPhone.getText()+"',age='"+comboEditBoxAge.getSelectedItem()+"' where id='"+_id+"'  ";                              
									  
									  	   
								       
							
							statement.executeUpdate(sql);
							setinfo();
							setEdit();
							JOptionPane.showMessageDialog(null, "Your information has already updated.");
							break;
						}
						
							//System.out.println(result.getString("iduser")+result.getString("username")+","+result.getString("password"));
					}
					
				}catch(Exception ex){ex.printStackTrace();}
				
				
			}
		});
		btnUserUpdate.setBounds(10, 161, 185, 31);
		panelEdit.add(btnUserUpdate);
		
		textEditAddress = new JTextField();
		textEditAddress.setBounds(55, 73, 332, 20);
		panelEdit.add(textEditAddress);
		textEditAddress.setColumns(10);
		
		JLabel lblEditAddress = new JLabel("Address");
		lblEditAddress.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEditAddress.setBounds(0, 75, 55, 14);
		panelEdit.add(lblEditAddress);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblPassword.setBounds(140, 106, 66, 14);
		panelEdit.add(lblPassword);
		
		JButton btnUpdatePassword = new JButton("Update Password");
		Image imgUpdatePassword=new ImageIcon(this.getClass().getResource("/lock-icon.png")).getImage();
		btnUpdatePassword.setIcon(new ImageIcon(imgUpdatePassword));
		btnUpdatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection mysql=null;
				try{
					 Class.forName("com.mysql.jdbc.Driver");
					 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
					Statement statement=mysql.createStatement();
					ResultSet result=statement.executeQuery("select * from user");
					 en=new Encryption(String.valueOf(passwordPassword.getPassword()));
					
					
					
					while(result.next())
					{
						
						if(_id.equals(result.getString("iduser")) )
						{
							
						    String sql="update  user set password= '"+en.MakeToEncrypted()+"' where iduser='"+_id+"'  ";                              
									  
									  	   
								       
							
							statement.executeUpdate(sql);
							
							JOptionPane.showMessageDialog(null, "Your password has already changed.");
							passwordPassword.setText("");
							break;
						}
						
							//System.out.println(result.getString("iduser")+result.getString("username")+","+result.getString("password"));
					}
					
				}catch(Exception ex){ex.printStackTrace();}
				
				
				
			}
		});
		btnUpdatePassword.setBounds(202, 161, 185, 31);
		panelEdit.add(btnUpdatePassword);
		
		passwordPassword = new JPasswordField();
		passwordPassword.setBounds(216, 104, 171, 20);
		panelEdit.add(passwordPassword);
		
		JPanel panelOrdered = new JPanel();
		tabbedPaneUseroptions.addTab("Ordered Food", null, panelOrdered, null);
		panelOrdered.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(4, 5, 389, 147);
		panelOrdered.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnShowOrder = new JButton("Show");
		Image imgOrder=new ImageIcon(this.getClass().getResource("/order-icon.png")).getImage();
		btnShowOrder.setIcon(new ImageIcon(imgOrder));
		btnShowOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateOrderedFood();
				
			}
		});
		btnShowOrder.setBounds(285, 169, 102, 23);
		panelOrdered.add(btnShowOrder);
		
		JButton btnCancel = new JButton("Cancel");
		Image imgCancel=new ImageIcon(this.getClass().getResource("/cancel-icon.png")).getImage();
		btnCancel.setIcon(new ImageIcon(imgCancel));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection mysql=null;
				try{
					 Class.forName("com.mysql.jdbc.Driver");
					 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
					Statement statement1=mysql.createStatement();
					Statement statement2=mysql.createStatement();
					
						   ResultSet result=statement1.executeQuery("select * from orderedfood where orderId='"+textOrderId.getText()+"' ");
					try{		  
						   result.next();
						   
						   DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
						   LocalDateTime userDateTime = LocalDateTime.parse(result.getString("date"), formatter);
						   userDateTime=userDateTime.plusMinutes(1);
						   LocalDateTime currentDateTime = LocalDateTime.now();
						   
						  
						   String sql="delete from  orderedfood  where orderId='"+textOrderId.getText()+"'  ";
						   if(userDateTime.isAfter(currentDateTime))
						   {
							   int i=statement2.executeUpdate(sql);	
								if(i==0)
								{
									JOptionPane.showMessageDialog(null, "You have entered wrong ID.");	
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Your order has already canceled.");
									updateOrderedFood();
								}
						   }
						   else
						   {
							        JOptionPane.showMessageDialog(null, "Order can not be canceled"+"-Time Out-");	
							   
						   }
					} catch(Exception ex1){ JOptionPane.showMessageDialog(null, "Your input is invalid, please try again");} 						  
					
							       
					
					}

				    catch(Exception ex){ex.printStackTrace();}
				
			}
		});
		
		
		btnCancel.setBounds(176, 169, 102, 23);
		panelOrdered.add(btnCancel);
		
		textOrderId = new JTextField();
		textOrderId.setBounds(117, 170, 53, 20);
		panelOrdered.add(textOrderId);
		textOrderId.setColumns(10);
		
		JLabel lblCancelOrder = new JLabel("Cancel Order Id :");
		lblCancelOrder.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblCancelOrder.setBounds(4, 172, 118, 14);
		panelOrdered.add(lblCancelOrder);
		
		
		
		JPanel panelBalance = new JPanel();
		tabbeMainoptions.addTab("Load Balance", null, panelBalance, null);
		panelBalance.setLayout(null);
		
		JButton btnLoadPay = new JButton("Pay");
		Image imgPay=new ImageIcon(this.getClass().getResource("/payment.png")).getImage();
		btnLoadPay.setIcon(new ImageIcon(imgPay));
		btnLoadPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection mysql=null;
				try{
					 Class.forName("com.mysql.jdbc.Driver");
					 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
					Statement statement=mysql.createStatement();
					ResultSet result=statement.executeQuery("select * from userprofile");
					
					while(result.next())
					{
						
						if(_id.equals(result.getString("id")) )
						{
							
							
							if(0<= Double.parseDouble(textPayment.getText()))
							{
								double add=Double.parseDouble(textPayment.getText())+  Double.parseDouble(result.getString("loadbalance"));
								String temp=String.valueOf(add);
	                            String sql="update  userprofile set loadbalance= '"+temp+"' where id='"+_id+"'  ";                              
								
								statement.executeUpdate(sql);
								setinfo();
								setEdit();
								JOptionPane.showMessageDialog(null, "Your payment has been added in your load balance");
							}
							
							else
							{
								
								
								JOptionPane.showMessageDialog(null, "Operation Refused!!!");
								
								
							}
							
							
							break;
						}
						
							//System.out.println(result.getString("iduser")+result.getString("username")+","+result.getString("password"));
					}
					
				}catch(Exception ex){ex.printStackTrace();}
				
				
				
				
			}
		});
		
		btnLoadPay.setBounds(149, 152, 108, 36);
		panelBalance.add(btnLoadPay);
		
		textNowBalance = new JTextField();
		textNowBalance.setBounds(149, 31, 108, 26);
		panelBalance.add(textNowBalance);
		textNowBalance.setColumns(10);
		
		textPayment = new JTextField();
		textPayment.setBounds(149, 80, 108, 26);
		panelBalance.add(textPayment);
		textPayment.setColumns(10);
		
		JLabel lblLoadPayment = new JLabel("Your Payment");
		lblLoadPayment.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblLoadPayment.setBounds(39, 83, 100, 14);
		panelBalance.add(lblLoadPayment);
		
		JLabel lblLoadBalance = new JLabel("Your Load Balance");
		lblLoadBalance.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblLoadBalance.setBounds(10, 37, 129, 14);
		panelBalance.add(lblLoadBalance);
		
		JPanel panelOrderFood = new JPanel();
		tabbeMainoptions.addTab("Order Food", null, panelOrderFood, null);
		panelOrderFood.setLayout(null);
		
		
		
		
		JButton buttonKofteciYusuf = new JButton("");
		Image imgKofte=new ImageIcon(this.getClass().getResource("/köfteciyusuf-logo"
				+ ".png")).getImage();
		buttonKofteciYusuf.setIcon(new ImageIcon(imgKofte));
		buttonKofteciYusuf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				KofteciYusuf order=new KofteciYusuf(_id,2,getLoginedGUI());
				order.setVisible(true);
			}
		});
		buttonKofteciYusuf.setBounds(59, 11, 107, 64);
		panelOrderFood.add(buttonKofteciYusuf);
		JLabel lblKofte = new JLabel("Köfteci Yusuf");
		lblKofte.setBounds(80, 86, 86, 14);
		panelOrderFood.add(lblKofte);
		
		
		
		
		
		
		
		JButton buttonMcDonalds = new JButton("");
		Image imgMcDonalds=new ImageIcon(this.getClass().getResource("/mcds-logo.png")).getImage();
		buttonMcDonalds.setIcon(new ImageIcon(imgMcDonalds));
		buttonMcDonalds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				McDonalds order=new McDonalds(_id,3,getLoginedGUI());
				order.setVisible(true);
			}
		});
		buttonMcDonalds.setBounds(241, 11, 107, 64);
		panelOrderFood.add(buttonMcDonalds);
		
		JLabel lblMcdonalds = new JLabel("McDonalds");
		lblMcdonalds.setBounds(262, 86, 57, 14);
		panelOrderFood.add(lblMcdonalds);
		
		
		
		
		
		
		JButton buttonGazinantep = new JButton("");
		Image imgGaz=new ImageIcon(this.getClass().getResource("/gaziantepliler-logo.png")).getImage();
		buttonGazinantep.setIcon(new ImageIcon(imgGaz));
		buttonGazinantep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Altineller order=new Altineller(_id,4,getLoginedGUI());
				order.setVisible(true);
				
			}
		});
		buttonGazinantep.setBounds(59, 122, 107, 64);
		panelOrderFood.add(buttonGazinantep);
		
		JLabel lblGaziantep = new JLabel("Gaziantep Altineller");
		lblGaziantep.setBounds(69, 197, 122, 14);
		panelOrderFood.add(lblGaziantep);
		
		
		
		
		
		JButton buttonFishi = new JButton("");
		buttonFishi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FISHI order=new FISHI(_id,1,getLoginedGUI());
				order.setVisible(true);
			}
		});
		Image imgFishi=new ImageIcon(this.getClass().getResource("/fish-logo.png")).getImage();
		buttonFishi.setIcon(new ImageIcon(imgFishi));
		buttonFishi.setBounds(241, 122, 107, 64);
		panelOrderFood.add(buttonFishi);
		
		
		
		JLabel lblFishi = new JLabel("FISHI");
		lblFishi.setBounds(276, 197, 27, 14);
		panelOrderFood.add(lblFishi);
		
	
		setinfo();
		setEdit();
	}
}
