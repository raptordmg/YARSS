package randomShipSelector;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class RSSGetShips {

	private JSONArray ships = new JSONArray();
	private JSONArray sortedShips = new JSONArray();
	private JSONArray sortedShips1 = new JSONArray();
	private JSONArray sortedShips2 = new JSONArray();

	/*
	 * Gets the user's selections and calls the sort functions passing the parameters selected
	 */
	public void userSelections(String[] Tiers, String[] Nations, String[] Type) throws IOException {
		getShips();
		for (int i = 0; i < Tiers.length; i++) {
			sortShips(Tiers[i]); //Calls the sortShips function and passes the value of Tiers[i]
		}
		for (int i = 0; i < Nations.length; i++) {
			sortShipsNation(Nations[i]);
		}
		for (int i = 0; i < Type.length; i++) {
			sortShipType(Type[i]);
		}
	}
	
	/*
	 * Reinitialises the sorting JSONArrays
	 */
	public void clean() {
		sortedShips = new JSONArray();
		sortedShips1 = new JSONArray();
		sortedShips2 = new JSONArray();
	}
	
	/*
	 * Sorts ships by tier based on user selections
	 */
	private void sortShips(String Tier) { 
		for (int i = 0; i < ships.length(); i++) {
			JSONObject currentObject = ships.getJSONObject(i); //Creates a JSONObject from the ships JSONArray
			if (currentObject.get("Tier").toString().equals(Tier)) { //If the JSONObject's Tier is equal to the string Tier
				sortedShips.put(currentObject); //Add currentObject to the sortedShips JSONArray
			}
		}
	}
	
	/*
	 * Sorts ships by nation based on user selections
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
	 * Sorts ships by ship type based on user selections
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
	 * Selects a random item from the JSONArray and returns it's "Name"
	 */
	public String getRandomShip() {
		if (sortedShips2.length() != 0) {
			Random number = new Random(); //Calls the random number class and assigns it to number
			
			int n = number.nextInt(sortedShips2.length()); //Creates an integer n and sets it to a random value between 0 and the length of sortedShips2
			JSONObject currentObject = sortedShips2.getJSONObject(n);
				
			return currentObject.getString("Name"); //Returns the Name field from the JSONObject
		}
		else {
			return "Invalid parameters"; //Returns a message if user selects parameters that can't be used
		}
	}
	
	/*
	 * Reads the data from the Ships.json file
	 */
	private void getShips() throws IOException {
		File file = new File("Ships.json");
		String content = FileUtils.readFileToString(file, "utf-8");
		ships = new JSONArray(content);
	}
}