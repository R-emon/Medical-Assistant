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
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import java.awt.Panel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JCheckBox;

public class LoginSignupUI extends JFrame {
	
	public static LoginSignupUI frame; //first login UI frame variable
	private JPanel contentPane, logInPanel, signUpPanel; //JPanel variable
	private JTextField userNameTextField, emailTextField, logInUserNameTextField;
	private JPasswordField passwordTextField, conPasswordTextField, loginPasswordField;
	private JLabel bkImageLabel;
	private	int posX=0,posY=0;
	private JLayeredPane signUpLogInLayeredPane;
	private Image crossLogo= new ImageIcon(LoginSignupUI.class.getResource("/images/cross.png")).getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
	private ButtonGroup userLoginCheckBoxGroup, userSignUpCheckBoxGroup;
	private JCheckBox patientLoginCheckBox, doctorLoginCheckBox, nurseLoginCheckBox;
	private boolean patientLoginSelected=false, doctorLoginSelected=false, nurseLoginSelected=false, patientSignUpSelected=false, doctorSignUpSelected=false, 
				nurseSignUpSelected=false;
	public static Dashboard dashboard;
	private String filePath="src/data/patientData.txt",  docFilePath="src/data/doctorData.txt", nurseFilePath="src/data/NurseData.txt";
	
	
	
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
	
	public void loadPatientData(String filePath,ArrayList<Patient> arr) {
		File file=new File(filePath);
		try {
			file.createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
		
			while(fis.available()!=0) {
				Patient tempPatient=(Patient) ois.readObject();
				arr.add(tempPatient);
			}
			fis.close();
			ois.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadDoctorData(String filePath,ArrayList<Doctor> arr) {
		File file=new File(filePath);
		try {
			file.createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			
			while(fis.available()!=0) {
				Doctor tempPatient=(Doctor) ois.readObject();
				arr.add(tempPatient);
			}
			fis.close();
			ois.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void loadNurseData(String filePath,ArrayList<Nurse> arr) {
		File file=new File(filePath);
		try {
			file.createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
		
			while(fis.available()!=0) {
				Nurse tempPatient=(Nurse) ois.readObject();
				arr.add(tempPatient);
			}
			fis.close();
			ois.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean multipleUserNameCheck(String name) {
		ArrayList<Patient> tempArrP=new ArrayList<Patient>();		
		ArrayList<Nurse> tempArrN=new ArrayList<Nurse>();
		ArrayList<Doctor> tempArrD=new ArrayList<Doctor>();
		
		Patient tempP=new Patient();
		tempP.loadPatientData(filePath, tempArrP);
		Doctor tempD=new Doctor();
		tempD.loadDoctorData(docFilePath, tempArrD);
		Nurse tempN=new Nurse();
		tempN.loadNurseData(nurseFilePath, tempArrN);
		
		for(int i=0; i<tempArrP.size(); i++) {
			Patient temp=(Patient) tempArrP.get(i);
			if(temp.getName().equals(name))
				return true;
		}
		for(int i=0; i<tempArrD.size(); i++) {
			Doctor temp=(Doctor) tempArrD.get(i);
			if(temp.getName().equals(name))
				return true;
		}
		for(int i=0; i<tempArrN.size(); i++) {
			Nurse temp=(Nurse) tempArrN.get(i);
			if(temp.getName().equals(name))
				return true;
		}
		
		return false;
	}
	
	public void loginPageContents() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bkImageLabel = new JLabel("",new ImageIcon(LoginSignupUI.class.getResource("/images/121.png")),JLabel.CENTER);
		bkImageLabel.setBounds(0, 0, 500, 563);
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
				boolean loginCheck=false;
				String userName=logInUserNameTextField.getText().trim();
				String password=String.valueOf(loginPasswordField.getPassword()).trim();
				if(patientLoginSelected==true) {
					ArrayList<Patient> tempArray=new ArrayList<Patient>();
					loadPatientData(filePath, tempArray);
					Iterator<Patient> iter=tempArray.iterator();
					while(iter.hasNext()) {
						Patient tempPatient=(Patient)iter.next();
						if((tempPatient.getName().equals(userName)) && (tempPatient.getPassword().equals(password))) {
							dashboard=new Dashboard(userName, frame);
							dashboard.setVisible(true);
							dashboard.switchPatientPanel();
							frame.setVisible(false);
							loginCheck=true;
							break;
						}
					}
					if(!loginCheck)
						JOptionPane.showMessageDialog(frame, "Wrong username, passowrd or user selection", "Message", JOptionPane.ERROR_MESSAGE);
					
					logInUserNameTextField.setText("");
					loginPasswordField.setText("");
				}
				
				if(doctorLoginSelected==true) {
					ArrayList<Doctor> tempArrD=new ArrayList<Doctor>();
					loadDoctorData(docFilePath, tempArrD);
					Iterator<Doctor> iter=tempArrD.iterator();
					while(iter.hasNext()) {
						Doctor tempDoctor=(Doctor) iter.next();
						if((tempDoctor.getName().equals(userName)) && (tempDoctor.getPassword().equals(password))) {
							dashboard=new Dashboard(userName, frame);
							dashboard.setVisible(true);
							dashboard.switchDoctorPanel();
							frame.setVisible(false);
							loginCheck=true;
							break;
						}
					}
					if(!loginCheck)
						JOptionPane.showMessageDialog(frame, "Wrong username, passowrd or user selection", "Message", JOptionPane.ERROR_MESSAGE);
					logInUserNameTextField.setText("");
					loginPasswordField.setText("");
				}
				
				if(nurseLoginSelected==true) {
					ArrayList<Nurse> tempArrN=new ArrayList<Nurse>();
					loadNurseData(nurseFilePath, tempArrN);
					Iterator<Nurse> iter=tempArrN.iterator();
					while(iter.hasNext()) {
						Nurse tempNurse=(Nurse) iter.next();
						if((tempNurse.getName().equals(userName)) && (tempNurse.getPassword().equals(password))){
							dashboard=new Dashboard(userName, frame);
							dashboard.setVisible(true);
							dashboard.switchNursePanel();
							frame.setVisible(false);
							loginCheck=true;
							break;
						}
					}
					if(!loginCheck)
						JOptionPane.showMessageDialog(frame, "Wrong username, passowrd or user selection", "Message", JOptionPane.ERROR_MESSAGE);
					logInUserNameTextField.setText("");
					loginPasswordField.setText("");
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
					patientLoginSelected=true;
					doctorLoginSelected=false;
					nurseLoginSelected=false;
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
				doctorLoginSelected=true;
				patientLoginSelected=false;
				nurseLoginSelected=false;
			}
		});
		
		nurseLoginCheckBox = new JCheckBox("Log In as Nurse");
		nurseLoginCheckBox.setBackground(Color.WHITE);
		nurseLoginCheckBox.setBounds(43, 356, 119, 26);
		logInPanel.add(nurseLoginCheckBox);
		nurseLoginCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nurseLoginSelected=true;
				patientLoginSelected=false;
				doctorLoginSelected=false;
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
		
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("Calibri", Font.PLAIN, 13));
		userNameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		userNameTextField.setBounds(43, 84, 283, 36);
		userNameTextField.setColumns(10);
		signUpPanel.add(userNameTextField);
		
		JSeparator userNameSeparator = new JSeparator();
		userNameSeparator.setForeground(Color.BLACK);
		userNameSeparator.setBackground(Color.BLACK);
		userNameSeparator.setBounds(43, 120, 283, 1);
		signUpPanel.add(userNameSeparator);
		
		JLabel emailLabel = new JLabel("EMAIL");
		emailLabel.setBounds(43, 140, 157, 26);
		signUpPanel.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Calibri", Font.PLAIN, 13));
		emailTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		emailTextField.setBounds(43, 162, 283, 36);
		emailTextField.setColumns(10);
		signUpPanel.add(emailTextField);
		
		JSeparator emailSeparator = new JSeparator();
		emailSeparator.setForeground(Color.BLACK);
		emailSeparator.setBackground(Color.BLACK);
		emailSeparator.setBounds(43, 198, 283, 1);
		signUpPanel.add(emailSeparator);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setBounds(43, 214, 157, 26);
		signUpPanel.add(passwordLabel);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		passwordTextField.setBounds(43, 237, 283, 36);
		signUpPanel.add(passwordTextField);
		
		JSeparator passwordSeparator = new JSeparator();
		passwordSeparator.setBackground(Color.BLACK);
		passwordSeparator.setForeground(Color.BLACK);
		passwordSeparator.setBounds(43, 273, 283, 1);
		signUpPanel.add(passwordSeparator);
		
		JLabel conPasswordLabel = new JLabel("CONFIRM PASSWORD");
		conPasswordLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		conPasswordLabel.setBounds(43, 290, 157, 26);
		signUpPanel.add(conPasswordLabel);
		
		conPasswordTextField = new JPasswordField();
		conPasswordTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		conPasswordTextField.setBounds(43, 312, 283, 36);
		signUpPanel.add(conPasswordTextField);
		
		JSeparator conPasswordSeparator = new JSeparator();
		conPasswordSeparator.setBackground(Color.BLACK);
		conPasswordSeparator.setForeground(Color.BLACK);
		conPasswordSeparator.setBounds(43, 348, 283, 1);
		signUpPanel.add(conPasswordSeparator);
		
		Button signUpButton = new Button("Sign UP");
		signUpButton.setActionCommand("Sign Up");
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tempUserName=userNameTextField.getText().trim();
				String tempEmail= emailTextField.getText().trim();
				String tempPassword= String.valueOf(passwordTextField.getPassword()).trim();
				String tempConPassWord= String.valueOf(conPasswordTextField.getPassword()).trim();
				String tempUserType="";
				
				if(tempUserName.equals("") || tempEmail.equals("") || tempPassword.equals("") || tempConPassWord.equals("") || tempUserName.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please Fill Up All The TextFileds!","Message", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(patientSignUpSelected==true) {
						if(multipleUserNameCheck(tempUserName)) {
							JOptionPane.showMessageDialog(frame, "This username already exist.","Message", JOptionPane.ERROR_MESSAGE);
						}
						else {
							tempUserType="Patient";
							ArrayList<Patient> tempArrP=new ArrayList<Patient>();
							Patient tempPatient=new Patient(tempUserName, tempEmail, tempPassword, tempConPassWord, tempUserType);
							tempPatient.loadPatientData(filePath, tempArrP);
							tempArrP.add(tempPatient);
							tempPatient.addUser(filePath, tempArrP);
							
							userNameTextField.setText("");
							emailTextField.setText("");
							passwordTextField.setText("");
							conPasswordTextField.setText("");
							JOptionPane.showMessageDialog(frame, "Sign Up Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
					else if(doctorSignUpSelected==true) {
						if(multipleUserNameCheck(tempUserName)) {
							JOptionPane.showMessageDialog(frame, "This username already exist.","Message", JOptionPane.ERROR_MESSAGE);
						}
						else {
							tempUserType="Doctor";
							ArrayList<Doctor> tempArrD=new ArrayList<Doctor>();
							Doctor tempDoctor=new Doctor(tempUserName, tempEmail, tempPassword, tempConPassWord, tempUserType);
							tempDoctor.loadDoctorData(docFilePath, tempArrD);
							tempArrD.add(tempDoctor);
							tempDoctor.addUser(docFilePath, tempArrD);
							
							userNameTextField.setText("");
							emailTextField.setText("");
							passwordTextField.setText("");
							conPasswordTextField.setText("");
							JOptionPane.showMessageDialog(frame, "Sign Up Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
					else if(nurseSignUpSelected==true) {
						if(multipleUserNameCheck(tempUserName)) {
							JOptionPane.showMessageDialog(frame, "This username already exist.","Message", JOptionPane.ERROR_MESSAGE);
						}
						else {
							tempUserType="Nurse";
							ArrayList<Nurse> tempArrN=new ArrayList<Nurse>();
							Nurse tempNurse=new Nurse(tempUserName, tempEmail, tempPassword, tempConPassWord, tempUserType);
							tempNurse.loadNurseData(nurseFilePath, tempArrN);
							tempArrN.add(tempNurse);
							tempNurse.addUser(nurseFilePath, tempArrN);
							
							userNameTextField.setText("");
							emailTextField.setText("");
							passwordTextField.setText("");
							conPasswordTextField.setText("");
							JOptionPane.showMessageDialog(frame, "Sign Up Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
		signUpButton.setBounds(43, 420, 283, 36);
		signUpButton.setForeground(Color.BLACK);
		signUpButton.setBackground(new Color(241,57,83));
		signUpPanel.add(signUpButton);
		
		JLabel orLabel = new JLabel("OR");
		orLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		orLabel.setBounds(174, 460, 52, 19);
		signUpPanel.add(orLabel);
		
		JCheckBox patientSignUpCheckBox = new JCheckBox("Sign Up as Patient");
		patientSignUpCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patientSignUpSelected=true;
				doctorSignUpSelected=false;
				nurseSignUpSelected=false;
			}
		});
		patientSignUpCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 9));
		patientSignUpCheckBox.setBackground(Color.WHITE);
		patientSignUpCheckBox.setBounds(6, 375, 125, 26);
		signUpPanel.add(patientSignUpCheckBox);
		
		JCheckBox doctorSignUpCheckBox = new JCheckBox("Sign Up as Doctor");
		doctorSignUpCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patientSignUpSelected=false;
				doctorSignUpSelected=true;
				nurseSignUpSelected=false;
			}
		});
		doctorSignUpCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 9));
		doctorSignUpCheckBox.setBackground(Color.WHITE);
		doctorSignUpCheckBox.setBounds(133, 375, 122, 26);
		signUpPanel.add(doctorSignUpCheckBox);
		
		JCheckBox nurseSignUpCheckBox = new JCheckBox("Sign Up as Nurse");
		nurseSignUpCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patientSignUpSelected=false;
				doctorSignUpSelected=false;
				nurseSignUpSelected=true;
			}
		});
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
