import java.util.ArrayList;
import java.util.Scanner;

public class ProblemG {

	public static void dowork(int a, int b) {
		debug(a + " " + b);

	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int game = 1;
		while (true) {
			String line = kb.nextLine();
			String[] xySplit = line.split(" ");
			int y = Integer.parseInt(xySplit[0]);
			int x = Integer.parseInt(xySplit[1]);
			if (x == 0 && y == 0) {
				break;
			}
			ArrayList<char[]> board = new ArrayList<char[]>(y);
			for (int f = 0; f < y; f++) {
				board.add(kb.nextLine().toCharArray());
			}

			char[] commands = kb.nextLine().toCharArray();

			int px = -1, py = -1;
			for (int l = 0; l < y; l++) {
				char[] ls = board.get(l);
				int i = ls.indexOf("w");
				if (i != -1) {
					px = i;
					py = l;
				}
			}
			debug(String.format("px = %d, py = %d", px, py));

			for (int cIndex = 0; cIndex < commands.length; cIndex++) {
				char command = commands[cIndex];
				int npx = px;
				int npy = py;
				switch (command) {
				case 'U':
					npy --;
					break;
				case 'D':
					npy ++;
					break;
				case 'L':
					npx --;
					break;
				case 'R':
					npx ++;
					break;
				}
				switch(board.get(npy).charAt(npx)) {
				case '.':
					board.get(npy).
					break;
				case '#':
					npx = px;
					npy = py;
					break;
				case '+':
					
				}
			}
			game++;
		}
	}

	public static void debug(Object o) {
		System.out.println(o);
	}

}
