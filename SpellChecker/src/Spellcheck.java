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
public class Spellcheck {
	
	private static Scanner input = new Scanner(System.in);


	public static void spellcheck(int choice, String text) {

		String text = getGreekInput();           		/* Κάλεσμα μεθόδου getGreekInput */
		
		System.out.printf("\n");
		
		String[] words = text.split("[^a-zA-Zα-ωΑ-Ωά-ώΐ]+"); 	/* Σπάσιμο του String που έδωσε ο χρήστης σε επιμέρους λέξεις */
		
		Map<Integer, String> dictionary = BuildDictionary.buildDictionary();
		
		printArray(words);				 /* εκτύπωση των λέξεων που έδωσε ο χρήστης */
		
		String[] wrongwords = treeSearch(words,dictionary);   /* αναζήτηση στο treemap */
		
		System.out.printf("\n");
		
		if (wrongwords[0] == null &&  wrongwords[1] == null) {
			System.out.println("Το κείμενο είναι ορθογραφικά σωστό.\n\n");
		} else {
			System.out.println("Οι λάθος λέξεις είναι :\n\n");
			printArray(wrongwords);  /* εκτύπωση λέξεων με ορθογραφικά λάθη */
		} 

	}

	/**
	  *	Μέθοδος που σου επιτρέπει να διαβάζεις Strings.
	  *	@return the text that the user inserted
	  *	@throws Exception if the input is wrong.
	  */
	private static String getInput() {    

	        System.out.flush();          		/* Καθαρίζει τη μνήμη  */

	        try {
	            BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "cp737"));    /* Χειρισμός εξαίρεσης  */
	            return in.readLine();
	        } catch (Exception e) {
	            return "Error: " + e.getMessage();
	        }

	}  /* Τέλος μεθόδου getInput */


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
							
				}
			}
		}
		

		return wrongArray ;

			
				
       } /* Τέλος μεθόδου treeSearch */
	
	private static int getMenu() {



		System.out.println("Press 1 for Greek:\nPress 2 for English:\n");

		int choice = input.nextInt();

		while( (choice != 1) && (choice != 2) ) {
		  		System.out.print("You should choose either 1 or 2\n");
		        System.out.print("Press 1 for Greek:\nPress 2 for English:\n");
		        choice = input.nextInt();
      		}

		if(choice == 1) {
		System.out.println("Πληκτρολόγησε ένα κείμενο στα ελληνικά και θα ελέγξουμε άμα είναι ορθογραφικά σωστό:\n\n");


		} else {
		System.out.println("Type a text in English and we will check if the spelling is correct:\n\n");


		}

		return choice;

	}  /* Τέλος getMenu */







} /* Τέλος κλάσης */

