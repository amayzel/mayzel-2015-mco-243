package mayzel.compiler;

import java.util.Scanner;

public class Compiler {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String command = "";
		do{
			command = keyboard.next();
			switch(command){
				case "//":
					keyboard.nextLine();
					break;
				case "LD":
					break;
				case "ST":
					break;
				case "SWP":
					break;
				case "ADD":
					break;
				case "INC":
					break;
				case "DEC":
					break;
				case "BZ":
					break;
				case "BR":
					break;
				case "STP":
					keyboard.close();
					System.exit(0);
					break;
			}	
		}while(true);

	}
}
