package randomShipSelector;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.json.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings({ "serial", "unused" })
public class RSSAddShip extends JDialog {
	private JTextField textFieldName;
	private JComboBox<String> comboBoxTier;
	private JComboBox<String> comboBoxType;
	private JComboBox<String> comboBoxNation;
	private JSONObject ship = new JSONObject();
	private JSONArray ships = new JSONArray();
	
	public void display() {
		setVisible(true);
	}
	
	/*
	 * Add ship function
	 */
	public void addship() {
		ship.put("Name:", textFieldName.getText());
		ship.put("Tier:", comboBoxTier.getSelectedItem());
		ship.put("Type:", comboBoxType.getSelectedItem());
		ship.put("Nation:", comboBoxNation.getSelectedItem());
		ships.put(ship);
		output();
	}
	
	public void output() {
		try {
			File file = new File("C:\\Users\\559735\\Downloads\\Ships.json");
			FileWriter writeFile = new FileWriter(file);
			writeFile.write(ships.toString());
			writeFile.flush();
			writeFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Create the dialog.
	 */
	public RSSAddShip() {
		setTitle("Add Ships");
		setBounds(100, 100, 234, 212);
		getContentPane().setLayout(null);
		
		JLabel lblShipName = new JLabel("Ship Name");
		lblShipName.setBounds(10, 11, 76, 19);
		getContentPane().add(lblShipName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(79, 10, 86, 20);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblTier = new JLabel("Tier");
		lblTier.setBounds(10, 43, 46, 14);
		getContentPane().add(lblTier);
		
		JLabel lblShipType = new JLabel("Ship Type");
		lblShipType.setBounds(10, 71, 64, 14);
		getContentPane().add(lblShipType);
		
		JLabel lblShipNation = new JLabel("Ship Nation");
		lblShipNation.setBounds(10, 105, 64, 14);
		getContentPane().add(lblShipNation);
		
		comboBoxTier = new JComboBox<String>();
		comboBoxTier.setBounds(79, 40, 46, 20);
		comboBoxTier.addItem("I");
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
		comboBoxNation.addItem("Poland");
		getContentPane().add(comboBoxNation);
		
		JButton btnAddShip = new JButton("Add Ship");
		btnAddShip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addship();
			}
		});
		btnAddShip.setBounds(100, 140, 89, 23);
		getContentPane().add(btnAddShip);
	}
}