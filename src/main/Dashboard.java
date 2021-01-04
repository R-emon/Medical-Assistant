package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

//import com.sun.java.swing.plaf.windows.WindowsBorders.DashedBorder;
import com.toedter.calendar.JDateChooser;

public class Dashboard extends JFrame implements Runnable{

	private JPanel dashboardContentPane;
	public JPanel patientTopBarPanel;
	public JPanel doctorTopBarPanel;
	private JPanel nurseTopBarPanel;
	private JPanel patientSideBarPanel;
	private JPanel doctorSideBarPanel;
	private JPanel nurseSideBarPanel;
	private Image topBar= new ImageIcon(Dashboard.class.getResource("/images/dashboardTopBar.png")).getImage().getScaledInstance(1428, 127, Image.SCALE_SMOOTH);
	private Image topBarPatientLogo= new ImageIcon(Dashboard.class.getResource("/images/hospitalisation1.png")).getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
	private Image sideBar= new ImageIcon(Dashboard.class.getResource("/images/sideBar.png")).getImage().getScaledInstance(338, 536, Image.SCALE_SMOOTH);
	private Image addMedLogo= new ImageIcon(Dashboard.class.getResource("/images/addMedLogo.png")).getImage().getScaledInstance(66, 56, Image.SCALE_SMOOTH);
	private Image addPresLogo= new ImageIcon(Dashboard.class.getResource("/images/addPresLogo.png")).getImage().getScaledInstance(66, 56, Image.SCALE_SMOOTH);
	private Image dueLogo= new ImageIcon(Dashboard.class.getResource("/images/dueLogo.png")).getImage().getScaledInstance(66, 56, Image.SCALE_SMOOTH);
	private Image setAlertLogo= new ImageIcon(Dashboard.class.getResource("/images/setAlertLogo.png")).getImage().getScaledInstance(66, 56, Image.SCALE_SMOOTH);
	private Image logOutLogo= new ImageIcon(Dashboard.class.getResource("/images/logOutLogo2.png")).getImage().getScaledInstance(35, 30, Image.SCALE_SMOOTH);
	private Image topBarDoctorLogo= new ImageIcon(Dashboard.class.getResource("/images/doctorTopbar.png")).getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
	private Image crossDashboardLogo= new ImageIcon(Dashboard.class.getResource("/images/cross.png")).getImage().getScaledInstance(25, 20, Image.SCALE_SMOOTH);
	private Image addAppointmentLogo= new ImageIcon(Dashboard.class.getResource("/images/report.png")).getImage().getScaledInstance(66, 56, Image.SCALE_SMOOTH);
	private Image topBarNurseLogo= new ImageIcon(Dashboard.class.getResource("/images/nurse.png")).getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
	private JLabel topBarPatientLogoLabel;
	private JLabel patientNameLabel;
	private JLabel addMedLogoLabel;
	private JLabel addMedicineLabel;
	private JLabel addPresLogoLabel;
	private JLabel addPresLabel;
	private JLabel dueLogoLabel;
	private JLabel dueLabel;
	private JLabel setAlertLogoLabel;
	private JLabel setAlertLabel;
	private JLabel logOutLogoLabel;
	private JLabel logOutLabel;
	private JPanel addPresContentPanel;
	private JPanel medicineDuePanel;
	private JPanel addMedicineContentPanel;
	private JPanel setAlertPanel;
	private JTextField medicineNameTextField;
	private JTable medicineTable;
	private DefaultTableModel model;
	private String[] colums= {"Medicine Name", "mg"};
	private String[] row=new String[2];
	private String[] items= {"0", "1", "2", "3"};
	private DefaultTableModel prescriptionModel;
	private String[] pressColums= {"Medicine Name", "mg", "Morning", "Evening", "Night", "Days"};
	private String[] presRow=new String[6];
	private DefaultTableModel patientDueModel;
	private String[] dueColums= {"Medicine Name", "Time", "Date", "Alert Status"};
	private String[] dueRow=new String[4];
	private DefaultTableModel alertListModel;
	private String[] alertColums= {"Medicine Name", "Time", "Date", "Alert Status"};
	private String[] alertRow=new String[4];
	private DefaultTableModel addAppointmentModel;
	private String[] addAppointColums= {"Patient Name","Number", "Time","Date"};
	private String[] addAppointRow=new String[4];
	private DefaultTableModel docAlertListModel;
	private String[] docAlertListColums= {"Patient Name", "Time", "Date", "Alert Status"};
	private String[] docAlertListRow=new String[4];
	private DefaultTableModel patientVisitModel;
	private String[] patientVisitColums= {"Patient Name", "Bed No.", "Medicine Name", "Medicine Qnty."};
	private String[] patientVisitRow=new String[4];
	private DefaultTableModel nurseAlertListModel;
	private String[] nurseAlertListColum= {"Patient Name","Bed No.", "Time", "Date","Alert Status"};
	private String[] nurseAlertListRow=new String[5];
	private DefaultTableModel docDueModel;
	private String[] docDueColum= {"Patient Name","Number", "Time","Date","Alert Staus"};
	private String[] docDueRow=new String[5];
	private DefaultTableModel nurseDueModel;
	private String[] nurseDueColum= {"Patient Name","Bed No.", "Time", "Date","Alert Status"};
	private String[] nurseDueRow=new String[5];
	private JTextField medicineMgTextField;
	private JLabel topBarDoctorLogoLabel;
	private JLabel doctorNameLabel;
	private JLabel doctorLogOutLabel;
	private JLabel doctorLogOutLogoLabel;
	private JLayeredPane topBarLayeredPane;
	private JLayeredPane sideBarLayeredPane;
	private JLayeredPane activityContentlayeredPane;
	private JTextField addPressMedNameTxtField;
	private JTextField addPressMgTextField;
	private JComboBox morningComboBox;
	private JComboBox eveningComboBox;
	private JComboBox nightComboBox;
	private JTextField courseForTextField;
	private JTable prescriptionTable;
	private JButton addPrescriptionButton;
	private JButton deletePrescriptionButton;
	private JTable medicineDueTable;
	private JButton dueRefreshButton;
	private JTable setAlertTable;
	private JTextField timeTextField;
	private JTable alertListTable;
	private JDateChooser dueDateChooser;
	private static String userName;
	private LoginSignupUI frame;
	public JFrame dashboardFrame;
	private JLabel crossDashboardLabel;
	private JLabel minimizeDashboardLogo_2;
	private	int posX=0,posY=0;
	private JLabel addAppointmentLabel;
	private JLabel addAppointmentLogoLabel;
	private JPanel addAppointPanel;
	private JLabel docDueLogoLabel;
	private JLabel docaDueLabel;
	private JLabel docSetAlertLogoLabel;
	private JLabel docaSetAlertLabel;
	private JTable addAppointmentTable;
	private JTextField docPatientNameTextField;
	private JTextField patientNumTextField;
	private JTextField appointmentTimeTextField;
	private JDateChooser appointmentDateChooser;
	private JButton addAppointmentButton;
	private JButton deleteAppointmentButton;
	private JPanel appointmentDuePanel;
	private JTable docDueTable;
	private JPanel docSetAlertPanel;
	private JTextField docTimeTextField;
	private JTable docSetAlertTable;
	private JScrollPane docSetAlertScrollPane;
	private JTable docAlertListTable;
	private JScrollPane docAlertListScrollPane;
	private JLabel nurseNameLabel;
	private JLabel nurseLogOutLabel;
	private JLabel nurseLogOutLogoLabel;
	private JLabel nurseSideBarBKLabel;
	private JLabel addPatientVisitLogoLabel;
	private JLabel addPatientVisitLabel;
	private JLabel nurseDueLogoLabel;
	private JLabel nurseDueLabel;
	private JLabel nurseSetAlertLogoLabel;
	private JLabel nurseSetAlertLabel;
	private JPanel addPatientVisitPanel;
	private JTextField nursePatientNameTextField;
	private JTextField bedNumberTextField;
	private JTextField nurseMedicineTextField;
	private JLabel nurseMdeicineQntyLabel;
	private JTable patientVisitTable;
	private JScrollPane patientVisitScrollPane;
	private JTable nurseDueTable;
	private JPanel nurseDuePanel;
	private JPanel nurseSetAlertPanel;
	private JTextField nurseAlertTimeTextField;
	private JTable nurseSetAlertTable;
	private JScrollPane nurseSetAlertScrollPane;
	private JTable nurseAlertListTable;
	private JScrollPane nurseAlertListScrollPane;
	private JDateChooser nurseAlertDateChooser;
	private JButton nurseTurnOffAlertButton;
	private boolean logIn=false;
	private boolean exitThread=false;
	private String filePath="src/data/patientData.txt";
	private String docFilePath="src/data/doctorData.txt";
	private String nurseFilePath="src/data/NurseData.txt";
	//private Dashboard dashboard;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Dashboard window = new Dashboard();
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public void switchPatientPanel() {
		topBarLayeredPane.removeAll();
		topBarLayeredPane.add(patientTopBarPanel);
		topBarLayeredPane.repaint();
		topBarLayeredPane.revalidate();
		
		sideBarLayeredPane.removeAll();
		sideBarLayeredPane.add(patientSideBarPanel);
		sideBarLayeredPane.repaint();
		sideBarLayeredPane.revalidate();
		
		activityContentlayeredPane.removeAll();
		activityContentlayeredPane.add(addMedicineContentPanel);
		activityContentlayeredPane.add(addPresContentPanel);
		activityContentlayeredPane.add(medicineDuePanel);
		activityContentlayeredPane.add(setAlertPanel);
		activityContentlayeredPane.repaint();
		activityContentlayeredPane.revalidate();
	}
	
	public void switchDoctorPanel() {
		topBarLayeredPane.removeAll();
		topBarLayeredPane.add(doctorTopBarPanel);
		topBarLayeredPane.repaint();
		topBarLayeredPane.revalidate();
		
		sideBarLayeredPane.removeAll();
		sideBarLayeredPane.add(doctorSideBarPanel);
		sideBarLayeredPane.repaint();
		sideBarLayeredPane.revalidate();
		
		activityContentlayeredPane.removeAll();
		activityContentlayeredPane.add(addAppointPanel);
		activityContentlayeredPane.repaint();
		activityContentlayeredPane.revalidate();
		
		
	}
	public void switchNursePanel() {
		topBarLayeredPane.removeAll();
		topBarLayeredPane.add(nurseTopBarPanel);
		topBarLayeredPane.repaint();
		topBarLayeredPane.revalidate();
		
		sideBarLayeredPane.removeAll();
		sideBarLayeredPane.add(nurseSideBarPanel);
		sideBarLayeredPane.repaint();
		sideBarLayeredPane.revalidate();
		
		activityContentlayeredPane.removeAll();
		activityContentlayeredPane.add(addPatientVisitPanel);
		activityContentlayeredPane.repaint();
		activityContentlayeredPane.revalidate();
		
		
	}
	public void switchPanel(JPanel panel) {
		activityContentlayeredPane.removeAll();
		activityContentlayeredPane.add(panel);
		activityContentlayeredPane.repaint();
		activityContentlayeredPane.revalidate();
	}
	
	public void logInStatus(boolean logIn) {
		this.logIn=logIn;
	}
	
//	public Dashboard getDashboardFrame() {
//		return this.dashboard;
//	}

	public Dashboard(String name, LoginSignupUI frame) {
		this.userName=name;
		this.frame=frame;
		//this.dashboard=dashboard;
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginSignupUI.class.getResource("/images/doctor.png")));
		setTitle("Medical Assistant");
		getContentPane().setBackground(new Color(229,234,230));
		getContentPane().setLayout(null);
		setBounds(10, 10, 1500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		initialize();
	}
	@Override
	public void run()
	{
		ArrayList<Patient> tempArrP=new ArrayList<Patient>();
		Patient tempP=new Patient();
		tempP.loadPatientData(filePath, tempArrP);
		Patient temp = null;
		for(int i=0;i<tempArrP.size(); i++) {
			if(tempArrP.get(i).getName().equalsIgnoreCase(userName)) {
				temp=(Patient)tempArrP.get(i);
				break;
			}
		}
		
		ArrayList<String> patientAlertTime=temp.getAlertTime();
		Iterator<String> iterPatientAlertTime=patientAlertTime.iterator();
		ArrayList<String> patientAlertDate=temp.getAlertDate();
		Iterator<String> iterPatientAlertDate=patientAlertDate.iterator();

		while(!exitThread)
		{
			System.out.println("Hello world!");
			
			if(iterPatientAlertTime.hasNext() && iterPatientAlertDate.hasNext()) {
				String time=iterPatientAlertTime.next();
				String date=iterPatientAlertDate.next();
				System.out.println(time);
				System.out.println(date);
				
				Date currentSystemDate=new Date();
				SimpleDateFormat dateformat=new SimpleDateFormat("MM/dd/yy");
				String currentDate=dateformat.format(currentSystemDate);
				
				
			}
			
			
			
			try {Thread.sleep(5000);} catch(Exception e) {}
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//dashboardFrame=new JFrame();
		dashboardContentPane = new JPanel();
		dashboardContentPane.setBorder(new EmptyBorder(5,5,5,5));
		dashboardContentPane.setLayout(new BorderLayout(0,0));
		
		topBarLayeredPane = new JLayeredPane();
		topBarLayeredPane.setBounds(31, 50, 1428, 130);
		getContentPane().add(topBarLayeredPane);
		topBarLayeredPane.setLayout(new CardLayout(0, 0));
		
		patientTopBarPanel = new JPanel();
		patientTopBarPanel.setForeground(new Color(229,234,230));
		patientTopBarPanel.setBackground(new Color(229,234,230));
		topBarLayeredPane.add(patientTopBarPanel, "name_38695801413200");
		patientTopBarPanel.setLayout(null);
		
		JLabel topBarImageLabel = new JLabel("");
		topBarImageLabel.setIcon(new ImageIcon(topBar));
		//topBarImageLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/images/dashboardTopBar.png")));
		topBarImageLabel.setBackground(new Color(229,234,230));
		topBarImageLabel.setForeground(new Color(229,234,230));
		topBarImageLabel.setBounds(0, 0, 1428, 130);
		patientTopBarPanel.add(topBarImageLabel);
		
		topBarPatientLogoLabel = new JLabel("");
		topBarPatientLogoLabel.setBounds(21, 33, 80, 70);
		topBarPatientLogoLabel.setBackground(new Color(159,219,231));
		topBarPatientLogoLabel.setForeground(new Color(159,219,231));
		topBarPatientLogoLabel.setIcon(new ImageIcon(topBarPatientLogo));
		topBarImageLabel.add(topBarPatientLogoLabel);
		
		String name="Welcome,"+userName.toUpperCase();
		patientNameLabel = new JLabel("Welcome,");
		patientNameLabel.setBounds(133, 40, 260, 54);
		topBarImageLabel.add(patientNameLabel);
		patientNameLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		patientNameLabel.setText(name);
		
		logOutLogoLabel = new JLabel("");
		logOutLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exitThread=true;
				frame.setVisible(true);
				//setVisible(false);
				dispose();
			}
		});
		logOutLogoLabel.setBounds(1259, 52, 35, 30);
		logOutLogoLabel.setIcon(new ImageIcon(logOutLogo));
		topBarImageLabel.add(logOutLogoLabel);
		
		logOutLabel = new JLabel("Log Out");
		logOutLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exitThread=true;
				frame.setVisible(true);
				//setVisible(false);
				dispose();
			}
		});
		logOutLabel.setBounds(1296, 50, 78, 32);
		logOutLabel.setForeground(Color.RED);
		logOutLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		topBarImageLabel.add(logOutLabel);
		
		doctorTopBarPanel = new JPanel();
		doctorTopBarPanel.setForeground(new Color(229,234,230));
		doctorTopBarPanel.setBackground(new Color(229,234,230));
		topBarLayeredPane.add(doctorTopBarPanel, "name_38730535960000");
		doctorTopBarPanel.setLayout(null);
		
		JLabel doctorTopBarImageLabel = new JLabel("");
		doctorTopBarImageLabel.setIcon(new ImageIcon(topBar));
		//topBarImageLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/images/dashboardTopBar.png")));
		doctorTopBarImageLabel.setBackground(new Color(229,234,230));
		doctorTopBarImageLabel.setForeground(new Color(229,234,230));
		doctorTopBarImageLabel.setBounds(0, 0, 1428, 130);
		doctorTopBarPanel.add(doctorTopBarImageLabel);
		
		topBarDoctorLogoLabel = new JLabel("");
		topBarDoctorLogoLabel.setBounds(21, 33, 80, 70);
		topBarDoctorLogoLabel.setBackground(new Color(159,219,231));
		topBarDoctorLogoLabel.setForeground(new Color(159,219,231));
		topBarDoctorLogoLabel.setIcon(new ImageIcon(topBarDoctorLogo));
		doctorTopBarImageLabel.add(topBarDoctorLogoLabel);
		
		doctorNameLabel = new JLabel("Welcome,");
		doctorNameLabel.setBounds(133, 40, 260, 54);
		doctorTopBarImageLabel.add(doctorNameLabel);
		doctorNameLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		doctorNameLabel.setText(name);
		
		
		doctorLogOutLogoLabel = new JLabel("");
		doctorLogOutLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exitThread=true;
				frame.setVisible(true);
				//setVisible(false);
				dispose();
			}
		});
		doctorLogOutLogoLabel.setBounds(1259, 52, 35, 30);
		doctorTopBarImageLabel.add(doctorLogOutLogoLabel);
		doctorLogOutLogoLabel.setIcon(new ImageIcon(logOutLogo));
		
		doctorLogOutLabel = new JLabel("Log Out");
		doctorLogOutLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exitThread=true;
				frame.setVisible(true);
				//setVisible(false);
				dispose();
			}
		});
		doctorLogOutLabel.setBounds(1296, 50, 78, 32);
		doctorTopBarImageLabel.add(doctorLogOutLabel);
		doctorLogOutLabel.setForeground(Color.RED);
		doctorLogOutLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		
		nurseTopBarPanel = new JPanel();
		nurseTopBarPanel.setForeground(new Color(229,234,230));
		nurseTopBarPanel.setBackground(new Color(229,234,230));
		topBarLayeredPane.add(nurseTopBarPanel, "name_38755163090900");
		nurseTopBarPanel.setLayout(null);
		
		JLabel nurseTopBarImageLabel = new JLabel("");
		nurseTopBarImageLabel.setIcon(new ImageIcon(topBar));
		nurseTopBarImageLabel.setBackground(new Color(229,234,230));
		nurseTopBarImageLabel.setForeground(new Color(229,234,230));
		nurseTopBarImageLabel.setBounds(0, 0, 1428, 130);
		nurseTopBarPanel.add(nurseTopBarImageLabel);
		
		JLabel nurseLogoLabel = new JLabel("New label");
		nurseLogoLabel.setBounds(21, 33, 80, 70);
		nurseLogoLabel.setBackground(new Color(159,219,231));
		nurseLogoLabel.setForeground(new Color(159,219,231));
		nurseLogoLabel.setIcon(new ImageIcon(topBarNurseLogo));
		nurseTopBarImageLabel.add(nurseLogoLabel);
		
		String nurseName="Welcome,"+userName.toUpperCase();
		nurseNameLabel = new JLabel("Welcome,");
		nurseNameLabel.setBounds(133, 40, 260, 54);
		nurseNameLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		nurseNameLabel.setText(nurseName);
		nurseTopBarImageLabel.add(nurseNameLabel);
		
		nurseLogOutLabel = new JLabel("Log Out");
		nurseLogOutLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exitThread=true;
				frame.setVisible(true);
				//setVisible(false);
				dispose();
			}
		});
		nurseLogOutLabel.setBounds(1296, 50, 78, 32);
		nurseLogOutLabel.setForeground(Color.RED);
		nurseLogOutLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		nurseTopBarImageLabel.add(nurseLogOutLabel);
		
		nurseLogOutLogoLabel = new JLabel("");
		nurseLogOutLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exitThread=true;
				frame.setVisible(true);
				//setVisible(false);
				dispose();
			}
		});
		nurseLogOutLogoLabel.setBounds(1259, 52, 35, 30);
		nurseLogOutLogoLabel.setIcon(new ImageIcon(logOutLogo));
		nurseTopBarImageLabel.add(nurseLogOutLogoLabel);
		
		sideBarLayeredPane = new JLayeredPane();
		sideBarLayeredPane.setBounds(31, 198, 338, 536);
		getContentPane().add(sideBarLayeredPane);
		sideBarLayeredPane.setLayout(new CardLayout(0, 0));
		
		patientSideBarPanel = new JPanel();
		sideBarLayeredPane.add(patientSideBarPanel, "name_38915446570600");
		patientSideBarPanel.setLayout(null);
		
		JLabel patientSideBarBKLabel = new JLabel("");
		patientSideBarBKLabel.setForeground(new Color(159,219,231));
		patientSideBarBKLabel.setBackground(new Color(159,219,231));
		patientSideBarBKLabel.setBounds(0, 0, 338, 536);
		patientSideBarBKLabel.setIcon(new ImageIcon(sideBar));
		patientSideBarPanel.add(patientSideBarBKLabel);
		
		addMedLogoLabel = new JLabel("");
		addMedLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(addMedicineContentPanel);
			}
		});
		addMedLogoLabel.setBounds(46, 74, 66, 56);
		addMedLogoLabel.setIcon(new ImageIcon(addMedLogo));
		patientSideBarBKLabel.add(addMedLogoLabel);
		
		addMedicineLabel = new JLabel("Add Medicine");
		addMedicineLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(addMedicineContentPanel);
			}
		});
		addMedicineLabel.setBounds(125, 89, 128, 32);
		patientSideBarBKLabel.add(addMedicineLabel);
		addMedicineLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		
		addPresLogoLabel = new JLabel("");
		addPresLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(addPresContentPanel);
			}
		});
		addPresLogoLabel.setIcon(new ImageIcon(addPresLogo));
		addPresLogoLabel.setBounds(50, 200, 66, 56);
		patientSideBarBKLabel.add(addPresLogoLabel);
		
		addPresLabel = new JLabel("Add Prescription");
		addPresLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(addPresContentPanel);
			}
		});
		addPresLabel.setBounds(124, 201, 149, 32);
		patientSideBarBKLabel.add(addPresLabel);
		addPresLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		
		dueLogoLabel = new JLabel("");
		dueLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(medicineDuePanel);
			}
		});
		dueLogoLabel.setIcon(new ImageIcon(dueLogo));
		dueLogoLabel.setBounds(56, 320, 66, 56);
		patientSideBarBKLabel.add(dueLogoLabel);
		
		dueLabel = new JLabel("Due Today");
		dueLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(medicineDuePanel);
			}
		});
		dueLabel.setBounds(124, 332, 100, 32);
		patientSideBarBKLabel.add(dueLabel);
		dueLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		
		setAlertLogoLabel = new JLabel("");
		setAlertLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(setAlertPanel);
			}
		});
		setAlertLogoLabel.setIcon(new ImageIcon(setAlertLogo));
		setAlertLogoLabel.setBounds(48, 429, 66, 56);
		patientSideBarBKLabel.add(setAlertLogoLabel);
		
		setAlertLabel = new JLabel("Set Alert");
		setAlertLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(setAlertPanel);
			}
		});
		setAlertLabel.setBounds(124, 436, 84, 32);
		patientSideBarBKLabel.add(setAlertLabel);
		setAlertLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		
		doctorSideBarPanel = new JPanel();
		sideBarLayeredPane.add(doctorSideBarPanel, "name_38948241781600");
		doctorSideBarPanel.setLayout(null);
		
		JLabel doctorSideBarBKLabel = new JLabel("");
		doctorSideBarBKLabel.setForeground(new Color(159,219,231));
		doctorSideBarBKLabel.setBackground(new Color(159,219,231));
		doctorSideBarBKLabel.setBounds(0, 0, 338, 536);
		doctorSideBarBKLabel.setIcon(new ImageIcon(sideBar));
		doctorSideBarPanel.add(doctorSideBarBKLabel);
		
		addAppointmentLogoLabel = new JLabel("");
		addAppointmentLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(addAppointPanel);
			}
		});
		addAppointmentLogoLabel.setBounds(55, 88, 66, 56);
		addAppointmentLogoLabel.setIcon(new ImageIcon(addAppointmentLogo));
		doctorSideBarBKLabel.add(addAppointmentLogoLabel);
		
		addAppointmentLabel = new JLabel("Add Appointment");
		addAppointmentLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(addAppointPanel);
			}
		});
		addAppointmentLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		addAppointmentLabel.setBounds(134, 103, 180, 32);
		doctorSideBarBKLabel.add(addAppointmentLabel);
		
		docDueLogoLabel = new JLabel("");
		docDueLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(appointmentDuePanel);
			}
		});
		docDueLogoLabel.setBounds(55, 259, 66, 56);
		docDueLogoLabel.setIcon(new ImageIcon(dueLogo));
		doctorSideBarBKLabel.add(docDueLogoLabel);
		
		docaDueLabel = new JLabel("Appointment Due");
		docaDueLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(appointmentDuePanel);
			}
		});
		docaDueLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		docaDueLabel.setBounds(134, 274, 180, 32);
		doctorSideBarBKLabel.add(docaDueLabel);
		
		docSetAlertLogoLabel = new JLabel("");
		docSetAlertLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(docSetAlertPanel);
			}
		});
		docSetAlertLogoLabel.setBounds(55, 418, 66, 56);
		docSetAlertLogoLabel.setIcon(new ImageIcon(setAlertLogo));
		doctorSideBarBKLabel.add(docSetAlertLogoLabel);
		
		docaSetAlertLabel = new JLabel("Set Alert");
		docaSetAlertLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(docSetAlertPanel);
			}
		});
		docaSetAlertLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		docaSetAlertLabel.setBounds(134, 433, 180, 32);
		doctorSideBarBKLabel.add(docaSetAlertLabel);
		
		nurseSideBarPanel = new JPanel();
		sideBarLayeredPane.add(nurseSideBarPanel, "name_38965842404800");
		nurseSideBarPanel.setLayout(null);
		
		nurseSideBarBKLabel = new JLabel("");
		nurseSideBarBKLabel.setForeground(new Color(159,219,231));
		nurseSideBarBKLabel.setBackground(new Color(159,219,231));
		nurseSideBarBKLabel.setBounds(0, 0, 338, 536);
		nurseSideBarBKLabel.setIcon(new ImageIcon(sideBar));
		nurseSideBarPanel.add(nurseSideBarBKLabel);
		
		addPatientVisitLogoLabel = new JLabel("");
		addPatientVisitLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(addPatientVisitPanel);
			}
		});
		addPatientVisitLogoLabel.setBounds(55, 88, 66, 56);
		addPatientVisitLogoLabel.setIcon(new ImageIcon(addAppointmentLogo));
		nurseSideBarBKLabel.add(addPatientVisitLogoLabel);
		
		addPatientVisitLabel = new JLabel("Add Patient Visit");
		addPatientVisitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(addPatientVisitPanel);
			}
		});
		addPatientVisitLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		addPatientVisitLabel.setBounds(134, 103, 180, 32);
		nurseSideBarBKLabel.add(addPatientVisitLabel);
		
		nurseDueLogoLabel = new JLabel("");
		nurseDueLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(nurseDuePanel);
			}
		});
		nurseDueLogoLabel.setBounds(55, 259, 66, 56);
		nurseDueLogoLabel.setIcon(new ImageIcon(dueLogo));
		nurseSideBarBKLabel.add(nurseDueLogoLabel);
		
		nurseDueLabel = new JLabel("Patient Visit Due");
		nurseDueLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(nurseDuePanel);
			}
		});
		nurseDueLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		nurseDueLabel.setBounds(134, 274, 180, 32);
		nurseSideBarBKLabel.add(nurseDueLabel);
		
		nurseSetAlertLogoLabel = new JLabel("");
		nurseSetAlertLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(nurseSetAlertPanel);
			}
		});
		nurseSetAlertLogoLabel.setBounds(55, 418, 66, 56);
		nurseSetAlertLogoLabel.setIcon(new ImageIcon(setAlertLogo));
		nurseSideBarBKLabel.add(nurseSetAlertLogoLabel);
		
		nurseSetAlertLabel = new JLabel("Set Alert");
		nurseSetAlertLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(nurseSetAlertPanel);
			}
		});
		nurseSetAlertLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		nurseSetAlertLabel.setBounds(134, 433, 180, 32);
		nurseSideBarBKLabel.add(nurseSetAlertLabel);
		
		activityContentlayeredPane = new JLayeredPane();
		activityContentlayeredPane.setBounds(413, 198, 1046, 536);
		getContentPane().add(activityContentlayeredPane);
		activityContentlayeredPane.setLayout(new CardLayout(0, 0));
		
		addMedicineContentPanel = new JPanel();
		addMedicineContentPanel.setBounds(413, 198, 1046, 536);
		addMedicineContentPanel.setForeground(new Color(229,234,230));
		addMedicineContentPanel.setBackground(new Color(229,234,230));
		activityContentlayeredPane.add(addMedicineContentPanel, "name_5285986441700");
		addMedicineContentPanel.setLayout(null);
		
		JLabel medicineNameLabel = new JLabel("Medicine name");
		medicineNameLabel.setBackground(new Color(229,234,230));
		medicineNameLabel.setForeground(Color.DARK_GRAY);
		medicineNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		medicineNameLabel.setBounds(104, 181, 144, 35);
		addMedicineContentPanel.add(medicineNameLabel);
		
		medicineNameTextField = new JTextField();
		medicineNameTextField.setBounds(259, 181, 226, 35);
		addMedicineContentPanel.add(medicineNameTextField);
		medicineNameTextField.setColumns(10);
		
		JButton addMedicineButton = new JButton("Add");
		addMedicineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String medName=medicineNameTextField.getText().trim();
				String medMg=medicineMgTextField.getText().trim();
				row[0]=medName;
				row[1]=medMg;
				model.addRow(row);
				medicineNameTextField.setText("");
				medicineMgTextField.setText("");
				
				ArrayList<Patient> tempArrayP=new ArrayList<Patient>();
				Patient tempP=new Patient();
				tempP.loadPatientData(filePath, tempArrayP);
				
				for(int i=0;i<tempArrayP.size(); i++) {
					Patient temp=(Patient) tempArrayP.get(i);
					if(temp.getName().equalsIgnoreCase(userName)) {
						temp.setAddMedicineName(medName);
						temp.setAddMg(medMg);
						tempArrayP.set(i, temp);
						break;
					}
				}
				
				tempP.addUser(filePath, tempArrayP);
				
			}
		});
		addMedicineButton.setBounds(184, 343, 118, 41);
		addMedicineButton.setForeground(Color.WHITE);
		addMedicineButton.setBackground(new Color(94,94,194));
		addMedicineContentPanel.add(addMedicineButton);
		
		JButton deleteMedicineButton = new JButton("Delete");
		deleteMedicineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=medicineTable.getSelectedRow();
				String selectedMedName=model.getValueAt(selectedRow, 0).toString().trim();
				String selectedMg=model.getValueAt(selectedRow, 1).toString().trim();
				if(selectedRow>=0) {
					model.removeRow(selectedRow);
					ArrayList<Patient> tempArr=new ArrayList<Patient>();
					Patient tempP=new Patient();
					tempP.loadPatientData(filePath, tempArr);
					
					for(int i=0; i<tempArr.size(); i++) {
						Patient temp=(Patient)tempArr.get(i);
						if(temp.getName().equalsIgnoreCase(userName)) {
							temp.deleAddMedicineName(selectedMedName);
							temp.deleteAddMg(selectedMg);
							tempArr.set(i, temp);
							break;
						}
					}
					tempP.addUser(filePath, tempArr);
				}
			}
		});
		deleteMedicineButton.setBounds(339, 343, 118, 41);
		deleteMedicineButton.setBackground(new Color(220,59,59));
		deleteMedicineButton.setForeground(Color.WHITE);;
		addMedicineContentPanel.add(deleteMedicineButton);
		
		JScrollPane medicineScrollPane = new JScrollPane();
		medicineScrollPane.setBounds(554, 47, 369, 444);
//		medicineScrollPane.setBackground(new Color(173,255,241));
		medicineScrollPane.getViewport().setBackground(Color.WHITE);
		addMedicineContentPanel.add(medicineScrollPane);
		
		medicineTable = new JTable();
		medicineTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		medicineScrollPane.setViewportView(medicineTable);
		
		model=new DefaultTableModel();
		model.setColumnIdentifiers(colums);
		medicineTable.setModel(model);
		medicineTable.setRowHeight(40);
		medicineTable.setBackground(new Color(238,255,252));
		loadDataToPatientAddMedTable();
		
		JLabel mgLabel = new JLabel("mg/Unit");
		mgLabel.setForeground(Color.DARK_GRAY);
		mgLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mgLabel.setBackground(new Color(229, 234, 230));
		mgLabel.setBounds(104, 266, 104, 35);
		addMedicineContentPanel.add(mgLabel);
		
		medicineMgTextField = new JTextField();
		medicineMgTextField.setColumns(10);
		medicineMgTextField.setBounds(259, 266, 226, 35);
		addMedicineContentPanel.add(medicineMgTextField);
		
		addPresContentPanel = new JPanel();
		addPresContentPanel.setBackground(new Color(229,234,230));
		addPresContentPanel.setForeground(new Color(229,234,230));
		addPresContentPanel.setBounds(413, 198, 1046, 536);
		activityContentlayeredPane.add(addPresContentPanel, "name_5669470193100");
		addPresContentPanel.setLayout(null);
		
		JLabel addPressMedNameLabel = new JLabel("Medicine name");
		addPressMedNameLabel.setForeground(Color.DARK_GRAY);
		addPressMedNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addPressMedNameLabel.setBackground(new Color(229, 234, 230));
		addPressMedNameLabel.setBounds(82, 124, 144, 35);
		addPresContentPanel.add(addPressMedNameLabel);
		
		addPressMedNameTxtField = new JTextField();
		addPressMedNameTxtField.setColumns(10);
		addPressMedNameTxtField.setBounds(237, 124, 226, 35);
		addPresContentPanel.add(addPressMedNameTxtField);
		
		JLabel addPressMgLabel = new JLabel("mg/Unit");
		addPressMgLabel.setForeground(Color.DARK_GRAY);
		addPressMgLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addPressMgLabel.setBackground(new Color(229, 234, 230));
		addPressMgLabel.setBounds(82, 179, 91, 35);
		addPresContentPanel.add(addPressMgLabel);
		
		addPressMgTextField = new JTextField();
		addPressMgTextField.setColumns(10);
		addPressMgTextField.setBounds(237, 179, 226, 35);
		addPresContentPanel.add(addPressMgTextField);
		
		JLabel morningLabel = new JLabel("Morning");
		morningLabel.setForeground(Color.DARK_GRAY);
		morningLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		morningLabel.setBackground(new Color(229, 234, 230));
		morningLabel.setBounds(82, 235, 91, 35);
		addPresContentPanel.add(morningLabel);
		
		morningComboBox = new JComboBox(items);
		morningComboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		morningComboBox.setBounds(82, 280, 91, 35);
		//morningcomboBox.add(items);
		addPresContentPanel.add(morningComboBox);
		
		JLabel eveningLabel = new JLabel("Evening");
		eveningLabel.setForeground(Color.DARK_GRAY);
		eveningLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eveningLabel.setBackground(new Color(229, 234, 230));
		eveningLabel.setBounds(226, 235, 91, 35);
		addPresContentPanel.add(eveningLabel);
		
		JLabel nightLabel = new JLabel("Night");
		nightLabel.setForeground(Color.DARK_GRAY);
		nightLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nightLabel.setBackground(new Color(229, 234, 230));
		nightLabel.setBounds(372, 235, 91, 35);
		addPresContentPanel.add(nightLabel);
		
		eveningComboBox = new JComboBox(items);
		eveningComboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		eveningComboBox.setBounds(226, 280, 91, 35);
		addPresContentPanel.add(eveningComboBox);
		
		nightComboBox = new JComboBox(items);
		nightComboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		nightComboBox.setBounds(372, 280, 91, 35);
		addPresContentPanel.add(nightComboBox);
		
		JLabel courseForDaysLabel = new JLabel("Course for (Days)");
		courseForDaysLabel.setForeground(Color.DARK_GRAY);
		courseForDaysLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		courseForDaysLabel.setBackground(new Color(229, 234, 230));
		courseForDaysLabel.setBounds(198, 348, 178, 35);
		addPresContentPanel.add(courseForDaysLabel);
		
		courseForTextField = new JTextField();
		courseForTextField.setBounds(226, 393, 91, 35);
		addPresContentPanel.add(courseForTextField);
		courseForTextField.setColumns(10);
		
		JScrollPane prescriptionScrollPane = new JScrollPane();
		prescriptionScrollPane.setBounds(554, 47, 464, 444);
		prescriptionScrollPane.getViewport().setBackground(Color.WHITE);
		addPresContentPanel.add(prescriptionScrollPane);
		
		prescriptionTable = new JTable();
		prescriptionTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prescriptionScrollPane.setViewportView(prescriptionTable);
		
		prescriptionModel=new DefaultTableModel();
		prescriptionModel.setColumnIdentifiers(pressColums);
		prescriptionTable.setModel(prescriptionModel);
		prescriptionTable.setRowHeight(30);
		prescriptionTable.setBackground(new Color(238,255,252));
		
		TableColumnModel pressColumnModel = prescriptionTable.getColumnModel();
		pressColumnModel.getColumn(0).setPreferredWidth(80);
		pressColumnModel.getColumn(1).setPreferredWidth(5);
		pressColumnModel.getColumn(2).setPreferredWidth(5);
		pressColumnModel.getColumn(3).setPreferredWidth(5);
		pressColumnModel.getColumn(4).setPreferredWidth(5);
		pressColumnModel.getColumn(5).setPreferredWidth(5);
		loadDataToPatientAddPresTable();
		
		addPrescriptionButton = new JButton("Add");
		addPrescriptionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pressMedName=addPressMedNameTxtField.getText().trim();
				String pressMg=addPressMgTextField.getText().trim();
				String morningNumber=morningComboBox.getSelectedItem().toString().trim();
				String eveningNumber=eveningComboBox.getSelectedItem().toString().trim();
				String nigntNumber=nightComboBox.getSelectedItem().toString().trim();
				String courseTotalNumber=courseForTextField.getText().trim();
				
				presRow[0]=pressMedName;
				presRow[1]=pressMg;
				presRow[2]=morningNumber;
				presRow[3]=eveningNumber;
				presRow[4]=nigntNumber;
				presRow[5]=courseTotalNumber;
				prescriptionModel.addRow(presRow);

				addPressMedNameTxtField.setText("");
				addPressMgTextField.setText("");
				morningComboBox.setSelectedIndex(0);
				eveningComboBox.setSelectedIndex(0);
				nightComboBox.setSelectedIndex(0);
				courseForTextField.setText("");
				
				ArrayList<Patient> tempArrayP=new ArrayList<Patient>();
				Patient tempP=new Patient();
				tempP.loadPatientData(filePath, tempArrayP);
				
				for(int i=0; i<tempArrayP.size(); i++) {
					Patient temp=(Patient) tempArrayP.get(i);
					if(temp.getName().equalsIgnoreCase(userName)) {
						temp.setAddPresMedicineName(pressMedName);
						temp.setAddPresMg(pressMg);
						temp.setAddPresMoring(morningNumber);
						temp.setAddPresEvening(eveningNumber);
						temp.setAddPresNight(nigntNumber);
						temp.setTotalCourseDays(courseTotalNumber);
						tempArrayP.add(i, temp);
						break;
					}
				}
				tempP.addUser(filePath, tempArrayP);
				
			}
		});
		addPrescriptionButton.setForeground(Color.WHITE);
		addPrescriptionButton.setBackground(new Color(94, 94, 194));
		addPrescriptionButton.setBounds(149, 456, 118, 41);
		addPresContentPanel.add(addPrescriptionButton);
		
		deletePrescriptionButton = new JButton("Delete");
		deletePrescriptionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=prescriptionTable.getSelectedRow();
				String selectedPresMedName=prescriptionModel.getValueAt(selectedRow, 0).toString().trim();
				String selectedPresMg=prescriptionModel.getValueAt(selectedRow, 1).toString().trim();
				String selectedMorningCount=prescriptionModel.getValueAt(selectedRow, 2).toString().trim();
				String selectedEveningCount=prescriptionModel.getValueAt(selectedRow, 3).toString().trim();
				String selectedNightCount=prescriptionModel.getValueAt(selectedRow, 4).toString().trim();
				String selectedCourseDays=prescriptionModel.getValueAt(selectedRow, 5).toString().trim();
				if(selectedRow>=0) {
					prescriptionModel.removeRow(selectedRow);
					ArrayList<Patient> tempArrP=new ArrayList<Patient>();
					Patient tempP=new Patient();
					tempP.loadPatientData(filePath, tempArrP);
					
					for(int i=0; i<tempArrP.size(); i++) {
						Patient temp=(Patient) tempArrP.get(i);
						if(temp.getName().equalsIgnoreCase(userName)) {
							temp.deleteAddPressMedicineName(selectedPresMedName);
							temp.deleteAddPresMg(selectedPresMg);
							temp.deleteAddPresMorning(selectedMorningCount);
							temp.deleteAddPressEvening(selectedEveningCount);
							temp.deleteAddPresNight(selectedNightCount);
							temp.deleteTotalCourseDays(selectedCourseDays);
							tempArrP.set(i, temp);
							break;
						}
					}
					tempP.addUser(filePath, tempArrP);
				}
				
			}
		});
		deletePrescriptionButton.setForeground(Color.WHITE);
		deletePrescriptionButton.setBackground(new Color(220, 59, 59));
		deletePrescriptionButton.setBounds(292, 456, 118, 41);
		addPresContentPanel.add(deletePrescriptionButton);
		
		
		
		
		medicineDuePanel = new JPanel();
		medicineDuePanel.setBackground(new Color(229,234,230));
		medicineDuePanel.setForeground(new Color(229,234,230));
		medicineDuePanel.setBounds(413, 198, 1046, 536);
		activityContentlayeredPane.add(medicineDuePanel, "name_5773124559600");
		medicineDuePanel.setLayout(null);
		
		JScrollPane medicineDueScrollPane = new JScrollPane();
		medicineDueScrollPane.setBounds(554, 47, 445, 444);
		medicineDueScrollPane.getViewport().setBackground(Color.WHITE);
		medicineDuePanel.add(medicineDueScrollPane);
		
		medicineDueTable = new JTable();
		medicineDueTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		medicineDueTable.setBackground(new Color(238,255,252));
		medicineDueTable.setRowHeight(40);
		medicineDueScrollPane.setViewportView(medicineDueTable);
		
		patientDueModel=new DefaultTableModel();
		patientDueModel.setColumnIdentifiers(dueColums);
		medicineDueTable.setModel(patientDueModel);
		medicineDueTable.setRowHeight(40);
		medicineDueTable.setBackground(new Color(238,255,252));
		
		TableColumnModel patientDueColumnModel = medicineDueTable.getColumnModel();
		patientDueColumnModel.getColumn(0).setPreferredWidth(80);
		patientDueColumnModel.getColumn(1).setPreferredWidth(5);
		patientDueColumnModel.getColumn(2).setPreferredWidth(5);
		patientDueColumnModel.getColumn(3).setPreferredWidth(5);
		loadTodaysDueDataToPatientDueTable();
		
		JLabel medicineDueTodayLabe = new JLabel("Due Today");
		medicineDueTodayLabe.setFont(new Font("Tahoma", Font.BOLD, 24));
		medicineDueTodayLabe.setBounds(175, 242, 205, 65);
		medicineDuePanel.add(medicineDueTodayLabe);
		
		dueRefreshButton = new JButton("Refresh");
		dueRefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patientDueModel.setRowCount(0);
				loadTodaysDueDataToPatientDueTable();
			}
		});
		dueRefreshButton.setForeground(Color.WHITE);
		dueRefreshButton.setBackground(new Color(146,94,194));
		dueRefreshButton.setBounds(185, 317, 118, 41);
		medicineDuePanel.add(dueRefreshButton);
		
		setAlertPanel = new JPanel();
		setAlertPanel.setBackground(new Color(229,234,230));
		setAlertPanel.setForeground(new Color(229,234,230));
		setAlertPanel.setBounds(413, 198, 1046, 536);
		activityContentlayeredPane.add(setAlertPanel, "name_6284499503700");
		setAlertPanel.setLayout(null);
		
		JScrollPane setAlertScrollPane = new JScrollPane();
		setAlertScrollPane.setBounds(590, 48, 369, 489);
		setAlertScrollPane.getViewport().setBackground(Color.WHITE);
		setAlertPanel.add(setAlertScrollPane);
		
		setAlertTable = new JTable();
		setAlertTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		setAlertTable.setBackground(new Color(238,255,252));
		setAlertScrollPane.setViewportView(setAlertTable);
		
		model.setColumnIdentifiers(colums);
		setAlertTable.setModel(model);
		setAlertTable.setRowHeight(40);
		
		JLabel timeLabel = new JLabel("Time");
		timeLabel.setForeground(Color.DARK_GRAY);
		timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		timeLabel.setBackground(new Color(229, 234, 230));
		timeLabel.setBounds(60, 99, 59, 28);
		setAlertPanel.add(timeLabel);
		
		JLabel timeFormatLabel = new JLabel("(hh:mm AM/PM)");
		timeFormatLabel.setForeground(Color.DARK_GRAY);
		timeFormatLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		timeFormatLabel.setBackground(new Color(229, 234, 230));
		timeFormatLabel.setBounds(60, 133, 114, 28);
		setAlertPanel.add(timeFormatLabel);
		
		timeTextField = new JTextField();
		timeTextField.setBackground(Color.WHITE);
		timeTextField.setColumns(10);
		timeTextField.setBounds(169, 92, 226, 35);
		setAlertPanel.add(timeTextField);
		
		JLabel dateLabel = new JLabel("Date");
		dateLabel.setForeground(Color.DARK_GRAY);
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateLabel.setBackground(new Color(229, 234, 230));
		dateLabel.setBounds(60, 171, 59, 28);
		setAlertPanel.add(dateLabel);
		
		dueDateChooser = new JDateChooser();
		dueDateChooser.setBounds(169, 171, 152, 35);
		setAlertPanel.add(dueDateChooser);
		//dueDateChooser.get
		JScrollPane alertListScrollPane = new JScrollPane();
		alertListScrollPane.setBounds(60, 402, 435, 134);
		alertListScrollPane.getViewport().setBackground(Color.WHITE);
		setAlertPanel.add(alertListScrollPane);
		
		alertListTable = new JTable();
		alertListTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		alertListTable.setBackground(new Color(238,255,252));
		alertListScrollPane.setViewportView(alertListTable);
		
		alertListModel=new DefaultTableModel();
		alertListModel.setColumnIdentifiers(alertColums);
		alertListTable.setModel(alertListModel);
		alertListTable.setRowHeight(30);
		
		TableColumnModel alertColumnModel = alertListTable.getColumnModel();
		alertColumnModel.getColumn(0).setPreferredWidth(80);
		alertColumnModel.getColumn(1).setPreferredWidth(5);
		alertColumnModel.getColumn(2).setPreferredWidth(5);
		alertColumnModel.getColumn(3).setPreferredWidth(5);
		loadDataToPatientSetAlertListTable();

		JLabel alertListLabel = new JLabel("Alert List");
		alertListLabel.setForeground(Color.DARK_GRAY);
		alertListLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		alertListLabel.setBackground(new Color(229, 234, 230));
		alertListLabel.setBounds(60, 366, 70, 28);
		setAlertPanel.add(alertListLabel);
		
		JLabel selectHereLabel = new JLabel("Select Here");
		selectHereLabel.setForeground(Color.DARK_GRAY);
		selectHereLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selectHereLabel.setBackground(new Color(229, 234, 230));
		selectHereLabel.setBounds(590, 10, 80, 28);
		setAlertPanel.add(selectHereLabel);
		
		JButton setAlertButton = new JButton("Set Alert");
		setAlertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowIndex=setAlertTable.getSelectedRow();
				Date date=dueDateChooser.getDate();
				String strDate=DateFormat.getInstance().format(date);
				String[] arrDate=strDate.split(",");
				
				String setAlertListMedName=model.getValueAt(selectedRowIndex, 0).toString().trim();
				String setAlertListTime=timeTextField.getText().trim();
				String splitedDate=arrDate[0];
				String setAlertListAlertStatus="On";
				
				alertRow[0]= setAlertListMedName;
				alertRow[1]= setAlertListTime;
				alertRow[2]= splitedDate;
				alertRow[3]= setAlertListAlertStatus;
				alertListModel.addRow(alertRow);
				
				timeTextField.setText("");
				dueDateChooser.cleanup();
				
				ArrayList<Patient> tempArrP=new ArrayList<Patient>();
				Patient tempP=new Patient();
				tempP.loadPatientData(filePath, tempArrP);
				
				for(int i=0; i<tempArrP.size(); i++) {
					Patient temp=tempArrP.get(i);
					if(temp.getName().equalsIgnoreCase(userName)) {
						temp.setAlertMedicineName(setAlertListMedName);
						temp.setAlertTime(setAlertListTime);
						temp.setAlertDate(splitedDate);
						temp.setAlertStaus(setAlertListAlertStatus);
						tempArrP.set(i, temp);
						break;
					}
				}
				tempP.addUser(filePath, tempArrP);
			}
		});
		setAlertButton.setForeground(Color.WHITE);
		setAlertButton.setBackground(new Color(94,194,162));
		setAlertButton.setBounds(169, 274, 118, 41);
		setAlertPanel.add(setAlertButton);
		
		JButton patientTurnOffAlertButton = new JButton("Turn Off Alert");
		patientTurnOffAlertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowIndex=alertListTable.getSelectedRow();
				String selectedAlertListMedName=alertListModel.getValueAt(selectedRowIndex, 0).toString().trim();
				String selectedAlertListTime=alertListModel.getValueAt(selectedRowIndex, 1).toString().trim();
				String selectedAlertListDate=alertListModel.getValueAt(selectedRowIndex, 2).toString().trim();
				alertListModel.setValueAt("Off", selectedRowIndex, 3);
				
				ArrayList<Patient> tempArrP=new ArrayList<Patient>();
				Patient tempP=new Patient();
				tempP.loadPatientData(filePath, tempArrP);
				
				for(int i=0; i<tempArrP.size(); i++) {
					Patient temp=tempArrP.get(i);
					if(temp.getName().equalsIgnoreCase(userName)) {
						ArrayList<String> tempArrAlerListMedName=temp.getAlertMedicineName();
						Iterator<String> iterTempArrAlertListMedName=tempArrAlerListMedName.iterator();
						ArrayList<String> tempArrAlertListTime=temp.getAlertTime();
						Iterator<String> iterTempArrAlertListTime=tempArrAlertListTime.iterator();
						ArrayList<String> tempArrAlertListDate=temp.getAlertDate();
						Iterator<String> iterTempAlertListDate=tempArrAlertListDate.iterator();
						ArrayList<String> tempAlertListStatus=temp.getAlertStatus();
						
						int statusIndex=0;
						while(iterTempArrAlertListMedName.hasNext() && iterTempArrAlertListTime.hasNext() && iterTempAlertListDate.hasNext()) {
							
							if(iterTempArrAlertListMedName.next().equalsIgnoreCase(selectedAlertListMedName) && iterTempArrAlertListTime.next().equalsIgnoreCase(selectedAlertListTime) 
									&& iterTempAlertListDate.next().equalsIgnoreCase(selectedAlertListDate)) {
								tempAlertListStatus.set(statusIndex, "Off");
								break;
							}
							statusIndex++;
						}
						tempArrP.set(i, temp);
						break;
					}
				}
				tempP.addUser(filePath, tempArrP);
			}
		});
		patientTurnOffAlertButton.setForeground(Color.WHITE);
		patientTurnOffAlertButton.setBackground(new Color(220, 59, 59));
		patientTurnOffAlertButton.setBounds(316, 274, 118, 41);
		setAlertPanel.add(patientTurnOffAlertButton);
		
		addAppointPanel = new JPanel();
		addAppointPanel.setBackground(new Color(229,234,230));
		addAppointPanel.setForeground(new Color(229,234,230));
		activityContentlayeredPane.add(addAppointPanel, "name_129264126906200");
		addAppointPanel.setLayout(null);
		
		JScrollPane addAppointmentScrollPane = new JScrollPane();
		addAppointmentScrollPane.setBounds(554, 47, 440, 444);
		addAppointmentScrollPane.getViewport().setBackground(Color.WHITE);
		addAppointPanel.add(addAppointmentScrollPane);
		
		addAppointmentTable = new JTable();
		addAppointmentTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addAppointmentTable.setBackground(new Color(238,255,252));
		addAppointmentScrollPane.setViewportView(addAppointmentTable);
		
		addAppointmentModel=new DefaultTableModel();
		addAppointmentModel.setColumnIdentifiers(addAppointColums);
		addAppointmentTable.setModel(addAppointmentModel);
		addAppointmentTable.setRowHeight(30);
		
		TableColumnModel appointColumnModel = addAppointmentTable.getColumnModel();
		appointColumnModel.getColumn(0).setPreferredWidth(80);
		appointColumnModel.getColumn(1).setPreferredWidth(40);
		appointColumnModel.getColumn(2).setPreferredWidth(5);
		appointColumnModel.getColumn(3).setPreferredWidth(5);
		loadDataToDoctorAppointTable();
		
		JLabel docPatientNameLabel = new JLabel("Patient Name");
		docPatientNameLabel.setForeground(Color.DARK_GRAY);
		docPatientNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		docPatientNameLabel.setBackground(new Color(229, 234, 230));
		docPatientNameLabel.setBounds(45, 47, 144, 35);
		addAppointPanel.add(docPatientNameLabel);
		
		docPatientNameTextField = new JTextField();
		docPatientNameTextField.setColumns(10);
		docPatientNameTextField.setBounds(200, 47, 226, 35);
		addAppointPanel.add(docPatientNameTextField);
		
		JLabel patientNumLabel = new JLabel("Patient Number");
		patientNumLabel.setForeground(Color.DARK_GRAY);
		patientNumLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		patientNumLabel.setBackground(new Color(229, 234, 230));
		patientNumLabel.setBounds(45, 127, 144, 35);
		addAppointPanel.add(patientNumLabel);
		
		patientNumTextField = new JTextField();
		patientNumTextField.setColumns(10);
		patientNumTextField.setBounds(200, 127, 226, 35);
		addAppointPanel.add(patientNumTextField);
		
		appointmentTimeTextField = new JTextField();
		appointmentTimeTextField.setColumns(10);
		appointmentTimeTextField.setBounds(239, 206, 187, 35);
		addAppointPanel.add(appointmentTimeTextField);
		
		JLabel appointTimeLabel = new JLabel("Appointment Time");
		appointTimeLabel.setForeground(Color.DARK_GRAY);
		appointTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		appointTimeLabel.setBackground(new Color(229, 234, 230));
		appointTimeLabel.setBounds(45, 206, 177, 35);
		addAppointPanel.add(appointTimeLabel);
		
		appointmentDateChooser = new JDateChooser();
		appointmentDateChooser.setBounds(239, 289, 152, 35);
		addAppointPanel.add(appointmentDateChooser);
		
		JLabel appointmentDateLabel = new JLabel("Appointment Date");
		appointmentDateLabel.setForeground(Color.DARK_GRAY);
		appointmentDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		appointmentDateLabel.setBackground(new Color(229, 234, 230));
		appointmentDateLabel.setBounds(45, 289, 177, 35);
		addAppointPanel.add(appointmentDateLabel);
		
		JLabel addAppointmentDateFormat = new JLabel("(hh:mm AM/PM)");
		addAppointmentDateFormat.setForeground(Color.DARK_GRAY);
		addAppointmentDateFormat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addAppointmentDateFormat.setBackground(new Color(229, 234, 230));
		addAppointmentDateFormat.setBounds(436, 206, 114, 28);
		addAppointPanel.add(addAppointmentDateFormat);
		
		addAppointmentButton = new JButton("Add");
		addAppointmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String appointPatientName=docPatientNameTextField.getText().trim();
				String appointPatientNum=patientNumTextField.getText().trim();
				String appointTime=appointmentTimeTextField.getText().trim();
				Date date=appointmentDateChooser.getDate();
				String strDate=DateFormat.getInstance().format(date);
				String[] arrDate=strDate.split(",");
				String appointDate=arrDate[0].trim();
				addAppointRow[0]=appointPatientName;
				addAppointRow[1]=appointPatientNum;
				addAppointRow[2]=appointTime;
				addAppointRow[3]=appointDate;
				addAppointmentModel.addRow(addAppointRow);
				
				docPatientNameTextField.setText("");
				patientNumTextField.setText("");
				appointmentTimeTextField.setText("");
				
				ArrayList<Doctor> tempArrD=new ArrayList<Doctor>();
				Doctor tempD=new Doctor();
				tempD.loadDoctorData(docFilePath, tempArrD);
				
				for(int i=0; i<tempArrD.size(); i++) {
					Doctor temp=(Doctor) tempArrD.get(i);
					if(temp.getName().equalsIgnoreCase(userName)) {
						temp.setAddAppointPatientName(appointPatientName);
						temp.setAddAppointPatientNumber(appointPatientNum);
						temp.setAddAppointTime(appointTime);
						temp.setAddAppointDate(appointDate);
						tempArrD.set(i, temp);
						break;
					}
				}
				tempD.addUser(docFilePath, tempArrD);
			}
		});
		
		addAppointmentButton.setForeground(Color.WHITE);
		addAppointmentButton.setBackground(new Color(94, 94, 194));
		addAppointmentButton.setBounds(145, 375, 118, 41);
		addAppointPanel.add(addAppointmentButton);
		
		deleteAppointmentButton = new JButton("Delete");
		deleteAppointmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=addAppointmentTable.getSelectedRow();
				String selectedAppointPatientName=addAppointmentModel.getValueAt(selectedRow, 0).toString().trim();
				String selectedAppointPatientNum=addAppointmentModel.getValueAt(selectedRow, 1).toString().trim();
				String selecteAppointTime=addAppointmentModel.getValueAt(selectedRow, 2).toString().trim();
				String selectedAppointDate=addAppointmentModel.getValueAt(selectedRow, 3).toString().trim();
				
				if(selectedRow>=0) {
					addAppointmentModel.removeRow(selectedRow);
					ArrayList<Doctor> tempArrD=new ArrayList<Doctor>();
					Doctor tempD=new Doctor();
					tempD.loadDoctorData(docFilePath, tempArrD);
					
					for(int i=0; i<tempArrD.size(); i++) {
						Doctor temp=(Doctor) tempArrD.get(i);
						if(temp.getName().equalsIgnoreCase(userName)) {
							temp.deleteAddAppointPatientName(selectedAppointPatientName);
							temp.deleteAddAppointPatientNumber(selectedAppointPatientNum);
							temp.deleteSetAppointTime(selecteAppointTime);
							temp.deleteSetAddAppointDate(selectedAppointDate);
							tempArrD.set(i, temp);
							break;
						}
					}
					tempD.addUser(docFilePath, tempArrD);
				}
			}
		});
		deleteAppointmentButton.setForeground(Color.WHITE);
		deleteAppointmentButton.setBackground(new Color(220, 59, 59));
		deleteAppointmentButton.setBounds(308, 375, 118, 41);
		addAppointPanel.add(deleteAppointmentButton);
		
		appointmentDuePanel = new JPanel();
		appointmentDuePanel.setBackground(new Color(229,234,230));
		appointmentDuePanel.setForeground(new Color(229,234,230));
		activityContentlayeredPane.add(appointmentDuePanel, "name_283700376507500");
		appointmentDuePanel.setLayout(null);
		
		JButton docDueRefreshButton = new JButton("Refresh");
		docDueRefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				docDueModel.setRowCount(0);
				loadDataToDoctorDueTable();
			}
		});
		docDueRefreshButton.setForeground(Color.WHITE);
		docDueRefreshButton.setBackground(new Color(146, 94, 194));
		docDueRefreshButton.setBounds(185, 317, 118, 41);
		appointmentDuePanel.add(docDueRefreshButton);
		
		JLabel docDueTodayLabel = new JLabel("Due Today");
		docDueTodayLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		docDueTodayLabel.setBounds(175, 242, 205, 65);
		appointmentDuePanel.add(docDueTodayLabel);
		
		JScrollPane docDueScrollPane = new JScrollPane();
		docDueScrollPane.setBounds(554, 47, 445, 444);
		docDueScrollPane.getViewport().setBackground(Color.WHITE);
		appointmentDuePanel.add(docDueScrollPane);
		
		docDueTable = new JTable();
		docDueTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		docDueTable.setBackground(new Color(238,255,252));
		docDueScrollPane.setViewportView(docDueTable);
		
		docDueModel=new DefaultTableModel();
		docDueModel.setColumnIdentifiers(docDueColum);
		docDueTable.setModel(docDueModel);
		docDueTable.setRowHeight(40);
		
		TableColumnModel docDueColumnModel = docDueTable.getColumnModel();
		docDueColumnModel.getColumn(0).setPreferredWidth(80);
		docDueColumnModel.getColumn(1).setPreferredWidth(40);
		docDueColumnModel.getColumn(2).setPreferredWidth(5);
		docDueColumnModel.getColumn(3).setPreferredWidth(5);
		docDueColumnModel.getColumn(4).setPreferredWidth(5);
		loadDataToDoctorDueTable();
		
		docSetAlertPanel = new JPanel();
		docSetAlertPanel.setBackground(new Color(229,234,230));
		docSetAlertPanel.setForeground(new Color(229,234,230));
		activityContentlayeredPane.add(docSetAlertPanel, "name_292845815149100");
		docSetAlertPanel.setLayout(null);
		
		JLabel docTimeLabel = new JLabel("Time");
		docTimeLabel.setForeground(Color.DARK_GRAY);
		docTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		docTimeLabel.setBackground(new Color(229, 234, 230));
		docTimeLabel.setBounds(60, 99, 59, 28);
		docSetAlertPanel.add(docTimeLabel);
		
		docTimeTextField = new JTextField();
		docTimeTextField.setBackground(Color.WHITE);
		docTimeTextField.setColumns(10);
		docTimeTextField.setBounds(169, 92, 226, 35);
		docSetAlertPanel.add(docTimeTextField);
		
		JLabel doctimeFormatLabel = new JLabel("(hh:mm AM/PM)");
		doctimeFormatLabel.setForeground(Color.DARK_GRAY);
		doctimeFormatLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		doctimeFormatLabel.setBackground(new Color(229, 234, 230));
		doctimeFormatLabel.setBounds(60, 133, 114, 28);
		docSetAlertPanel.add(doctimeFormatLabel);
		
		JLabel docDateLabel = new JLabel("Date");
		docDateLabel.setForeground(Color.DARK_GRAY);
		docDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		docDateLabel.setBackground(new Color(229, 234, 230));
		docDateLabel.setBounds(60, 171, 59, 28);
		docSetAlertPanel.add(docDateLabel);
		
		JDateChooser docDueDateChooser = new JDateChooser();
		docDueDateChooser.setBounds(169, 171, 152, 35);
		docSetAlertPanel.add(docDueDateChooser);
		
		JButton docSetAlertButton = new JButton("Set Alert");
		docSetAlertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date=docDueDateChooser.getDate();
				String strDate=DateFormat.getInstance().format(date);
				String[] arrDate=strDate.split(",");
				int selectedRowIndex=docSetAlertTable.getSelectedRow();
				String setAlertPatientName=(String) addAppointmentModel.getValueAt(selectedRowIndex, 0).toString();
				String setAlertTime=(String) docTimeTextField.getText().trim();
				String setAlertDate=(String) arrDate[0];
				String setAlertStatus="Alert on";
				docAlertListRow[0]=setAlertPatientName;
				docAlertListRow[1]=setAlertTime;
				docAlertListRow[2]=setAlertDate;
				docAlertListRow[3]=setAlertStatus;
				docAlertListModel.addRow(docAlertListRow);
				docTimeTextField.setText("");
				
				ArrayList<Doctor> tempArrD=new ArrayList<Doctor>();
				Doctor tempD=new Doctor();
				tempD.loadDoctorData(docFilePath, tempArrD);
				
				for(int i=0; i<tempArrD.size(); i++) {
					Doctor temp=tempArrD.get(i);
					if(temp.getName().equalsIgnoreCase(userName)) {
						temp.setDocAlertPatientName(setAlertPatientName);
						temp.setDocAlertTime(setAlertTime);
						temp.setDocAlertDate(setAlertDate);
						temp.setDocAlertStatus(setAlertStatus);
						tempArrD.set(i, temp);
						break;
					}
				}
				tempD.addUser(docFilePath, tempArrD);
			}
		});
		docSetAlertButton.setForeground(Color.WHITE);
		docSetAlertButton.setBackground(new Color(94,194,162));
		docSetAlertButton.setBounds(169, 274, 118, 41);
		docSetAlertPanel.add(docSetAlertButton);
		
		docSetAlertScrollPane = new JScrollPane();
		docSetAlertScrollPane.setBounds(590, 48, 400, 489);
		docSetAlertScrollPane.getViewport().setBackground(Color.WHITE);
		docSetAlertPanel.add(docSetAlertScrollPane);
		
		docSetAlertTable = new JTable();
		docSetAlertTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		docSetAlertScrollPane.setViewportView(docSetAlertTable);
		docSetAlertTable.setBackground(new Color(238,255,252));
		docSetAlertTable.setModel(addAppointmentModel);
		docSetAlertTable.setRowHeight(30);
		
		TableColumnModel setAlertColumnModel = docSetAlertTable.getColumnModel();
		setAlertColumnModel.getColumn(0).setPreferredWidth(80);
		setAlertColumnModel.getColumn(1).setPreferredWidth(40);
		setAlertColumnModel.getColumn(2).setPreferredWidth(5);
		setAlertColumnModel.getColumn(3).setPreferredWidth(5);
		
		docAlertListScrollPane = new JScrollPane();
		docAlertListScrollPane.setBounds(60, 402, 435, 134);
		docAlertListScrollPane.getViewport().setBackground(Color.WHITE);
		docSetAlertPanel.add(docAlertListScrollPane);
		
		docAlertListTable = new JTable();
		docAlertListTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		docAlertListTable.setBackground(new Color(238,255,252));
		docAlertListTable.setRowHeight(30);
		docAlertListScrollPane.setViewportView(docAlertListTable);
		
		docAlertListModel=new DefaultTableModel();
		docAlertListModel.setColumnIdentifiers(docAlertListColums);
		docAlertListTable.setModel(docAlertListModel);
		
		TableColumnModel docAlertListColumModel=docAlertListTable.getColumnModel();
		docAlertListColumModel.getColumn(0).setPreferredWidth(80);
		docAlertListColumModel.getColumn(1).setPreferredWidth(5);
		docAlertListColumModel.getColumn(2).setPreferredWidth(5);
		docAlertListColumModel.getColumn(3).setPreferredWidth(5);
		loadDataToDocSetAlertListTable();
		
		
		JLabel doctorAlertListLabel = new JLabel("Alert List");
		doctorAlertListLabel.setForeground(Color.DARK_GRAY);
		doctorAlertListLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		doctorAlertListLabel.setBackground(new Color(229, 234, 230));
		doctorAlertListLabel.setBounds(61, 364, 70, 28);
		docSetAlertPanel.add(doctorAlertListLabel);
		
		JLabel doctorSelectHereLabel = new JLabel("Select Here");
		doctorSelectHereLabel.setForeground(Color.DARK_GRAY);
		doctorSelectHereLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		doctorSelectHereLabel.setBackground(new Color(229, 234, 230));
		doctorSelectHereLabel.setBounds(590, 10, 80, 28);
		docSetAlertPanel.add(doctorSelectHereLabel);
		
		JButton docTurnOffAlertButton = new JButton("Turn Off Alert");
		docTurnOffAlertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowIndex=docAlertListTable.getSelectedRow();
				String alerListPatientName=docAlertListModel.getValueAt(selectedRowIndex, 0).toString().trim();
				String alertListTime=docAlertListModel.getValueAt(selectedRowIndex, 1).toString().trim();
				String alertListDate=docAlertListModel.getValueAt(selectedRowIndex, 2).toString().trim();
				String alertListStatus="Off";
				docAlertListModel.setValueAt("Alert Off", selectedRowIndex, 3);
				
				ArrayList<Doctor> tempArrD=new ArrayList<Doctor>();
				Doctor tempD=new Doctor();
				tempD.loadDoctorData(docFilePath, tempArrD);
				
				for(int i=0; i<tempArrD.size(); i++) {
					Doctor temp=(Doctor) tempArrD.get(i);
					if(temp.getName().equalsIgnoreCase(userName)) {
						ArrayList<String> tempAlertListPatientName=temp.getDocAlertPatientName();
						ArrayList<String> tempAlertListTime=temp.getDocAlertTime();
						ArrayList<String> tempAlertListDate=temp.getDocAlertDate();
						ArrayList<String> tempAlertListStatus=temp.getDocAlertStatus();
						
						for(int j=0; j<tempAlertListPatientName.size(); j++) {
							if(tempAlertListPatientName.get(j).equalsIgnoreCase(alerListPatientName) && tempAlertListTime.get(j).equalsIgnoreCase(alertListTime) 
								&& tempAlertListDate.get(j).equalsIgnoreCase(alertListDate)) {
								tempAlertListStatus.set(j, alertListStatus);
								break;
							}
						}
						tempArrD.set(i, temp);
						break;
					}
				}
				tempD.addUser(docFilePath, tempArrD);
			}
		});
		docTurnOffAlertButton.setForeground(Color.WHITE);
		docTurnOffAlertButton.setBackground(new Color(220, 59, 59));
		docTurnOffAlertButton.setBounds(304, 274, 118, 41);
		docSetAlertPanel.add(docTurnOffAlertButton);
		
		
		
		addPatientVisitPanel = new JPanel();
		addPatientVisitPanel.setBounds(413, 198, 1046, 536);
		addPatientVisitPanel.setForeground(new Color(229,234,230));
		addPatientVisitPanel.setBackground(new Color(229,234,230));
		activityContentlayeredPane.add(addPatientVisitPanel, "name_357329325946400");
		addPatientVisitPanel.setLayout(null);
		
		JLabel nursePatientNameLabel = new JLabel("Patient Name");
		nursePatientNameLabel.setForeground(Color.DARK_GRAY);
		nursePatientNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nursePatientNameLabel.setBackground(new Color(229, 234, 230));
		nursePatientNameLabel.setBounds(91, 96, 144, 35);
		addPatientVisitPanel.add(nursePatientNameLabel);
		
		nursePatientNameTextField = new JTextField();
		nursePatientNameTextField.setColumns(10);
		nursePatientNameTextField.setBounds(246, 96, 226, 35);
		addPatientVisitPanel.add(nursePatientNameTextField);
		
		JLabel bedNumberLabel = new JLabel("Bed Number");
		bedNumberLabel.setForeground(Color.DARK_GRAY);
		bedNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bedNumberLabel.setBackground(new Color(229, 234, 230));
		bedNumberLabel.setBounds(91, 165, 144, 35);
		addPatientVisitPanel.add(bedNumberLabel);
		
		bedNumberTextField = new JTextField();
		bedNumberTextField.setColumns(10);
		bedNumberTextField.setBounds(246, 165, 70, 35);
		addPatientVisitPanel.add(bedNumberTextField);
		
		JLabel nurseMedicineNameLabel = new JLabel("Mdeicine Name");
		nurseMedicineNameLabel.setForeground(Color.DARK_GRAY);
		nurseMedicineNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nurseMedicineNameLabel.setBackground(new Color(229, 234, 230));
		nurseMedicineNameLabel.setBounds(91, 233, 144, 35);
		addPatientVisitPanel.add(nurseMedicineNameLabel);
		
		nurseMedicineTextField = new JTextField();
		nurseMedicineTextField.setColumns(10);
		nurseMedicineTextField.setBounds(246, 233, 226, 35);
		addPatientVisitPanel.add(nurseMedicineTextField);
		
		JComboBox nurseMedQuantityComboBox = new JComboBox(items);
		nurseMedQuantityComboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		nurseMedQuantityComboBox.setBounds(246, 302, 91, 35);
		addPatientVisitPanel.add(nurseMedQuantityComboBox);
		
		nurseMdeicineQntyLabel = new JLabel("Mdeicine Qnty.");
		nurseMdeicineQntyLabel.setForeground(Color.DARK_GRAY);
		nurseMdeicineQntyLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nurseMdeicineQntyLabel.setBackground(new Color(229, 234, 230));
		nurseMdeicineQntyLabel.setBounds(91, 302, 144, 35);
		addPatientVisitPanel.add(nurseMdeicineQntyLabel);
		
		patientVisitScrollPane = new JScrollPane();
		patientVisitScrollPane.setBounds(554, 47, 464, 444);
		patientVisitScrollPane.getViewport().setBackground(Color.WHITE);
		addPatientVisitPanel.add(patientVisitScrollPane);
		
		patientVisitTable = new JTable();
		patientVisitTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		patientVisitTable.setBackground(new Color(238,255,252));
		patientVisitScrollPane.setViewportView(patientVisitTable);
		
		patientVisitModel=new DefaultTableModel();
		patientVisitModel.setColumnIdentifiers(patientVisitColums);
		patientVisitTable.setModel(patientVisitModel);
		patientVisitTable.setRowHeight(40);
		
		TableColumnModel patientVisitColumnModel = patientVisitTable.getColumnModel();
		patientVisitColumnModel.getColumn(0).setPreferredWidth(80);
		patientVisitColumnModel.getColumn(1).setPreferredWidth(5);
		patientVisitColumnModel.getColumn(2).setPreferredWidth(40);
		patientVisitColumnModel.getColumn(3).setPreferredWidth(5);
		loadDataToNursePatientVisitTable();
		
		JButton addPatientVisitButton = new JButton("Add");
		addPatientVisitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String visitPatientName=nursePatientNameTextField.getText().trim();
				String visitBedNumber=bedNumberTextField.getText().trim();
				String visitMedicineName=nurseMedicineTextField.getText().trim();
				String visitMedicineQty=nurseMedQuantityComboBox.getSelectedItem().toString().trim();
				patientVisitRow[0]=visitPatientName;
				patientVisitRow[1]=visitBedNumber;
				patientVisitRow[2]=visitMedicineName;
				patientVisitRow[3]=visitMedicineQty;
				patientVisitModel.addRow(patientVisitRow);
				
				nursePatientNameTextField.setText("");
				bedNumberTextField.setText("");
				nurseMedQuantityComboBox.setSelectedIndex(0);
				nurseMedicineTextField.setText("");
				
				ArrayList<Nurse> tempArrN=new ArrayList<Nurse>();
				Nurse tempN=new Nurse();
				tempN.loadNurseData(nurseFilePath, tempArrN);
				
				for(int i=0; i<tempArrN.size(); i++) {
					Nurse temp=(Nurse) tempArrN.get(i);
					if(temp.getName().equalsIgnoreCase(userName)) {
						temp.setAddVisitPatientName(visitPatientName);
						temp.setAddVisitBedNumber(visitBedNumber);
						temp.setAddVisitMedName(visitMedicineName);
						temp.setAddVisitMedQty(visitMedicineQty);
						tempArrN.set(i, temp);
						break;
					}
				}
				tempN.addUser(nurseFilePath, tempArrN);
			}
		});
		addPatientVisitButton.setForeground(Color.WHITE);
		addPatientVisitButton.setBackground(new Color(94, 94, 194));
		addPatientVisitButton.setBounds(158, 404, 118, 41);
		addPatientVisitPanel.add(addPatientVisitButton);
		
		JButton deletePatientVisitButton = new JButton("Delete");
		deletePatientVisitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=patientVisitTable.getSelectedRow();
				String selectedPatientName=patientVisitModel.getValueAt(selectedRow, 0).toString().trim();
				String selectedBedNumber=patientVisitModel.getValueAt(selectedRow, 1).toString().trim();
				String selectedMedicineName=patientVisitModel.getValueAt(selectedRow, 2).toString().trim();
				String selectedMedicineQty=patientVisitModel.getValueAt(selectedRow, 3).toString().trim();
				
				if(selectedRow>=0) {
					patientVisitModel.removeRow(selectedRow);
					ArrayList<Nurse> tempArrN=new ArrayList<Nurse>();
					Nurse tempN=new Nurse();
					tempN.loadNurseData(nurseFilePath, tempArrN);
					
					for(int i=0; i<tempArrN.size(); i++) {
						Nurse temp=(Nurse) tempArrN.get(i);
						if(temp.getName().equalsIgnoreCase(userName)) {
							temp.deleteAddVisitPatientName(selectedPatientName);
							temp.deleteAddVisitMedName(selectedMedicineName);
							temp.deleteAddVisitBedNumber(selectedBedNumber);
							temp.deleteAddVisitMedQty(selectedMedicineQty);
							tempArrN.set(i, temp);
							break;
						}
					}
					tempN.addUser(nurseFilePath, tempArrN);
				}
				
			}
		});
		deletePatientVisitButton.setForeground(Color.WHITE);
		deletePatientVisitButton.setBackground(new Color(220, 59, 59));
		deletePatientVisitButton.setBounds(301, 404, 118, 41);
		addPatientVisitPanel.add(deletePatientVisitButton);
		
		nurseDuePanel = new JPanel();
		nurseDuePanel.setBounds(413, 198, 1046, 536);
		nurseDuePanel.setForeground(new Color(229,234,230));
		nurseDuePanel.setBackground(new Color(229,234,230));
		activityContentlayeredPane.add(nurseDuePanel, "name_385195264362000");
		nurseDuePanel.setLayout(null);
		
		JLabel nurseDueTodayLabe = new JLabel("Due Today");
		nurseDueTodayLabe.setFont(new Font("Tahoma", Font.BOLD, 24));
		nurseDueTodayLabe.setBounds(175, 242, 205, 65);
		nurseDuePanel.add(nurseDueTodayLabe);
		
		JButton nurseDueRefreshButton = new JButton("Refresh");
		nurseDueRefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nurseDueModel.setRowCount(0);
				loadDataToNurseDueTable();
			}
		});
		nurseDueRefreshButton.setForeground(Color.WHITE);
		nurseDueRefreshButton.setBackground(new Color(146,94,194));
		nurseDueRefreshButton.setBounds(185, 317, 118, 41);
		nurseDuePanel.add(nurseDueRefreshButton);
		
		JScrollPane nurseDueScrollPane = new JScrollPane();
		nurseDueScrollPane.setBounds(554, 47, 464, 444);
		nurseDueScrollPane.getViewport().setBackground(Color.WHITE);
		nurseDuePanel.add(nurseDueScrollPane);
		
		nurseDueTable = new JTable();
		nurseDueTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nurseDueTable.setBackground(new Color(238,255,252));
		nurseDueTable.setRowHeight(40);
		nurseDueScrollPane.setViewportView(nurseDueTable);
		
		nurseDueModel=new DefaultTableModel();
		nurseDueModel.setColumnIdentifiers(nurseDueColum);
		nurseDueTable.setModel(nurseDueModel);
		
		TableColumnModel nurseDueColumnModel = nurseDueTable.getColumnModel();
		nurseDueColumnModel.getColumn(0).setPreferredWidth(80);
		nurseDueColumnModel.getColumn(1).setPreferredWidth(5);
		nurseDueColumnModel.getColumn(2).setPreferredWidth(5);
		nurseDueColumnModel.getColumn(3).setPreferredWidth(40);
		nurseDueColumnModel.getColumn(4).setPreferredWidth(10);
		loadDataToNurseDueTable();
		
		nurseSetAlertPanel = new JPanel();
		nurseSetAlertPanel.setBounds(413, 198, 1046, 536);
		nurseSetAlertPanel.setForeground(new Color(229,234,230));
		nurseSetAlertPanel.setBackground(new Color(229,234,230));
		activityContentlayeredPane.add(nurseSetAlertPanel, "name_386065400734900");
		nurseSetAlertPanel.setLayout(null);
		
		JLabel nurseAlertTimeLabel = new JLabel("Time");
		nurseAlertTimeLabel.setForeground(Color.DARK_GRAY);
		nurseAlertTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nurseAlertTimeLabel.setBackground(new Color(229, 234, 230));
		nurseAlertTimeLabel.setBounds(60, 99, 59, 28);
		nurseSetAlertPanel.add(nurseAlertTimeLabel);
		
		nurseAlertTimeTextField = new JTextField();
		nurseAlertTimeTextField.setBackground(Color.WHITE);
		nurseAlertTimeTextField.setColumns(10);
		nurseAlertTimeTextField.setBounds(169, 92, 226, 35);
		nurseSetAlertPanel.add(nurseAlertTimeTextField);
		
		JLabel nurseAlertTimeFormatLabel = new JLabel("(hh:mm AM/PM)");
		nurseAlertTimeFormatLabel.setForeground(Color.DARK_GRAY);
		nurseAlertTimeFormatLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nurseAlertTimeFormatLabel.setBackground(new Color(229, 234, 230));
		nurseAlertTimeFormatLabel.setBounds(60, 133, 114, 28);
		nurseSetAlertPanel.add(nurseAlertTimeFormatLabel);
		
		JLabel nurseAlertDateLabel = new JLabel("Date");
		nurseAlertDateLabel.setForeground(Color.DARK_GRAY);
		nurseAlertDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nurseAlertDateLabel.setBackground(new Color(229, 234, 230));
		nurseAlertDateLabel.setBounds(60, 171, 59, 28);
		nurseSetAlertPanel.add(nurseAlertDateLabel);
		
		JButton nurseSetAlertButton = new JButton("Set Alert");
		nurseSetAlertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date=nurseAlertDateChooser.getDate();
				String strDate=DateFormat.getInstance().format(date);
				String[] arrDate=strDate.split(",");
				int selectedRowIndex=nurseSetAlertTable.getSelectedRow();
				String setNurseAlertPatientName=(String) patientVisitModel.getValueAt(selectedRowIndex, 0).toString();
				String setNurseAlertBedNumber=(String) patientVisitModel.getValueAt(selectedRowIndex, 1).toString();
				String setNurseAlertTime=(String) nurseAlertTimeTextField.getText().trim();
				String setNurseAlertDate=(String) arrDate[0];
				String setNurseAlertStatus="On";
				nurseAlertListRow[0]=setNurseAlertPatientName;
				nurseAlertListRow[1]=setNurseAlertBedNumber;
				nurseAlertListRow[2]=setNurseAlertTime;
				nurseAlertListRow[3]=setNurseAlertDate;
				nurseAlertListRow[4]=setNurseAlertStatus;
				nurseAlertListModel.addRow(nurseAlertListRow);
				nurseAlertTimeTextField.setText("");
				
				ArrayList<Nurse> tempArrN=new ArrayList<Nurse>();
				Nurse tempN=new Nurse();
				tempN.loadNurseData(nurseFilePath, tempArrN);
				
				for(int i=0; i<tempArrN.size(); i++) {
					Nurse temp=(Nurse) tempArrN.get(i);
					if(temp.getName().equalsIgnoreCase(userName)) {
						temp.setNurseAlertPatientName(setNurseAlertPatientName);
						temp.setAlertPatientBedNumber(setNurseAlertBedNumber);
						temp.setNurseAlertDate(setNurseAlertDate);
						temp.setNurseAlertTime(setNurseAlertTime);
						temp.setNurseAlertStatus(setNurseAlertStatus);
						tempArrN.set(i, temp);
						break;
					}
				}
				tempN.addUser(nurseFilePath, tempArrN);
			}
		});
		nurseSetAlertButton.setForeground(Color.WHITE);
		nurseSetAlertButton.setBackground(new Color(94,194,162));
		nurseSetAlertButton.setBounds(169, 274, 118, 41);
		nurseSetAlertPanel.add(nurseSetAlertButton);
		
		nurseAlertDateChooser = new JDateChooser();
		nurseAlertDateChooser.setBounds(169, 171, 152, 35);
		nurseSetAlertPanel.add(nurseAlertDateChooser);
		
		nurseSetAlertScrollPane = new JScrollPane();
		nurseSetAlertScrollPane.setBounds(572, 48, 464, 489);
		nurseSetAlertScrollPane.getViewport().setBackground(Color.WHITE);
		nurseSetAlertPanel.add(nurseSetAlertScrollPane);
		
		nurseSetAlertTable = new JTable();
		nurseSetAlertTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nurseSetAlertTable.setBackground(new Color(238,255,252));
		nurseSetAlertTable.setRowHeight(40);
		nurseSetAlertScrollPane.setViewportView(nurseSetAlertTable);
		nurseSetAlertTable.setModel(patientVisitModel);
		
		TableColumnModel nurseSetAlertTableColumnModel = nurseSetAlertTable.getColumnModel();
		nurseSetAlertTableColumnModel.getColumn(0).setPreferredWidth(80);
		nurseSetAlertTableColumnModel.getColumn(1).setPreferredWidth(5);
		nurseSetAlertTableColumnModel.getColumn(2).setPreferredWidth(40);
		nurseSetAlertTableColumnModel.getColumn(3).setPreferredWidth(5);
		
		
		nurseAlertListScrollPane = new JScrollPane();
		nurseAlertListScrollPane.setBounds(60, 402, 435, 134);
		nurseAlertListScrollPane.getViewport().setBackground(Color.WHITE);
		nurseSetAlertPanel.add(nurseAlertListScrollPane);
		
		nurseAlertListTable = new JTable();
		nurseAlertListTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nurseAlertListTable.setBackground(new Color(238,255,252));
		nurseAlertListTable.setRowHeight(30);
		nurseAlertListScrollPane.setViewportView(nurseAlertListTable);
		
		nurseAlertListModel=new DefaultTableModel();
		nurseAlertListModel.setColumnIdentifiers(nurseAlertListColum);
		nurseAlertListTable.setModel(nurseAlertListModel);
		
		TableColumnModel nurseAlertListTableColumnModel = nurseAlertListTable.getColumnModel();
		nurseAlertListTableColumnModel.getColumn(0).setPreferredWidth(80);
		nurseAlertListTableColumnModel.getColumn(1).setPreferredWidth(10);
		nurseAlertListTableColumnModel.getColumn(2).setPreferredWidth(5);
		nurseAlertListTableColumnModel.getColumn(3).setPreferredWidth(5);
		nurseAlertListTableColumnModel.getColumn(4).setPreferredWidth(10);
		loadDataToNurseSetAlertListTable();
		
		JLabel nurseAlertListLabel = new JLabel("Alert List");
		nurseAlertListLabel.setForeground(Color.DARK_GRAY);
		nurseAlertListLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nurseAlertListLabel.setBackground(new Color(229, 234, 230));
		nurseAlertListLabel.setBounds(60, 364, 70, 28);
		nurseSetAlertPanel.add(nurseAlertListLabel);
		
		JLabel nurseSelectHereLabel = new JLabel("Select Here");
		nurseSelectHereLabel.setForeground(Color.DARK_GRAY);
		nurseSelectHereLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nurseSelectHereLabel.setBackground(new Color(229, 234, 230));
		nurseSelectHereLabel.setBounds(572, 10, 80, 28);
		nurseSetAlertPanel.add(nurseSelectHereLabel);
		
		nurseTurnOffAlertButton = new JButton("Turn Off Alert");
		nurseTurnOffAlertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowIndex=nurseAlertListTable.getSelectedRow();
				String alertListPatientName=nurseAlertListModel.getValueAt(selectedRowIndex, 0).toString().trim();
				String alertListBedNumber=nurseAlertListModel.getValueAt(selectedRowIndex, 1).toString().trim();
				String alertListTime=nurseAlertListModel.getValueAt(selectedRowIndex, 2).toString().trim();
				String alertListDate=nurseAlertListModel.getValueAt(selectedRowIndex, 3).toString().trim();
				String alertListStatus="Off";
				nurseAlertListModel.setValueAt("Alert Off", selectedRowIndex, 4);
				
				ArrayList<Nurse> tempArrN=new ArrayList<Nurse>();
				Nurse tempN=new Nurse();
				tempN.loadNurseData(nurseFilePath, tempArrN);
				
				for(int i=0; i<tempArrN.size(); i++) {
					Nurse temp=(Nurse) tempArrN.get(i);
					if(temp.getName().equalsIgnoreCase(userName)) {
						ArrayList<String> tempAlertListPatientName=temp.getSetAlertPatientName();
						ArrayList<String> tempAlertListBedNumber=temp.getSetAlertPatientBedNumber();
						ArrayList<String> tempAlertListTime=temp.getSetAlertTime();
						ArrayList<String> tempAlertListDate=temp.getSetAlertDate();
						ArrayList<String> tempAlertListStatus=temp.getSetAlertStatus();
						
						for(int j=0; j<tempAlertListPatientName.size(); j++) {
							if(tempAlertListPatientName.get(j).equalsIgnoreCase(alertListPatientName) && tempAlertListBedNumber.get(j).equalsIgnoreCase(alertListBedNumber) 
									&& tempAlertListTime.get(j).equalsIgnoreCase(alertListTime) && tempAlertListDate.get(j).equalsIgnoreCase(alertListDate)) {
								
								tempAlertListStatus.set(j, alertListStatus);
								break;
							}
						}
						tempArrN.set(i, temp);
						break;
					}
				}
				tempN.addUser(nurseFilePath, tempArrN);
			}
		});
		nurseTurnOffAlertButton.setForeground(Color.WHITE);
		nurseTurnOffAlertButton.setBackground(new Color(220, 59, 59));
		nurseTurnOffAlertButton.setBounds(297, 274, 118, 41);
		nurseSetAlertPanel.add(nurseTurnOffAlertButton);
		
		
		JLabel dashboardTopBar = new JLabel("");
		dashboardTopBar.setIcon(new ImageIcon(Dashboard.class.getResource("/images/dashboardTitleBar.png")));
		dashboardTopBar.setForeground(Color.WHITE);
		dashboardTopBar.setBounds(0, 0, 1500, 36);
		getContentPane().add(dashboardTopBar);
		dashboardTopBar.addMouseMotionListener(new MouseAdapter()
		{
			 @Override
		     public void mouseDragged(MouseEvent evt)
		     {
				int x = evt.getXOnScreen();
				int y = evt.getYOnScreen();
				setLocation(x-posX,y-posY);
							
		     }
		});
		dashboardTopBar.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX=e.getX();
				posY=e.getY();
			}
		});
		
		crossDashboardLabel = new JLabel("");
		crossDashboardLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		crossDashboardLabel.setForeground(Color.WHITE);
		crossDashboardLabel.setBounds(1450, 2, 30, 30);
		crossDashboardLabel.setIcon(new ImageIcon(crossDashboardLogo));
		dashboardTopBar.add(crossDashboardLabel);
		
		minimizeDashboardLogo_2 = new JLabel("");
		minimizeDashboardLogo_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(frame.ICONIFIED);
			}
		});
		minimizeDashboardLogo_2.setIcon(new ImageIcon(Dashboard.class.getResource("/images/minus.png")));
		minimizeDashboardLogo_2.setBounds(1400, 1, 30, 30);
		dashboardTopBar.add(minimizeDashboardLogo_2);
		
		JLabel appdashboardLogo = new JLabel("");
		appdashboardLogo.setIcon(new ImageIcon(Dashboard.class.getResource("/images/doctor.png")));
		appdashboardLogo.setBounds(3, 4, 30, 29);
		dashboardTopBar.add(appdashboardLogo);
		
		JLabel appDashboardTitleLabel = new JLabel("Medical Assistant");
		appDashboardTitleLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		appDashboardTitleLabel.setBounds(41, 10, 100, 13);
		dashboardTopBar.add(appDashboardTitleLabel);
	}
	
	public void loadDataToPatientAddMedTable() {
		ArrayList<Patient> tempArrP=new ArrayList<Patient>();
		Patient tempP=new Patient();
		tempP.loadPatientData(filePath, tempArrP);
		
		Iterator<Patient> iter=tempArrP.iterator();
		
		while(iter.hasNext()) {
			Patient temp=(Patient) iter.next();
			if(temp.getName().equalsIgnoreCase(userName)) {
				ArrayList<String> tempArrM=temp.getAddMedicineName();
				Iterator<String> i=tempArrM.iterator();
				ArrayList<String> tempArrMg=temp.getAddMg();
				Iterator<String> j=tempArrMg.iterator();
				while(i.hasNext() && j.hasNext()) {
					row[0]=(String)i.next().trim();
					row[1]=(String)j.next().trim();
					model.addRow(row);
				}
				break;
			}
		}

	}
	
	public void loadDataToPatientAddPresTable() {
		ArrayList<Patient> tempArrP=new ArrayList<Patient>();
		Patient tempP=new Patient();
		tempP.loadPatientData(filePath, tempArrP);
		
		Iterator<Patient> iter=tempArrP.iterator();
		
		while(iter.hasNext()) {
			Patient temp=(Patient) iter.next();
			if(temp.getName().equalsIgnoreCase(userName)) {
				ArrayList<String> tempArrM=temp.getAddPresMedicineName();
				Iterator<String> iterTempArrM=tempArrM.iterator();
				ArrayList<String> tempArrMg=temp.getAddPresMg();
				Iterator<String> iterTempArrMg=tempArrMg.iterator();
				ArrayList<String> tempArrMoring=temp.getAddPresMorning();
				Iterator<String> iterTempArrMoring=tempArrMoring.iterator();
				ArrayList<String> tempArrEvening=temp.getAddPresEvening();
				Iterator<String> iterTemparrEvening=tempArrEvening.iterator();
				ArrayList<String> tempArrNight=temp.getAddPresNight();
				Iterator<String> iterTempArrNight=tempArrNight.iterator();
				ArrayList<String> tempArrTotalCourseDay=temp.getTotalCourseDays();
				Iterator<String> iterTempArrTotalCourseDay=tempArrTotalCourseDay.iterator();
				
				while(iterTempArrM.hasNext() && iterTempArrMg.hasNext() && iterTempArrMoring.hasNext() && iterTemparrEvening.hasNext()
						&& iterTempArrNight.hasNext() && iterTempArrTotalCourseDay.hasNext()) {
					presRow[0]=(String) iterTempArrM.next().trim();
					presRow[1]=(String) iterTempArrMg.next().trim();
					presRow[2]=(String) iterTempArrMoring.next().trim();
					presRow[3]=(String) iterTemparrEvening.next().trim();
					presRow[4]=(String) iterTempArrNight.next().trim();
					presRow[5]=(String) iterTempArrTotalCourseDay.next().trim();
					prescriptionModel.addRow(presRow);
					
				}
				break;
			}
			
		}
	}
	
	public void loadDataToPatientSetAlertListTable() {
		ArrayList<Patient> tempArrP=new ArrayList<Patient>();
		Patient tempP=new Patient();
		tempP.loadPatientData(filePath, tempArrP);
		
		Iterator<Patient> iter=tempArrP.iterator();
		
		while(iter.hasNext()) {
			Patient temp=(Patient) iter.next();
			if(temp.getName().equalsIgnoreCase(userName)) {
				ArrayList<String> tempArrAlerListMedName=temp.getAlertMedicineName();
				Iterator<String> iterTempArrAlertListMedName=tempArrAlerListMedName.iterator();
				ArrayList<String> tempArrAlertListTime=temp.getAlertTime();
				Iterator<String> iterTempArrAlertListTime=tempArrAlertListTime.iterator();
				ArrayList<String> tempArrAlertListDate=temp.getAlertDate();
				Iterator<String> iterTempAlertListDate=tempArrAlertListDate.iterator();
				ArrayList<String> tempAlertListStatus=temp.getAlertStatus();
				Iterator<String> iterTempAlertListStatus=tempAlertListStatus.iterator();
				
				while(iterTempArrAlertListMedName.hasNext() && iterTempArrAlertListTime.hasNext() && iterTempAlertListDate.hasNext() 
						&& iterTempAlertListStatus.hasNext()) {
					alertRow[0]=(String) iterTempArrAlertListMedName.next().trim();
					alertRow[1]=(String) iterTempArrAlertListTime.next().trim();
					alertRow[2]=(String) iterTempAlertListDate.next().trim();
					alertRow[3]=(String) iterTempAlertListStatus.next().trim();
					alertListModel.addRow(alertRow);
		
				}
				break;
			}
		}
	}
	
	public void loadTodaysDueDataToPatientDueTable() {
		ArrayList<Patient> tempArrP=new ArrayList<Patient>();
		Patient tempP=new Patient();
		tempP.loadPatientData(filePath, tempArrP);
		
		Iterator<Patient> iter=tempArrP.iterator();
		
		while(iter.hasNext()) {
			Patient temp=(Patient) iter.next();
			if(temp.getName().equalsIgnoreCase(userName)) {
				
				ArrayList<String> alertDueMedName=temp.getAlertMedicineName();
				ArrayList<String> alertDueDateArr=temp.getAlertDate();
				ArrayList<String> alertDueTimeArr=temp.getAlertTime();
				ArrayList<String> alertStatusDue=temp.getAlertStatus();
				Date currentSystemDate=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yy");
				String currentDate=sdf.format(currentSystemDate);
				System.out.println(currentDate);
				
				for(int i=0; i<alertDueMedName.size(); i++) {
					String[] dateArr=alertDueDateArr.get(i).split("/");
					int first=(int) Integer.valueOf(dateArr[0]);
					int second=(int) Integer.valueOf(dateArr[1]);
					String month=first<10 ? "0"+dateArr[0] : dateArr[0];
					String date=second<10 ? "0"+dateArr[1] : dateArr[1];
					
					String convertedDate=month+"/"+date+"/"+dateArr[2];
					System.out.println(convertedDate);
					if(convertedDate.equalsIgnoreCase(currentDate)) {
						
						dueRow[0]=alertDueMedName.get(i).trim();
						dueRow[1]=alertDueDateArr.get(i).trim();
						dueRow[2]=alertDueTimeArr.get(i).trim();
						dueRow[3]=alertStatusDue.get(i).trim();
						patientDueModel.addRow(dueRow);
					}
				}
				break;
			}
		}
	}
	
	public void loadDataToDoctorAppointTable() {
		ArrayList<Doctor> tempArrD=new ArrayList<Doctor>();
		Doctor tempD=new Doctor();
		tempD.loadDoctorData(docFilePath, tempArrD);
		
		Iterator<Doctor> iter=tempArrD.iterator();
		
		while(iter.hasNext()) {
			Doctor temp=iter.next();
			if(temp.getName().equalsIgnoreCase(userName)) {
				ArrayList<String> tempArrPName=temp.getAddAppointPatientName();
				Iterator<String> iterTempArrPName=tempArrPName.iterator();
				ArrayList<String> tempArrPNum=temp.getAddAppointPatientNumber();
				Iterator<String> iterTempArrPNum=tempArrPNum.iterator();
				ArrayList<String> tempArrTime=temp.getAddAppointTime();
				Iterator<String> iterTempArrTime=tempArrTime.iterator();
				ArrayList<String> tempArrDate=temp.getAddAppointDate();
				Iterator<String> iterTempArrDate=tempArrDate.iterator();
				
				while(iterTempArrPName.hasNext() && iterTempArrPNum.hasNext() && iterTempArrTime.hasNext() && iterTempArrDate.hasNext()) {
					addAppointRow[0]=(String) iterTempArrPName.next().trim();
					addAppointRow[1]=(String) iterTempArrPNum.next().trim();
					addAppointRow[2]=(String) iterTempArrTime.next().trim();
					addAppointRow[3]=(String) iterTempArrDate.next().trim();
					addAppointmentModel.addRow(addAppointRow);
				}
				break;
			}
		}
	}
	
	public void loadDataToDoctorDueTable() {
		ArrayList<Doctor> tempArrD=new ArrayList<Doctor>();
		Doctor tempD=new Doctor();
		tempD.loadDoctorData(docFilePath, tempArrD);
		
		Iterator<Doctor> iter=tempArrD.iterator();
		
		while(iter.hasNext()) {
			Doctor temp=(Doctor) iter.next();
			if(temp.getName().equalsIgnoreCase(userName)) {
				ArrayList<String> duePatientName=temp.getDocAlertPatientName();
				ArrayList<String> duePatientNum=temp.getAddAppointPatientNumber();
				ArrayList<String> duePatientTime=temp.getDocAlertTime();
				ArrayList<String> duePatientDate=temp.getDocAlertDate();
				ArrayList<String> dueAppointAlertStatus=temp.getDocAlertStatus();
				
				Date currentSystemDate=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yy");
				String currentDate=sdf.format(currentSystemDate);
				
				for(int i=0; i<duePatientName.size(); i++) {
					String[] dateArr=duePatientDate.get(i).split("/");
					int first=(int) Integer.valueOf(dateArr[0]);
					int second=(int) Integer.valueOf(dateArr[1]);
					String month=first<10 ? "0"+dateArr[0] : dateArr[0];
					String date=second<10 ? "0"+dateArr[1] : dateArr[1];
					
					String convertedDate=month+"/"+date+"/"+dateArr[2];
					System.out.println(convertedDate);
					
					if(convertedDate.equalsIgnoreCase(currentDate)) {
						docDueRow[0]=duePatientName.get(i).trim();
						docDueRow[1]=duePatientNum.get(i).trim();
						docDueRow[2]=duePatientTime.get(i).trim();
						docDueRow[3]=duePatientDate.get(i).trim();
						docDueRow[4]=dueAppointAlertStatus.get(i).trim();
						docDueModel.addRow(docDueRow);
					}
				}
				break;
			}
		}
	}
	
	public void loadDataToDocSetAlertListTable() {
		ArrayList<Doctor> tempArrD=new ArrayList<Doctor>();
		Doctor tempD=new Doctor();
		tempD.loadDoctorData(docFilePath, tempArrD);
		
		Iterator<Doctor> iter=tempArrD.iterator();
		
		while(iter.hasNext()) {
			Doctor temp=(Doctor) iter.next();
			if(temp.getName().equalsIgnoreCase(userName)) {
				ArrayList<String> alertListPatientName=temp.getDocAlertPatientName();
				Iterator<String> iterAlertListPatientName=alertListPatientName.iterator();
				ArrayList<String> alertListTime=temp.getDocAlertTime();
				Iterator<String> iterAlertListTime=alertListTime.iterator();
				ArrayList<String> alertListDate=temp.getDocAlertDate();
				Iterator<String> iterAlertListDate=alertListDate.iterator();
				ArrayList<String> alertListStatus=temp.getDocAlertStatus();
				Iterator<String> iterAlertListStatus=alertListStatus.iterator();
			
				while(iterAlertListPatientName.hasNext() && iterAlertListTime.hasNext() && iterAlertListDate.hasNext() && iterAlertListStatus.hasNext()) {
					docAlertListRow[0]=iterAlertListPatientName.next().trim();
					docAlertListRow[1]=iterAlertListTime.next().trim();
					docAlertListRow[2]=iterAlertListDate.next().trim();
					docAlertListRow[3]=iterAlertListStatus.next().trim();
					docAlertListModel.addRow(docAlertListRow);
				}
				break;
			}
		}
	}
	
	public void loadDataToNursePatientVisitTable() {
		ArrayList<Nurse> tempArrN=new ArrayList<Nurse>();
		Nurse tempN=new Nurse();
		tempN.loadNurseData(nurseFilePath, tempArrN);
		Iterator<Nurse> iter=tempArrN.iterator();
		
		while(iter.hasNext()) {
			Nurse temp=(Nurse) iter.next();
			if(temp.getName().equalsIgnoreCase(userName)) {
				ArrayList<String> visitPatientName=temp.getAddVisitPatientName();
				Iterator<String> iterVisitPatientName=visitPatientName.iterator();
				ArrayList<String> visitPatientBedNumber=temp.getAddVisitBedNumber();
				Iterator<String> iterVisitPatientBedNumber=visitPatientBedNumber.iterator();
				ArrayList<String> visitPatientMedName=temp.getAddVisitMedName();
				Iterator<String> iterVisitPatientMedName=visitPatientMedName.iterator();
				ArrayList<String> visitPatientMedQty=temp.getAddVisitMedQty();
				Iterator<String> iterVisitPatientMedQty=visitPatientMedQty.iterator();
				
				while(iterVisitPatientName.hasNext() && iterVisitPatientBedNumber.hasNext() && iterVisitPatientMedName.hasNext() 
						&& iterVisitPatientMedQty.hasNext()) {
					patientVisitRow[0]=iterVisitPatientName.next().trim();
					patientVisitRow[1]=iterVisitPatientBedNumber.next().trim();
					patientVisitRow[2]=iterVisitPatientMedName.next().trim();
					patientVisitRow[3]=iterVisitPatientMedQty.next().trim();
					patientVisitModel.addRow(patientVisitRow);
					
					}
				break;
			}
		}
	}
	
	public void loadDataToNurseSetAlertListTable() {
		ArrayList<Nurse> tempArrN=new ArrayList<Nurse>();
		Nurse tempN=new Nurse();
		tempN.loadNurseData(nurseFilePath, tempArrN);
		Iterator<Nurse> iter=tempArrN.iterator();
		
		while(iter.hasNext()) {
			Nurse temp=iter.next();
			if(temp.getName().equalsIgnoreCase(userName)) {
				ArrayList<String> alertListPatientName=temp.getSetAlertPatientName();
				Iterator<String> iterAlertListPatientName=alertListPatientName.iterator();
				ArrayList<String> alertListPatientBedNumber=temp.getSetAlertPatientBedNumber();
				Iterator<String> iterAlertListPatientBedNumber=alertListPatientBedNumber.iterator();
				ArrayList<String> alertListTime=temp.getSetAlertTime();
				Iterator<String> iterAlertListTime=alertListTime.iterator();
				ArrayList<String> alertListDate=temp.getSetAlertDate();
				Iterator<String> iterAlertListDate=alertListDate.iterator();
				ArrayList<String> alertListStatus=temp.getSetAlertStatus();
				Iterator<String> iterAlertListStatus=alertListStatus.iterator();
				
				while(iterAlertListPatientName.hasNext() && iterAlertListPatientBedNumber.hasNext() && iterAlertListTime.hasNext()
						&& iterAlertListDate.hasNext() && iterAlertListStatus.hasNext()) {
					nurseAlertListRow[0]=iterAlertListPatientName.next().trim();
					nurseAlertListRow[1]=iterAlertListPatientBedNumber.next().trim();
					nurseAlertListRow[2]=iterAlertListTime.next().trim();
					nurseAlertListRow[3]=iterAlertListDate.next().trim();
					nurseAlertListRow[4]=iterAlertListStatus.next().trim();
					nurseAlertListModel.addRow(nurseAlertListRow);
				}
				break;
			}
		}
	}
	
	public void loadDataToNurseDueTable() {
		ArrayList<Nurse> tempArrN=new ArrayList<Nurse>();
		Nurse tempN=new Nurse();
		tempN.loadNurseData(nurseFilePath, tempArrN);
		
		Iterator<Nurse> iter=tempArrN.iterator();
		
		while(iter.hasNext()) {
			Nurse temp=(Nurse) iter.next();
			if(temp.getName().equalsIgnoreCase(userName)) {
				ArrayList<String> duePatientName=temp.getSetAlertPatientName();
				ArrayList<String> dueBedNumber=temp.getSetAlertPatientBedNumber();
				ArrayList<String> dueAlertListTime=temp.getSetAlertTime();
				ArrayList<String> dueAlertListDate=temp.getSetAlertDate();
				ArrayList<String> dueAlertListStatus=temp.getSetAlertStatus();
				
				Date currentSystemDate=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yy");
				String currentDate=sdf.format(currentSystemDate);
				
				for(int i=0; i<duePatientName.size(); i++) {
					String[] dateArr=dueAlertListDate.get(i).split("/");
					int first=(int) Integer.valueOf(dateArr[0]);
					int second=(int) Integer.valueOf(dateArr[1]);
					String month=first<10 ? "0"+dateArr[0] : dateArr[0];
					String date=second<10 ? "0"+dateArr[1] : dateArr[1];
					
					String convertedDate=month+"/"+date+"/"+dateArr[2];
					
					if(convertedDate.equalsIgnoreCase(currentDate)) {
						nurseDueRow[0]=duePatientName.get(i).trim();
						nurseDueRow[1]=dueBedNumber.get(i).trim();
						nurseDueRow[2]=dueAlertListTime.get(i).trim();
						nurseDueRow[3]=dueAlertListDate.get(i).trim();
						nurseDueRow[4]=dueAlertListStatus.get(i).trim();
						nurseDueModel.addRow(nurseDueRow);
					}
				}
				break;
			}
		}
	}
	
}
