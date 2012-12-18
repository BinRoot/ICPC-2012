import java.util.ArrayList;
import java.util.Scanner;


public class ProblemA {
	
	
	public static void dowork(ArrayList<Integer> nums) {
		
	}
	
	
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		while(kb.hasNextLine()) {
			int n = Integer.parseInt(kb.nextLine());
			
			if(n==0) return;
			
			ArrayList<Integer> nums = new ArrayList<Integer>();
			for(int i=0; i<n; i++) {
				nums.add(Integer.parseInt(kb.nextLine()));
			}
			
			dowork(nums);
		}
	}
}
