import java.util.Map;
import java.util.TreeMap;
public class Menu {

	public static void main(String args[]) {

		SpellcheckerWithOptions Spellchecker = new SpellcheckerWithOptions();
		int choice = Spellchecker.getMenu();
		String text = Spellchecker.getGreekInput();
		System.out.printf("\n");

		String[] words = text.split("[^a-zA-Zα-ωΑ-Ωά-ώΐ]+"); 	/*   Σπάσιμο του String που έδωσε ο χρήστης σε επιμέρους λέξεις  Μορφοποίηση no:2[ \n\t\r,.;!?(){}]+  */
		Spellchecker.printArray(words);										/* εκτύπωση των λέξεων που έδωσε ο χρήστης */
		System.out.printf("\n\n");

		Map<Integer, String> dictionary = BuildDictionary.buildDictionary(choice);


		String[] wrongwords = Spellchecker.treeSearch(words,dictionary);

		System.out.printf("\n");
		if (wrongwords[0] == null && wrongwords[1] == null) {
			System.out.println("Το κείμενο είναι ορθογραφικά σωστό.\n\n");
		} else {
			System.out.println("Οι λάθος λέξεις είναι :\n\n");
			Spellchecker.printArray(wrongwords);
		}


	}




}