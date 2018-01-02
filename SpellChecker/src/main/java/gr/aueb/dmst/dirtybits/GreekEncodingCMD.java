package gr.aueb.dmst.dirtybits;

import java.io.IOException;

public class GreekEncodingCMD {

	public static void main(String[] args) {
		setEncoding();
	}

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
