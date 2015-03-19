package mayzel.clientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientServer {
	public static void main(String args[]) {
		try {
			String line;
			String clientProgram = "java -cp ./bin mayzel.network.Client";
			String serverProgram = "java -cp ./bin mayzel.network.Server";

			Process process1 = Runtime.getRuntime().exec(clientProgram);
			Process process2 = Runtime.getRuntime().exec(serverProgram);
			BufferedReader input1 = new BufferedReader(new InputStreamReader(process2.getInputStream()));
			while ((line = input1.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}