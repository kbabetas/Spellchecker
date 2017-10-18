import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Spellchecker {




	public static void main(String args[]) {


	    Scanner input = new Scanner(System.in);

		System.out.println("Δώσε κείμενο και θα σου πω άμα είναι ορθογραφικά σωστό\n\n");


        String keimeno = getGreekInput();           /* Κάλεσμα μεθόδου getGreekInput */

		String[] Pinakas = keimeno.split(" ");  /* Σπάσιμο του String που έδωσε ο χρήστης σε επιμέρους λέξεις */

		for  (int i=0 ; i< Pinakas.length;i ++) {
			System.out.println("\n");            /* Κενά */
			System.out.println(Pinakas[i]);      /* Εκτύπωση του πίνακα */
            System.out.println("\n");            /* Κενά */
		}










	}
	private static String getGreekInput() {    /* Μέθοδος που σου επιτρέπει να διαβάζεις Strings στα ελληνικά */

	        System.out.flush();          /* Καθαρίζει τη μνήμη  */

	        try {                       /* Χειρισμός εξαίρεσης  */
	            BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "cp737"));    /* Η διαδικασία μετατροπής στα ελληνικά*/
	            return in.readLine();
	        } catch (Exception e) {
	            return "Error: " + e.getMessage();
	        }
    }



}