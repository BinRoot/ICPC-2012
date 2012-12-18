import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class ProblemB {
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNextLine()) {
			String line = kb.nextLine();
			if(line.equals("0")) {
				break;
			}
			
			String []strArr = line.split(" ");
			
			int k = Integer.parseInt(strArr[0]);
			
			ArrayList<Integer> ints = new ArrayList<Integer>();
			for(int i =1; i<strArr.length; i++) {
				ints.add(Integer.parseInt(strArr[i]));
			}
			
			dowork(ints);
			
		}
	}
	
	public static void dowork(ArrayList<Integer> nums) {
		String outStr = "";
		
		for(int i=0; i<nums.size(); i++) {
			if(i>0 && nums.get(i)-nums.get(i-1)>0) {
				
				for(int j=nums.get(i)-nums.get(i-1); j>0; j--) {
//					
//					if(i==nums.size()-1) {
//						System.out.print(i+1);
//					}
//					else System.out.print(i+1 + " ");
//					
					outStr = outStr + (i+1) +" ";
				}
			}
			else if(i==0 && nums.get(i)>0) {
				for(int j=nums.get(i); j>0; j--) {
//					
//					System.out.print(1 + " ");
					
					
					outStr = outStr + "1" + " ";
				}
			}
			
			
			else continue;
		}
		
		
		outStr = outStr.trim();
		System.out.println(outStr);
		
	}
}
