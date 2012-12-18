import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ProblemH {
	
	static ArrayList<Adult> males = new ArrayList<Adult>();
	static ArrayList<Adult> females = new ArrayList<Adult>();
	static ArrayList<Boolean> isDominantList = new ArrayList<Boolean>();
	
	public static String mix(String d1, String d2) {
		String outstr = "";
		
		for(int i=0; i<d1.length(); i++) {
			if(isDominantList.get(i)) {
				// or
				int dig1 = Integer.parseInt(d1.charAt(i)+"");
				int dig2 = Integer.parseInt(d2.charAt(i)+"");
				outstr = outstr + (dig1 | dig2);
			}
			else {
				// and
				int dig1 = Integer.parseInt(d1.charAt(i)+"");
				int dig2 = Integer.parseInt(d2.charAt(i)+"");
				outstr = outstr + (dig1 & dig2);
			}
		}
		
		return outstr;
	}
	
	public static void dowork(String name, String desc) {
		System.out.print(name+" by ");
		
		boolean found1 = false;
		ArrayList<String> pairing = new ArrayList<String>();
		for(Adult m : males) {
			for(Adult f : females) {
				if(mix(m.desc, f.desc).equals(desc)) {
					// woo found!
					
					pairing.add(f.name+"-"+m.name);
					
				}
			}
		}
		
		Collections.sort(pairing);
		
		for(String s : pairing) {
			if(!found1) {
				System.out.print(s);
			}
			else {
				System.out.print(" or "+s);
			}
			found1 = true;
		}
		
		System.out.println();
	}
	
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		
		
		String chars = kb.nextLine();
		
		
		for(int i=0; i<chars.length(); i++) {
			char c = chars.charAt(i);
			if(c == 'R') {
				isDominantList.add(false);
			}
			else isDominantList.add(true);
		}
		
		int mode = 0;
		while(kb.hasNextLine()) {
			
			String line = kb.nextLine();
			
			if(line.equals("***")) {
				mode++;
				if(mode == 2) break;
				continue;
			}
			
			if(mode == 0) {
				String name = line.split(" ")[0];
				String gender = line.split(" ")[1];
				String desc = line.split(" ")[2];
				Adult a = new Adult();
				a.name = name;
				a.gender = gender;
				a.desc = desc;
				if(gender.equals("M")) {
					males.add(a);
				}
				else {
					females.add(a);
				}
			}
			else if(mode == 1) {
				String name = line.split(" ")[0];
				String desc = line.split(" ")[1];
				dowork(name, desc);
			}
			else return;
			
		}
		
		
	}
	
	private static class Adult {
		public String name;
		public String gender;
		public String desc;
	}
}
