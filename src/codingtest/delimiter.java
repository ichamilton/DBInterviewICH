package codingtest;

import java.util.ArrayList;
import java.util.Random;

/**
 * Generates a semicolon-delimited list of names, then converts the list into an array of the names.  
 * 
 * Ian Hamilton 09/14/14 for Disruptor Beam interview
 */

public class delimiter {
	public static void main(String[] args){		

		// Strings to use as tokens in the delimited string
		 String[] tokens = new String[]{"Arya","Bran","Catelyn","Cersei","Daenerys","Davos","Drogo","Eddard","Jaime","Jon","Jorah",
				"Loras","Lysa","Margery","Renly","Robb","Robert","Samwell","Sansa","Stannis","Theon","Tyrion","Tywin","Viserys"};
		int size = 10; // Number of elements in the delimited string 

		String initialList = "";  // Our initial string of delimited values
		ArrayList<String> returnList = new ArrayList<String>();  // The array that will contain the tokens in initialList 

		// Populate initialList with <size> randomly-generated tokens the list, semicolon-delimited.
		Random randInt = new Random();
		for (int i=0;i<=size;i++){
			initialList = initialList.concat(tokens[randInt.nextInt(tokens.length)]);
			if (i < size)
				initialList = initialList.concat(";");
		}
		System.out.println(initialList); 

		/* Add all the characters to the left of the first semi to the array, then remove those characters and the semi from the list.
		 * Will miss the final item because it lacks a semicolon.  Fortunately, the string will then contain only the last item...
		 */

		String copiedList = initialList; // This method is destructive, so make a copy and use that in case the original is needed.

		while (copiedList.contains(";")){   
			int semiIndex = copiedList.indexOf(";");   // Find the first semi
			String currentToken = copiedList.substring(0, semiIndex);  // Use it to get the whole first token from the String
			returnList.add(currentToken);  // Add everything before the semi to the Array
			copiedList = copiedList.substring(semiIndex+1);  // Remove the token, including semi, from the String
		}
		returnList.add(copiedList); // Add the remaining item

		System.out.println(returnList);  // Should display all of the items in the string in the same order	
	}
}
