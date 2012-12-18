import java.util.Scanner;

public class ProblemE {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int num = Integer.parseInt(kb.nextLine());
		double[] x = new double[num];
		double[] y = new double[num];
		for(int i =0 ; i < num; i++) {
			String[] ln = kb.nextLine().split(",");
			x[i] = Double.parseDouble(ln[0]);
			y[i] = Double.parseDouble(ln[1]);
		}
		
		double integral = 0;
		for(int i = 0; i < num - 1; i++) {
			double dx = x[i + 1] - x[i];
			double avgy = (y[i + 1] + y[i]) / 2.0;
			integral += dx * avgy;
		}
		System.out.println(String.format("%.2f to %.2f: %.4f", x[0], x[x.length - 1], integral));
	}
}

class Coord implements Comparable<Coord>{
	public double x;
	public double y;
	@Override
	public String toString() {
		return "Coord [x=" + x + ", y=" + y + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Coord other = (Coord) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		return true;
	}
	public Coord(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Coord arg0) {
		return (new Double(x)).compareTo(new Double(arg0.x));
	}
	
}