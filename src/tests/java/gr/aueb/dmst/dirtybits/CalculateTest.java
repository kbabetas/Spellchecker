package gr.aueb.dmst.dirtybits;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;

import org.junit.Test;

public class CalculateTest {

	public static int calculateLines() throws IOException {

			File upOne = new File(System.getProperty("use.dir")).getParentFile();
			FileReader fr = new FileReader(upOne + "/src/tests/resources/HeyTest.txt");
			BufferedReader textReader = new BufferedReader(fr);
			int numberOfLines = 0;

			while (textReader.readLine() != null) {
				numberOfLines++;
			}
			textReader.close();
			return numberOfLines;
	}

	@Test
	public void testCalculate() throws IOException {
			Calculate cl= new Calculate();
			assertTrue(cl.calculateLines() == 4);
	}
}