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
		
		System.out.printf("\n");
		
		String[] words = text.split("[^a-zA-Zα-ωΑ-Ωά-ώΐ]+"); 	/* Σπάσιμο του String που έδωσε ο χρήστης σε επιμέρους λέξεις */
		
		Map<Integer, String> dictionary = BuildDictionary.buildDictionary();
		
		printArray(words);				 /* εκτύπωση των λέξεων που έδωσε ο χρήστης */
		
		String[] wrongwords = treeSearch(words,dictionary);   /* αναζήτηση στο treemap */
		
		System.out.printf("\n");				
		
		System.out.println("Οι λάθος λέξεις είναι :\n\n");
		
		printArray(wrongwords);					/* εκτύπωση λέξεων με ορθογραφικά λάθη */
		

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
	private static String[] treeSearch(String [] words , Map<Integer, String> dictionary) {
		
		String[] wrongArray = new String[words.length];
		int k = 0;
		
		for(int i = 0; i < words.length; i++) {

			if(!dictionary.containsValue(words[i])){

					
				if(!dictionary.containsValue(words[i].toLowerCase() )) {
					wrongArray[k] = words[i];
					k++ ;
					//  extra επιλογές
					System.out.println("Προτεινόμενες λέξεις για : " +words[i] +" : ");
					for (int j=0; j < dictionary.size() ; j++) {
						String value = dictionary.get(j);
						giveOptions(words[i], value) ;
					}
					System.out.println("-");		
				}
			}
		}
		

		return wrongArray ;

			
				
       } /* Τέλος μεθόδου treeSearch */

//μέθοδος που εμφανίζει προτεινόμενες λέξεις
	
private static void giveOptions(String s1, String s2) {
	OptionsTest r = new OptionsTest();

 	double v = r.percSimilarity(s1, s2) ;

 		if (v > 85) { //αν το ποσοστό ομοιότητας είναι πάνω απο 85% να προτείνει την λέξη
			// με χαμηλότερο ποσοστό προτείνει παρα πολλές λέξεις.
 			System.out.println(s2);
		}
}




} /* Τέλος κλάσης */

