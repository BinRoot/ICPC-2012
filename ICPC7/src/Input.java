import java.util.Scanner;

public class Input {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while (true) {
			String ln = kb.nextLine();
			if (ln.startsWith("#")) {
				break;
			}
			char end = ln.charAt(ln.length() - 1);
			boolean even = end == 'e';
			int numOne = 0;
			for(int i = 0; i < ln.length() - 1; i++) {
				if(ln.charAt(i) == '1') {
					numOne++;
				}
			}
			if(!even && numOne % 2 == 0 || even && numOne % 2 == 1) {
				System.out.println(ln.substring(0, ln.length() - 1) + "1");
			} else {
				System.out.println(ln.substring(0, ln.length() - 1) + "0");
			}
		}
	}
}
