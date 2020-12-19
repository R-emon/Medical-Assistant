package package1;

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
	private Button logInButton;
	private JPanel logInPanel;
	private JPanel signUpPanel;
	private Image crossLogo= new ImageIcon(LoginSignupUI.class.getResource("/images/cross.png")).getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
	private ButtonGroup userCheckBoxGroup;
	private JCheckBox patientCheckBox;
	private JCheckBox doctorCheckBox;
	private JCheckBox nurseCheckBox;
	private boolean patientSelected=false;
	private boolean doctorSelected=false;
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

	/**
	 * Create the frame.
	 */
	public void switchLogInSignUpPanel(JPanel panel) {
		signUpLogInLayeredPane.removeAll();
		signUpLogInLayeredPane.add(panel);
		signUpLogInLayeredPane.repaint();
		signUpLogInLayeredPane.revalidate();
	}
	public Dashboard getDashboardFrame() {
		return this.dashboard;
	}
	public LoginSignupUI() { //first login UI frame constructor.
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginSignupUI.class.getResource("/images/doctor.png")));
		setTitle("Medical Assistant");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 900, 600); // all properties of first main frame UI.
		
		loginPageContents();  //all other contents method.
		
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
		bkImageLabel.setBounds(0, 0, 500, 600);
		//add(bkImageLabel);
		contentPane.add(bkImageLabel);
		
		signUpLogInLayeredPane = new JLayeredPane();
		signUpLogInLayeredPane.setForeground(Color.WHITE);
		signUpLogInLayeredPane.setBackground(Color.WHITE);
		signUpLogInLayeredPane.setBounds(500, 33, 400, 600);
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
					System.out.println("correct");
					dashboard=new Dashboard(userName, frame);
					dashboard.setVisible(true);
					dashboard.switchDoctorPanel();
				}
				else if(authCheck==true && patientSelected==true) {
					System.out.println("correct" + userName);
					dashboard=new Dashboard(userName, frame);
					dashboard.setVisible(true);
					dashboard.switchPatientPanel();
					frame.dispose();
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
		
		patientCheckBox = new JCheckBox("Log In as Patient");
		patientCheckBox.setBackground(Color.WHITE);
		patientCheckBox.setBounds(43, 296, 130, 26);
		logInPanel.add(patientCheckBox);
		patientCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(patientCheckBox.isSelected()) {
					patientSelected=true;
				}
			}
		});
		
		
		doctorCheckBox = new JCheckBox("Log In as Doctor");
		doctorCheckBox.setBackground(Color.WHITE);
		doctorCheckBox.setBounds(43, 327, 130, 26);
		logInPanel.add(doctorCheckBox);
		doctorCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doctorSelected=true;
				
			}
		});
		
		nurseCheckBox = new JCheckBox("Log In as Nurse");
		nurseCheckBox.setBackground(Color.WHITE);
		nurseCheckBox.setBounds(43, 356, 130, 26);
		logInPanel.add(nurseCheckBox);
		
		userCheckBoxGroup=new ButtonGroup();
		userCheckBoxGroup.add(patientCheckBox);
		userCheckBoxGroup.add(doctorCheckBox);
		userCheckBoxGroup.add(nurseCheckBox);
		
		JLabel userNameLabel = new JLabel("USERNAME");
		userNameLabel.setBounds(43, 79, 157, 26);
		signUpPanel.add(userNameLabel);
		//bkImageLabel.add(userNameLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("Calibri", Font.PLAIN, 13));
		userNameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		userNameTextField.setBounds(43, 102, 283, 36);
		userNameTextField.setColumns(10);
		signUpPanel.add(userNameTextField);
		
		//bkImageLabel.add(userNameTextField);
		
		JSeparator userNameSeparator = new JSeparator();
		userNameSeparator.setForeground(Color.BLACK);
		userNameSeparator.setBackground(Color.BLACK);
		userNameSeparator.setBounds(43, 138, 283, 1);
		signUpPanel.add(userNameSeparator);
		//bkImageLabel.add(separator);
		
		JLabel emailLabel = new JLabel("EMAIL");
		emailLabel.setBounds(43, 158, 157, 26);
		signUpPanel.add(emailLabel);
		//bkImageLabel.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Calibri", Font.PLAIN, 13));
		emailTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		emailTextField.setBounds(43, 180, 283, 36);
		emailTextField.setColumns(10);
		signUpPanel.add(emailTextField);
		//bkImageLabel.add(emailTextField);
		
		JSeparator emailSeparator = new JSeparator();
		emailSeparator.setForeground(Color.BLACK);
		emailSeparator.setBackground(Color.BLACK);
		emailSeparator.setBounds(43, 216, 283, 1);
		signUpPanel.add(emailSeparator);
		//bkImageLabel.add(separator_1);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setBounds(43, 232, 157, 26);
		signUpPanel.add(passwordLabel);
		//bkImageLabel.add(passwordLabel);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		passwordTextField.setBounds(43, 255, 283, 36);
		signUpPanel.add(passwordTextField);
		//bkImageLabel.add(passwordTextField);
		
		JSeparator passwordSeparator = new JSeparator();
		passwordSeparator.setBackground(Color.BLACK);
		passwordSeparator.setForeground(Color.BLACK);
		passwordSeparator.setBounds(43, 291, 283, 1);
		signUpPanel.add(passwordSeparator);
		//bkImageLabel.add(separator_1_1);
		
		JLabel conPasswordLabel = new JLabel("CONFIRM PASSWORD");
		conPasswordLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		conPasswordLabel.setBounds(43, 308, 157, 26);
		signUpPanel.add(conPasswordLabel);
		//bkImageLabel.add(conPasswordTextField_1);
		
		conPasswordTextField = new JPasswordField();
		conPasswordTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		conPasswordTextField.setBounds(43, 330, 283, 36);
		signUpPanel.add(conPasswordTextField);
		//bkImageLabel.add(conPasswordTextField);
		
		JSeparator conPasswordSeparator = new JSeparator();
		conPasswordSeparator.setBackground(Color.BLACK);
		conPasswordSeparator.setForeground(Color.BLACK);
		conPasswordSeparator.setBounds(43, 366, 283, 1);
		signUpPanel.add(conPasswordSeparator);
		//bkImageLabel.add(separator_1_1_1);
		
		Button signUpButton = new Button("Sign UP");
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
		
		JLabel lblNewLabel_1 = new JLabel("OR");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(174, 460, 52, 19);
		signUpPanel.add(lblNewLabel_1);
		//bkImageLabel.add(minimizeLabel);
		
		logInButton = new Button("Log In");
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchLogInSignUpPanel(logInPanel);
			}
		});
		logInButton.setForeground(Color.WHITE);
		logInButton.setBackground(new Color(30, 144, 255));
		logInButton.setBounds(43, 485, 283, 36);
		signUpPanel.add(logInButton);
		

		
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
		
		JLabel toBarLabel = new JLabel("");
		toBarLabel.setIcon(new ImageIcon(LoginSignupUI.class.getResource("/images/topBar.png")));
		toBarLabel.setForeground(Color.WHITE);
		toBarLabel.setBounds(0, 0, 900, 34);
		contentPane.add(toBarLabel);
		
		toBarLabel.addMouseMotionListener(new MouseAdapter()
		{
			 @Override
		     public void mouseDragged(MouseEvent evt)
		     {
				int x = evt.getXOnScreen();
				int y = evt.getYOnScreen();
				LoginSignupUI.this.setLocation(x-posX,y-posY);
							
		     }
		});
		toBarLabel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX=e.getX();
				posY=e.getY();
			}
		});
	}
}
