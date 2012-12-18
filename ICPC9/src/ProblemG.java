import java.util.Scanner;


public class ProblemG {

	public static long dist(long a, long b, long n) {
		return (long) Math.abs(Math.pow(a, n) - b);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNextLine()) {
			String line = kb.nextLine();
			if(line.equals("0 0")) {
				break;
			}
			
			String[] ln = line.split(" ");
			int B = Integer.parseInt(ln[0]);
			int N = Integer.parseInt(ln[1]);
			
			double exact = Math.exp(Math.log(B)/N);
			long floor = (long) Math.floor(exact);
			long ciel = (long) Math.ceil(exact);
			if(dist(floor, B, N) < dist(ciel, B, N)) {
				System.out.println(floor);
			} else {
				System.out.println(ciel);
			}
		}
		
	}

}
