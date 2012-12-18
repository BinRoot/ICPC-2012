import java.util.ArrayList;
import java.util.Scanner;


public class ProblemC {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int menu = 0;
		while(kb.hasNextLine()) {
			menu++;
			int pizzas = Integer.parseInt(kb.nextLine());
			if(pizzas == 0) {
				break;
			}
			ArrayList<Integer> d = new ArrayList<Integer>(pizzas);
			ArrayList<Integer> p = new ArrayList<Integer>(pizzas);
			for(int i=0; i<pizzas; i++) {
				String line = kb.nextLine();
				String[] split = line.split(" ");
				d.add(Integer.parseInt(split[0]));
				p.add(Integer.parseInt(split[1]));
			}
			int bestIndex = 0;
			double bestPPA = Double.POSITIVE_INFINITY;
			for(int i = 0; i < pizzas; i++) {
				double area = Math.PI * (d.get(i) / 2.0f) * (d.get(i) / 2.0f);
				double pricePerArea = ((double) p.get(i)) / area;
				if(pricePerArea < bestPPA) {
					bestIndex = i;
					bestPPA = pricePerArea;
				}
			}
			System.out.println(String.format("Menu %d: %d", menu, d.get(bestIndex)));
		}
	}
	
	public static void debug(Object o) {
		System.err.println(o);
	}

}
