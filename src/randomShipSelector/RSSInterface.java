import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class RSSInterface {

	private JFrame frmYarss;
	private RSSAddShip addShip = new RSSAddShip();
	private JCheckBox chckbxI;
	private JCheckBox chckbxII;
	private JCheckBox chckbxIII;
	private JCheckBox chckbxIV;
	private JCheckBox chckbxV;
	private JCheckBox chckbxVI;
	private JCheckBox chckbxVII;
	private JCheckBox chckbxVIII;
	private JCheckBox chckbxIX;
	private JCheckBox chckbxX;
	private JCheckBox chckbxUSA;
	private JCheckBox chckbxJapan;
	private JCheckBox chckbxUssr;
	private JCheckBox chckbxGermany;
	private JCheckBox chckbxUK;
	private JCheckBox chckbxFrance;
	private JCheckBox chckbxItaly;
	private JCheckBox chckbxPanAsia;
	private JCheckBox chckbxPanAmerica;
	private JCheckBox chckbxPanEU;
	private JCheckBox chckbxCommonwealth;
	private JCheckBox chckbxDestroyer;
	private JCheckBox chckbxCruiser;
	private JCheckBox chckbxBattleship;
	private JCheckBox chckbxAircraftCarrier;
	private String[] Tiers = new String[10];
	private String[] Nations = new String[11];
	private String[] Type = new String[4];
	private RSSGetShips randomise = new RSSGetShips();
	private JLabel lblSelectedShip;
	private JLabel lblSelectedShipIs;
	
	/*
	 * YARSS(Yet Another Random Ship Selector)
	 * Created by Stephen Wallace using the org.json and commons-io-2.6 libraries
	 * Latest update: 18/04/2019
	 */
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RSSInterface window = new RSSInterface();
					window.frmYarss.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RSSInterface() {
		initialize();
	}
	
	/*
	 * Gets the selected check boxes and populates arrays
	 */
	private void getSelected() {
		JCheckBox[] tiers = new JCheckBox[] {chckbxI,chckbxII,chckbxIII,chckbxIV,chckbxV,chckbxVI,chckbxVII,chckbxVIII,chckbxIX,chckbxX};
		for (int i = 0; i < tiers.length; i++) {
			if (tiers[i].isSelected() == true) {
				Tiers[i] = tiers[i].getText();
			}
		}
		
		JCheckBox[] nations = new JCheckBox[] {chckbxUSA, chckbxJapan, chckbxUssr, chckbxGermany, chckbxUK, chckbxFrance, chckbxItaly, chckbxPanAsia, chckbxPanAmerica, chckbxPanEU, chckbxCommonwealth};
		for (int i = 0; i < nations.length; i++) {
			if (nations[i].isSelected() == true) {
				Nations[i] = nations[i].getText();
			}
		}
		
		JCheckBox[] type = new JCheckBox[] {chckbxDestroyer, chckbxCruiser, chckbxBattleship, chckbxAircraftCarrier};
		for (int i = 0; i < type.length; i++) {
			if (type[i].isSelected() == true) {
				Type[i] = type[i].getText();
			}
		}
	}
	
	/*
	 * Reinitialises the arrays after a random ship is returned to clear the previously selected options 
	 */
	private void reInitArrays() {
		Tiers = new String[10];
		Nations = new String[11];
		Type = new String[4];
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frmYarss = new JFrame();
		frmYarss.setTitle("YARSS");
		frmYarss.setBounds(100, 100, 380, 330);
		frmYarss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYarss.getContentPane().setLayout(null);
		
		JButton btnAddShip = new JButton("Add Ship");
		btnAddShip.setBounds(18, 11, 89, 23);
		btnAddShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addShip.display();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			};
		});
		frmYarss.getContentPane().add(btnAddShip);
		
		JLabel lblTier = new JLabel("Tier");
		lblTier.setBounds(20, 45, 46, 14);
		frmYarss.getContentPane().add(lblTier);
		
		chckbxI = new JCheckBox("I");
		chckbxI.setSelected(true);
		chckbxI.setBounds(10, 65, 97, 23);
		frmYarss.getContentPane().add(chckbxI);
		
		chckbxII = new JCheckBox("II");
		chckbxII.setSelected(true);
		chckbxII.setBounds(10, 85, 97, 23);
		frmYarss.getContentPane().add(chckbxII);
		
		chckbxIII = new JCheckBox("III");
		chckbxIII.setSelected(true);
		chckbxIII.setBounds(10, 104, 97, 23);
		frmYarss.getContentPane().add(chckbxIII);
		
		chckbxIV = new JCheckBox("IV");
		chckbxIV.setSelected(true);
		chckbxIV.setBounds(10, 125, 97, 23);
		frmYarss.getContentPane().add(chckbxIV);
		
		chckbxV = new JCheckBox("V");
		chckbxV.setSelected(true);
		chckbxV.setBounds(10, 145, 97, 23);
		frmYarss.getContentPane().add(chckbxV);
		
		chckbxVI = new JCheckBox("VI");
		chckbxVI.setSelected(true);
		chckbxVI.setBounds(10, 165, 97, 23);
		frmYarss.getContentPane().add(chckbxVI);
		
		chckbxVII = new JCheckBox("VII");
		chckbxVII.setSelected(true);
		chckbxVII.setBounds(10, 185, 97, 23);
		frmYarss.getContentPane().add(chckbxVII);
		
		chckbxVIII = new JCheckBox("VIII");
		chckbxVIII.setSelected(true);
		chckbxVIII.setBounds(10, 205, 97, 23);
		frmYarss.getContentPane().add(chckbxVIII);
		
		chckbxIX = new JCheckBox("IX");
		chckbxIX.setSelected(true);
		chckbxIX.setBounds(10, 225, 97, 23);
		frmYarss.getContentPane().add(chckbxIX);
		
		chckbxX = new JCheckBox("X");
		chckbxX.setSelected(true);
		chckbxX.setBounds(10, 245, 97, 23);
		frmYarss.getContentPane().add(chckbxX);
		
		JLabel lblNation = new JLabel("Nation");
		lblNation.setBounds(123, 45, 46, 14);
		frmYarss.getContentPane().add(lblNation);
		
		chckbxUSA = new JCheckBox("USA");
		chckbxUSA.setSelected(true);
		chckbxUSA.setBounds(116, 65, 97, 23);
		frmYarss.getContentPane().add(chckbxUSA);
		
		chckbxJapan = new JCheckBox("Japan");
		chckbxJapan.setSelected(true);
		chckbxJapan.setBounds(116, 85, 97, 23);
		frmYarss.getContentPane().add(chckbxJapan);
		
		chckbxUssr = new JCheckBox("USSR");
		chckbxUssr.setSelected(true);
		chckbxUssr.setBounds(116, 105, 97, 23);
		frmYarss.getContentPane().add(chckbxUssr);
		
		chckbxGermany = new JCheckBox("Germany");
		chckbxGermany.setSelected(true);
		chckbxGermany.setBounds(116, 125, 97, 23);
		frmYarss.getContentPane().add(chckbxGermany);
		
		chckbxUK = new JCheckBox("UK");
		chckbxUK.setSelected(true);
		chckbxUK.setBounds(116, 145, 97, 23);
		frmYarss.getContentPane().add(chckbxUK);
		
		chckbxFrance = new JCheckBox("France");
		chckbxFrance.setSelected(true);
		chckbxFrance.setBounds(116, 165, 97, 23);
		frmYarss.getContentPane().add(chckbxFrance);
		
		chckbxItaly = new JCheckBox("Italy");
		chckbxItaly.setSelected(true);
		chckbxItaly.setBounds(116, 185, 97, 23);
		frmYarss.getContentPane().add(chckbxItaly);
		
		chckbxPanAsia = new JCheckBox("Pan-Asia");
		chckbxPanAsia.setSelected(true);
		chckbxPanAsia.setBounds(116, 205, 97, 23);
		frmYarss.getContentPane().add(chckbxPanAsia);
		
		chckbxPanAmerica = new JCheckBox("Pan-America");
		chckbxPanAmerica.setSelected(true);
		chckbxPanAmerica.setBounds(116, 225, 135, 23);
		frmYarss.getContentPane().add(chckbxPanAmerica);
		
		chckbxCommonwealth = new JCheckBox("Commonwealth");
		chckbxCommonwealth.setSelected(true);
		chckbxCommonwealth.setBounds(116, 245, 120, 23);
		frmYarss.getContentPane().add(chckbxCommonwealth);
		
		chckbxPanEU = new JCheckBox("Pan-EU");
		chckbxPanEU.setSelected(true);
		chckbxPanEU.setBounds(116, 265, 97, 23);
		frmYarss.getContentPane().add(chckbxPanEU);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(235, 45, 46, 14);
		frmYarss.getContentPane().add(lblType);
		
		chckbxDestroyer = new JCheckBox("Destroyer");
		chckbxDestroyer.setSelected(true);
		chckbxDestroyer.setBounds(226, 65, 97, 23);
		frmYarss.getContentPane().add(chckbxDestroyer);
		
		chckbxCruiser = new JCheckBox("Cruiser");
		chckbxCruiser.setSelected(true);
		chckbxCruiser.setBounds(226, 85, 97, 23);
		frmYarss.getContentPane().add(chckbxCruiser);
		
		chckbxBattleship = new JCheckBox("Battleship");
		chckbxBattleship.setSelected(true);
		chckbxBattleship.setBounds(226, 104, 97, 23);
		frmYarss.getContentPane().add(chckbxBattleship);
		
		chckbxAircraftCarrier = new JCheckBox("Aircraft Carrier");
		chckbxAircraftCarrier.setSelected(true);
		chckbxAircraftCarrier.setBounds(226, 125, 148, 23);
		frmYarss.getContentPane().add(chckbxAircraftCarrier);
		
		JButton btnSelectShip = new JButton("Select Ship");
		btnSelectShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSelected();
				try {
					randomise.userSelections(Tiers, Nations, Type);
					lblSelectedShip.setVisible(true);
					lblSelectedShipIs.setText(randomise.getRandomShip());
					randomise.clean();
					reInitArrays();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSelectShip.setBounds(248, 265, 105, 23);
		frmYarss.getContentPane().add(btnSelectShip);
		
		lblSelectedShip = new JLabel("The selected ship is ");
		lblSelectedShip.setBounds(235, 189, 120, 14);
		lblSelectedShip.setVisible(false);
		frmYarss.getContentPane().add(lblSelectedShip);
		
		lblSelectedShipIs = new JLabel("");
		lblSelectedShipIs.setBounds(235, 205, 120, 14);
		frmYarss.getContentPane().add(lblSelectedShipIs);
	}
}