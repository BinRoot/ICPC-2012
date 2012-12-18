import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		boolean capNext = false;
		while (kb.hasNextLine()) {
			String input = kb.nextLine();
			StringBuilder output = new StringBuilder("");

			for (int i = 0; i < input.length(); i++) {
				char next = input.charAt(i);
				String result = "" + next;
				if (capNext
						&& ((next >= 'a' && next <= 'z') || (next >= 'A' && next <= 'Z'))) {
					result = result.toUpperCase();
					capNext = false;
				} else {
					result = result.toLowerCase();
				}
				char before;
				if (i == 0) {
					before = ' ';
				} else {
					before = input.charAt(i - 1);
				}
				char after;
				if (i + 1 >= input.length()) {
					after = ' ';
				} else {
					after = input.charAt(i + 1);
				}
				if ("?.!".contains(result)) {
					boolean decimal = (next == '.')
							&& ((after >= '0' && after <= '9'));
					if (!decimal) {
						capNext = true;
					}
				}

				output.append("" + result);
			}

			System.out.println(output.toString());
		}
	}
}
