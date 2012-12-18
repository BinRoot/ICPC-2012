import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProblemD {
	public static List<Integer> solve(List<Integer> p, int bottomSize) {
		int h = p.get(0);
		
		return p;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while(kb.hasNextLine()) {
			String l = kb.nextLine();
			if(l.equals("0")) {
				break;
			}
			List<Integer> p = new ArrayList<Integer>();
			
			List<Integer> solution =solve(p, 0);
		}
	}

	public static void debug(Object o) {
		System.out.println(o);
	}

}
