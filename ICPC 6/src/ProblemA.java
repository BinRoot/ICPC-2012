import java.util.HashMap;
import java.util.Scanner;

public class ProblemA {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int runs = Integer.parseInt(kb.nextLine());
		for (int p = 0; p < runs; p++) {
			String line = kb.nextLine();
			int SH = Integer.parseInt(line.split(" ")[0]);
			int SM = Integer.parseInt(line.split(" ")[1]);
			int DH = Integer.parseInt(line.split(" ")[2]);
			int DM = Integer.parseInt(line.split(" ")[3]);

			System.out.println("------+---------");
			System.out.println(" time | elapsed ");
			System.out.println("------+---------");
			int m = -SM;
			for (int lh = SH; lh <= (SH + DH) + ((SM + DM) / 60); lh++) {
				int h = lh;
				if(lh > 12) {
					h = lh - 12;
				}
				if (h < 10) {
					System.out.print(" ");
				}
				if( m > 0) {
					System.out.println(String.format("%d:XX | XX + %d", h, m));
				}
				if(m < 0) {
					System.out.println(String.format("%d:XX | XX - %d", h, -m));
				}
				if (m == 0) {
					System.out.println(String.format("%d:XX | XX", h));
				}
				
				m += 60;
			}
		}
	}
}
