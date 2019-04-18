package randomShipSelector;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * YARSS(Yet Another Random Ship Selector)
 * Created by Stephen Wallace using the org.json and commons-io-2.6 libraries
 * Latest update: 18/04/2019
 */

@SuppressWarnings("unused")
public class RSSGetShips {

	private JSONArray ships = new JSONArray();
	private JSONArray sortedShips = new JSONArray();
	private JSONArray sortedShips1 = new JSONArray();
	private JSONArray sortedShips2 = new JSONArray();

	/*
	 * Receives the check boxes that the user has selected and sorts the ship data
	 */
	public void userSelections(String[] Tiers, String[] Nations, String[] Type) throws IOException {
		getShips();
		for (int i = 0; i < Tiers.length; i++) {
			sortShips(Tiers[i]);
		}
		for (int i = 0; i < Nations.length; i++) {
			sortShipsNation(Nations[i]);
		}
		for (int i = 0; i < Type.length; i++) {
			sortShipType(Type[i]);
		}
	}
	
	/*
	 * Reinitialises the ship sorting JSONArrays 
	 */
	public void clean() {
		sortedShips = new JSONArray();
		sortedShips1 = new JSONArray();
		sortedShips2 = new JSONArray();
	}
	
	/*
	 * Filters the ships by tier
	 */
	private void sortShips(String Tier) { //if ships json data equals fields from userSelections
		for (int i = 0; i < ships.length(); i++) {
			JSONObject currentObject = ships.getJSONObject(i);
			if (currentObject.get("Tier").toString().equals(Tier)) {
				sortedShips.put(currentObject);
			}
		}
	}
	
	/*
	 * Filters the ships from the previous stage by nation
	 */
	private void sortShipsNation(String Nation) {
		for (int i = 0; i < sortedShips.length(); i++) {
			JSONObject currentObject = sortedShips.getJSONObject(i);
			if (currentObject.get("Nation").toString().equals(Nation)) {
				sortedShips1.put(currentObject);
			}
		}
	}
	
	/*
	 * Filters the ships from the previous stage by type
	 */
	private void sortShipType(String Type) {
		for (int i = 0; i < sortedShips1.length(); i++) {
			JSONObject currentObject = sortedShips1.getJSONObject(i);
			if (currentObject.get("Type").toString().equals(Type)) {
				sortedShips2.put(currentObject);
			}
		}
	}
	
	/* 
	 * Chooses a random ship from the ships remaining after filtering
	 */
	public String getRandomShip() {
		Random number = new Random();
		
		int n = number.nextInt(sortedShips2.length());
		JSONObject currentObject = sortedShips2.getJSONObject(n);
			
		return currentObject.getString("Name");
	}
	
	/*
	 * Opens the Ships.json and adds the data to a JSONArray
	 */
	private void getShips() throws IOException {
		File file = new File("Ships.json");
		String content = FileUtils.readFileToString(file, "utf-8");
		ships = new JSONArray(content);
	}
}