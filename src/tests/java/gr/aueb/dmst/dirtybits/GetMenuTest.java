import java.util.Scanner;

public class GetMenuTest {

	public static void main (String[] args) {
		int language = getMenuTest();
	}

	public static int getMenuTest() {

		Scanner input = new Scanner(System.in);
		int language = 0;
		int selection;
		System.out.println("Press 1 for Greek/ Πιέστε 1 για ελληνικά:");
		System.out.println("Press 2 for English/ Πιέστε 2 για αγγλικά:");
		System.out.println("Press 3 to exit/ Πιέστε 3 για έξοδο:\n");

		try {

			language = input.nextInt();
			System.out.println();

			while ((language != 1) && (language != 2) && (language != 3)) {
				System.out.print("Please press 1 or 2 or 3\n");
				System.out.print("Press 1 for Greek:\n"
						+ "Press 2 for English:\nPress 3 to exit\n");
				language = input.nextInt();
			}

			if (language == 1) {
				System.out.println("Πληκτρολόγησε 1 άμα θέλεις να γράψεις"
						+ " ένα δικό σου  κείμενο:");
				System.out.println("Πληκτρολόγησε 2 άμα θέλεις να ελέγξεις"
						+ " ορθογραφικά ένα αρχείο της επιλογής σου:\n");

				selection = input.nextInt();
				System.out.println();
				while ((selection != 1) && (selection != 2)) {
					System.out.print("Παρακαλώ πληκτρολογήστε 1 ή 2\n");
					selection = input.nextInt();
					System.out.println();
				}
				if (selection == 1) {
					System.out.println("Πληκτρολόγησε ένα κείμενο στα "
							+ "ελληνικά και θα ελέγξουμε άμα είναι "
							+ "ορθογραφικά σωστό:\n\n");
				} else {
					System.out.println("Πληκτρολόγησε το path που "
							+ "βρίσκεται το αρχείο και θα ελέγξουμε "
							+ "άμα είναι ορθογραφικά σωστό:\n");
				}
			} else if (language == 2) {
				System.out.println("Press 1 if you want to test the "
						+ "spelling of a text that you will type:");
				System.out.println("Press 2 if you want to test the "
						+ "spelling of a file that you will choose:\n");

				selection = input.nextInt();
				System.out.println();
				while ((selection != 1) && (selection != 2)) {
					System.out.print("Please press 1 or 2\n");
					selection = input.nextInt();
					System.out.println();
				}
				if (selection == 1) {
					System.out.println("Type a text in English and we "
							+ "will check if the spelling is correct:\n\n");
				} else {
					System.out.println("Please insert the path of the "
							+ "file and we will check if the spelling "
							+ "is correct:\n");
				}
			} else {
				Runtime.getRuntime().exit(1);
			}
		} catch (Exception e) {

			System.out.println("\nError: You can only use 1 or 2 or 3");
			getMenuTest();
		}

		return language;

	} /* end o method */

}