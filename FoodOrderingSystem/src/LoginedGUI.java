import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginedGUI extends JFrame {

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
	

	/**
	 * Launch the application.
	 */
	public  void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new LoginedGUI();
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
	public LoginedGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("teetet");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbeMainoptions = new JTabbedPane(JTabbedPane.TOP);
		tabbeMainoptions.setBounds(10, 0, 414, 250);
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
		textEditName.setBounds(75, 11, 98, 20);
		panelEdit.add(textEditName);
		textEditName.setColumns(10);
		
		textEditSurname = new JTextField();
		textEditSurname.setBounds(282, 11, 86, 20);
		panelEdit.add(textEditSurname);
		textEditSurname.setColumns(10);
		
		textEditEmail = new JTextField();
		textEditEmail.setBounds(75, 42, 293, 20);
		panelEdit.add(textEditEmail);
		textEditEmail.setColumns(10);
		
		textEditPhone = new JTextField();
		textEditPhone.setBounds(75, 73, 98, 20);
		panelEdit.add(textEditPhone);
		textEditPhone.setColumns(10);
		
	
		
		
		
		JLabel lblEditSurname = new JLabel("Surname");
		lblEditSurname.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEditSurname.setBounds(217, 13, 58, 14);
		panelEdit.add(lblEditSurname);
		
		JLabel lblEditEmail= new JLabel("E-Mail");
		lblEditEmail.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEditEmail.setBounds(29, 44, 46, 14);
		panelEdit.add(lblEditEmail);
		
		JLabel lblEditPhone = new JLabel("Phone");
		lblEditPhone.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEditPhone.setBounds(32, 75, 46, 14);
		panelEdit.add(lblEditPhone);
		
		
		
		JLabel lblEditName = new JLabel("Name");
		lblEditName.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEditName.setBounds(34, 13, 39, 14);
		panelEdit.add(lblEditName);
		
		
		
		String [] age = new String[100];
		for(int i=0;i<100;i++)
		{
			age[i]=String.valueOf(i);
		}
		ComboBoxModel mycombo = new DefaultComboBoxModel(age);
		
		
		JComboBox comboEditBoxAge = new JComboBox();
		comboEditBoxAge.setBounds(282, 73, 86, 20);
		comboEditBoxAge.setModel(mycombo);
		panelEdit.add(comboEditBoxAge);
		
		JLabel lblEditAge = new JLabel("Age");
		lblEditAge.setFont(new Font("Lato Semibold", Font.BOLD, 13));
		lblEditAge.setBounds(250, 75, 26, 14);
		panelEdit.add(lblEditAge);
		
		JButton btnUserUpdate = new JButton("Update");
		Image imgUpdate=new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnUserUpdate.setIcon(new ImageIcon(imgUpdate));
		btnUserUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUserUpdate.setBounds(145, 127, 108, 36);
		panelEdit.add(btnUserUpdate);
		
		JPanel panelOrdered = new JPanel();
		tabbedPaneUseroptions.addTab("Ordered Food", null, panelOrdered, null);
		panelOrdered.setLayout(null);
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel panelBalance = new JPanel();
		tabbeMainoptions.addTab("Load Balance", null, panelBalance, null);
		panelBalance.setLayout(null);
		
		JButton btnLoadPay = new JButton("Pay");
		Image imgPay=new ImageIcon(this.getClass().getResource("/payment.png")).getImage();
		btnLoadPay.setIcon(new ImageIcon(imgPay));
		btnLoadPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				KofteciYusuf order=new KofteciYusuf();
				order.setVisible(true);
			}
		});
		buttonKofteciYusuf.setBounds(46, 11, 107, 64);
		panelOrderFood.add(buttonKofteciYusuf);
		JLabel lblNewLabel = new JLabel("Köfteci Yusuf");
		lblNewLabel.setBounds(56, 86, 86, 14);
		panelOrderFood.add(lblNewLabel);
		
		
		
		
		
		
		
		JButton buttonMcDonalds = new JButton("");
		Image imgMcDonalds=new ImageIcon(this.getClass().getResource("/mcds-logo.png")).getImage();
		buttonMcDonalds.setIcon(new ImageIcon(imgMcDonalds));
		buttonMcDonalds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				McDonalds order=new McDonalds();
				order.setVisible(true);
			}
		});
		buttonMcDonalds.setBounds(217, 11, 107, 64);
		panelOrderFood.add(buttonMcDonalds);
		
		JLabel lblNewLabel_1 = new JLabel("McDonalds");
		lblNewLabel_1.setBounds(241, 86, 57, 14);
		panelOrderFood.add(lblNewLabel_1);
		
		
		
		
		
		
		JButton buttonGazinantep = new JButton("");
		Image imgGaz=new ImageIcon(this.getClass().getResource("/gaziantepliler-logo.png")).getImage();
		buttonGazinantep.setIcon(new ImageIcon(imgGaz));
		buttonGazinantep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Altineller order=new Altineller();
				order.setVisible(true);
				
			}
		});
		buttonGazinantep.setBounds(46, 122, 107, 64);
		panelOrderFood.add(buttonGazinantep);
		
		JLabel lblNewLabel_2 = new JLabel("Gaziantep Altineller");
		lblNewLabel_2.setBounds(44, 197, 122, 14);
		panelOrderFood.add(lblNewLabel_2);
		
		
		
		
		
		JButton buttonFishi = new JButton("");
		buttonFishi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FISHI order=new FISHI();
				order.setVisible(true);
			}
		});
		Image imgFishi=new ImageIcon(this.getClass().getResource("/fish-logo.png")).getImage();
		buttonFishi.setIcon(new ImageIcon(imgFishi));
		buttonFishi.setBounds(217, 122, 107, 64);
		panelOrderFood.add(buttonFishi);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("FISHI");
		lblNewLabel_3.setBounds(257, 197, 41, 14);
		panelOrderFood.add(lblNewLabel_3);
	}
}
