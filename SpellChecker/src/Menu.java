import java.util.Map;
import java.util.TreeMap;
public class Menu {

	public static void main(String args[]) {

		Spellchecker Spell = new Spellchecker();
		int choice = Spell.getMenu();
		String text = Spell.getGreekInput();
		System.out.printf("\n");
		Spell.spellchecker(choice,text);
		

	}


}
