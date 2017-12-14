package gr.aueb.dmst.dirtybits;

import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.File;

/**
 * This class converts the txt dictionary to a Treemap
 * @author Konstantinos
 *
 */
public class BuildDictionary {

	private static Map<Integer, String> dictionary = new TreeMap<Integer, String>();
	private static final String[] DICTIONARIES = {"Greek Dictionary.txt", "English Dictionary.txt"};
	/**
	 * This method encodes the dictionary and after puts every word in a treemap
	 * @param language shows which of the two dictionaries the user will need
	 * */
	public BuildDictionary(int language) {
		File upOne = new File(System.getProperty("user.dir")).getParentFile();

		try {
			BufferedReader reader;
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(upOne + "/resources/" + DICTIONARIES[language - 1]),"UTF-8")); // for non maven use
			//reader = new BufferedReader(new InputStreamReader(new FileInputStream(upOne + "/src/main/resources/" + DICTIONARIES[language - 1]),"UTF-8")); for maven

           	String word;
            int key = 0;
            while ((word = reader.readLine()) != null) {
            	dictionary.put(key, word);
            	key++;
           	}
            reader.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	/*
	 * This method returns the dictionary
	 * @return the appropriate dictionary in a treemap
	 */
	public Map<Integer, String> getDictionary() {
		return BuildDictionary.dictionary;
	}
}
