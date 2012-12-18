import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ProblemC {
	public static int[] concat(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		int i = 0;
		for (; i < a.length; i++) {
			result[i] = a[i];
		}
		for (; i < a.length + b.length; i++) {
			result[i] = b[i - a.length];
		}
		return result;
	}

	public static List<int[]> getChars(int base) {
		ArrayList<int[]> characters = new ArrayList<int[]>();
		for (int i = 0; i < base; i++) {
			characters.add(new int[] { i });
		}
		return characters;
	}

	public static List<int[]> combine(List<int[]> sides, List<int[]> center) {
		List<int[]> accum = new ArrayList<int[]>();
		for (int[] s : sides) {
			for (int[] c : center) {
				accum.add(concat(concat(s, c), s));
			}
		}
		return accum;
	}

	public static List<int[]> genPal(int dig, int base) {
		List<int[]> chars = getChars(base);
		List<int[]> accum = new ArrayList<int[]>();
		if (dig <= 0) {
			accum.add(new int[] {});
			return accum;
		}
		if (dig == 1) {
			return chars;
		}
		return combine(chars, genPal(dig - 2, base));
	}

	public static long toDec(int[] num, int base) {
		long accum = 0;
		long pow = 1;
		for (int i = num.length - 1; i >= 0; i--) {
			accum += pow * num[i];
			pow *= base;
		}
		return accum;
	}

	public static boolean isPrime(long p) {
		if(p > Integer.MAX_VALUE) {
			return false;
		}
		if(p <= 1) {
			return false;
		}
		if(p == 2) {
			return true;
		}
		for (long i = 2; i <= Math.ceil(Math.sqrt(p)); i++) {
			if (p % i == 0)
				return false;
		}
		return true;
	}

	public static int allPrimesInDec(int dig, int base) {
		int count = 0;
		List<int[]> pal = genPal(dig, base);
		for (int[] p : pal) {
			long i = toDec(p, base);
			if (isPrime(i)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while (true) {
			int dig = kb.nextInt();//parseInt(input[0]);
			int base = kb.nextInt();//Integer.parseInt(input[1]);
			if (dig == 0 && base == 0) {
				break;
			}
			dig = (int)Math.ceil(Math.min(dig, Math.log10(Integer.MAX_VALUE)/Math.log10(base)));
			int count = allPrimesInDec(dig, base);
			System.out
					.println(String
							.format(
									"The number of %d-digit palindromic primes < 2^31 in base %d.",
									dig, base));
			System.out.println(String.format("What is %d?", count));
		}

	}
}
