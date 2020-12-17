package package1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

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

public class Dashboard extends JFrame{

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
	private JPanel dueContentPanel;
	private JPanel addMedicineContentPanel;
	private JPanel setAlertPanel;
	private JTextField medicineNameTextField;
	private JTable medicineTable;
	private DefaultTableModel model;
	private DefaultTableModel prescriptionModel;
	private String[] colums= {"Medicine Name", "mg"};
	private String[] row=new String[2];
	private String[] items= {"1","2","3"};
	private String[] pressColums= {"Medicine Name", "mg", "Morning", "Evening", "Night", "Days"};
	private String[] presRow=new String[6];
	private JTextField medicineMgTextField;
	private JLabel topBarDoctorLogoLabel;
	private JLabel doctorNameLabel;
	private JLabel doctorLogOutLabel;
	private JLabel doctorLogOutLogoLabel;
	private JLayeredPane topBarLayeredPane;
	private JLayeredPane sideBarLayeredPane;
	private JLayeredPane patientContentlayeredPane;
	private JTextField addPressMedNameTxtField;
	private JTextField addPressMgTextField;
	private JComboBox morningComboBox;
	private JComboBox eveningComboBox;
	private JComboBox nightComboBox;
	private JTextField courseForTextField;
	private JTable prescriptionTable;
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
		
		patientContentlayeredPane.removeAll();
		patientContentlayeredPane.add(addMedicineContentPanel);
		patientContentlayeredPane.add(addPresContentPanel);
		patientContentlayeredPane.add(dueContentPanel);
		patientContentlayeredPane.add(setAlertPanel);
		patientContentlayeredPane.repaint();
		patientContentlayeredPane.revalidate();
	}
	
	public void switchDoctorPanel() {
		topBarLayeredPane.removeAll();
		topBarLayeredPane.add(doctorTopBarPanel);
		topBarLayeredPane.repaint();
		topBarLayeredPane.revalidate();
		
		sideBarLayeredPane.removeAll();
		patientContentlayeredPane.removeAll();
		
		
	}
	public void switchPanel(JPanel panel) {
		patientContentlayeredPane.removeAll();
		patientContentlayeredPane.add(panel);
		patientContentlayeredPane.repaint();
		patientContentlayeredPane.revalidate();
	}
	
	public Dashboard() {
		getContentPane().setBackground(new Color(229,234,230));
		getContentPane().setLayout(null);
		
		topBarLayeredPane = new JLayeredPane();
		topBarLayeredPane.setBounds(31, 40, 1428, 130);
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
		
		patientNameLabel = new JLabel("Welcome,");
		patientNameLabel.setBounds(133, 40, 260, 54);
		topBarImageLabel.add(patientNameLabel);
		patientNameLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		
		logOutLogoLabel = new JLabel("");
		logOutLogoLabel.setBounds(1259, 52, 35, 30);
		topBarImageLabel.add(logOutLogoLabel);
		logOutLogoLabel.setIcon(new ImageIcon(logOutLogo));
		
		logOutLabel = new JLabel("Log Out");
		logOutLabel.setBounds(1296, 50, 78, 32);
		topBarImageLabel.add(logOutLabel);
		logOutLabel.setForeground(Color.RED);
		logOutLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		
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
		
		
		doctorLogOutLogoLabel = new JLabel("");
		doctorLogOutLogoLabel.setBounds(1259, 52, 35, 30);
		doctorTopBarImageLabel.add(doctorLogOutLogoLabel);
		doctorLogOutLogoLabel.setIcon(new ImageIcon(logOutLogo));
		
		doctorLogOutLabel = new JLabel("Log Out");
		doctorLogOutLabel.setBounds(1296, 50, 78, 32);
		doctorTopBarImageLabel.add(doctorLogOutLabel);
		doctorLogOutLabel.setForeground(Color.RED);
		doctorLogOutLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		
		nurseTopBarPanel = new JPanel();
		topBarLayeredPane.add(nurseTopBarPanel, "name_38755163090900");
		nurseTopBarPanel.setLayout(null);
		
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
		dueLogoLabel.setIcon(new ImageIcon(dueLogo));
		dueLogoLabel.setBounds(56, 320, 66, 56);
		patientSideBarBKLabel.add(dueLogoLabel);
		
		dueLabel = new JLabel("Due");
		dueLabel.setBounds(124, 332, 52, 32);
		patientSideBarBKLabel.add(dueLabel);
		dueLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		
		setAlertLogoLabel = new JLabel("");
		setAlertLogoLabel.setIcon(new ImageIcon(setAlertLogo));
		setAlertLogoLabel.setBounds(48, 429, 66, 56);
		patientSideBarBKLabel.add(setAlertLogoLabel);
		
		setAlertLabel = new JLabel("setAlert");
		setAlertLabel.setBounds(124, 436, 84, 32);
		patientSideBarBKLabel.add(setAlertLabel);
		setAlertLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		
		doctorSideBarPanel = new JPanel();
		sideBarLayeredPane.add(doctorSideBarPanel, "name_38948241781600");
		doctorSideBarPanel.setLayout(null);
		
		nurseSideBarPanel = new JPanel();
		sideBarLayeredPane.add(nurseSideBarPanel, "name_38965842404800");
		nurseSideBarPanel.setLayout(null);
		
		patientContentlayeredPane = new JLayeredPane();
		patientContentlayeredPane.setBounds(413, 198, 1046, 536);
		getContentPane().add(patientContentlayeredPane);
		patientContentlayeredPane.setLayout(new CardLayout(0, 0));
		
		addMedicineContentPanel = new JPanel();
		addMedicineContentPanel.setBounds(413, 198, 1046, 536);
		addMedicineContentPanel.setForeground(new Color(229,234,230));
		addMedicineContentPanel.setBackground(new Color(229,234,230));
		patientContentlayeredPane.add(addMedicineContentPanel, "name_5285986441700");
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
				row[0]=medicineNameTextField.getText().trim();
				row[1]=medicineMgTextField.getText().trim();
				model.addRow(row);
				
				medicineNameTextField.setText("");
				medicineMgTextField.setText("");
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
				if(selectedRow>=0) {
					model.removeRow(selectedRow);
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
		patientContentlayeredPane.add(addPresContentPanel, "name_5669470193100");
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
		
		
		dueContentPanel = new JPanel();
		dueContentPanel.setBackground(new Color(229,234,230));
		dueContentPanel.setForeground(new Color(229,234,230));
		dueContentPanel.setBounds(413, 198, 1046, 536);
		patientContentlayeredPane.add(dueContentPanel, "name_5773124559600");
		dueContentPanel.setLayout(null);
		
		setAlertPanel = new JPanel();
		setAlertPanel.setBackground(new Color(229,234,230));
		setAlertPanel.setForeground(new Color(229,234,230));
		setAlertPanel.setBounds(413, 198, 1046, 536);
		patientContentlayeredPane.add(setAlertPanel, "name_6284499503700");
		setAlertPanel.setLayout(null);
		
		
		setBounds(10, 10, 1500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dashboardContentPane = new JPanel();
		dashboardContentPane.setBorder(new EmptyBorder(5,5,5,5));
		dashboardContentPane.setLayout(new BorderLayout(0,0));
	}
}
