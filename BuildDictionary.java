
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* Μετατρέπει το λεξικό μας (Dictionary.txt) σε μια ArrayList με όνομα dictionary */

public class BuildDictionary {
	
	public static void main(String[] args) {
		
		ArrayList<String> dictionary = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Dictionary.txt")); /* Dictionary.txt should be on the same folder  */ 
            String word;
            while ((word = reader.readLine()) != null) {
                dictionary.add(word);
            }
        } catch (IOException ioe) {
           ioe.printStackTrace();
        }
			
	}

}



	