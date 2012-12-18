import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ProblemD {
	public static int ccount(List<Line> lines, int vx, int vy) {
		int count = 0;
		for (int i = 0; i < lines.size(); i++) {
			HashSet<Integer> queens = new HashSet<Integer>();
			Line line = lines.get(i);
			for (int d = 0; d <= line.k - 1; d++) {
				queens.add(new Point(line.x + line.s * d, line.y + line.t * d)
						.project(vx, vy));
			}
			System.out.println(queens);
			for (int j = i + 1; j < lines.size(); j++) {
				Line other = lines.get(j);
				for (int d = 0; d <= other.k - 1; d++) {
					if (queens.contains(
							new Point(other.x + other.s * d, other.y + other.t
									* d).project(vx, vy))) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while (true) {
			String params;
			params = kb.nextLine();
			if (params.equals("0")) {
				break;
			}
			int size = Integer.parseInt(params.split(" ")[0]);
			int lines = Integer.parseInt(params.split(" ")[1]);
			List<Line> lns = new ArrayList<Line>();
			for (int l = 0; l < lines; l++) {
				String[] ltext = kb.nextLine().split(" ");
				Line ln = new Line(Integer.parseInt(ltext[0]), Integer
						.parseInt(ltext[1]), Integer.parseInt(ltext[2]),
						Integer.parseInt(ltext[3]), Integer.parseInt(ltext[4]));
				lns.add(ln);
			}
			int totalQueens = 0;
			totalQueens += ccount(lns, 1, 0);
			totalQueens += ccount(lns, 0, 1);
			totalQueens += ccount(lns, 1, 1);
			totalQueens += ccount(lns, 1, -1);
			System.out.println(totalQueens);
		}
	}
}

class Point {
	public int x, y;

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int project(int x, int y) {
		return this.x * x + this.y * y;
	}
}

class Line {
	public int k;
	public int x, y;
	public int s, t;

	public Line(int k, int x, int y, int s, int t) {
		this.k = k;
		this.x = x;
		this.y = y;
		this.s = s;
		this.t = t;
	}
}