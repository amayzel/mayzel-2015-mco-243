package mayzel.compiler;

import java.util.Scanner;

public class Compiler {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		StringBuilder info = new StringBuilder();
		String [] commands = new String[256];
		String command = "";
		int location;
		int counter= 0;
		String temp;
		do{
			command = keyboard.next();
			switch(command){
				case "//":
					keyboard.nextLine();
					break;
				case "LD":
					commands[counter++] = "0";
					location = keyboard.nextInt();
					temp = Integer.toHexString(location);
					if(temp.length()>1){
						commands[counter++] = String.valueOf(temp.charAt(0));
						commands[counter++] = String.valueOf(temp.charAt(1));
					}
					else{
						commands[counter++] = "0";	
						commands[counter++] = String.valueOf(temp.charAt(0));
					}
					keyboard.nextLine();
					break;
				case "ST":
					commands[counter++] = "1";
					location = keyboard.nextInt();
					temp = Integer.toHexString(location);
					if(temp.length()>1){
						commands[counter++] = String.valueOf(temp.charAt(0));
						commands[counter++] = String.valueOf(temp.charAt(1));
					}
					else{
						commands[counter++] = "0";	
						commands[counter++] = String.valueOf(temp.charAt(0));
					}
					keyboard.nextLine();
					break;
				case "SWP":
					commands[counter++] = "2";
					keyboard.nextLine();
					break;
				case "ADD":
					commands[counter++] = "3";
					keyboard.nextLine();
					break;
				case "INC":
					commands[counter++] = "4";
					keyboard.nextLine();
					break;
				case "DEC":
					commands[counter++] = "5";
					keyboard.nextLine();
					break;
				case "BZ":
					commands[counter++] = "6";
					location = keyboard.nextInt();
					temp = Integer.toHexString(location);
					if(temp.length()>1){
						commands[counter++] = String.valueOf(temp.charAt(0));
						commands[counter++] = String.valueOf(temp.charAt(1));
					}
					else{
						commands[counter++] = "0";	
						commands[counter++] = String.valueOf(temp.charAt(0));
					}
					keyboard.nextLine();
					break;
				case "BR":
					commands[counter++] = "7";
					location = keyboard.nextInt();
					temp = Integer.toHexString(location);
					if(temp.length()>1){
						commands[counter++] = String.valueOf(temp.charAt(0));
						commands[counter++] = String.valueOf(temp.charAt(1));
					}
					else{
						commands[counter++] = "0";	
						commands[counter++] = String.valueOf(temp.charAt(0));
					}
					keyboard.nextLine();
					break;
				case "STP":
					commands[counter++] = "8";
					keyboard.nextLine();
					break;
				case "DATA":
					int where = keyboard.nextInt();
					String what = Integer.toHexString(keyboard.nextInt());
					if(what.length()>1){
						commands[where++] = String.valueOf(what.charAt(0));
						commands[where] = String.valueOf(what.charAt(1));
					}
					else{
						commands[where++] = "0";	
						commands[where] = String.valueOf(what.charAt(0));
					}
					keyboard.nextLine();
					break;
			}	
		}while(keyboard.hasNext());//wrong cuz its input

		for (int i = 0; i < commands.length; i++) {
			if(commands[i].equals(null)){
				commands[i] = "0";
			}
			System.out.print(commands[i].toUpperCase());
		}
		
	}
}
