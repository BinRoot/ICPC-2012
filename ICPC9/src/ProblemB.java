import java.util.ArrayList;
import java.util.Scanner;


public class ProblemB {

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
			if(line.equals("#")) {
				break;
			}
			
			
			ArrayList<Double> probOfFail = new ArrayList<Double>();
			for(int i=0; i<line.length(); i++) {
				char c = line.charAt(i);
				
				if(c == '_') {
					probOfFail.add(0.0);
				}
				if(c == '.') {
					probOfFail.add(100.0);
				}
				
				if(c == '\\') {
					boolean good = false;
					for(int j=i; j<line.length(); j++) {
						char d = line.charAt(j);
						if((d == '|' || d=='/')&&j!=i) {
							good = true;
							break;
						}
						else if (d == '.') {
							good = false;
							break;
						}
						if(j==line.length()-1) {
							good = false;
						}
					}
					
					if(good) {
						probOfFail.add(0.0);
					}
					else {
						probOfFail.add(100.0);
					}
				}
				
				
				if(c == '/') {
					boolean good = false;
					for(int j=i; j>=0; j--) {
						char d = line.charAt(j);
						if((d == '|' || d=='\\')&&j!=i) {
							good = true;
							break;
						}
						else if (d == '.') {
							good = false;
							break;
						}
						if(j==0) {
							good = false;
						}
					}
					
					if(good) {
						probOfFail.add(0.0);
					}
					else {
						probOfFail.add(100.0);
					}
				}
				
				if(c == '|') { 
					
					// go right
					
					boolean good1 = false;
					for(int j=i; j<line.length(); j++) {
						char d = line.charAt(j);
						if((d == '|' || d=='/') && j!=i) {
							good1 = true;
							break;
						}
						else if (d == '.') {
							good1 = false;
							break;
						}
						if(j==line.length()-1) {
							good1 = false;
						}
					}
					
					//go left
					
					boolean good2 = false;
					for(int j=i; j>=0; j--) {
						char d = line.charAt(j);
						if((d == '|' || d=='\\')&&j!=i) {
							good2 = true;
							break;
						}
						else if (d == '.') {
							good2 = false;
							break;
						}
						if(j==0) {
							good2 = false;
						}
					}
					
					
					if(good1 && good2) {
						probOfFail.add(0.0);
					}
					else if(good1 && !good2) {
						probOfFail.add(50.0);
					}
					else if(!good1 && good2) {
						probOfFail.add(50.0);
					}
					else if(!good1 && !good2) {
						probOfFail.add(100.0);
					}
				}
			}
			
			//System.out.println(probOfFail);
			
			double sum = 0.0;
			for(Double d : probOfFail) {
				sum += d;
			}
			
			
			double avg = sum/probOfFail.size();
			
			System.out.println((int)avg);
		}
		
	}

}
