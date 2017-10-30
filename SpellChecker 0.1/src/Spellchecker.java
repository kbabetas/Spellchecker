import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Spellchecker {


	public static void main(String args[]) {


		Scanner input = new Scanner(System.in);

		System.out.println("Δώσε κείμενο και θα σου πω άμα είναι ορθογραφικά σωστό\n\n");
		String text = getGreekInput();           		/* Κάλεσμα μεθόδου getGreekInput */

		String[] splittedArray = text.split("[^α-ωΑ-Ωά-ώ]+"); 	/* Σπάσιμο του String που έδωσε ο χρήστης σε επιμέρους λέξεις */
		Map<Integer, String> dictionary = BuildDictionary.buildDictionary();


		printArray(splittedArray);				 /* εκτύπωση των λέξεων που έδωσε ο χρήστης */

		System.out.println("Οι λάθος λέξεις είναι :\n\n");

	}


	private static String getGreekInput() {    /* Μέθοδος που σου επιτρέπει να διαβάζεις Strings στα ελληνικά */

	        System.out.flush();          		/* Καθαρίζει τη μνήμη  */

	        try {
	            BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "cp737"));    /* Χειρισμός εξαίρεσης  */
	            return in.readLine();
	        } catch (Exception e) {
	            return "Error: " + e.getMessage();
	        }

	}  /* Τέλος μεθόδου getGreekInput */



	private static void printArray(String[] array) {    /* Μέθοδος που εκτυπώνει  πίνακα  */

		for  (int i=0 ; i< array.length;i ++) {
			if(array[i] != null) {
				System.out.println();			 /* Κενά */
				System.out.println(array[i]);      /* Εκτύπωση του πίνακα */
            			System.out.println("\n");            /* Κενά */
			}

   		 }

	} /* Τέλος μεθόδου printArray */


	private static String[] treeSearch(String [] a , Map<Integer, String> dic) { /*  Αναζήτηση σε 2 πίνακες,γεμίζοντας έναν τρίτο με τα στοιχεία που δεν είναι κοινά και στους 2 */
			String[] wrongArray = new String[a.length];
			for(int i = 0; i < a.length; i++) {
				

			}

			return wrongArray ;   /* Επιστρέφει τον πίνακα με τις λάθος λέξεις */

		} /* Τέλος μεθόδου treeSearch */






} /* Τέλος κλάσης */

