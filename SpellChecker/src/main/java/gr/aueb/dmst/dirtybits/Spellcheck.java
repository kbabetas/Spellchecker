package gr.aueb.dmst.dirtybits;

import java.util.Map;
import java.util.TreeMap;


/** 
  *	In this class the user inserts a text that is splitted into words and these words are spell-checked one to one.
  *	if a wrong word exists, it is inserted in an array.
  *	@author Βούγιας,Γεωργούλη,Κακουλάκη,Λαζαρίδη,Λαζαρίδου,Μπαμπέτας,Παυλίδη,Σπέρτου
  */ 
public class Spellcheck {
	
	


	public static void spellcheck(int language, String text) {
		
		String[] words = text.split("[^a-zA-Zα-ωΑ-Ωά-ώΐ]+"); /* the String is splitted in words */
		
		System.out.printf("\n\n");
		
		Map<Integer, String> dictionary = BuildDictionary.buildDictionary(language);
		
		String[] wrongwords = treeSearch(words,dictionary,language);   /* search inside the treemap */
		
		System.out.printf("\n");
		
		int flag = 0;

		for (int i = 0; i < wrongwords.length;i++) {
			if (wrongwords[i]!= null) {
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

		for  (int i=0 ; i< array.length;i ++) {
			if(array[i] != null) {
				System.out.println(array[i]);      
			}

   		 }

	} /* end of the method printArray */

	
	/** 
	  *	Σύγκριση κάθε λέξης του πίνακα splittedArray με το treeMap που περιέχει το λεξικό, 
	  *	έπειτα γεμίζεται ένας τρίτος με τις λανθασμένες λέξεις.
	  *	@return the array with the wrong words found; null array if no wrong words are found.
	  */			
	private static String[] treeSearch(String [] words , Map<Integer, String> dictionary,int language) {
		
		String[] wrongArray = new String[words.length + 1];
		int k = 0;
		
		for(int i = 0; i < words.length; i++) {

			if(!dictionary.containsValue(words[i])){

					
				if(!dictionary.containsValue(words[i].toLowerCase() )) {
					wrongArray[k] = words[i];
					k++ ;
					if (language == 1) {
						System.out.println("Προτεινόμενες λέξεις για : " +words[i] +" : ");
					} else {
						System.out.println("Suggestions for : " +words[i] +" : ");
					}
				//  extra επιλογές
					
					for (int j=0; j < dictionary.size() ; j++) {
						String value = dictionary.get(j);
						if( (words[i]!= words[i].toLowerCase()) && ((words[i].length() + value.length())<14) ){
							giveOptions(words[i], value) ;
							giveOptions(words[i].toLowerCase(), value) ;
						} else {
							giveOptions(words[i], value) ;
						}
					}
					System.out.println("-");
				}
			}
		}


		return wrongArray ;
	}


	public static int LevenshteinDistance( String s1, String s2) {
	//upologizei poses allages xreiazonte gia na ginoun ta duo string idia
	int sl1 = s1.length() ;
	int sl2 = s2.length();
	if (sl1 == 0) {
		return sl2 ;
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


			 if (i!=0 && j!=0) {
			 				if ( s1.charAt(i-1)!= s2.charAt(j-1)) {
			 					// an o xaraktiras den einai idios o pinakas pairnei san timi
			 					// to min twn dis[(i-1)][j]+1 , dis[i][(j-1)]+1 , dis[(i-1)][(j-1)] kai prosthetw 1
			 					// ara toses allages xreiazonte mexri auto to simio gia na ginoun idia ta duo strings

			 					 int a = Math.min( dis[(i-1)][j] , dis[i][(j-1)]);
			 					 dis[i][j] = Math.min(dis[(i-1)][(j-1)] , a)+1;


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

public static double percSimilarity(String s1, String s2) {
 int d = LevenshteinDistance(s1,s2);
 double sim = (double)(((s1.length() + s2.length()) -d)/(double)(s1.length() + s2.length())*100);

 return sim;
 }

public static void giveOptions(String s1, String s2) {

 	double v = percSimilarity(s1, s2) ;

 		if (v > 85) { //if the percentage of similarity is over the 75%, the program proposes the specific word
 			System.out.println(s2);
		}
}
				
	
} /* end of class */

