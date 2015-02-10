package mayzel.microprocessorSimulation;

import java.util.Scanner;

public class Microprocessor {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String memory = keyboard.nextLine();
		char[] chars = memory.toCharArray();
		String[] words = new String[chars.length];
		for (int i = 0; i < chars.length; i++) {
			words[i] = String.valueOf(chars[i]);
		}
		String word;
		String highWord;
		String lowWord;
		String A = "";
		String B = "";
		int location = 0;
		int counter = 0;
		do {
			if(words[counter].equals(7) || words[counter].equals(6) && A.equals("0")){
				word = words[counter];
			}
			else{
				word = words[counter++];
			}
			switch (word) {
			case "0":
				highWord = words[counter++];
				lowWord = words[counter++];
				location = Integer.parseInt(highWord + lowWord, 16);
				A = words[location];
				break;
			case "1":
				highWord = words[counter++];
				lowWord = words[counter++];
				location = Integer.parseInt(highWord + lowWord, 16);
				words[location] = A;
				break;
			case "2":
				String temp = B;
				B = A;
				A = temp;
				break;
			case "3":
				int decA = Integer.parseInt(A, 16);
				int decB = Integer.parseInt(B, 16);
				int sum = decA + decB;
				String hex = Integer.toHexString(sum);
				if (hex.length() > 1) {
					B = String.valueOf(hex.charAt(0));
					A = String.valueOf(hex.charAt(1));
				}// issues with ff and A-reg 2x
				else {
					A = String.valueOf(hex.charAt(0));
					B = "0";
				}
				
				break;
			case "4":
				int decimalA = Integer.parseInt(A, 16);
				if (decimalA == 15) {
					decimalA = 0;
				} else {
					decimalA++;
				}
				A = Integer.toHexString(decimalA);
				break;
			case "5":
				int decimA = Integer.parseInt(A, 16);
				if (decimA == 0) {
					decimA = 15;
				} else {
					decimA--;
				}
				A = Integer.toHexString(decimA);

				break;
			case "6":
				if (A.equals("0")) {
					highWord = words[counter++];
					lowWord = words[counter++];
					location = Integer.parseInt(highWord + lowWord, 16);
					counter = location;
				} else {
					counter = counter + 2;
				}
				break;
			case "7":
				highWord = words[counter++];
				lowWord = words[counter++];
				location = Integer.parseInt(highWord + lowWord, 16);
				counter = location;
				break;
			case "8":
				for (int i = 0; i < words.length; i++) {
					System.out.print(words[i].toUpperCase());
				}
				keyboard.close();
				System.exit(0);
				break;
			}
		} while (true);

	}

}
