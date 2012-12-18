import java.util.HashSet;
import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		while (kb.hasNextLine()) {
			String line = kb.nextLine();

			if (line.equals("*"))
				break;
			work(line);
		}
	}

	public static void work(String line) {
		int maxDist = line.length() - 1;
		if (maxDist < 1) {
			System.out.println(line + " is surprising.");
			return;
		}
		for (int length = 1; length <= maxDist; length++) {
			HashSet<String> pairs = new HashSet<String>();
			// System.err.println("length = " + length);
			for (int start = 0; start < line.length() - length; start++) {
				String pair = "" + line.charAt(start)
						+ line.charAt(start + length);
				// System.err.println(pair);
				if (pairs.contains(pair)) {
					System.out.println(line + " is NOT surprising.");
					return;
				}
				pairs.add(pair);
			}
		}
		System.out.println(line + " is surprising.");
	}
}
