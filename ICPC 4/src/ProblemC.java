import java.util.Arrays;
import java.util.Scanner;

public class ProblemC {

	public static void dowork(int n, int m, int dataset) {
		
		
		int digs[] = new int[n];
		
		int count = 0;
		for(int i=0; i<n; i++) {
			digs[i] = (int) Math.pow(2, i);
		}
		
		while(increment(digs, m)[0] != -1) {
			
			count++;
		}
		
		count++;
		System.out.println("Data set "+dataset+": "+n+" "+m+" "+count);
		
	}
	
	
	
	public static int[] increment(int [] digs, int m) {
		
		for(int i=digs.length-1; i>=0; i--) {
			
			int max = 0;
			if(i==digs.length-1) {
				max = m;
			}
			else {
				max = digs[i+1]/2;
			}
			
			if(digs[i] < max) {
				digs[i]++;
				
				try{
				digs[i+1] = digs[i]*2;
				}
				catch(Exception e){}
				
				//printarr(digs);
				return digs;
			}
			
		}
		
		
		digs[0]=-1;
		return digs;
	}
	
	public static void printarr(int [] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int runs = Integer.parseInt(kb.nextLine());
		
		for(int i=0; i<runs; i++) {
			String line = kb.nextLine();
			int n = Integer.parseInt(line.split(" ")[0]);
			int m = Integer.parseInt(line.split(" ")[1]);
			
			dowork(n, m, i+1);
		}
		
	}

	public static void debug(Object o) {
		System.err.println(o);
	}

}
