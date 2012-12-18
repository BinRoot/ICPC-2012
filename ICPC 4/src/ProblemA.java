import java.util.Scanner;

public class ProblemA {

	public static void dowork() {

	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		while (kb.hasNextLine()) {
			String line = kb.nextLine();
			if (line.startsWith("-100 ")) {
				break;
			}
			Scanner l = new Scanner(line);
			int scoreA = 0;
			double x, y;
			for (int i = 0; i < 3; i++) {
				x = l.nextDouble();
				y = l.nextDouble();

				double d = Math.sqrt(x * x + y * y);
				if (d <= 3) {
					scoreA += 100;
				} else if (d <= 6) {
					scoreA += 80;
				} else if (d <= 9) {
					scoreA += 60;
				} else if (d <= 12) {
					scoreA += 40;
				} else if (d <= 15) {
					scoreA += 20;
				}

				debug("score of "+x+", "+y+" is " + scoreA);
			}

			int scoreB = 0;
			for (int i = 0; i < 3; i++) {
				x = l.nextDouble();
				y = l.nextDouble();
				double d = Math.sqrt(x * x + y * y);
				if (d <= 3) {
					scoreB += 100;
				} else if (d <= 6) {
					scoreB += 80;
				} else if (d <= 9) {
					scoreB += 60;
				} else if (d <= 12) {
					scoreB += 40;
				} else if (d <= 15) {
					scoreB += 20;
				}
			}

			String result;
			if (scoreA == scoreB) {
				result = "TIE";
			} else if (scoreA > scoreB) {
				result = "PLAYER 1 WINS";
			} else {
				result = "PLAYER 2 WINS";
			}
			System.out.println(String.format("SCORE: %d to %d, %s.",
					scoreA, scoreB, result));
		}

	}

	public static void debug(Object o) {
		//System.err.println(o);
	}

}
