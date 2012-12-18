import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProblemF {

	public static int gray(List<Integer> colors) {
		Collections.sort(colors);
		int gray = colors.get(colors.size() - 3);
		if (gray == 0) {
			return 0;
		}
		colors.set(colors.size() - 3, colors.get(colors.size() - 3) - gray);
		colors.set(colors.size() - 2, colors.get(colors.size() - 2) - gray);
		colors.set(colors.size() - 1, colors.get(colors.size() - 1) - gray);
		return gray + gray(colors);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		while (kb.hasNextLine()) {
			String[] line = kb.nextLine().split(" ");
			int numColors = Integer.parseInt(line[0]);
			if (numColors == 0) {
				break;
			}
			List<Integer> colors = new ArrayList<Integer>(numColors);
			for (int c = 0; c < numColors; c++) {
				colors.add(Integer.parseInt(line[1 + c]));
			}
			int targetGray = Integer.parseInt(line[line.length - 1]);

			int maxColor = 0;
			for (Integer c : colors) {
				if (c > maxColor) {
					maxColor = c;
				}
			}

			int numKits = (int) (maxColor - 1) / 50 + 1;
			if (maxColor == 0) {
				numKits = 0;
			}

			int boughtPaint = numKits * 50;
			for (int i = 0; i < numColors; i++) {
				colors.set(i, boughtPaint - colors.get(i));
			}

			ArrayList<Integer> copy;
			copy = new ArrayList<Integer>();
			for(Integer i : colors) {
				copy.add(i);
			}
			int squeezedGray = gray(colors);
			int numGrayKits = 0;
			while (squeezedGray < targetGray) {
				copy = new ArrayList<Integer>();
				for(Integer i : colors) {
					copy.add(i);
				}
				for (int i = 0; i < numColors; i++) {
					colors.set(i, 50 * numGrayKits + colors.get(i));
				}
				squeezedGray = gray(copy);

				numGrayKits++;
			}
			// System.err.println("numKits = " + numKits);
			System.out.println(numKits + numGrayKits);
		}
	}

}
