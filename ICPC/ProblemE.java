import java.util.Scanner;

public class ProblemE {
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		while(true) {
			String[] ln = s.nextLine().split(" ");
			if(ln.length == 1 && ln[0].equals("0")) {
				break;
			}
			int last = -1;
			for(int i =1; i < ln.length; i++) {
				int cur = Integer.parseInt(ln[i]);
				if(cur != last) {
					System.out.print(ln[i] + " ");
					last = cur;
				} else {
					
				}
			}
			System.out.println("$");
		}
	}
}
