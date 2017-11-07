import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/** This class converts the txt dictionary to a Treemap */
public class BuildDictionary {


	public static Map<Integer, String>  buildDictionary() {

		Map<Integer, String> dictionary = new TreeMap<Integer, String>();
		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Dictionary.txt"),"cp737")); /* Dictionary.txt should be on the same folder  */

            		String word;
            		int key = 0;
            		while ((word = reader.readLine()) != null) {
            			dictionary.put(key, word);
            			key++;
            		}
        	} catch (IOException ioe) {
           	ioe.printStackTrace();
       		}

	return dictionary;
	}

}
