import java.util.ArrayList;
import java.util.Scanner;


public class ProblemD {

	public static boolean good(float w, float h, float maxW, float maxH) {
		return w <= maxW && h <= maxH;
	}
	public static int solve(float w, float h, float maxW, float maxH) {
		for(int factor = 100; factor >= 1; factor --) {
			if(good(w * factor / 100.0f, h * factor / 100.0f, maxW, maxH)) {
				return factor;
			}
		}
		return 1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNextLine()) {
			String[] line = kb.nextLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			int c = Integer.parseInt(line[2]);
			int d = Integer.parseInt(line[3]);
			if(a == 0 && b == 0 && c == 0 && d == 0) {
				break;
			}
			int solve1 = solve(a, b, c, d);
			int solve2 = solve(b, a, c, d);
			int max = Math.max(solve1, solve2);
			int result = (int) (max);
			System.out.println("" + result + "%");
		}
	}

}
