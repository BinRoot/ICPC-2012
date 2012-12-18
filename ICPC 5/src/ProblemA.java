import java.util.ArrayList;
import java.util.Scanner;

public class ProblemA {

	public static void dowork(long a, long b) {
		debug(a + " " + b);

	}

	public static long dig(long i) {
		return (long) Math.floor(Math.log10(i)) + 1;
	}

	public static void p(long val, long totalPlaces) {
		long valDig = dig(val);
		long numSpaces = totalPlaces - valDig;
		for (int i = 0; i < numSpaces; i++) {
			System.out.print(" ");
		}
		System.out.print(val);
		System.out.println();
	}

	public static void pdiv(long totalPlaces) {
		for (int i = 0; i < totalPlaces; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int prob = 1;
		while (kb.hasNextLine()) {
			String line = kb.nextLine();
			String[] s = line.split(" ");
			long x = Long.parseLong(s[0]);
			long y = Long.parseLong(s[1]);
			if (x == 0 && y == 0) {
				break;
			}
			System.out.println(String.format("Problem %d", prob));
			prob++;
			ArrayList<Long> res = new ArrayList<Long>();
			long yp = y;
			while (yp > 0) {
				long n = yp % 10;
				res.add(x * n);
				yp /= 10;
			}
			long totalPlaces = (long) Math.max(dig(x), dig(y));
			totalPlaces = (long) Math.max(totalPlaces, dig(x * y));
			int numNonZero = 0;
			for (Long i : res) {
				if (i != 0) {
					numNonZero++;
				}
			}
			if (numNonZero <= 1) {
				p(x, totalPlaces);
				p(y, totalPlaces);
				pdiv(totalPlaces);
				p(x * y, totalPlaces);
			} else {
				p(x, totalPlaces);
				p(y, totalPlaces);
				pdiv(totalPlaces);
				long mul = 1;
				long mtpDelay = 1;
				long mtp = totalPlaces;
				for (int i = 0; i < res.size(); i++) {
					if (res.get(i) == 0) {
						mul *= 10;
						mtpDelay++;
					} else {
						p(res.get(i) * mul, mtp);
						mul = 1;
						mtp -= mtpDelay;
						mtpDelay = 1;
					}
				}

				pdiv(totalPlaces);
				p(x * y, totalPlaces);
			}
		}
	}

	public static void debug(Object o) {
		System.out.println(o);
	}

}
