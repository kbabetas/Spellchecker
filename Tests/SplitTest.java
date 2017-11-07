import java.util.Scanner;

public class SplitTest {

	public static void main (String[] args) {

		String text = "Γεια σας παιδιά!";

		String[] splittedArray = text.split("[^α-ωΑ-Ωά-ώ]+");

		String[] array = splittedArray;

		if (array[0].equals("Γεια")) {
			System.out.println("well done team!");
		} else {
			System.out.println("try again");
			System.out.println(array[0]);
		}

		for  (int i=0 ; i< array.length;i ++) {
			if(array[i] != null) {
				System.out.println();
				System.out.println(array[i]);
		        System.out.println("\n");
			}
		}
	}
}