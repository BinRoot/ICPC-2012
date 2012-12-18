import java.util.HashMap;
import java.util.Scanner;

public class ProblemH {
	public static void printImg(boolean[][] img, int size) {
		for(int y = 0; y < size; y++) {
			for(int x = 0; x < size; x++) {
				System.out.print(img[y][x]?"1":"0");
			}
			System.out.println();
		}
	}
	public static void clear(boolean[][] img, int thresh, int top, int left, int bottom, int right) {
		int count = 0;
		int total = (right - left) * (bottom - top);
		for(int y = top; y < bottom; y++) {
			for(int x = left; x < right; x++) {
				if(img[y][x]) {
					count++;
				}
			}
		}
		if(((float) count / (float) total ) >= thresh / 100.0f) {
			// clear out
			for(int y = top; y < bottom; y++) {
				for(int x = left; x < right; x++) {
					img[y][x] = true;
				}
			}
			return;
		}
		if(((float) (total - count) / (float) total ) >= thresh / 100.0f) {
			// clear out
			for(int y = top; y < bottom; y++) {
				for(int x = left; x < right; x++) {
					img[y][x] = false;
				}
			}
			return;
		}
		clear(img, thresh, top, left, (top + bottom) / 2, (left + right) / 2);
		clear(img, thresh, top, (left + right) / 2, (top + bottom) / 2, right);
		clear(img, thresh, (top + bottom) / 2, left, bottom, (left + right) / 2);
		clear(img, thresh, (top + bottom)/ 2, (left + right) / 2, bottom, right);
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int prob = 1;
		while (true) {
			String line = kb.nextLine();
			if(line.equals("0")) {
				break;
			}
			int size = Integer.parseInt(line.split(" ")[0]);
			int thresh = Integer.parseInt(line.split(" ")[1]);
			boolean[][] img = new boolean[size][];
			for(int y = 0; y < size; y++) {
				String row = kb.nextLine();
				img[y] = new boolean[size];
				for(int x = 0; x < row.length(); x++) {
					switch(row.charAt(x)) {
					case '0':
						img[y][x] = false;
						break;
					case '1':
						img[y][x] = true;
						break;
					}
				}
			}
			clear(img, thresh, 0, 0, size, size);
			
			System.out.println("Image " + prob + ":");
			printImg(img, size);
			
			prob++;
		}
	}
}
