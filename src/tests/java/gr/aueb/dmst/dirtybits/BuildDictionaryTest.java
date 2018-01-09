package gr.aueb.dmst.dirtybits;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

public class BuildDictionaryTest {
	int language = 2;
	BuildDictionary object = new BuildDictionary(language);

	Map<Integer, String> dictionary = object.getDictionary();
	String firstWord = "a";
	int size = dictionary.size() - 1;
	String lastWord = "zwitterionic";

	@Test
	public void testFirstWord() throws IOException {
		assertEquals(firstWord, dictionary.get(0));
	}

	@Test
	public void testLastWord() throws IOException {
		assertEquals(lastWord, dictionary.get(size));
	}

}

