import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemD {

	public static int[] toChar(int val) {
		int[] c = new int[16];
		String s = Integer.toString(val, 2);
		int tot = 16 - s.length();
		for(int i = 0; i < tot; i++) {
			s = "0" + s;
		}
		for (int i = 0; i < 16; i++) {
			c[i] = (s.charAt(i) == '0') ? 0 : 1;
		}
		return c;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while(true) {
			String line = kb.nextLine();
			if(line.equals("0")) {
				break;
			}
			
			String arr[] = line.split(" ");
			
			int A = Integer.parseInt(arr[0]);
			int B = Integer.parseInt(arr[1]);
			int C = Integer.parseInt(arr[2]);
			int S = Integer.parseInt(arr[3]);
			
			Set<Integer> numSet = new HashSet<Integer>();
			
			int nextVal = S;
			
			while(!numSet.contains(nextVal)) {
				numSet.add(nextVal);
				nextVal = (A * nextVal + B) % C;
			}
			
			int[] bits = null;
			boolean[] diff = new boolean[16];
			for(int i = 0; i < 16; i++) {
				diff[i] = false;
			}
			for(Integer val : numSet) {
				if(bits == null) {
					bits = toChar(val);
				}
				int[] newBits = toChar(val);
				for(int i = 0; i < 16; i++) {
					if(bits[i] != newBits[i]) {
						diff[i] = true;
					}
				}
			}
			for(int i = 0; i < 16; i++) {
				if(diff[i]) {
					System.out.print("?");
				} else {
					System.out.print(bits[i]);
				}
			}
			System.out.println();
		}
	}
}
