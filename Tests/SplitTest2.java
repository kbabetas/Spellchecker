import java.util.Scanner;


public class SplitTest2 {

	public static void main (String[] args) {

		String text = "Δοκιμή με    κενό";

		String[] splittedArray = text.split("[^á-ùÁ-ÙÜ-þ]+");

		String[] array = splittedArray;

		if (array[2].equals("κενό")) {
			System.out.println("well done team!");
			System.out.println("To programma douleuei osa kena kai na exei anamesa stis le3eis");
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
