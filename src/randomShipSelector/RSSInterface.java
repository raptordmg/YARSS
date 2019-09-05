package randomShipSelector;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class RSSInterface {

	private JFrame frmYarss; //Initialises private variables
	private RSSAddShip addShip = new RSSAddShip(); //Gives a class a name in order to be used
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
	private String[] Tiers = new String[10]; //Initialises arrays
	private String[] Nations = new String[11];
	private String[] Type = new String[4];
	private RSSGetShips randomise = new RSSGetShips();
	private JLabel lblSelectedShip;
	private JLabel lblSelectedShipIs;
	
	/**
	 * Launches the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		JCheckBox[] tiers = new JCheckBox[] {chckbxI,chckbxII,chckbxIII,chckbxIV,chckbxV,chckbxVI,chckbxVII,chckbxVIII,chckbxIX,chckbxX}; //add's the check boxes to an array
		for (int i = 0; i < tiers.length; i++) { //Creates a for loop
			if (tiers[i].isSelected() == true) { //checks if the check box is selected
				Tiers[i] = tiers[i].getText(); //Adds the tier to a list
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
		frmYarss = new JFrame(); //Creates the window for the program
		frmYarss.setResizable(false);
		frmYarss.setTitle("YARSS");
		frmYarss.setBounds(100, 100, 391, 350);
		frmYarss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYarss.getContentPane().setLayout(null);
		
		JButton btnAddShip = new JButton("Add Ship"); //Adds a button with the text "Add Ship"
		btnAddShip.setBounds(18, 11, 89, 23);
		btnAddShip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { //Performs an action when the button is clicked
	 			try {
					addShip.display(); //Calls the display function from the addShips class
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			};
		});
		frmYarss.getContentPane().add(btnAddShip);
		
		JLabel lblTier = new JLabel("Tier"); //Adds a text box
		lblTier.setBounds(28, 68, 46, 14);
		frmYarss.getContentPane().add(lblTier);
		
		chckbxI = new JCheckBox("I"); //Creates a check box
		chckbxI.setSelected(true); //Selects the text box
		chckbxI.setBounds(18, 88, 97, 23);
		frmYarss.getContentPane().add(chckbxI);
		
		chckbxII = new JCheckBox("II");
		chckbxII.setSelected(true);
		chckbxII.setBounds(18, 108, 97, 23);
		frmYarss.getContentPane().add(chckbxII);
		
		chckbxIII = new JCheckBox("III");
		chckbxIII.setSelected(true);
		chckbxIII.setBounds(18, 127, 97, 23);
		frmYarss.getContentPane().add(chckbxIII);
		
		chckbxIV = new JCheckBox("IV");
		chckbxIV.setSelected(true);
		chckbxIV.setBounds(18, 148, 97, 23);
		frmYarss.getContentPane().add(chckbxIV);
		
		chckbxV = new JCheckBox("V");
		chckbxV.setSelected(true);
		chckbxV.setBounds(18, 168, 97, 23);
		frmYarss.getContentPane().add(chckbxV);
		
		chckbxVI = new JCheckBox("VI");
		chckbxVI.setSelected(true);
		chckbxVI.setBounds(18, 188, 97, 23);
		frmYarss.getContentPane().add(chckbxVI);
		
		chckbxVII = new JCheckBox("VII");
		chckbxVII.setSelected(true);
		chckbxVII.setBounds(18, 208, 97, 23);
		frmYarss.getContentPane().add(chckbxVII);
		
		chckbxVIII = new JCheckBox("VIII");
		chckbxVIII.setSelected(true);
		chckbxVIII.setBounds(18, 228, 97, 23);
		frmYarss.getContentPane().add(chckbxVIII);
		
		chckbxIX = new JCheckBox("IX");
		chckbxIX.setSelected(true);
		chckbxIX.setBounds(18, 248, 97, 23);
		frmYarss.getContentPane().add(chckbxIX);
		
		chckbxX = new JCheckBox("X");
		chckbxX.setSelected(true);
		chckbxX.setBounds(18, 268, 97, 23);
		frmYarss.getContentPane().add(chckbxX);
		
		JLabel lblNation = new JLabel("Nation");
		lblNation.setBounds(131, 68, 46, 14);
		frmYarss.getContentPane().add(lblNation);
		
		chckbxUSA = new JCheckBox("USA");
		chckbxUSA.setSelected(true);
		chckbxUSA.setBounds(124, 88, 97, 23);
		frmYarss.getContentPane().add(chckbxUSA);
		
		chckbxJapan = new JCheckBox("Japan");
		chckbxJapan.setSelected(true);
		chckbxJapan.setBounds(124, 108, 97, 23);
		frmYarss.getContentPane().add(chckbxJapan);
		
		chckbxUssr = new JCheckBox("USSR");
		chckbxUssr.setSelected(true);
		chckbxUssr.setBounds(124, 128, 97, 23);
		frmYarss.getContentPane().add(chckbxUssr);
		
		chckbxGermany = new JCheckBox("Germany");
		chckbxGermany.setSelected(true);
		chckbxGermany.setBounds(124, 148, 97, 23);
		frmYarss.getContentPane().add(chckbxGermany);
		
		chckbxUK = new JCheckBox("UK");
		chckbxUK.setSelected(true);
		chckbxUK.setBounds(124, 168, 97, 23);
		frmYarss.getContentPane().add(chckbxUK);
		
		chckbxFrance = new JCheckBox("France");
		chckbxFrance.setSelected(true);
		chckbxFrance.setBounds(124, 188, 97, 23);
		frmYarss.getContentPane().add(chckbxFrance);
		
		chckbxItaly = new JCheckBox("Italy");
		chckbxItaly.setSelected(true);
		chckbxItaly.setBounds(124, 208, 97, 23);
		frmYarss.getContentPane().add(chckbxItaly);
		
		chckbxPanAsia = new JCheckBox("Pan-Asia");
		chckbxPanAsia.setSelected(true);
		chckbxPanAsia.setBounds(124, 228, 97, 23);
		frmYarss.getContentPane().add(chckbxPanAsia);
		
		chckbxPanAmerica = new JCheckBox("Pan-America");
		chckbxPanAmerica.setSelected(true);
		chckbxPanAmerica.setBounds(124, 248, 135, 23);
		frmYarss.getContentPane().add(chckbxPanAmerica);
		
		chckbxCommonwealth = new JCheckBox("Commonwealth");
		chckbxCommonwealth.setSelected(true);
		chckbxCommonwealth.setBounds(124, 268, 120, 23);
		frmYarss.getContentPane().add(chckbxCommonwealth);
		
		chckbxPanEU = new JCheckBox("Pan-EU");
		chckbxPanEU.setSelected(true);
		chckbxPanEU.setBounds(124, 288, 97, 23);
		frmYarss.getContentPane().add(chckbxPanEU);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(243, 68, 46, 14);
		frmYarss.getContentPane().add(lblType);
		
		chckbxDestroyer = new JCheckBox("Destroyer");
		chckbxDestroyer.setSelected(true);
		chckbxDestroyer.setBounds(234, 88, 97, 23);
		frmYarss.getContentPane().add(chckbxDestroyer);
		
		chckbxCruiser = new JCheckBox("Cruiser");
		chckbxCruiser.setSelected(true);
		chckbxCruiser.setBounds(234, 108, 97, 23);
		frmYarss.getContentPane().add(chckbxCruiser);
		
		chckbxBattleship = new JCheckBox("Battleship");
		chckbxBattleship.setSelected(true);
		chckbxBattleship.setBounds(234, 127, 97, 23);
		frmYarss.getContentPane().add(chckbxBattleship);
		
		chckbxAircraftCarrier = new JCheckBox("Aircraft Carrier");
		chckbxAircraftCarrier.setSelected(true);
		chckbxAircraftCarrier.setBounds(234, 148, 148, 23);
		frmYarss.getContentPane().add(chckbxAircraftCarrier);
		
		lblSelectedShip = new JLabel("The selected ship is ");
		lblSelectedShip.setBounds(235, 189, 139, 14);
		lblSelectedShip.setVisible(false);
		frmYarss.getContentPane().add(lblSelectedShip);
		
		lblSelectedShipIs = new JLabel("");
		lblSelectedShipIs.setBounds(235, 205, 139, 14);
		frmYarss.getContentPane().add(lblSelectedShipIs);
		
		JButton btnSelectShip = new JButton("Select Ship");
		btnSelectShip.addActionListener(new ActionListener() { //Adds an action listener
			@Override
			public void actionPerformed(ActionEvent e) {
				getSelected(); //Calls the getSelected function 
				try {
					randomise.userSelections(Tiers, Nations, Type); //Calls the userSelections from the randomise class passing 3 arrays
					lblSelectedShip.setVisible(true); //Makes the SelectedShip label visible
					lblSelectedShipIs.setText(randomise.getRandomShip()); //Sets the SelectedShipIs text to the value returned by randomise.getRandomShip()
					randomise.clean();
					reInitArrays();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSelectShip.setBounds(266, 288, 105, 23);
		frmYarss.getContentPane().add(btnSelectShip);
		
		JCheckBox chckbxToggleTiers = new JCheckBox("Toggle Tiers");
		chckbxToggleTiers.setBounds(18, 41, 97, 23);
		frmYarss.getContentPane().add(chckbxToggleTiers);
		chckbxToggleTiers.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				
				JCheckBox[] tiers = new JCheckBox[] {chckbxI,chckbxII,chckbxIII,chckbxIV,chckbxV,chckbxVI,chckbxVII,chckbxVIII,chckbxIX,chckbxX};
				if (tiers[0].isSelected() == true) {
					for (int i = 0; i < tiers.length; i++)
					{
						tiers[i].setSelected(false);
					}
				}
				else {
					for (int i = 0; i < tiers.length; i++)
					{
						tiers[i].setSelected(true);
					}
				}
			}
		});
		
		JCheckBox chckbxToggleNations = new JCheckBox("Toggle nations");
		chckbxToggleNations.setBounds(124, 41, 110, 23);
		frmYarss.getContentPane().add(chckbxToggleNations);
		chckbxToggleNations.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				
				JCheckBox[] nations = new JCheckBox[] {chckbxUSA, chckbxJapan, chckbxUssr, chckbxGermany, chckbxUK, chckbxFrance, chckbxItaly, chckbxPanAsia, chckbxPanAmerica, chckbxPanEU, chckbxCommonwealth};
				if (nations[0].isSelected() == true) {
					for (int i = 0; i < nations.length; i++)
					{
						nations[i].setSelected(false);
					}
				}
				else {
					for (int i = 0; i < nations.length; i++)
					{
						nations[i].setSelected(true);
					}
				}
			}
		});
		
		JCheckBox chckbxToggleType = new JCheckBox("Toggle Type");
		chckbxToggleType.setBounds(234, 41, 97, 23);
		frmYarss.getContentPane().add(chckbxToggleType);
		chckbxToggleType.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				
				JCheckBox[] type = new JCheckBox[] {chckbxDestroyer, chckbxCruiser, chckbxBattleship, chckbxAircraftCarrier};
				if (type[0].isSelected() == true) {
					for (int i = 0; i < type.length; i++)
					{
						type[i].setSelected(false);
					}
				}
				else {
					for (int i = 0; i < type.length; i++)
					{
						type[i].setSelected(true);
					}
				}
			}
		});
	}
}