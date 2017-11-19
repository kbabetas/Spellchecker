import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader; 
import java.io.IOException;

public class Menu {
	
	private static int selection;  //shows how the user selects to give the text
	private static int choice;  //shows the user's choice either Greek or English
	

	private static Scanner input = new Scanner(System.in);
	
	
	public static void main(String args[]) {

		Spellcheck Spell = new Spellcheck();
		choice = getMenu();
		String text = null;
		 if(selection == 1) {
			text = getInput();
		 } else {
			text = getFileReader();
		 }
		
		System.out.printf("\n");
		Spell.spellcheck(choice,text);
		

	}
	
	
	public static int getMenu() {
		System.out.println("Press 1 for Greek:\nPress 2 for English:\n");

		int choice = input.nextInt();
		System.out.print("\n");

		while( (choice != 1) && (choice != 2) ) {
			  System.out.print("You should choose either 1 or 2\n");
			  System.out.print("Press 1 for Greek:\nPress 2 for English:\n");
			  choice = input.nextInt();
	      	}

		if(choice == 1) {
			System.out.println("Πληκτρολόγησε 1 άμα θέλεις να γράψεις  ένα δικό σου  κείμενο :");
			System.out.println("Πληκτρολόγησε 2 άμα θέλεις να ελέγξεις ορθογραφικά ένα αρχείο της επιλογής σου:\n");

			selection = input.nextInt();
			System.out.print("\n");
			while( (selection != 1) && (selection != 2) ) {
				System.out.print("You should choose either 1 or 2\n");

				selection = input.nextInt();
				System.out.print("\n");
	      		}


			if(selection == 1) {
				System.out.println("Πληκτρολόγησε ένα κείμενο στα ελληνικά και θα ελέγξουμε άμα είναι ορθογραφικά σωστό:\n\n");
			} else {
				System.out.println("Πληκτρολόγησε το path που βρίσκεται το αρχείο και θα ελέγξουμε άμα είναι ορθογραφικά σωστό:\n");
			}



		} else {
			System.out.println("Press 1  if you want to test the spelling of a text that you will type:");
			System.out.println("Press 2  if you want to test the spelling of a file that you will choose:\n");

			selection = input.nextInt();
			System.out.print("\n");
			while( (selection != 1) && (selection != 2) ) {
				System.out.print("You should choose either 1 or 2\n");

				selection = input.nextInt();
				System.out.print("\n");
	      		}
			if(selection == 1) {
				System.out.println("Type a text in English and we will check if the spelling is correct:\n\n");
			} else {
				System.out.println("Please insert the path of the file you want to read and we will check if the spelling is correct:\n");
			 }



		}

		return choice;
		



	}  /* Τέλος getMenu */
	
	public static String getInput() {    /* Μέθοδος που σου επιτρέπει να διαβάζεις Strings στα ελληνικά */

		        System.out.flush();          		/* Καθαρίζει τη μνήμη  */

		        try {
		            BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "cp737"));    /* Χειρισμός εξαίρεσης  */
		            return in.readLine();
		        } catch (Exception e) {
		            return "Error: " + e.getMessage();
		        }

	}  /* Τέλος μεθόδου getGreekInput */

	
	public static String getFileReader()  {

			input.nextLine();

			String path = input.nextLine();
		    	String text = null;

			try {

				String[] printLines =  getFile(path);




				for (int i = 0;i < printLines.length; i++) {
					text += " " + printLines[i];
				}
			
				System.out.println();
			
				if (choice == 2) {
					System.out.println("You read the file successfully");
				} else {
					System.out.println("Το αρχείο διαβάστηκε επιτυχώς");

				}


			
			
			} catch (IOException e) {
				System.out.println("Sorry, we cannot find your text file. Please try again." );

			}
			
			String newtext= text.substring(4);
			
			if (choice == 2 ) {
			System.out.println("The context of your file is:");
			} else {
			System.out.println("Το περιεχόμενο του αρχείου είναι:\n");

			}

			System.out.println(newtext);

			return newtext;
	} // end of method getFileReader
	
	public static String[] getFile(String path) throws IOException {
		
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
	
		int numberOfLines = calculateLines(path);
	   	String[] textOfData = new String[numberOfLines]; //each position in textData array can hold one line of text.
	
	   	for (int i=0; i< numberOfLines; i++) {
	    		textOfData[i] = textReader.readLine();
	    	
	    	}
	    
	    textReader.close();
	    return textOfData;
	
	} //end of method getFile
	
	public static int calculateLines(String path) throws IOException{
		
		
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		
		int numberOfLines = 0;
		
		while ( textReader.readLine()  != null ) {
			numberOfLines++ ;
		}
		
		textReader.close();
		
		return numberOfLines;
	} //end of method calculateLines
	


}
