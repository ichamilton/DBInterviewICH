package codingtest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Generates a list of integers, puts the integers into a set to dedupe them, then places them into a new list.  
 * This scales decently. 
 * 
 * Ian Hamilton 09/14/14 for Disruptor Beam interview
 */


public class dedupe {
	public static void main(String[] args){		

		ArrayList<Integer> initialList = new ArrayList<Integer>();  // Our beginning list to dedupe.
		int size = 20; // Length of initial list - provided here for easy tweaking.
		int range = 30; // Values in list will be from 1 - <range>.

		// Populate initialList with <size> randomly-generated integers from 1-<range>.
		Random randInt = new Random();
		for (int i=0;i<size;i++){
			initialList.add(randInt.nextInt(range)+1);
		}
		// Make absolutely certain that at least one value is duplicated by re-adding a random item from the list.
		initialList.add(initialList.get(randInt.nextInt(size)));  
		System.out.println(initialList);  

		Set<Integer> dedupeBucket = new HashSet<Integer>();  // Set to store the values in initialList.

		for (int i=0;i<initialList.size();i++){   // Put every item in the list into the set; duplicate values will be removed.
			dedupeBucket.add(initialList.get(i));
		}
		System.out.println(dedupeBucket);

		// Create a list containing the values of the set. 
		ArrayList<Integer> returnList = new ArrayList<Integer>(dedupeBucket);  

		System.out.println(returnList);
	}
}
