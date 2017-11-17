import java.util.Map;
import java.util.TreeMap;
public class Menu {

	public static void main(String args[]) {

		Spellchecker Spell = new Spellchecker();
		int choice = Spell.getMenu();
		String text = Spell.getGreekInput();
		System.out.printf("\n");

		String[] words = text.split("[^a-zA-Zα-ωΑ-Ωά-ώΐ]+"); 	
		Spell.printArray(words);
		System.out.printf("\n\n");

		Map<Integer, String> dictionary = BuildDictionary.buildDictionary(choice);


		String[] wrongwords = Spell.treeSearch(words,dictionary);

		System.out.printf("\n");
		if (wrongwords[0] == null && wrongwords[1] == null) {
			System.out.println("Το κείμενο είναι ορθογραφικά σωστό.\n\n");
		} else {
			System.out.println("Οι λάθος λέξεις είναι :\n\n");
			Spellr.printArray(wrongwords);
		}


	}




}
