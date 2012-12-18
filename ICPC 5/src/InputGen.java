import java.util.Scanner;


public class InputGen {

	public static void dowork(int a, int b) {
		debug(a+" "+b);
		
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNextLine()) {
			int lines = Integer.parseInt(kb.nextLine());
			for(int i=0; i<lines; i++) {
				String line = kb.nextLine();
				
			}
		}
	}
	
	public static void debug(Object o) {
		System.out.println(o);
	}

}
