import java.util.ArrayList;
import java.util.Scanner;

public class ProblemB {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int num = 1;
		while (true) {
			String line = kb.nextLine(); // 2 0 0
			
			String arr[] = line.split(" ");
			int j = Integer.parseInt(arr[0]);
			
			if(j==0) {
				break;
			}
			
			
			double cx = Double.parseDouble(arr[1]);
			double cy = Double.parseDouble(arr[2]);
			
			ArrayList<Point> fPoints = new ArrayList<Point>();
			while(true) {
				line = kb.nextLine();
				if(line.equals("-1 -1")) {
					break;
				}
				
				double fx = Double.parseDouble(line.split(" ")[0]);
				double fy = Double.parseDouble(line.split(" ")[1]);
				fPoints.add(new Point(fx, fy));
				
			}
			
			dowork(num++, j, cx, cy, fPoints);
		}
	}
	
	public static void dowork(int num, int j, double cx, double cy, ArrayList<Point> fPoints) {
		
		Point c = new Point(cx, cy);
		for(Point fp : fPoints) {
			
			if( dist(c, fp) < 1.0) {
				java.awt.geom.Area
				System.out.println("Firefly "+num+" caught at ("+(int)fp.x+","+(int)fp.y+")");
				return;
			}
			
			c = move(c, fp, j);
			
			if( dist(c, fp) < 1.0) {
				System.out.println("Firefly "+num+" caught at ("+(int)fp.x+","+(int)fp.y+")");
				return;
			}
			
		}
		System.out.println("Firefly "+num+" not caught");
	}
	
	public static Point move(Point c, Point f, int j) {
		//System.out.println("previous p: "+c);
		double mDist = dist(c, f);
		
		double frac = ((double)j)/mDist;
		
		double newx = c.x + frac*(f.x-c.x);
		double newy = c.y + frac*(f.y-c.y);
		
		//System.out.println("next p: "+new Point(newx, newy));
		return new Point(newx, newy);
	}
	
	public static double dist(Point a, Point b) {
		return Math.sqrt(  (a.x-b.x)*(a.x-b.x)  +  (a.y-b.y)*(a.y-b.y)  );
	}
	
	
}

class Point {
	public double x;
	public double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return x+","+y;
	}
}