import java.util.HashMap;
import java.util.Scanner;

public class ProblemC {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		while (true) {
			String line = kb.nextLine();
			if (line.equals("#")) {
				break;
			}
			int y = 0;
			int n = 0;
			int p = 0;
			int a = 0;
			for (int i = 0; i < line.length(); i++) {
				switch (line.charAt(i)) {
				case 'Y':
					y++;
					break;
				case 'N':
					n++;
					break;
				case 'P':
					p++;
					break;
				case 'A':
					a++;
					break;
				}
			}
			int tot = y + n + p + a;
			if ((float) a >= (float) tot / 2.0f) {
				System.out.println("need quorum");
			} else if(y > n){
				System.out.println("yes");
			} else if(n > y) {
				System.out.println("no");
			} else if(n == y){
				System.out.println("tie");
			}
		}
	}
}
