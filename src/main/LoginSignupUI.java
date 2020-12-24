package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import java.awt.Panel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JCheckBox;

public class LoginSignupUI extends JFrame {
	
	public static LoginSignupUI frame; //first login UI frame variable
	private static JFrame dashboardJFrame;
	private JPanel contentPane; //JPanel variable
	private JTextField userNameTextField;
	private JTextField emailTextField;
	private JPasswordField passwordTextField;
	private JPasswordField conPasswordTextField;
	private JLabel bkImageLabel;
	private	int posX=0,posY=0;
	private JTextField logInUserNameTextField;
	private JPasswordField loginPasswordField;
	private JLayeredPane signUpLogInLayeredPane;
	private JPanel logInPanel;
	private JPanel signUpPanel;
	private Image crossLogo= new ImageIcon(LoginSignupUI.class.getResource("/images/cross.png")).getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
	private ButtonGroup userLoginCheckBoxGroup;
	private JCheckBox patientLoginCheckBox;
	private JCheckBox doctorLoginCheckBox;
	private JCheckBox nurseLoginCheckBox;
	private boolean patientSelected=false;
	private boolean doctorSelected=false;
	private boolean nurseSelected=false;
	private ButtonGroup userSignUpCheckBoxGroup;
	public static Dashboard dashboard;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginSignupUI();
					frame.setUndecorated(true);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//	public Dashboard getDashboardFrame() {
//		return this.dashboard;
//	}
	public LoginSignupUI() { //first login UI frame constructor.
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginSignupUI.class.getResource("/images/doctor.png")));
		setTitle("Medical Assistant");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 900, 600); // all properties of first main frame UI.
		
		loginPageContents();  //all other contents method.
		
	}
	
	public void switchLogInSignUpPanel(JPanel panel){
		signUpLogInLayeredPane.removeAll();
		signUpLogInLayeredPane.add(panel);
		signUpLogInLayeredPane.repaint();
		signUpLogInLayeredPane.revalidate();
	}
	
	public void loginPageContents() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * JPanel panel = new JPanel(); panel.setBackground(Color.WHITE);
		 * panel.setBounds(0, 0, 500, 600); contentPane.add(panel);
		 * panel.setLayout(null);
		 */
		
		
//		ImageIcon imgIcon=new ImageIcon(LoginSignupUI.class.getResource("/images/10198.jpg"));
//		
//		Image img=imgIcon.getImage();
//		Image tempImg=img.getScaledInstance(500, 600, Image.SCALE_SMOOTH);
//		imgIcon =new ImageIcon(tempImg);
//		bkImageLabel=new JLabel("",imgIcon,JLabel.CENTER);
		bkImageLabel = new JLabel("",new ImageIcon(LoginSignupUI.class.getResource("/images/121.png")),JLabel.CENTER);
		//lblNewLabel_3.setIcon(new ImageIcon(LoginSignupUI.class.getResource("/images/10198 Small Final.jpg")));
		bkImageLabel.setBounds(0, 0, 500, 563);
		//add(bkImageLabel);
		contentPane.add(bkImageLabel);
		
		signUpLogInLayeredPane = new JLayeredPane();
		signUpLogInLayeredPane.setForeground(Color.WHITE);
		signUpLogInLayeredPane.setBackground(Color.WHITE);
		signUpLogInLayeredPane.setBounds(500, 33, 386, 530);
		contentPane.add(signUpLogInLayeredPane);
		signUpLogInLayeredPane.setLayout(new CardLayout(0, 0));
		
		signUpPanel = new JPanel();
		signUpPanel.setForeground(Color.WHITE);
		signUpPanel.setBackground(Color.WHITE);
		signUpLogInLayeredPane.add(signUpPanel, "name_84000460423700");
		signUpPanel.setLayout(null);
		
		logInPanel = new JPanel();
		logInPanel.setForeground(Color.WHITE);
		logInPanel.setBackground(Color.WHITE);
		signUpLogInLayeredPane.add(logInPanel, "name_84044062427600");
		logInPanel.setLayout(null);
		
		JLabel logInUserNameLabel = new JLabel("USERNAME");
		logInUserNameLabel.setBounds(43, 140, 157, 26);
		logInPanel.add(logInUserNameLabel);
		
		logInUserNameTextField = new JTextField();
		logInUserNameTextField.setFont(new Font("Calibri", Font.PLAIN, 13));
		logInUserNameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		logInUserNameTextField.setBounds(43, 163, 283, 36);
		logInPanel.add(logInUserNameTextField);
		logInUserNameTextField.setColumns(10);
		
		JSeparator logInUserNameSeparator = new JSeparator();
		logInUserNameSeparator.setForeground(Color.BLACK);
		logInUserNameSeparator.setBackground(Color.BLACK);
		logInUserNameSeparator.setBounds(43, 199, 283, 1);
		logInPanel.add(logInUserNameSeparator);
		
		JLabel logInPasswordLabel = new JLabel("PASSWORD");
		logInPasswordLabel.setBounds(43, 212, 157, 26);
		logInPanel.add(logInPasswordLabel);
		
		loginPasswordField = new JPasswordField();
		loginPasswordField.setBounds(43, 235, 283, 36);
		loginPasswordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		logInPanel.add(loginPasswordField);
		
		Button logInPanelLogInButton = new Button("Log In");
		logInPanelLogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAuthentication auth=new UserAuthentication();
				String userName=logInUserNameTextField.getText().trim();
				String password=String.valueOf(loginPasswordField.getPassword()).trim();
				boolean authCheck=auth.verifyUser(userName, password);
				if(authCheck==true && doctorSelected==true ) {
					dashboard=new Dashboard(userName, frame);
					dashboard.setVisible(true);
					dashboard.switchDoctorPanel();
					frame.setVisible(false);
					//doctorSelected=false;
					
				}
				else if(authCheck==true && patientSelected==true) {
					dashboard=new Dashboard(userName, frame);
					dashboard.setVisible(true);
					dashboard.switchPatientPanel();
					frame.setVisible(false);
					//patientSelected=false;
					
				}
				else if(authCheck==true && nurseSelected==true) {
					dashboard=new Dashboard(userName, frame);
					dashboard.setVisible(true);
					dashboard.switchNursePanel();
					frame.setVisible(false);
					//nurseSelected=false;
					
				}
				else if(authCheck==false){
					JOptionPane.showMessageDialog(frame, "Wrong User Name or Password","Alert", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		logInPanelLogInButton.setForeground(Color.WHITE);
		logInPanelLogInButton.setBounds(43, 406, 283, 36);
		logInPanelLogInButton.setBackground(new Color(30, 144, 255));
		logInPanel.add(logInPanelLogInButton);
		
		JSeparator LogInPasswordSeparator = new JSeparator();
		LogInPasswordSeparator.setForeground(Color.BLACK);
		LogInPasswordSeparator.setBackground(Color.BLACK);
		LogInPasswordSeparator.setBounds(43, 271, 283, 1);
		logInPanel.add(LogInPasswordSeparator);
		
		patientLoginCheckBox = new JCheckBox("Log In as Patient");
		patientLoginCheckBox.setBackground(Color.WHITE);
		patientLoginCheckBox.setBounds(43, 296, 119, 26);
		logInPanel.add(patientLoginCheckBox);
		patientLoginCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(patientLoginCheckBox.isSelected()) {
					patientSelected=true;
					doctorSelected=false;
					nurseSelected=false;
				}
			}
		});
		
		
		doctorLoginCheckBox = new JCheckBox("Log In as Doctor");
		doctorLoginCheckBox.setBackground(Color.WHITE);
		doctorLoginCheckBox.setBounds(43, 327, 119, 26);
		logInPanel.add(doctorLoginCheckBox);
		doctorLoginCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doctorSelected=true;
				patientSelected=false;
				nurseSelected=false;
			}
		});
		
		nurseLoginCheckBox = new JCheckBox("Log In as Nurse");
		nurseLoginCheckBox.setBackground(Color.WHITE);
		nurseLoginCheckBox.setBounds(43, 356, 119, 26);
		logInPanel.add(nurseLoginCheckBox);
		nurseLoginCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nurseSelected=true;
				patientSelected=false;
				doctorSelected=false;
			}
		});
		
		userLoginCheckBoxGroup=new ButtonGroup();
		userLoginCheckBoxGroup.add(patientLoginCheckBox);
		userLoginCheckBoxGroup.add(doctorLoginCheckBox);
		userLoginCheckBoxGroup.add(nurseLoginCheckBox);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchLogInSignUpPanel(signUpPanel);
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(150, 463, 103, 26);
		lblNewLabel.setForeground(new Color(241,57,83));
		logInPanel.add(lblNewLabel);
		
		JSeparator signUpSeparator = new JSeparator();
		signUpSeparator.setBounds(148, 488, 70, 2);
		logInPanel.add(signUpSeparator);
		
		JLabel userNameLabel = new JLabel("USERNAME");
		userNameLabel.setBounds(43, 61, 157, 26);
		signUpPanel.add(userNameLabel);
		//bkImageLabel.add(userNameLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("Calibri", Font.PLAIN, 13));
		userNameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		userNameTextField.setBounds(43, 84, 283, 36);
		userNameTextField.setColumns(10);
		signUpPanel.add(userNameTextField);
		
		//bkImageLabel.add(userNameTextField);
		
		JSeparator userNameSeparator = new JSeparator();
		userNameSeparator.setForeground(Color.BLACK);
		userNameSeparator.setBackground(Color.BLACK);
		userNameSeparator.setBounds(43, 120, 283, 1);
		signUpPanel.add(userNameSeparator);
		//bkImageLabel.add(separator);
		
		JLabel emailLabel = new JLabel("EMAIL");
		emailLabel.setBounds(43, 140, 157, 26);
		signUpPanel.add(emailLabel);
		//bkImageLabel.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Calibri", Font.PLAIN, 13));
		emailTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		emailTextField.setBounds(43, 162, 283, 36);
		emailTextField.setColumns(10);
		signUpPanel.add(emailTextField);
		//bkImageLabel.add(emailTextField);
		
		JSeparator emailSeparator = new JSeparator();
		emailSeparator.setForeground(Color.BLACK);
		emailSeparator.setBackground(Color.BLACK);
		emailSeparator.setBounds(43, 198, 283, 1);
		signUpPanel.add(emailSeparator);
		//bkImageLabel.add(separator_1);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setBounds(43, 214, 157, 26);
		signUpPanel.add(passwordLabel);
		//bkImageLabel.add(passwordLabel);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		passwordTextField.setBounds(43, 237, 283, 36);
		signUpPanel.add(passwordTextField);
		//bkImageLabel.add(passwordTextField);
		
		JSeparator passwordSeparator = new JSeparator();
		passwordSeparator.setBackground(Color.BLACK);
		passwordSeparator.setForeground(Color.BLACK);
		passwordSeparator.setBounds(43, 273, 283, 1);
		signUpPanel.add(passwordSeparator);
		//bkImageLabel.add(separator_1_1);
		
		JLabel conPasswordLabel = new JLabel("CONFIRM PASSWORD");
		conPasswordLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		conPasswordLabel.setBounds(43, 290, 157, 26);
		signUpPanel.add(conPasswordLabel);
		//bkImageLabel.add(conPasswordTextField_1);
		
		conPasswordTextField = new JPasswordField();
		conPasswordTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		conPasswordTextField.setBounds(43, 312, 283, 36);
		signUpPanel.add(conPasswordTextField);
		//bkImageLabel.add(conPasswordTextField);
		
		JSeparator conPasswordSeparator = new JSeparator();
		conPasswordSeparator.setBackground(Color.BLACK);
		conPasswordSeparator.setForeground(Color.BLACK);
		conPasswordSeparator.setBounds(43, 348, 283, 1);
		signUpPanel.add(conPasswordSeparator);
		//bkImageLabel.add(separator_1_1_1);
		
		Button signUpButton = new Button("Sign UP");
		signUpButton.setActionCommand("Sign Up");
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAuthentication userAuth=new UserAuthentication();
				String tempUserName= userNameTextField.getText().trim();
				String tempEmail= emailTextField.getText().trim();
				String tempPassword= String.valueOf(passwordTextField.getPassword()).trim();
				String tempConPassWord= String.valueOf(conPasswordTextField.getPassword()).trim();
				boolean multiCheck=userAuth.checkMultipleUser(tempUserName);
				if(multiCheck==true) {
					JOptionPane.showMessageDialog(frame, "This user name Already exist!","Alert",JOptionPane.WARNING_MESSAGE);
				}
				else {
				userAuth.addUser(tempUserName, tempEmail, tempPassword, tempConPassWord);
				JOptionPane.showMessageDialog(frame, "Sign Up Successful","Success",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		signUpButton.setBounds(43, 420, 283, 36);
		signUpButton.setForeground(Color.BLACK);
		signUpButton.setBackground(new Color(241,57,83));
		signUpPanel.add(signUpButton);
		//bkImageLabel.add(signUpButton);
		
		JLabel orLabel = new JLabel("OR");
		orLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		orLabel.setBounds(174, 460, 52, 19);
		signUpPanel.add(orLabel);
		
		JCheckBox patientSignUpCheckBox = new JCheckBox("Sign Up as Patient");
		patientSignUpCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 9));
		patientSignUpCheckBox.setBackground(Color.WHITE);
		patientSignUpCheckBox.setBounds(6, 375, 125, 26);
		signUpPanel.add(patientSignUpCheckBox);
		
		JCheckBox doctorSignUpCheckBox = new JCheckBox("Sign Up as Doctor");
		doctorSignUpCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 9));
		doctorSignUpCheckBox.setBackground(Color.WHITE);
		doctorSignUpCheckBox.setBounds(133, 375, 122, 26);
		signUpPanel.add(doctorSignUpCheckBox);
		
		JCheckBox nurseSignUpCheckBox = new JCheckBox("Sign Up as Nurse");
		nurseSignUpCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 9));
		nurseSignUpCheckBox.setBackground(Color.WHITE);
		nurseSignUpCheckBox.setBounds(257, 375, 123, 26);
		signUpPanel.add(nurseSignUpCheckBox);
		
		userSignUpCheckBoxGroup=new ButtonGroup();
		userSignUpCheckBoxGroup.add(patientSignUpCheckBox);
		userSignUpCheckBoxGroup.add(doctorSignUpCheckBox);
		userSignUpCheckBoxGroup.add(nurseSignUpCheckBox);
		
		JLabel logInLabel = new JLabel("Log In");
		logInLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchLogInSignUpPanel(logInPanel);
			}
		});
		logInLabel.setForeground(new Color(30, 144, 255));
		logInLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		logInLabel.setBounds(157, 489, 85, 26);
		signUpPanel.add(logInLabel);
		
		JSeparator logInSeparator = new JSeparator();
		logInSeparator.setBounds(155, 514, 60, 2);
		signUpPanel.add(logInSeparator);
		
		JLabel exitLabelLogin = new JLabel("");
		exitLabelLogin.setIcon(new ImageIcon(crossLogo));
		//exitLabelLogin.setIcon(new ImageIcon(LoginSignupUI.class.getResource("/images/cross.png")));
		exitLabelLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exitLabelLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exitLabelLogin.setForeground(Color.WHITE);
		exitLabelLogin.setBounds(856, 4, 22, 22);
		exitLabelLogin.setBackground(Color.WHITE);
		contentPane.add(exitLabelLogin);
		//bkImageLabel.add(exitLabelLogin);
		
		JLabel minimizeLabel=new JLabel("",JLabel.CENTER);
		minimizeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(frame.ICONIFIED);
			}
		});
		minimizeLabel.setIcon(new ImageIcon(LoginSignupUI.class.getResource("/images/minus.png")));
		minimizeLabel.setBounds(807,0,30,30);
		contentPane.add(minimizeLabel);
		
		JLabel topBarLabel = new JLabel("");
		topBarLabel.setIcon(new ImageIcon(LoginSignupUI.class.getResource("/images/topBar.png")));
		topBarLabel.setForeground(Color.WHITE);
		topBarLabel.setBounds(0, 0, 900, 34);
		contentPane.add(topBarLabel);
		
		JLabel appLogoLabel = new JLabel("", SwingConstants.CENTER);
		appLogoLabel.setIcon(new ImageIcon(LoginSignupUI.class.getResource("/images/doctor.png")));
		appLogoLabel.setBounds(3, 4, 25, 29);
		topBarLabel.add(appLogoLabel);
		
		JLabel appTitleLabel = new JLabel("Medical Assistant");
		appTitleLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		appTitleLabel.setBounds(40, 13, 100, 13);
		topBarLabel.add(appTitleLabel);
		
		topBarLabel.addMouseMotionListener(new MouseAdapter()
		{
			 @Override
		     public void mouseDragged(MouseEvent evt)
		     {
				int x = evt.getXOnScreen();
				int y = evt.getYOnScreen();
				LoginSignupUI.this.setLocation(x-posX,y-posY);
							
		     }
		});
		topBarLabel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX=e.getX();
				posY=e.getY();
			}
		});
	}
}
