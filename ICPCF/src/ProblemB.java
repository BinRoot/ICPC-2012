import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;


public class ProblemB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int pn = 1;
		while(kb.hasNextLine()) {
			String line = kb.nextLine();
			int num = Integer.parseInt(line);
			
			//System.out.println("\n\nnum is now "+num);
			
			if(num == -1) {
				break;
			}
			
			ArrayList<Integer> arr = new ArrayList<Integer>();
			while(true) {
				String[] command = kb.nextLine().split(" ");
				boolean done = false;
				
				switch(command[0].charAt(0)) {
				case 'A':
				{
					int id = Integer.parseInt(command[1]);
					int size = Integer.parseInt(command[2]);
					
					for(int i=0; i<size; i++) {
						arr.add(0,id);
					}
					
					// remove last element if falls off shelf
					if(arr.size() > num) {
						if(arr.get(num-1) == arr.get(num)) {
							int idToRemove = arr.get(arr.size()-1);
							for(int i=0; i<arr.size(); i++) {
								if(arr.get(i) == idToRemove) {
									arr.remove(i);
									i--;
								}
							}
						}
						else {
							for(int j=num;j<arr.size(); j++) {
								arr.remove(j);
								j--;
							}
						}
					}
					
					
					//System.out.println("adding "+id+" of size "+size);
				}
					break;
				case 'R':
				{
					int id = Integer.parseInt(command[1]);
					//System.out.println("removing "+id);
					
					for(int i=0; i<arr.size(); i++) {
						if(arr.get(i) == id) {
							arr.remove(i);
							i--;
						}
					}
					
					
				}
					break;
				case 'E':
					done = true;
					break;
				}
				
				
			//	System.out.println(arr); 
				
				
				
				if(done) { 
					
					int oldNum = -1;
					String output = "";
					for(int i=0; i<arr.size(); i++) {
						if(oldNum != arr.get(i)) {
							output += " " + arr.get(i);
							oldNum = arr.get(i);
						}
					}
					//output = output.trim();
					
					System.out.println("PROBLEM "+pn+":"+output);
					pn++;
					
					break; }
			}
			
		}
	}

}
