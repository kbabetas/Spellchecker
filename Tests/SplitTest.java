import java.util.Scanner;

public class SplitTest {

	public static void main (String[] args) {

		String text1 = "Γεια σας παιδιά!";
		String text2 = "δοκιμή με    κενό";

		String[] words1 = text1.split("[^a-zA-Zα-ωΑ-Ωά-ώΐ]+");
		String[] words2 = text2.split("[^a-zA-Zα-ωΑ-Ωά-ώΐ]+");

		String[] array1 = words1;
		String[] array2 = words2;

		if (array1[0].equals("Γεια")) {
			System.out.println("try 1:");
			System.out.println("well done team!");
			System.out.println("H methodos splitArray douleuei kanonika");
		} else {
			System.out.println("try again");
			System.out.println(array1[0]);
		}

		for  (int i=0 ; i< array1.length;i ++) {
			if(array1[i] != null) {
				System.out.println();
				System.out.println(array1[i]);
		        System.out.println("\n");
			}
		}

		if (array2[2].equals("κενό")) {
			System.out.println("try 2:");
			System.out.println("well done team!");
			System.out.println("To programma douleuei osa kena kai na exei anamesa stis le3eis");
		} else {
			System.out.println("try again");
			System.out.println(array2[2]);
		}

		for  (int i=0 ; i< array2.length;i ++) {
			if(array2[i] != null) {
				System.out.println();
				System.out.println(array2[i]);
			    System.out.println("\n");
			}
		}
	}
}
