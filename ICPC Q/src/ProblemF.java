import java.util.Scanner;

public class ProblemF {
	public static void debug(Object o) {
		System.err.println(o);
	}

	public static String toBase2(int input) {
		int originalInput = input;
		long place = 0;
		String result = "";
		while (input > 0) {
			long v = input % 2;
			result = "" + v + result;
			input /= 2;
			place++;
		}
		return result;
	}

	public static void toBaseN2Positive(int target) {
		int digits = 0;
		int max = 1;
		while (max < target) {
			digits += 2;
			max = 0;
			for (int i = 0; i < digits; i += 2) {
				max += Math.pow(-2, i);
			}
		}

		digits --;
		int ptarget = max - target;
		debug(String.format("target = %d, ptarget =%d, digits = %d, max = %d",
				target, ptarget, digits, max));
		String presult = toBase2(ptarget);
		debug(presult);
		System.out.print("From decimal: " + target + " is ");
		System.out.print(1);
		for (int i = presult.length() - 1; i >= 0; i--) {
			int val = Integer.parseInt("" + presult.charAt(i));
			if (i % 2 == 0) {
				switch (val) {
				case 1:
					val = 0;
					break;
				case 0:
					val = 1;
					break;
				}
			}
			System.out.print(val);
		}
		System.out.println("");
	}

	public static void toBaseN2Negative(int target) {
		if (true)// deleteme
			return;
	}

	public static void fromBaseN2(String input) {
		long acc = 0;
		long pow = 1;
		for (int place = 0; place < input.length(); place++) {
			int p = Integer.parseInt(""
					+ input.charAt(input.length() - 1 - place));
			acc += pow * p;
			pow *= -2;
		}
		System.out.println(String.format("From binary: %s is %d", input, acc));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int numProbs = Integer.parseInt(kb.nextLine());
		for (int p = 0; p < numProbs; p++) {
			String[] line = kb.nextLine().split(" ");
			switch (line[0].charAt(0)) {
			case 'b':
				fromBaseN2(line[1]);
				break;
			case 'd':
				int target = Integer.parseInt(line[1]);
				if (target == 0) {
					System.out.println("From decimal: 0 is 0");
				} else if (target > 0) {
					toBaseN2Positive(target);
				} else {
					toBaseN2Negative(target);
				}
				break;
			}
		}
	}

}
