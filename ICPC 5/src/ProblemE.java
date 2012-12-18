import java.util.Scanner;


public class ProblemE {

	public static void dowork(int a, int b) {
		debug(a+" "+b);
		
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNextLine()) {
			String line = kb.nextLine();
			if(line.equals("END")) {
				break;
			}
			
			boolean dups = false;
			int arr[] = new int[91];
			for(int i=0; i<line.length(); i++) {
				if(line.charAt(i) == ' ') {
					continue;
				}
				
				char c = line.charAt(i);
				
				if(arr[c] == 1) {
					dups = true;
					break;
				}
				else {
					arr[c]++;
				}
			}
			
			if(!dups) {
				System.out.println(line);
			}
		}
	}
	
	public static void debug(Object o) {
		System.out.println(o);
	}

}
