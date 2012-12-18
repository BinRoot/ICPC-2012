import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;


public class ProblemA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		while(kb.hasNextLine()) {
			String line = kb.nextLine();
			int num = Integer.parseInt(line);
			
			if(num == -1) {
				break;
			}
			
			int [][] map = new int [num][num];
			for(int i=0; i<num; i++) {
				line = kb.nextLine();
				for(int j=0; j<line.length(); j++) {
					map[i][j] = Integer.parseInt(line.charAt(j)+"");
				}
			}
			
			
			long [][] dists = new long[num][num];
			long out = paths(map, 0, 0, num, dists);
			System.out.println(out);
			
		}
	}
	
	public static long paths(int [][] map, int x, int y, int n, long[][] dists) {
		long a = 0,b = 0;
		int jump = map[x][y];
		
		if(jump == 0) return 0;
		
		if(jump+y < n) {
			if(x == n-1 && jump+y == n-1) { // can go down
				dists[x][y]++;
				a = 1;
			}
			else {
				// TODO: DP here
				if(dists[x][jump+y] > 0) {
					a = dists[x][jump+y];
					dists[x][y] += a;
				}
				else {
					a = paths(map, x, jump+y, n, dists);
					dists[x][y] += a;
				}
				
			}
		}
		
		if(jump+x < n) { // can go right
			if(x+jump == n-1 && y==n-1) {
				dists[x][y]++;
				b = 1;
			}
			else {
				// TODO: DP here
				if(dists[x+jump][y] > 0) {
					b = dists[x+jump][y];
					dists[x][y] += b;
				}
				else {
					b = paths(map, x+jump, y, n, dists);
					dists[x][y] += b;
				}
			}
		}
		
		
		return a + b;
	}

}
