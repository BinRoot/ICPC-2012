import java.util.ArrayList;
import java.util.Scanner;


public class ProblemI {
	public static boolean twoUpperCase(String s) {
		for(int f = 0; f < s.length() - 1; f++) {
			char c1 = s.charAt(f);
			char c2 = s.charAt(f + 1);
			if(c1 >= 'A' && c1 <= 'Z' &&
			   c2 >= 'A' && c2 <= 'Z') {
				return true;
			}
		}
		return false;
	}
	
	public static boolean digLet(String s) {
		for(int f = 0; f < s.length() - 1; f++) {
			char c1 = s.charAt(f);
			char c2 = s.charAt(f + 1);
			if(c1 >= '0' && c1 <= '9' &&
			   c2 >= 'A' && c2 <= 'Z') {
				return true;
			}
			if(c1 >= '0' && c1 <= '9' &&
					   c2 >= 'a' && c2 <= 'z') {
						return true;
					}
			c1 = s.charAt(f + 1);
			c2 = s.charAt(f);
			if(c1 >= '0' && c1 <= '9' &&
					   c2 >= 'A' && c2 <= 'Z') {
						return true;
					}
			if(c1 >= '0' && c1 <= '9' &&
					   c2 >= 'a' && c2 <= 'z') {
						return true;
					}
		}
		return false;
	}
	
	public static boolean isolatedChar(String s) {
		for(int f = 0; f < s.length(); f++) {
			char c1, c2, c3;
			if(f - 1 < 0) {
				c1 = ' ';
			} else {
				c1 = s.charAt(f - 1);
			}
			c2 = s.charAt(f);
			if(f + 1 < s.length()) {
				c3 = s.charAt(f + 1);
			} else {
				c3 = ' ';
			}
			if(c1 == ' ' && c3 == ' ' && !("aAI".contains(""+c2))) {
				return true;
			}
		}
		return false;
	}
	public static boolean isLetter(char c) {
		return (c >= 'a' && c <= 'z') ||
			   (c >= 'A' && c <= 'Z');	
	}

	public static boolean isDig(char c) {
		return (c >= '0' && c <= '9');
	}
	
	public static boolean twoPunc(String s) {
		for(int f = 0; f < s.length() - 1; f++) {
			char c1 = s.charAt(f);
			char c2 = s.charAt(f + 1);
			if( !isLetter(c1) && !isDig(c1) && c1 != ' ' &&
				!isLetter(c2) && !isDig(c2) && c2 != ' ' && !(c2 == '"' ^ c1 == '"')) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNextLine()) {
			String line = kb.nextLine();
			if(line.equals("#")) {
				break;
			}
			//System.out.printf("%b %b %b %b", isolatedChar(line), twoPunc(line), digLet(line), twoUpperCase(line));
			if(isolatedChar(line) || twoPunc(line) || digLet(line) || twoUpperCase(line)) {
				System.out.println("suspicious");
			} else {
				System.out.println("OK");
			}
		}
	}

}
