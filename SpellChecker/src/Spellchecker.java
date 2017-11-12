import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/** 
  *	In this class the user inserts a text that is splitted into words and these words are spell-checked one to one.
  *	if a wrong word exists, it is inserted in an array.
  *	@author Βούγιας,Γεωργούλη,Κακουλάκη,Λαζαρίδη,Λαζαρίδου,Μπαμπέτας,Παυλίδη,Σπέρτου
  */ 
public class Spellchecker {


	public static void main(String args[]) {


		System.out.println("Δώσε κείμενο και θα σου πω άμα είναι ορθογραφικά σωστό\n\n");
		String text = getGreekInput();           		/* Κάλεσμα μεθόδου getGreekInput */

		String[] splittedArray = text.split("[^α-ωΑ-Ωά-ώ]+"); 	/* Σπάσιμο του String που έδωσε ο χρήστης σε επιμέρους λέξεις */
		Map<Integer, String> dictionary = BuildDictionary.buildDictionary();


		printArray(splittedArray);				 /* εκτύπωση των λέξεων που έδωσε ο χρήστης */

		System.out.println("Οι λάθος λέξεις είναι :\n\n");

	}

	/**
	  *	Μέθοδος που σου επιτρέπει να διαβάζεις Strings στα ελληνικά.
	  *	@return the greek text that the user inserted
	  *	@throws Exception if the input is wrong.
	  */
	private static String getGreekInput() {    

	        System.out.flush();          		/* Καθαρίζει τη μνήμη  */

	        try {
	            BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "cp737"));    /* Χειρισμός εξαίρεσης  */
	            return in.readLine();
	        } catch (Exception e) {
	            return "Error: " + e.getMessage();
	        }

	}  /* Τέλος μεθόδου getGreekInput */


	/**
	  *	Μέθοδος που εκτυπώνει  πίνακα
	  */
	private static void printArray(String[] array) {    

		for  (int i=0 ; i< array.length;i ++) {
			if(array[i] != null) {
				System.out.println();			 /* Κενά */
				System.out.println(array[i]);      /* Εκτύπωση του πίνακα */
            			System.out.println("\n");            /* Κενά */
			}

   		 }

	} /* Τέλος μεθόδου printArray */

	
	/** 
	  *	Σύγκριση κάθε λέξης του πίνακα splittedArray με το treeMap που περιέχει το λεξικό, 
	  *	έπειτα γεμίζεται ένας τρίτος με τις λανθασμένες λέξεις.
	  *	@return the array with the wrong words found; null array if no wrong words are found.
	  */			
	private static String[] treeSearch(String [] splittedArray , Map<Integer, String> dictionary) { 
			String[] wrongArray = new String[a.length];
			for(int i = 0; i < a.length; i++) {
				

			}

			return wrongArray ;   /* Επιστρέφει τον πίνακα με τις λάθος λέξεις */

	} /* Τέλος μεθόδου treeSearch */






} /* Τέλος κλάσης */

