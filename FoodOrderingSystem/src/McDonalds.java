import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class McDonalds extends JFrame {
    private int _idRes;
    private String _idUser;
    private LoginedGUI loginedGUI;
	private JPanel contentPane;
    private McDonalds frame;
    private JTextField textFieldPrice1;
    private JTextField textFieldTotal;
    private JTextField textFieldPrice2;
    private JTextField textFieldPrice3;
    private JTextField textFieldPrice4;
    private JLabel lblFood1,lblFood2,lblFood3,lblFood4;
    private JLabel lblPrice1,lblPrice2,lblPrice3,lblPrice4;
    private JComboBox comboBox1,comboBox2,comboBox3,comboBox4;
    
    public String newFoodId()
	{
		int passwordSize = 6;
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
    
    @SuppressWarnings("resource")
	public String checkOrderId()
	{
    	Connection mysql=null;
    	String orderId=newFoodId();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
			Statement statement=mysql.createStatement();
			ResultSet result=statement.executeQuery("select * from orderedfood");
			ResultSet result2=result;
			
			
			
			while(result.next())
			{
				
				  
				
					if(orderId.equals(result.getString("orderId")))
					{
						orderId=newFoodId();
						result=result2;
					}
					
					
				
				
					//System.out.println(result.getString("iduser")+result.getString("username")+","+result.getString("password"));
			}
			
		}catch(Exception ex){ex.printStackTrace();}
	   return orderId;
	}
    
    public void totalprice(){
    	textFieldTotal.setText( String.valueOf(  Double.parseDouble(textFieldPrice1.getText())
    			                                +Double.parseDouble(textFieldPrice2.getText()) 
    			                                +Double.parseDouble(textFieldPrice3.getText())
    			                                +Double.parseDouble(textFieldPrice4.getText()) 
    			                              ) );
    }
    
    public boolean checkbalance() throws SQLException, ClassNotFoundException{
    	
    	String balance = null;
		Connection mysql=null;
		try{
			 Class.forName("com.mysql.jdbc.Driver");
			 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
			Statement statement=mysql.createStatement();
			ResultSet result=statement.executeQuery("select * from userprofile");
			
			while(result.next())
			{
				if(_idUser.equals(result.getString("id")))
				{
					balance=result.getString("loadbalance");
				}
				
				
					
			}
			
		}catch(Exception ex){ex.printStackTrace();}
		
		         
		    if(Double.parseDouble(balance)>Double.parseDouble(textFieldTotal.getText()))
		    {

		    	Class.forName("com.mysql.jdbc.Driver");
				mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
				Statement statementUp=mysql.createStatement();
		    	String sql="update  userprofile set loadbalance='"+String.valueOf((Double.parseDouble(balance)-Double.parseDouble(textFieldTotal.getText())))+"' where id='"+Integer.parseInt(_idUser)+"'  ";                              
				  
			  	   
			       
				
				statementUp.executeUpdate(sql);
		    	return true;
		    }
		    else
		    {
		    	return false;
		    }
    	
    	
    	
    	
    }
    
    public void setFoodPrice(){
    	String [] food= new String[4];
    	String [] price= new String[4];
    	int cnt=0;
    	Connection mysql=null;
		try{
			 Class.forName("com.mysql.jdbc.Driver");
			 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
			Statement statement=mysql.createStatement();
			ResultSet result=statement.executeQuery("select * from foodprice");
			
			
			
			
			while(result.next())
			{
				
				if(String.valueOf(_idRes).equals(result.getString("idres")) )
				{
					
					food[cnt]=result.getString("food")+":";
					price[cnt]=result.getString("price");
					//lblFood1.setText(result.getString("food"));  
						      
					
				
					cnt++;
				}
				
				lblFood1.setText(food[0]);
				lblFood2.setText(food[1]);
				lblFood3.setText(food[2]);
				lblFood4.setText(food[3]);
				lblPrice1.setText(price[0]);
				lblPrice2.setText(price[1]);
				lblPrice3.setText(price[2]);
				lblPrice4.setText(price[3]);
			}
			
		}catch(Exception ex){ex.printStackTrace();}
    	
    	
    }
    
    
    public void setComboBox(JComboBox jcb){
    	String [] age = new String[100];
		for(int i=0;i<100;i++)
		{
			age[i]=String.valueOf(i);
		}
		ComboBoxModel mycombo = new DefaultComboBoxModel(age);
		jcb.setModel(mycombo);
		
    	
    }
	
	public  void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	 frame = new McDonalds();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public McDonalds(String idUser,int idRes,Object lg) {
		 _idUser=idUser; _idRes=idRes; loginedGUI=(LoginedGUI) lg;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblFood1 = new JLabel("");
		lblFood1.setFont(new Font("Lato Semibold", Font.BOLD, 11));
		lblFood1.setBounds(0, 42, 198, 21);
		contentPane.add(lblFood1);
		
		textFieldPrice1 = new JTextField();
		textFieldPrice1.setText("0");
		textFieldPrice1.setBounds(338, 40, 86, 20);
		contentPane.add(textFieldPrice1);
		textFieldPrice1.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblTotal.setBounds(288, 164, 46, 14);
		contentPane.add(lblTotal);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setText("0");
		textFieldTotal.setBounds(338, 162, 86, 20);
		contentPane.add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		comboBox1 = new JComboBox();
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldPrice1.setText(String.valueOf(Double.parseDouble(lblPrice1.getText())*Double.parseDouble((String) comboBox1.getSelectedItem())));	
				totalprice();
			}
		});
		setComboBox(comboBox1);
		comboBox1.setBounds(288, 40, 46, 20);
		contentPane.add(comboBox1);
		
		lblPrice1 = new JLabel("");
		lblPrice1.setFont(new Font("Lato Semibold", Font.BOLD, 11));
		lblPrice1.setBounds(204, 45, 33, 14);
		contentPane.add(lblPrice1);
		
		lblFood2 = new JLabel("");
		lblFood2.setFont(new Font("Lato Semibold", Font.BOLD, 11));
		lblFood2.setBounds(0, 70, 198, 21);
		contentPane.add(lblFood2);
		
		lblPrice2 = new JLabel("");
		lblPrice2.setFont(new Font("Lato Semibold", Font.BOLD, 11));
		lblPrice2.setBounds(204, 73, 33, 14);
		contentPane.add(lblPrice2);
		
		comboBox2 = new JComboBox();
		comboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldPrice2.setText(String.valueOf(Double.parseDouble(lblPrice2.getText())*Double.parseDouble((String) comboBox2.getSelectedItem())));	
				totalprice();
			}
		});
		setComboBox(comboBox2);
		comboBox2.setBounds(288, 68, 46, 20);
		contentPane.add(comboBox2);
		
		textFieldPrice2 = new JTextField();
		textFieldPrice2.setText("0");
		textFieldPrice2.setColumns(10);
		textFieldPrice2.setBounds(338, 68, 86, 20);
		contentPane.add(textFieldPrice2);
		
		lblFood3 = new JLabel("");
		lblFood3.setFont(new Font("Lato Semibold", Font.BOLD, 11));
		lblFood3.setBounds(0, 98, 198, 21);
		contentPane.add(lblFood3);
		
		lblPrice3 = new JLabel("");
		lblPrice3.setFont(new Font("Lato Semibold", Font.BOLD, 11));
		lblPrice3.setBounds(204, 101, 33, 14);
		contentPane.add(lblPrice3);
		
		comboBox3 = new JComboBox();
		comboBox3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldPrice3.setText(String.valueOf(Double.parseDouble(lblPrice3.getText())*Double.parseDouble((String) comboBox3.getSelectedItem())));	
				totalprice();
			}
		});
		setComboBox(comboBox3);
		comboBox3.setBounds(288, 96, 46, 20);
		contentPane.add(comboBox3);
		
		textFieldPrice3 = new JTextField();
		textFieldPrice3.setText("0");
		textFieldPrice3.setColumns(10);
		textFieldPrice3.setBounds(338, 96, 86, 20);
		contentPane.add(textFieldPrice3);
		
		lblFood4 = new JLabel("");
		lblFood4.setFont(new Font("Lato Semibold", Font.BOLD, 11));
		lblFood4.setBounds(0, 126, 198, 21);
		contentPane.add(lblFood4);
		
		lblPrice4 = new JLabel("");
		lblPrice4.setFont(new Font("Lato Semibold", Font.BOLD, 11));
		lblPrice4.setBounds(204, 129, 33, 14);
		contentPane.add(lblPrice4);
		
		comboBox4 = new JComboBox();
		comboBox4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldPrice4.setText(String.valueOf(Double.parseDouble(lblPrice4.getText())*Double.parseDouble((String) comboBox4.getSelectedItem())));	
				totalprice();
			}
		});
		setComboBox(comboBox4);
		comboBox4.setBounds(288, 124, 46, 20);
		contentPane.add(comboBox4);
		
		textFieldPrice4 = new JTextField();
		textFieldPrice4.setText("0");
		textFieldPrice4.setColumns(10);
		textFieldPrice4.setBounds(338, 124, 86, 20);
		contentPane.add(textFieldPrice4);
		
		JButton btnOrder = new JButton("");
		Image imgOrder=new ImageIcon(this.getClass().getResource("/order-logo.png")).getImage();
		btnOrder.setIcon(new ImageIcon(imgOrder));
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(checkbalance())
					{   
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
						LocalDateTime now = LocalDateTime.now();
						
						
						String [] food=new String[4];
						String [] number=new String[4];
						String [] price=new String[4];
						
						food[0]=lblFood1.getText(); number[0]=(String) comboBox1.getSelectedItem(); price[0]=lblPrice1.getText();
						food[1]=lblFood2.getText(); number[1]=(String) comboBox2.getSelectedItem(); price[1]=lblPrice2.getText();
						food[2]=lblFood3.getText(); number[2]=(String) comboBox3.getSelectedItem(); price[2]=lblPrice3.getText();
						food[3]=lblFood4.getText(); number[3]=(String) comboBox4.getSelectedItem(); price[3]=lblPrice4.getText();
						
						
						Connection mysql=null;
						try{
							Class.forName("com.mysql.jdbc.Driver");
							 mysql=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foodorderingsystem", "teyfik", "123456789");
							Statement statement=mysql.createStatement();
							String code=checkOrderId();
							for(int i=0;i<4;i++)
							{
								if(Integer.parseInt(number[i])==0)
								{
									
								}
								else
								{   
									
								   String p=String.valueOf( Double.parseDouble(number[i])*Double.parseDouble(price[i]));
									String d=dtf.format(now);
									String sql="insert into orderedfood"
											  +"(iduser,orderId,restaurant,food,number,price,date)"
											  +"values('"+_idUser+"','"+code+"','McDonalds','"+food[i]+"','"+number[i]+"','"+p+"','"+d+"')";
									
									
									
									statement.execute(sql);
								}
								
							}
							 
							
							
							
							JOptionPane.showMessageDialog(null, "Your order has been received");
							
							loginedGUI.setinfo();
							
							
						}catch(Exception ex){ex.printStackTrace();}
						
						
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You have not enough loadbalance!!!");
					}
				} catch (HeadlessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnOrder.setBounds(191, 184, 46, 49);
		contentPane.add(btnOrder);
		Image imgTL=new ImageIcon(this.getClass().getResource("/tl-logo.png")).getImage();
		JLabel lblLogo1 = new JLabel("");
		lblLogo1.setIcon(new ImageIcon(imgTL));
		lblLogo1.setBounds(242, 45, 23, 12);
		contentPane.add(lblLogo1);
		
		JLabel lblLogo2 = new JLabel("");
		lblLogo2.setIcon(new ImageIcon(imgTL));
		lblLogo2.setBounds(242, 73, 23, 12);
		contentPane.add(lblLogo2);
		
		JLabel lblLogo3 = new JLabel("");
		lblLogo3.setIcon(new ImageIcon(imgTL));
		lblLogo3.setBounds(242, 101, 23, 12);
		contentPane.add(lblLogo3);
		
		JLabel lblLogo4 = new JLabel("");
		lblLogo4.setIcon(new ImageIcon(imgTL));
		lblLogo4.setBounds(242, 129, 23, 12);
		contentPane.add(lblLogo4);
		
		
		JLabel lblMcDonalds = new JLabel("");
		Image imgMcDonalds=new ImageIcon(this.getClass().getResource("/mcds-logo.png")).getImage();
		lblMcDonalds.setIcon(new ImageIcon(imgMcDonalds));
		lblMcDonalds.setBounds(10, 184, 98, 49);
		contentPane.add(lblMcDonalds);
		
		setFoodPrice();
	}

}
