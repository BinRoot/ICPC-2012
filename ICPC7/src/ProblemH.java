import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class ProblemH {
	public static void printChar(int code) {
		//System.err.println("Read value: " + Integer.toString(code, 2));
		
		if(code == 0) {
			System.out.print(" ");
		} else if (code == 27) {
			System.out.print("'");
		} else if (code == 28) {
			System.out.print(",");
		} else if (code == 29) {
			System.out.print("-");
		} else if (code == 30) {
			System.out.print(".");
		} else if (code == 31) {
			System.out.print("?");
		} else {
			System.out.print(("" + ((char) ((char) 'A' + ((char) code) - (char) 1))));
		}
	}
	public static void processInput(String in) {
		char[] input = in.toCharArray();

		//System.err.println("processing input");
		int place = 4;
		int acc = 0;
		int totalSpaces = 0;
		boolean read = false;
		for (int i = 0; i < input.length; i++) {
			char curChar = input[i];
			if (curChar == ' ') {
				totalSpaces++;
				read = true;
			} else if (totalSpaces > 0) {
				//System.err.println("Read a string of " + totalSpaces + " spaces");
				acc |= ((totalSpaces % 2 == 0) ? 1 : 0) << place;
				place--;
				totalSpaces = 0;
			}
			if (place < 0) {
				// do something
				printChar(acc);
				acc = 0;
				place = 4;
				read = false;
			}
		}
		if(read) {
			printChar(acc);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String input = "";
		while (true) {
			String ln = kb.nextLine();
			if (ln.equals("#")) {
				break;
			}
			if (ln.equals("*")) {
				processInput(input);
				input = "";
			} else {
				input = input + ln;
			}

		}
	}
}
