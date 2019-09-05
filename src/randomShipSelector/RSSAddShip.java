package randomShipSelector;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.io.FileUtils;
import org.json.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings({ "serial", "unused" })
public class RSSAddShip extends JDialog {
	private JTextField shipName;
	private JComboBox<String> comboBoxTier;
	private JComboBox<String> comboBoxType;
	private JComboBox<String> comboBoxNation;
    private JSONArray ships; //Initialises a JSONArray
	
    
    /*
     * Makes the addships window appear
     */
	public void display() throws IOException {
		setVisible(true); //Makes the addships window visible
	}
	
	/*
	 * Add ship function
	 */
	private void addship() throws IOException {
		getShips(); //Calls getships()
		JSONObject ship = new JSONObject(); //Creates a new JSONObject
		ship.put("Name", shipName.getText()); //Adds fields and values to a JSON
		ship.put("Tier", comboBoxTier.getSelectedItem());
		ship.put("Type", comboBoxType.getSelectedItem());
		ship.put("Nation", comboBoxNation.getSelectedItem());
		ships.put(ship); //Adds the JSONObject to the JSONArray
		output(); //Calls output()
	}
	
	/*
	 * Outputs the JSON data to a file
	 */
	private void output() {
		try {
			File file = new File("Ships.json"); //Selects the file "Ships.json"
			FileWriter writeFile = new FileWriter(file); //Writes to the selected file
			writeFile.write(ships.toString()); 
			writeFile.flush();
			writeFile.close(); //Closes the file
			JOptionPane.showMessageDialog(null, "Ship added");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Reads the data from the Ships.json file
	 */
	private void getShips() throws IOException {
		File file = new File("Ships.json");
		String content = FileUtils.readFileToString(file, "utf-8"); //Reads the data held by the file to a string
		ships = new JSONArray(content); //Adds the data to the JSONArray
	}
	
	/**
	 * Create the dialog.
	 */
	public RSSAddShip() {
		setTitle("Add Ships"); //Creates the Add Ships window
 		setBounds(100, 100, 234, 212);
		getContentPane().setLayout(null);
		
		JLabel lblShipName = new JLabel("Ship Name");
		lblShipName.setBounds(10, 11, 76, 19);
		getContentPane().add(lblShipName);
		
		shipName = new JTextField(); //Creates a text box
		shipName.setBounds(79, 10, 86, 20);
		getContentPane().add(shipName);
		shipName.setColumns(10);
		
		JLabel lblTier = new JLabel("Tier");
		lblTier.setBounds(10, 43, 46, 14);
		getContentPane().add(lblTier);
		
		JLabel lblShipType = new JLabel("Ship Type");
		lblShipType.setBounds(10, 71, 64, 14);
		getContentPane().add(lblShipType);
		
		JLabel lblShipNation = new JLabel("Ship Nation");
		lblShipNation.setBounds(10, 105, 64, 14);
		getContentPane().add(lblShipNation);
		
		comboBoxTier = new JComboBox<String>(); //Creates a combo box
		comboBoxTier.setBounds(79, 40, 46, 20);
		comboBoxTier.addItem("I"); //Adds options to the combo box
		comboBoxTier.addItem("II");
		comboBoxTier.addItem("III");
		comboBoxTier.addItem("IV");
		comboBoxTier.addItem("V");
		comboBoxTier.addItem("VI");
		comboBoxTier.addItem("VII");
		comboBoxTier.addItem("VIII");
		comboBoxTier.addItem("IX");
		comboBoxTier.addItem("X");
		getContentPane().add(comboBoxTier);
		
		comboBoxType = new JComboBox<String>();
		comboBoxType.setBounds(79, 68, 123, 20);
		comboBoxType.addItem("Destroyer");
		comboBoxType.addItem("Cruiser");
		comboBoxType.addItem("Battleship");
		comboBoxType.addItem("Aircraft Carrier");
		getContentPane().add(comboBoxType);
		
		comboBoxNation = new JComboBox<String>();
		comboBoxNation.setBounds(79, 102, 123, 20);
		comboBoxNation.addItem("USA");
		comboBoxNation.addItem("Japan");
		comboBoxNation.addItem("USSR");
		comboBoxNation.addItem("Germany");
		comboBoxNation.addItem("UK");
		comboBoxNation.addItem("France");
		comboBoxNation.addItem("Italy");
		comboBoxNation.addItem("Pan-Asia");
		comboBoxNation.addItem("Pan-America");
		comboBoxNation.addItem("Commonwealth");
		comboBoxNation.addItem("Pan-EU");
		getContentPane().add(comboBoxNation);
		
		JButton btnAddShip = new JButton("Add Ship");
		btnAddShip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					addship();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAddShip.setBounds(100, 140, 89, 23);
		getContentPane().add(btnAddShip);
	}
}