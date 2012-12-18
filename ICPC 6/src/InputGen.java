import java.util.HashMap;
import java.util.Scanner;


public class InputGen {
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNextLine()) {
			String line = kb.nextLine();
			if(line.equals("#")) {
				break;
			}
			
			HashMap<String, String> mymap = new HashMap<String, String>();
			mymap.put("b", "d");
			mymap.put("p", "q");
			mymap.put("d", "b");
			mymap.put("q", "p");
			mymap.put("i", "i");
			mymap.put("o", "o");
			mymap.put("v", "v");
			mymap.put("w", "w");
			mymap.put("x", "x");
			
			boolean invalid = false;
			String outStr = "";
			for(int i=line.length()-1; i>=0; i--) {
				String letter = line.charAt(i) + "";
				if(!mymap.containsKey(letter)){
					invalid = true;
					break;
				}
				
				outStr = outStr + mymap.get(letter);
			}
			
			if(invalid) {
				System.out.println("INVALID");
			}
			else {
			
			System.out.println(outStr);
			}
			
		}
	}
}
