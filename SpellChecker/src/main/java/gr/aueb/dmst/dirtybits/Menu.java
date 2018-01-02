package gr.aueb.dmst.dirtybits;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Menu {

	private static int selection; // shows how the user selects to give the text
	private static int language; // shows the user's choice either Greek or
									// English
	private static Scanner input = new Scanner(System.in);

	public static void main(String args[]) {
		try {
			System.setOut(new PrintStream(System.out, true, "cp737"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		GreekEncodingCMD.main(null);
		Spellcheck Spell = new Spellcheck();
		language = getMenu();

		while (language != 3) {
			String text = typeReader();
			Spell.spellcheck(language, text);
			System.out.printf("\n\n");
			language = getMenu();
			if (language != 3) {
				String newtext = typeReader();
				Spell.spellcheck(language, newtext);
				language = getMenu();
			}
		}

	}

	/**
	 * In this method the user selects either Greek or English and also selects
	 * the way the text is inserted
	 * 
	 * @return an integer variable that contains the language the user selected
	 */
	public static int getMenu() {

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

			System.out.println("\nError: You can only use 1 or 2");
			getMenu();
		} /* end of InputMisMatch Exception */

		return language;

	} /* end of method getMenu */

	public static String getInput() {
		/* with this method you can read Strings in Greek */

		System.out.flush();
		/* clear the memory */
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in, "cp737")); /* handle exception */
			return in.readLine();
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	} /* end of method getGreekInput */

	/**
	 * 
	 * This method asks from the user the path of the text file and returns it's
	 * content in a String
	 * 
	 * @return returns a String with the content of the text file
	 */
	public static String getFileReader() {

		input.nextLine();
		String path = input.nextLine();
		String text = null;
		try {
			String[] printLines = getFile(path);

			for (int i = 0; i < printLines.length; i++) {
				text += " " + printLines[i];
			}

			System.out.println();
			if (language == 2) {
				System.out.println("The file was read successfully");
			} else {
				System.out.println("Το αρχείο διαβάστηκε επιτυχώς");
			}
		} catch (IOException e) {
			System.out.println("Sorry, we cannot find your text "
					+ "file. Please try again.");
			getMenu();
		}
		String newtext = text.substring(4);

		if (language == 2) {
			System.out.println("The context of your file is:\n");
		} else {
			System.out.println("Το περιεχόμενο του αρχείου είναι:\n");
		}

		System.out.println(newtext);
		return newtext;
	} // end of method getFileReader

	/**
	 * This method returns all the lines from the text file then these lines
	 * will be held in the array textOfData.
	 * 
	 * @return a String array with the lines of the text file.
	 * @throws IOException
	 *             will throw errors in the line.
	 */
	public static String[] getFile(String path) throws IOException {

		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);

		int numberOfLines = calculateLines(path);
		String[] textOfData = new String[numberOfLines]; // each position in
															// textData array
															// can hold one line
															// of text.

		for (int i = 0; i < numberOfLines; i++) {
			textOfData[i] = textReader.readLine();
		}
		textReader.close();
		return textOfData;
	} // end of method getFile

	/**
	 * This method calculates the number of lines of a text file.
	 * 
	 * @return returns the number of lines of a text file.
	 * @throws IOException
	 */
	public static int calculateLines(String path) throws IOException {

		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		int numberOfLines = 0;
		while (textReader.readLine() != null) {
			numberOfLines++;
		}
		textReader.close();
		return numberOfLines;
	} // end of method calculateLines

	public static String typeReader() {
		String text = null;
		if (selection == 1) {
			text = getInput();
		} else {
			text = getFileReader();
		}
		System.out.printf("\n");

		return text;
	}
}

