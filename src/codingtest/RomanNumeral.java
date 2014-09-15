package codingtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Class to represent Roman Numerals and handle basic conversion / arithmetic thereof.  
 * 
 * Ian Hamilton 09/14/14 for Disruptor Beam interview
 */

public class RomanNumeral {

	private static final Map<String, Integer> NUMERALS;   // Constant map that translates between values
	static {
		Map<String, Integer> result = new HashMap<String, Integer>();
		result.put("I",1);
		result.put("V",5);
		result.put("X",10);
		result.put("L",50);
		result.put("C",100);
		result.put("D",500);
		result.put("M",1000);
		NUMERALS = Collections.unmodifiableMap(result);
	}

	private String numeral = "";  // String that holds the initialized numeral


	/**
	 * RomanNumeral String constructor
	 * 	
	 * @param value The string representing the numeral to store.
	 */
	public RomanNumeral(String value){
		numeral = value;
	}

	/**
	 * RomanNumeral Integer constructor
	 * 	
	 * @param value The integer representing the numeral to store.
	 */
	public RomanNumeral(int value){
		numeral = getString(value);
	}	

	/**
	 * getString with no arguments returns the underlying string that the numeral was constructed with.
	 * 	
	 * @return
	 */	
	public String getString(){
		return numeral;
	}


	/**
	 * getString with an integer returns a String representing the provided integer.
	 * Lazy method:  Generate a string of highest-value letters as the first step. 
	 * As a second step, reduce it down by replacing all quadruplets with appropriate subtractive notation.
	 * 
	 * @param number
	 * @return  New string representing number.
	 */
	public String getString(int number){
		String value = "";  //  Numeral string that will be built as we go
		
		// Step 1:  Iteratively step through the number, subtracting highest values and adding letters.
		while (number > 0){  
			if (number >= 1000) {
				number -= 1000;
				value = value.concat("M");
			}
			else if (number >= 500) {
				number -= 500;
				value = value.concat("D");
			} 
			else if (number >= 100) {
				number -= 100;
				value = value.concat("C");
			} 
			else if (number >= 50) {
				number -= 50;
				value = value.concat("L");
			} 
			else if (number >= 10) {
				number -= 10;
				value = value.concat("X");
			} 
			else if (number >= 5) {
				number -= 5;
				value = value.concat("V");
			} 
			else {
				number -= 1;
				value = value.concat("I");
			}
		}

		// Step 2:  Replace '9' or '4' digit instances.   TODO: Work this into the larger if-else nonsense above; pretty sure it's doable.
		value = value.replace("VIIII","IX");
		value = value.replace("IIII","IV");
		value = value.replace("LXXXX","XC");
		value = value.replace("XXXX","XL");
		value = value.replace("DCCCC","CM");
		value = value.replace("CCCC","CD");

		return value;
	}


	/**
	 * Returns the integer value of the RomanNumeral it's invoked on.	
	 * @return  Integer equivalent
	 */
	public int getInt(){
		int result = 0;
		ArrayList<Integer> parseList = new ArrayList<Integer>();  // Convert the string into a list of integers
		for (int i=0;i<numeral.length();i++){
			parseList.add(NUMERALS.get(getString().substring(i,i+1)));
		}

		/* Iterate through the integer list.  If the current item is less than the next item, subtract it from the total. 
		 * Otherwise, add it.  We'll stop short of the final item, since it will always be added.		  
		 */
		for (int i=0;i<parseList.size()-1;i++){
			if (parseList.get(i) >= parseList.get(i+1))
				result += parseList.get(i);
			else
				result -= parseList.get(i);
		}
		result += parseList.get(parseList.size()-1);  // Add value of final character

		return result;
	}

	public int additionInteger(RomanNumeral secondNumeral){
		int newNumber = this.getInt() + secondNumeral.getInt();
		return newNumber;
	}
	
	public RomanNumeral additionNumeral(RomanNumeral secondNumeral){
		int newNumber = this.getInt() + secondNumeral.getInt();
		RomanNumeral result = new RomanNumeral(getString(newNumber));
		return result;
	}	
}
