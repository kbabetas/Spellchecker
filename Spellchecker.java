import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Spellchecker {




	public static void main(String args[]) {


	    	Scanner input = new Scanner(System.in);

			System.out.println("Δώσε κείμενο και θα σου πω άμα είναι ορθογραφικά σωστό\n\n");


        	String keimeno = getGreekInput();           			/* Κάλεσμα μεθόδου getGreekInput */

			String[] Pinakas = keimeno.split("[^α-ωΑ-Ωά-ώ]+"); 		/* Σπάσιμο του String που έδωσε ο χρήστης σε επιμέρους λέξεις */
			String[] correct = createCorrectWordsArray(Pinakas.length);   /*ο πινακας που έχει μέσα τις λέξεις του μινι λεξικού */
			String[] wrong = binarySearch(Pinakas ,correct); 			  /*ο πινακας που έχει μέσα τις λάθος λεξεις που έδωσε ο χρήστης,σε σχέση με το μινι λεξικό,χρησιμοποιόντας την binarySearch */
			printArray(Pinakas);										  /* εκτύπωση των λέξεων που έδωσε ο χρήστης */


			System.out.println("Οι λάθος λέξεις είναι :\n\n");
			printArray(wrong);   										/* εκτύπωση του πινακα με τις λαθος λεξεις */






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



	private static void printArray(String[] pinakas) {    /* Μέθοδος που εκτυπώνει  πίνακα  */

		  for  (int i=0 ; i< pinakas.length;i ++) {
			    if(pinakas[i] != null) {
			   	System.out.println("\n");			 /* Κενά */
			   	System.out.println(pinakas[i]);      /* Εκτύπωση του πίνακα */
            	System.out.println("\n");            /* Κενά */
				}

   		 }

	} /* Τέλος μεθόδου printArray */

	private static String[] createCorrectWordsArray(int N) {  /*Μέθοδος που δημιουργεί ένα προκαθορισμένο λεξικό,στη συνέχεια θα βάλουμε το κανονικό */
				String[] array1 = new String[N];

				array1[0] = "Καλημέρα" ;
				array1[1] = "φίλε" ;
				array1[2] = "τι" ;
				array1[3] = "κάνεις" ;

				return array1 ;




	} /* Τέλος μεθόδου createCorrectWordsArray */


	private static String[] binarySearch(String [] a ,String [] b) { /* Δυαδική αναζήτηση σε 2 πίνακες,γεμίζοντας έναν τρίτο με τα στοιχεία που δεν είναι κοινά και στους 2 */

			String[] wrongArray = new String [a.length];
			int wrongIndex= 0 ;
			for(int i = 0; i < a.length; i++) {
			  	int finder = 0 ;

		    	for(int j = 0; j < b.length; j++) {

		       		if(a[i].equals(b[j])) {

		            	finder=1;
		        	}
		   	    }

		   	    if( finder == 0) {
					wrongArray[wrongIndex] = a[i];
					wrongIndex++;
				}

			}

			return wrongArray ;   /* Επιστρέφει τον πίνακα με τις λάθος λέξεις */








		} /* Τέλος μεθόδου binarySearch */






} /* Τέλος κλάσης */
