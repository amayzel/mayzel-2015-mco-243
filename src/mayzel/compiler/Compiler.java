package mayzel.compiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Compiler {

	public static void main(String[] args) {
		try {
			Scanner file = new Scanner(new File("./file.txt"));
			String[] commands = new String[256];
			String command = "";
			int location;
			int counter = 0;
			String temp;

			for (int i = 0; i < commands.length; i++) {
				commands[i] = "0";
			}

			do {
				command = file.next();
				switch (command) {
				case "//":
					file.nextLine();
					break;
				case "LD":
					commands[counter++] = "0";
					location = file.nextInt();
					temp = Integer.toHexString(location);
					if (temp.length() > 1) {
						commands[counter++] = String.valueOf(temp.charAt(0));
						commands[counter++] = String.valueOf(temp.charAt(1));
					} else {
						commands[counter++] = "0";
						commands[counter++] = String.valueOf(temp.charAt(0));
					}
					file.nextLine();
					break;
				case "ST":
					commands[counter++] = "1";
					location = file.nextInt();
					temp = Integer.toHexString(location);
					if (temp.length() > 1) {
						commands[counter++] = String.valueOf(temp.charAt(0));
						commands[counter++] = String.valueOf(temp.charAt(1));
					} else {
						commands[counter++] = "0";
						commands[counter++] = String.valueOf(temp.charAt(0));
					}
					file.nextLine();
					break;
				case "SWP":
					commands[counter++] = "2";
					file.nextLine();
					break;
				case "ADD":
					commands[counter++] = "3";
					file.nextLine();
					break;
				case "INC":
					commands[counter++] = "4";
					file.nextLine();
					break;
				case "DEC":
					commands[counter++] = "5";
					file.nextLine();
					break;
				case "BZ":
					commands[counter++] = "6";
					location = file.nextInt();
					temp = Integer.toHexString(location);
					if (temp.length() > 1) {
						commands[counter++] = String.valueOf(temp.charAt(0));
						commands[counter++] = String.valueOf(temp.charAt(1));
					} else {
						commands[counter++] = "0";
						commands[counter++] = String.valueOf(temp.charAt(0));
					}
					file.nextLine();
					break;
				case "BR":
					commands[counter++] = "7";
					location = file.nextInt();
					temp = Integer.toHexString(location);
					if (temp.length() > 1) {
						commands[counter++] = String.valueOf(temp.charAt(0));
						commands[counter++] = String.valueOf(temp.charAt(1));
					} else {
						commands[counter++] = "0";
						commands[counter++] = String.valueOf(temp.charAt(0));
					}
					file.nextLine();
					break;
				case "STP":
					commands[counter++] = "8";
					file.nextLine();
					break;
				case "DATA":
					int where = file.nextInt();
					String what = Integer.toHexString(file.nextInt());
					if (what.length() > 1) {
						commands[where++] = String.valueOf(what.charAt(0));
						commands[where] = String.valueOf(what.charAt(1));
					} else {
						commands[where++] = "0";
						commands[where] = String.valueOf(what.charAt(0));
					}
					file.nextLine();
					break;
				}
			} while (file.hasNext());

			for (int i = 0; i < commands.length; i++) {
				System.out.print(commands[i].toUpperCase());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
