import java.util.Scanner;

public class ProblemB {
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		System.out.println("Gnomes:");
		for(int i = 0; i < num; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int c = s.nextInt();
			if(a <= b && b <= c) {
				System.out.println("Ordered");
			} else if(c <= b && b <= a) {
				System.out.println("Ordered");
			} else {
				System.out.println("Unordered");
			}
		}
	}
}
