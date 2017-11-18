package spellcheker;

import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException; 
import java.io.InputStreamReader;

/**
 * In this class the user chooses the language and the way that the files will be red.
 * @author Konstantinos, Ioannis, Marinina
 *
 */

public class Menu {
	

	private static Scanner input = new Scanner(System.in);
	
	
	public static void main(String args[]) {

		Spellcheck Spell = new Spellcheck();
		int[] choices = getMenu();
		
		if (choices[1] == 2) {
		String text = getInput();
		
		} else {
			String[] text = getFileReader();		
		
		
		
		System.out.printf("\n");
		Spell.spellcheck(choices[0],text); //issue
		

	}
	
	
	public static int[] getMenu() {
		
		    int[] choices = {0,0};
			System.out.println("Press 1 for Greek:\nPress 2 for English:\n");

			int choice = input.nextInt();
			choices[0] = choice;
			
			while( (choice != 1) && (choice != 2) ) {
			  		System.out.print("You should choose either 1 or 2\n");
			        System.out.print("Press 1 for Greek:\nPress 2 for English:\n");
			        choice = input.nextInt();
			        
	      		}

			if(choice == 1) {
				
				
		    	System.out.println("Πάτησε 2 για να γράψεις το δικό σου κείμενο:\nΠάτησε 3 για να πάρεις το κείμενο από κάποιο αρχείο:\n");
			
				int choice2 = input.nextInt();
				choices[1] = choice2;
			
				while( (choice2 != 2) && (choice2 != 3) ) {
					System.out.print("You should choose either 2 or 3\n");
					System.out.print("Press 2 to type your own text:\nPress 3 to read from a text file:\n");
					choice2 = input.nextInt();
				}
				
				if ( choice2 == 2 ) {
					
					System.out.println("Πληκτρολόγησε ένα κείμενο στα ελληνικά και θα ελέγξουμε άμα είναι ορθογραφικά σωστό:\n\n");
				} else {
					System.out.println("Πληκτρολόγησε το path που βρίσκεται το αρχείο και θα ελέγξουμε άμα είναι ορθογραφικά σωστό:\n\n");
					
				}				

			} else {
				System.out.println("Press 2 to type your own text:\nPress 3 to read from a text file:\n");
				
				int choice2 = input.nextInt();
			
				while( (choice2 != 2) && (choice2 != 3) ) {
					System.out.print("You should choose either 2 or 3\n");
					System.out.print("Press 2 to type your own text:\nPress 3 to read from a text file:\n");
					choice2 = input.nextInt();
				}
				
				if ( choice2 == 2 ) {
					
					System.out.println("Type a text in English and we will check if the spelling is correct:\n\n");
					
				} else {
					System.out.println("Please insert the path of the file you want to read and we will check if the spelling is correct:\n\n");
				}
					
			}

			return choices;

	}  /* end of the method getMenu */
	
	
	
	public static String getInput() {    /* Μέθοδος που σου επιτρέπει να διαβάζεις Strings στα ελληνικά */

		        System.out.flush();          		/* Καθαρίζει τη μνήμη  */

		        try {
		            BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "cp737"));    /* Χειρισμός εξαίρεσης  */
		            return in.readLine();
		        } catch (Exception e) {
		            return "Error: " + e.getMessage();
		        }

	}  /* end of the method getGreekInput */

	
	/**
	 * This method asks from the user the path of the text file and displays the array with the lines of the file.
	 * 
	 * @throws IOException
	 */
		public static String[] getFileReader () throws IOException {
			
			
			String path = input.nextLine();
			
			//try {
				
			String[] printLines = OpenFile(path);
			return printLines;
			
			/*for (int i=0; i < printLines.length; i++) {
				
				System.out.println("Line " + i + ": " + printLines[i]);
			}
			
			System.out.println();
			System.out.println("You read the file successful");
			
			}
			catch (IOException e) {
				System.out.println("Sorry, we cannot find your text file. Please try again." );
			}
			
			*/
			
		}	
	
	
	/**
	 * This method returns all the lines from the text file
	 * then these lines will be held in the array textOfData.
	 * 
	 * @return a String array with the lines of the text file.
	 * @throws IOException will throw errors in the line.
	 */
	public static String[] OpenFile(String path) throws IOException {
		
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
	
		int numberOfLines = calculateLines(path);
	    String[] textOfData = new String[numberOfLines]; //each position in textData array can hold one line of text.
	
	    for (int i=0; i< numberOfLines; i++) {
	    	textOfData[i] = textReader.readLine();
	    	
	    }
	    
	    textReader.close();
	    return textOfData;
	
	
	}
	
	/**
	 * This method calculates the number of lines of a text file.
	 * @return returns the number of lines of a text file.
	 * @throws IOException
	 */
	public static int calculateLines(String path) throws IOException{
		
		
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		
		int numberOfLines = 0;
		
		while ( textReader.readLine()  != null ) {
			numberOfLines++ ;
		}
		
		textReader.close();
		
		return numberOfLines;
	} 
	

	


}
