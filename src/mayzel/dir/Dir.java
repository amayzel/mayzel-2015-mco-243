package mayzel.dir;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class Dir {

	public static void main(String args[]) {
		try {
			Process child = Runtime.getRuntime().exec("ipconfig");
			BufferedReader reader = new BufferedReader(new InputStreamReader(child.getInputStream()));
			
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
