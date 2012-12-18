import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Scanner;

public class ProblemH {
	public static long factorial(long x) {
		if(x <= 1) {
			return 1;
		} else {
			return factorial(x - 1) * x;
		}
	}
	public static void doWork(int probNum, long n, long k) {
		if(k == 1){
			System.out.println(String.format("%d %d", probNum, factorial(n-1)));
		}
		else if(k == 2){
			System.out.println(String.format("%d %d", probNum, factorial(n-2)));
		}
		else{
			long answer = 0;
			for(long i = 2; i <= k; i++) {
				answer += ((i-1)*((i-1)+1)/2) * factorial(n - i);
			}
			System.out.println(String.format("%d %d", probNum, (factorial(k))*factorial(n - 2 - k)));	
		}
	}
	
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		int P = Integer.parseInt(kb.nextLine());
		
		for(int i = 0; i< P; i++) {
			String line = kb.nextLine();
			String strsplit[] = line.split(" ");
			int n = Integer.parseInt(strsplit[1]);
			int k = Integer.parseInt(strsplit[2]);
			doWork(i+1, n, k);
		}
	}
}

