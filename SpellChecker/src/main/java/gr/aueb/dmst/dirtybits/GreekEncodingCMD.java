package gr.aueb.dmst.dirtybits;

import java.io.IOException;

/**
 * This class sets the console's encoding to cp737
 * in order to show greek characters
 * 
 * @author kbabetas, javalicious
 * 
 */
public class GreekEncodingCMD {

	public static void main(String[] args) {
		setEncoding();
	}
/** 
* This method sets cmd's encoding to cp737
*/
	public static void setEncoding() {
		try {
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c",
					"chcp", "737").inheritIO();
			Process p = builder.start();
			p.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
