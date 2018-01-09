package gr.aueb.dmst.dirtybits;

import static org.junit.Assert.*;
import java.util.Map;
import org.junit.Test;
import java.io.IOException;

public class BuildDictionaryTest {

	int language = 2;
	BuildDictionary object = new BuildDictionary(language);


	Map<Integer, String> dictionary = object.getDictionary();
	int size = dictionary.size() - 1;

	String firstWord = "a";

	@Test
	public void testFirstWord() throws IOException {

		assertEquals(firstWord, dictionary.get(0));

	}

}