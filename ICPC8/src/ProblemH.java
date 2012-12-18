import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemH {

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
			
			if(line.equals("END")) {
				break;
			}
			
			
			ArrayList<Integer> periods = new ArrayList<Integer>();
			
			for(int i=0; i<line.length(); i++) {
				if(line.charAt(i) == '.') {
					periods.add(i);
				}
			}
			
			if(periods.isEmpty()) {
				System.out.println(line.length()-1+" 1");
			}
			else {
				Throw max = new Throw(Integer.MIN_VALUE, Integer.MAX_VALUE);
				
				for(Integer p : periods) {
					
					if(p == line.length()-1) {
						Throw t = new Throw(p, 1);
						t.count = 1;
						t.length = p;
							
						if(t.compareTo(max) > 0) {
							max = new Throw(t.i, t.d);
							max.length = t.length;
							max.count = t.count;
						}
					}
					
					for(int d = 1; d<line.length()-p; d++) {

						Throw current = new Throw(p, d);
						current.skip(line);
						if(current.compareTo(max) > 0) {
						//System.out.println("current: "+current.toString()+" with "+max);
							max = new Throw(current.i, current.d);
							max.length = current.length;
							max.count = current.count;
						}
					}
				}
				
				System.out.println(max.i+" "+max.d);
			}
			
		}
	}
}

class Throw implements Comparable<Throw>{
	int i;
	int d;
	int count = 1;
	int length;
	
	public Throw(int i, int d) {
		this.i = i;
		this.d = d;
	}
	
	void skip(String lake) {
		
		for(int j=i; j<lake.length(); j+=d) {
			length = j;
			if(lake.charAt(j) == '.') {
				count++;
			}
			else break;
		}
	}
	
	public int compareTo(Throw other) {
		
//		/System.out.print("comparing "+this+" and "+other);
		
		int retNum = 0;
		
		if(this.count > other.count) return 1;
		if(this.count < other.count) return -1;
		
		
		if(this.length > other.length) return 1;
		if(this.length < other.length) return -1;
		
		if(this.i > other.i) return 1;
		if(this.i < other.i) return -1;
		
		if(this.d < other.d) return 1;
		if(this.d > other.d) return -1;
		
		
		else retNum = 0;
		
	//	System.out.println(" "+retNum);
		
		return retNum;
	}

	@Override
	public String toString() {
		return "Throw [count=" + count + ", d=" + d + ", i=" + i + ", length="
				+ length + "]";
	}
	
	
}
