import java.util.*;

public class ProblemH {
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		while(true) {
			String[] line = s.nextLine().split(" ");
			if(line[0].equals("0")) {
				break;
			}
			int T = Integer.parseInt(line[0]);
			int R = Integer.parseInt(line[1]);
			List<Tower> towers = new LinkedList<Tower>();
			for(int i = 0; i < T; i++) {
				line = s.nextLine().split(" ");
				Tower t = new Tower();
				t.x = Integer.parseInt(line[0]);
				t.y = Integer.parseInt(line[1]);
				t.power = Integer.parseInt(line[2]);
				t.letter = (char) ((char) i + 'A');
				towers.add(t);
			}
			// System.err.println("towers: " + towers);
			line = s.nextLine().split(" ");
			Tower curTower = null;
			Tower lastTower = null;
			double pSegLen = 0;
			int ri = 0;
			String out = "";
			for(double miles = 0; ri < R; miles++) {
				Point start = new Point();
				start.x = Integer.parseInt(line[ri * 2]);
				start.y = Integer.parseInt(line[ri * 2 + 1]);
				Point end = new Point();
				end.x = Integer.parseInt(line[ri * 2 + 2]);
				end.y = Integer.parseInt(line[ri * 2 + 3]);
				Point direction = end.sub(start);
				double segmentLength = direction.norm();
				if(miles > pSegLen + segmentLength) {
					ri++;
					if(ri >= R && miles - 0.5 <= pSegLen + segmentLength) {
						miles = pSegLen + segmentLength;
						Point curMarker = end;
						int signal = -1;
						for(Tower t: towers) {
							int tsig = (int) Math.round(t.power / t.sub(curMarker).norm());
							if(tsig > signal) {
								curTower = t;
								signal = tsig;
							} else if(tsig == signal) {
								if(t.letter < curTower.letter) {
									curTower = t;
									signal = tsig;
								}
							}
						}
						if(curTower != lastTower) {
							out += String.format("(%d,%s) ", (int) Math.ceil(miles), "" + curTower.letter);
						}
						break;
					}
					pSegLen += segmentLength;
					miles -= 1;
					continue;
				}
				double distAlongSeg = (double) miles - pSegLen;
				direction.scale(distAlongSeg / segmentLength);
				Point curMarker = new Point();
				curMarker.x = start.x + direction.x;
				curMarker.y = start.y + direction.y;
				// System.err.println("Current point: " + curMarker.toString());
				int signal = -1;
				for(Tower t: towers) {
					int tsig = (int) Math.round(t.power / t.sub(curMarker).norm());
					if(tsig > signal) {
						curTower = t;
						signal = tsig;
					} else if(tsig == signal) {
						if(t.letter < curTower.letter) {
							curTower = t;
							signal = tsig;
						}
					}
				}
				if(curTower != lastTower) {
					out += String.format("(%d,%s) ", (int) Math.ceil(miles), "" + curTower.letter);
				}
				lastTower = curTower;
			}
			System.out.println(out.trim());
		}
	}
}

class Tower extends Point {
	public int power;
	public char letter;
	public String toString() {
		return String.format("(%f, %f, %d)", x, y, power);
	}
}

class Point {
	public double x;
	public double y;
	public String toString() {
		return String.format("(%f, %f)", x, y);
	}

	public double norm() {
		return Math.sqrt(x * x + y * y);
	}
	public void scale(double s) {
		x *= s;
		y *= s;
	}
	public Point sub(Point origin) {
		Point ret = new Point();
		ret.x = x - origin.x;
		ret.y = y - origin.y;
		return ret;
	}
}
