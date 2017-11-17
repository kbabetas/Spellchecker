import java.util.Map;
import java.util.TreeMap;
public class Menu {

	public static void main(String args[]) {

		Spellcheck Spell = new Spellcheck();
		int choice = Spell.getMenu();
		String text = Spell.getGreekInput();
		System.out.printf("\n");
		Spell.spellcheck(choice,text);
		

	}


}
