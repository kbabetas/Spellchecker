import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

/** 
  *	In this class the user inserts a text that is splitted into words and these words are spell-checked one to one.
  *	if a wrong word exists, it is inserted in an array.
  *	@author Βούγιας,Γεωργούλη,Κακουλάκη,Λαζαρίδη,Λαζαρίδου,Μπαμπέτας,Παυλίδη,Σπέρτου
  */ 
public class Spellcheck {
	
	private static Scanner input = new Scanner(System.in);


	public static void spellcheck(int choice, String text) {
		
		String[] words = text.split("[^a-zA-Zα-ωΑ-Ωά-ώΐ]+"); /* Σπάσιμο του String που έδωσε ο χρήστης σε επιμέρους λέξεις */
		
		System.out.printf("\n\n");
		
		Map<Integer, String> dictionary = BuildDictionary.buildDictionary(choice);
		
		String[] wrongwords = treeSearch(words,dictionary);   /* αναζήτηση στο treemap */
		
		System.out.printf("\n");
		
		int flag = 0;

		for (int i = 0; i < wrongwords.length;i++) {
			if (wrongwords[i]!= null) {
				flag = 1;
			}
		}

		if(flag == 0) {
			if(choice==1) {
				System.out.println("Το κείμενο είναι ορθογραφικά σωστό.\n\n");
			   } else {
				System.out.println("The text is spelled correctly.\n\n");
			}
		} else {
			if(choice==1) {
				System.out.println("Οι λάθος λέξεις είναι :\n\n");
			} else {
				System.out.println("The wrong words are:\n\n");
			}
			printArray(wrongwords);

		}
		
		
		
	}

	/**
	  *	Μέθοδος που εκτυπώνει  πίνακα
	  */
	private static void printArray(String[] array) {    

		for  (int i=0 ; i< array.length;i ++) {
			if(array[i] != null) {
				System.out.println(array[i]);      /* Εκτύπωση του πίνακα */
			}

   		 }

	} /* Τέλος μεθόδου printArray */

	
	/** 
	  *	Σύγκριση κάθε λέξης του πίνακα splittedArray με το treeMap που περιέχει το λεξικό, 
	  *	έπειτα γεμίζεται ένας τρίτος με τις λανθασμένες λέξεις.
	  *	@return the array with the wrong words found; null array if no wrong words are found.
	  */			
	private static String[] treeSearch(String [] words , Map<Integer, String> dictionary) {
		
		String[] wrongArray = new String[words.length + 1];
		int k = 0;
		
		for(int i = 0; i < words.length; i++) {

			if(!dictionary.containsValue(words[i])){

					
				if(!dictionary.containsValue(words[i].toLowerCase() )) {
					wrongArray[k] = words[i];
					k++ ;
							
				}
			}
		}
		

		return wrongArray ;

			
				
       } /* Τέλος μεθόδου treeSearch */
	
} /* Τέλος κλάσης */

