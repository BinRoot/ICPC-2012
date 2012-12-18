import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProblemD {

	private static void debug(String s) {
		System.err.println(s);
	}

	public static int countInRange(List<Double> values, double l, double u) {
		int total = 0;
		for (Double d : values) {
			if (d > l && d < u) {
				total++;
				continue;
			}
			d += 360;
			if (d > l && d < u) {
				total++;
				continue;
			}
			d -= 360 * 2;
			if (d > l && d < u) {
				total++;
				continue;
			}
		}
		return total;
	}

	public static double getAngle(List<Tree> trees, double x, double y, double v) {
		List<Double> angles = new ArrayList<Double>();
		for (Tree t : trees) {
			angles.add(t.getAngle(x, y));
		}
		Collections.sort(angles);
		debug(angles.toString());

		List<Double> testAngles = new ArrayList<Double>();
		List<Integer> testCounts = new ArrayList<Integer>();
		for (double a = 0; a < 360; a += 0.1) {
			testAngles.add(a);
			testCounts.add(countInRange(angles, a - v / 2, a + v / 2));
		}

		debug(testAngles.toString());
		debug(testCounts.toString());

		double bestAngle = testAngles.get(0);
		int bestCount = testCounts.get(0);
		for (int i = 0; i < testAngles.size(); i++) {
			double curAngle = testAngles.get(i);
			int curCount = testCounts.get(i);
			if (curCount > bestCount) {
				bestCount = curCount;
				bestAngle = curAngle;
			}
		}
		System.out.println(String.format(
				"Point the camera at angle %2.1f to view %d infested trees.",
				bestAngle, bestCount));
		return -1;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while (true) {
			int numTrees = Integer.parseInt(kb.nextLine());
			String[] camParams = kb.nextLine().split(" ");
			double x = Double.parseDouble(camParams[0]);
			double y = Double.parseDouble(camParams[1]);
			double v = Double.parseDouble(camParams[2]);

			List<Tree> trees = new LinkedList<Tree>();
			for (int i = 0; i < numTrees; i++) {
				String[] tree = kb.nextLine().split(" ");
				double tx = Double.parseDouble(tree[0]);
				double ty = Double.parseDouble(tree[1]);
				trees.add(new Tree(tx, ty));
			}

			double angle = getAngle(trees, x, y, v);

			String endline = kb.nextLine();
			if (endline.equals("0")) {
				break;
			}
		}
	}
}

class Tree {
	double x;
	double y;

	double getAngle(double cx, double cy) {
		double angle = Math.toDegrees(Math.atan2(x - cx, y - cy));
		return (angle + 360 * 10000) % 360;
	}

	public Tree(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
