import java.util.Scanner;


public class ProblemH {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int numGames = Integer.parseInt(kb.nextLine());
		
		for(int i=0; i<numGames; i++) {
			String names = kb.nextLine();
			String [] narr = names.split(" ");
			
			String starter = kb.nextLine();
			
			//System.err.println("> "+names+", "+starter);
			
			String p = kb.nextLine();
			
			//System.err.println(names+", "+starter+", "+p);
			
			int picked = Integer.parseInt(p);	
			
			int index = 0;
			for(int j=0; j<narr.length; j++) {
				if(narr[j].equals(starter)) {
					index = j;
				}
			}
			
			int newpicked = (index + (picked-1)) % narr.length;
			
			System.out.println(narr[newpicked]);
		}
	}

}
