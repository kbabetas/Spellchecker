package gr.aueb.dmst.dirtybits;

import java.util.Map;
import java.util.TreeMap;

/** 
  *	In this class the text given is splitted into words. These words are spell-checked one to one.
  *	If misspelled words are found there is a proposal of words that might correct the wrong ones.
  *	Then, some words from the dictionary are proposed to correct the wrong ones.
  *	@author Βούγιας,Γεωργούλη,Κακουλάκη,Λαζαρίδη,Λαζαρίδου,Μπαμπέτας,Παυλίδη,Σπέρτου
  */ 
public class Spellcheck {
	
	/**
	 * This method splits the text into words.
	 * The array words is created and contains the splitted words.
	 * A map is created and contains the words of the dictionary in the selected language.
	 * The array wrongwords is created and contains the misspelled words.
	 * The method displays whether there are misspelled words or not.
	 * 
	 * @param language is an integer that depicts the language (Greek or English) that the user chose.
	 * @param text is the string that the user either typed or gave through a file.
	 */
	public static void spellcheck(int language, String text) {
		
		String[] words = text.split("[^a-zA-Zα-ωΑ-Ωά-ώΐ]+"); /* the String is splitted inτο words */
		
		System.out.printf("\n\n");
		
		Map<Integer, String> dictionary = BuildDictionary.buildDictionary(language);
		
		String[] wrongwords = treeSearch(words, dictionary, language);   /* search inside the treemap */
		
		System.out.printf("\n");
		
		int flag = 0;

		for (int i = 0; i < wrongwords.length; i++) {
			if (wrongwords[i] != null) {
				flag = 1;
			}
		}

		if(flag == 0) {
			if(language == 1) {
				System.out.println("Το κείμενο είναι ορθογραφικά σωστό.\n\n");
			   } else {
				System.out.println("The text is spelled correctly.\n\n");
			}
		} else {
			if(language == 1) {
				System.out.println("Οι λάθος λέξεις είναι :\n\n");
			} else {
				System.out.println("The wrong words are:\n\n");
			}
			printArray(wrongwords);
		}	
	}

	/**
	  *	This method displays an array
	  */
	private static void printArray(String[] array) {    

		for  (int i=0 ; i< array.length; i++) {
			if(array[i] != null) {
				System.out.println(array[i]);      
			}
   		 }
	} /* end of the method printArray */

	
				
	/**
	 * This method compares each word from the array words with the treeMap that includes the dictionary.
	 * If there are wrong words found, words from the dictionary are being proposed to correct the spelling mistake.
	 * @param words is the array that contains the splitted words from the text given.
	 * @param dictionary the map that contains the words of the dictionary in the selected language.
	 * @param language is an integer that depicts the language (Greek or English) that the user chose.
	 * @return the array with the wrong words found; null array if no wrong words are found.
	 */		
	private static String[] treeSearch(String [] words, Map<Integer, String> dictionary, int language) {
		
		String[] wrongArray = new String[words.length + 1];
		int k = 0;
		
		for(int i = 0; i < words.length; i++) {

			if(!dictionary.containsValue(words[i])) {
	
				if(!dictionary.containsValue(words[i].toLowerCase())) {
					wrongArray[k] = words[i];
					k++;
					if (language == 1) {
						System.out.println("Προτεινόμενες λέξεις για: " +words[i] +" : ");
					} else {
						System.out.println("Suggestions for: " +words[i] +" : ");
					}
	
					for (int j=0; j < dictionary.size(); j++) {
						String value = dictionary.get(j);
						if((words[i] != words[i].toLowerCase()) && ((words[i].length() + value.length())<14)) {
							giveOptions(words[i], value);
							giveOptions(words[i].toLowerCase(), value);
						} else {
							giveOptions(words[i], value);
						}
					}
					System.out.println("-");
				}
			}
		}
		return wrongArray;
	}

	/**
	 * This method calculates the number of the changes needed so that two strings are equal.
	 * @param s1 is the first String.
	 * @param s2 is the second String.
	 * @return an integer with the number of the changes needed so that the strings are equal.
	 */
	public static int LevenshteinDistance(String s1, String s2) {
	//upologizei poses allages xreiazonte gia na ginoun ta duo string idia
		int sl1 = s1.length();
		int sl2 = s2.length();
		if (sl1 == 0) {
			return sl2;
		}
		if (sl2 == 0) {
			return sl1;
		}
		int[][] dis =new int[sl1+1][sl2+1];
		for (int i = 0; i <= sl1; i++){
			for (int j = 0; j <= sl2; j++) {
				if (i == 0) {
					dis[i][j] = j;
				}
				if (j == 0) {
					dis[i][j] = i;
				}

				if (i != 0 && j != 0) {
					if ( s1.charAt(i-1) != s2.charAt(j-1)) {
			 		// an o xaraktiras den einai idios o pinakas pairnei san timi
			 		// to min twn dis[(i-1)][j]+1 , dis[i][(j-1)]+1 , dis[(i-1)][(j-1)] kai prosthetw 1
			 		// ara toses allages xreiazonte mexri auto to simio gia na ginoun idia ta duo strings
			 			int a = Math.min(dis[(i-1)][j], dis[i][(j-1)]);
			 			dis[i][j] = Math.min(dis[(i-1)][(j-1)], a) + 1;
					} else {
			 		//an o xaraktiras einai idios pairnei thn timi tou pinaka
			 		//pou einai diagonia apo ti thesi pou vriskomaste afou den
			 		//xreiazetai pereterw allagi giauton ton xaraktira
			 			dis[i][j] = dis[(i-1)][(j-1)];
			 		}
				}
			}
	 	}
		return dis[sl1][sl2];
 	}
	
	/**
	 * This method finds the similarity of two Strings.
	 * @param s1 is the first String.
	 * @param s2 is the second String.
	 * @return a double with the percentage of similarity of the two strings.
	 */
	public static double percSimilarity(String s1, String s2) {
		int d = LevenshteinDistance(s1, s2);
		double sim = (double) (((s1.length() + s2.length()) - d) / (double) (s1.length() + s2.length()) * 100);
		return sim;
 	}
	
	/**
	 * This method proposes a specific word if the percentage of similarity of two strings is over the 75%
	 * @param s1 is the first String.
	 * @param s2 is the second String.
	 */
	public static void giveOptions(String s1, String s2) {
 		double v = percSimilarity(s1, s2);
 		if (v > 85) {
 			System.out.println(s2);
		}
	}					
} /* end of class */
