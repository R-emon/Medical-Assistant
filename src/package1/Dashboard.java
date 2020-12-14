package package1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Dashboard extends JFrame{

	private JPanel dashboardContentPane;
	private JPanel patientTopBarPanel;
	private JPanel doctorTopBarPanel;
	private JPanel nurseTopBarPanel;
	private JPanel patientSideBarPanel;
	private JPanel doctorSideBarPanel;
	private JPanel nurseSideBarPanel;
	private Image topBar= new ImageIcon(Dashboard.class.getResource("/images/dashboardTopBar.png")).getImage().getScaledInstance(1428, 127, Image.SCALE_SMOOTH);
	private Image topBarPatientLogo= new ImageIcon(Dashboard.class.getResource("/images/hospitalisation1.png")).getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
	private Image sideBar= new ImageIcon(Dashboard.class.getResource("/images/sideBar.png")).getImage().getScaledInstance(338, 536, Image.SCALE_SMOOTH);
	private Image addMedLogo= new ImageIcon(Dashboard.class.getResource("/images/addMedLogo.png")).getImage().getScaledInstance(66, 56, Image.SCALE_SMOOTH);
	private Image addPresLogo= new ImageIcon(Dashboard.class.getResource("/images/addPresLogo.png")).getImage().getScaledInstance(66, 56, Image.SCALE_SMOOTH);
	private JLabel topBarPatientLogoLabel;
	private JLabel patientNameLabel;
	private JLabel addMedLogoLabel;
	private JLabel lblNewLabel;
	private JLabel addPresLogoLabel;
	private JLabel lblNewLabel_1;
	private JLabel dueLogoLabel;
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
	public Dashboard() {
		getContentPane().setBackground(new Color(229,234,230));
		getContentPane().setLayout(null);
		
		JLayeredPane topBarLayeredPane = new JLayeredPane();
		topBarLayeredPane.setBounds(31, 25, 1428, 130);
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
		
		doctorTopBarPanel = new JPanel();
		topBarLayeredPane.add(doctorTopBarPanel, "name_38730535960000");
		doctorTopBarPanel.setLayout(null);
		
		nurseTopBarPanel = new JPanel();
		topBarLayeredPane.add(nurseTopBarPanel, "name_38755163090900");
		nurseTopBarPanel.setLayout(null);
		
		JLayeredPane sideBarLayeredPane = new JLayeredPane();
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
		addMedLogoLabel.setBounds(44, 74, 66, 56);
		addMedLogoLabel.setIcon(new ImageIcon(addMedLogo));
		patientSideBarBKLabel.add(addMedLogoLabel);
		
		lblNewLabel = new JLabel("Add Medicine");
		lblNewLabel.setBounds(125, 89, 128, 32);
		patientSideBarBKLabel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		
		addPresLogoLabel = new JLabel("");
		addPresLogoLabel.setIcon(new ImageIcon(addPresLogo));
		addPresLogoLabel.setBounds(50, 191, 66, 56);
		patientSideBarBKLabel.add(addPresLogoLabel);
		
		lblNewLabel_1 = new JLabel("Add Prescription");
		lblNewLabel_1.setBounds(124, 206, 149, 32);
		patientSideBarBKLabel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		
		dueLogoLabel = new JLabel("");
		dueLogoLabel.setBounds(48, 334, 66, 56);
		patientSideBarPanel.add(dueLogoLabel);
		
		doctorSideBarPanel = new JPanel();
		sideBarLayeredPane.add(doctorSideBarPanel, "name_38948241781600");
		doctorSideBarPanel.setLayout(null);
		
		nurseSideBarPanel = new JPanel();
		sideBarLayeredPane.add(nurseSideBarPanel, "name_38965842404800");
		nurseSideBarPanel.setLayout(null);
		
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
