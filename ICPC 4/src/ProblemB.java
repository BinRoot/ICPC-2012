import java.util.Scanner;

public class ProblemB {

	public static String intToAlphabet(int i) {
		String s = new String(new char[] { (char) (i + 65) });
		return s;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while (kb.hasNextLine()) {
			String l = kb.nextLine();
			if (l.startsWith("R0C0")) {
				break;
			}
			String row = l.substring(1, l.indexOf("C"));
			String col = l.substring(l.indexOf("C") + 1);
			// debug(String.format("Row = %s; col = %s", row, col));

			String rowTrans = "";
			int c = Integer.parseInt(col);
			boolean first = true;
			while (true) {
				if (c == 0) {
					break;
				}
				int i = c % 26;
				if (!first) {
					i = (c - 1) % 26;
				}
				if (i == 0) {
					rowTrans = "Z" + rowTrans;
				} else {
					rowTrans = intToAlphabet((char) i - 1) + rowTrans;
				}
				if (c == 26) {
					break;
				}
				c /= 26;
				first = false;
			}
			System.out.println(String.format("%s%s", rowTrans, row));
		}
	}

	public static void debug(Object o) {
		System.out.println(o);
	}

}
