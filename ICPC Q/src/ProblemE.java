import java.util.ArrayList;
import java.util.Scanner;

public class ProblemE {
	public static int c(char command) {
		int side = -1;
		switch (command) {
		case 'W':
			side = 0;
			break;
		case 'O':
			side = 1;
			break;
		case 'R':
			side = 2;
			break;
		case 'B':
			side = 3;
			break;
		case 'G':
			side = 4;
			break;
		case 'Y':
			side = 5;
			break;
		}
		return side;
	}

	public static void cToX(ArrayList<char[][]> cube, int side, int col,
			char[] tmp) {
		char[][] s = cube.get(side);
		for (int i = 0; i < 3; i++) {
			tmp[i] = s[i][col];
		}
	}

	public static void rToX(ArrayList<char[][]> cube, int side, int row,
			char[] tmp) {
		char[][] s = cube.get(side);
		for (int i = 0; i < 3; i++) {
			tmp[i] = s[row][i];
		}
	}

	public static void flip(char[] tmp) {
		char i0 = tmp[0];
		char i1 = tmp[1];
		char i2 = tmp[2];

		tmp[0] = i2;
		tmp[1] = i1;
		tmp[2] = i0;
	}

	public static void xToC(ArrayList<char[][]> cube, int side, int col,
			char[] tmp) {
		char[][] s = cube.get(side);
		for (int i = 0; i < 3; i++) {
			s[i][col] = tmp[i];
		}
	}

	public static void xToR(ArrayList<char[][]> cube, int side, int row,
			char[] tmp) {
		char[][] s = cube.get(side);
		for (int i = 0; i < 3; i++) {
			s[row][i] = tmp[i];
		}
	}

	public static void rotateSide(ArrayList<char[][]> cube, int side) {
		char[] tmp1 = new char[3];
		char[] tmp2 = new char[3];
		char[] tmp3 = new char[3];
		char[] tmp4 = new char[3];
		rToX(cube, side, 0, tmp1);
		cToX(cube, side, 0, tmp2);
		rToX(cube, side, 2, tmp3);
		cToX(cube, side, 2, tmp4);

		flip(tmp2);
		xToR(cube, side, 0, tmp2);

		xToC(cube, side, 0, tmp3);

		flip(tmp4);
		xToR(cube, side, 2, tmp4);

		xToC(cube, side, 2, tmp1);
	}

	public static void rotateCubeW(ArrayList<char[][]> cube) {
		rotateSide(cube, c('W'));
		char[] tmpR = new char[3];
		char[] tmpB = new char[3];
		char[] tmpG = new char[3];
		char[] tmpO = new char[3];

		cToX(cube, 2, 0, tmpR);
		cToX(cube, 3, 0, tmpB);
		cToX(cube, 4, 0, tmpG);
		cToX(cube, 1, 0, tmpO);

		xToC(cube, 3, 0, tmpR);
		xToC(cube, 4, 0, tmpB);
		xToC(cube, 1, 0, tmpG);
		xToC(cube, 2, 0, tmpO);
	}

	public static void rotateCubeO(ArrayList<char[][]> cube) {
		rotateSide(cube, c('O'));
		char[] tmpG = new char[3];
		char[] tmpY = new char[3];
		char[] tmpR = new char[3];
		char[] tmpW = new char[3];

		rToX(cube, c('G'), 2, tmpG);
		rToX(cube, c('Y'), 2, tmpY);
		rToX(cube, c('R'), 0, tmpR);
		cToX(cube, c('W'), 2, tmpW);

		flip(tmpY);
		flip(tmpW);

		xToR(cube, c('Y'), 2, tmpG);
		xToR(cube, c('R'), 0, tmpY);
		xToC(cube, c('W'), 2, tmpR);
		xToR(cube, c('G'), 2, tmpW);
	}

	public static void rotateCubeR(ArrayList<char[][]> cube) {
		rotateSide(cube, c('R'));
		char[] tmpO = new char[3];
		char[] tmpY = new char[3];
		char[] tmpB = new char[3];
		char[] tmpW = new char[3];

		rToX(cube, c('O'), 2, tmpO);
		cToX(cube, c('Y'), 2, tmpY);
		rToX(cube, c('B'), 0, tmpB);
		rToX(cube, c('W'), 2, tmpW);

		flip(tmpO);
		flip(tmpB);

		xToC(cube, c('Y'), 2, tmpO);
		xToR(cube, c('B'), 0, tmpY);
		xToR(cube, c('W'), 2, tmpB);
		xToR(cube, c('O'), 2, tmpW);
	}

	public static void rotateCubeB(ArrayList<char[][]> cube) {
		rotateSide(cube, c('B'));
		char[] tmpR = new char[3];
		char[] tmpY = new char[3];
		char[] tmpG = new char[3];
		char[] tmpW = new char[3];

		rToX(cube, c('R'), 2, tmpR);
		rToX(cube, c('Y'), 0, tmpY);
		rToX(cube, c('G'), 0, tmpG);
		cToX(cube, c('W'), 0, tmpW);

		flip(tmpR);
		flip(tmpG);

		xToR(cube, c('Y'), 0, tmpR);
		xToR(cube, c('G'), 0, tmpY);
		xToC(cube, c('W'), 0, tmpG);
		xToR(cube, c('R'), 2, tmpW);
	}

	public static void rotateCubeG(ArrayList<char[][]> cube) {
		rotateSide(cube, c('G'));
		char[] tmpB = new char[3];
		char[] tmpY = new char[3];
		char[] tmpO = new char[3];
		char[] tmpW = new char[3];

		rToX(cube, c('B'), 2, tmpB);
		cToX(cube, c('Y'), 0, tmpY);
		rToX(cube, c('O'), 0, tmpO);
		rToX(cube, c('W'), 0, tmpW);

		flip(tmpY);
		flip(tmpW);

		xToC(cube, c('Y'), 0, tmpB);
		xToR(cube, c('O'), 0, tmpY);
		xToR(cube, c('W'), 0, tmpO);
		xToR(cube, c('B'), 2, tmpW);
	}

	public static void rotateCubeY(ArrayList<char[][]> cube) {
		rotateSide(cube, c('Y'));
		char[] tmpB = new char[3];
		char[] tmpR = new char[3];
		char[] tmpO = new char[3];
		char[] tmpG = new char[3];

		cToX(cube, c('B'), 2, tmpB);
		cToX(cube, c('R'), 2, tmpR);
		cToX(cube, c('O'), 2, tmpO);
		cToX(cube, c('G'), 2, tmpG);

		xToC(cube, c('R'), 2, tmpB);
		xToC(cube, c('O'), 2, tmpR);
		xToC(cube, c('G'), 2, tmpO);
		xToC(cube, c('B'), 2, tmpG);
	}

	public static void printCube(ArrayList<char[][]> cube) {
		for (int y = 0; y < 3; y++) {
			for (int side = 0; side < 6; side++) {
				for (int x = 0; x < 3; x++) {
					System.out.print(cube.get(side)[y][x]);
					if (side == 5 && x == 3) {
						// last column, don't print space
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println("");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int numProbs = Integer.parseInt(kb.nextLine());
		for (int p = 0; p < numProbs; p++) {
			String[] lines = new String[3];
			lines[0] = kb.nextLine();
			lines[1] = kb.nextLine();
			lines[2] = kb.nextLine();
			String rots = kb.nextLine();

			ArrayList<char[][]> cube = new ArrayList<char[][]>();
			for (int i = 0; i < 6; i++) {
				char[][] c = new char[3][3];
				for (int x = 0; x < 3; x++) {
					for (int y = 0; y < 3; y++) {
						c[y][x] = lines[y].charAt((i * 2) * 3 + (x * 2));
					}
				}
				cube.add(c);
			}

			for (int i = 0; i < rots.length(); i++) {
				char command = rots.charAt(i);
				int side = -1;
				switch (command) {
				case 'W':
					rotateCubeW(cube);
					break;
				case 'O':
					rotateCubeO(cube);
					break;
				case 'R':
					rotateCubeR(cube);
					break;
				case 'B':
					rotateCubeB(cube);
					break;
				case 'G':
					rotateCubeG(cube);
					break;
				case 'Y':
					rotateCubeY(cube);
					break;
				}
			}

			printCube(cube);
			System.out.println("===================================");
		}
	}

}
