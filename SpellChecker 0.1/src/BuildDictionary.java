import java.util.Map;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* Μετατρέπει το λεξικό (Dictionary.txt) σε ένα treemap με όνομα dictionary */

	
public static void buildDictionary() {
		
	Map<Integer, String> dictionary = new TreeMap<Integer, String>();
	try {
		BufferedReader reader = new BufferedReader(new FileReader("Dictionary.txt")); /* Dictionary.txt should be on the same folder  */ 
            	String word;
            	int key = 0;
            	while ((word = reader.readLine()) != null) {
            		dictionary.put(key, word);
            		key++;
            	}
        } catch (IOException ioe) {
           ioe.printStackTrace();
        }
		
}


	
