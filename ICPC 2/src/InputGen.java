import java.util.Scanner;


public class InputGen {
	
	public static void dowork(int n, int r, String str) {
		StringBuilder s = new StringBuilder();
		for(int N = 0; N < str.length(); N++){
			for(int i = 0; i < r; i++){
				s.append(str.charAt(N));
			}
		}
		System.out.println(n + " " + s.toString());
	}
	
	
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		int inputs = Integer.parseInt(kb.nextLine());
		
		for(int i=0; i<inputs; i++) {
			String line = kb.nextLine();
			String strsplit[] = line.split(" ");
			int rcount = Integer.parseInt(strsplit[1]);
			String str = strsplit[2];
			
			dowork(i+1, rcount, str);
		}
	}
}
