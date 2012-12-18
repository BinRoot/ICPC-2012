import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ProblemH {
	
	
	static HashMap<Integer, Integer> lMapB = new HashMap<Integer, Integer>();
	static HashMap<Integer, Integer> bMapB = new HashMap<Integer, Integer>();
	
	static HashMap<Integer, Integer> lMapBcount = new HashMap<Integer, Integer>();
	static HashMap<Integer, Integer> bMapBcount = new HashMap<Integer, Integer>();

	public static void fill(ArrayList<Tuple> tList) {
		lMapB = new HashMap<Integer, Integer>();
		bMapB = new HashMap<Integer, Integer>();
		
		lMapBcount = new HashMap<Integer, Integer>();
		bMapBcount = new HashMap<Integer, Integer>();
		
		int prevNumB = 0;
		int prevNumL = 0;
		
		int prevLCount = 0;
		int prevBCount = 0;
		
		for(int i=0; i<tList.size(); i++) {
			if(tList.get(i).name.equals("Lisa")) {
				
				lMapBcount.put(i, ++prevLCount);
				bMapBcount.put(i, prevBCount);
				
				//lMapBcount.put(i, lMapBcount.get(i)+1);
				if(tList.get(i).val==1) {
					lMapB.put(i, ++prevNumL);
				}
				else {
					lMapB.put(i, prevNumL);
				}
				
				bMapB.put(i, prevNumB);
			}
			
			if(tList.get(i).name.equals("Bart")) {

				lMapB.put(i, prevNumL);
				
				lMapBcount.put(i, prevLCount);
				bMapBcount.put(i, ++prevBCount);
				
				//bMapBcount.put(i, bMapBcount.get(i)+1);
				if(tList.get(i).val==1) {
					bMapB.put(i, ++prevNumB);
				}
				else {
					bMapB.put(i, prevNumB);
				}
				
			}
		}
		
		//System.out.println(bMapB);
		//System.out.println(bMapBcount);
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int c = 1;
		
		
		
		while(kb.hasNextLine()) {
			String line = kb.nextLine();
			
			boolean detected = false;
			
			if(line.equals("0")) {
				break;
			}
			
			if(c!=1) System.out.println();
			
			int n = Integer.parseInt(line);
			
			ArrayList<Tuple> tList = new ArrayList<Tuple>();
			for(int i=0; i<n; i++) {
				line = kb.nextLine();
				String name = line.split(" ")[0];
				int val = Integer.parseInt(line.split(" ")[1]);
				Tuple t = new Tuple(name, val);
				tList.add(t);
			}
			
			fill(tList);
			
			
			int bSum = bMapB.get(tList.size()-1);  //sum("Bart", tList);
			int lSum = lMapB.get(tList.size()-1); //sum("Lisa", tList);
			
			
			boolean header = false;
			
			System.out.println("Case "+c+": Bart did "+bSum+" and Lisa did "+lSum);
			String finStr = "";
			
			if(bSum==lSum) {
				System.out.println("Bart and Lisa accomplished same number of chores");
				detected = true;
			}
			else {
				
				//double globalBart = (sum("Bart", tList)+0.0)*100/(count("Bart", tList)+0.0);
				
				//double globalLisa = (sum("Lisa", tList)+0.0)*100/(count("Lisa", tList)+0.0);
				
				//System.out.println("globalBart: "+globalBart+", globalLisa: "+globalLisa);
				
				
				
				
				for(int i=1; i<tList.size()-1; i++) {
					List<Tuple> before = tList.subList(0, i);
					List<Tuple> after = tList.subList(i, tList.size());
					
					int bSumBefore = bMapB.get(i); //sum("Bart", before);
					int bSumAfter = bMapB.get(tList.size()-1) - bMapB.get(i); //sum("Bart", after);
					int lSumBefore =  lMapB.get(i); //sum("Lisa", before);
					int lSumAfter = lMapB.get(tList.size()-1) - lMapB.get(i); //sum("Lisa", after);
					
//					double bBeforeP = (bSumBefore+0.0) / (count("Bart", before)+0.0);
//					double lBeforeP = (lSumBefore+0.0) / (count("Lisa", before)+0.0);


					double bBeforeP = (bSumBefore+0.0) / (bMapBcount.get(i)+0.0);
					double lBeforeP = (lSumBefore+0.0) / (lMapBcount.get(i)+0.0);
					
					double bAfterP = (bSumAfter+0.0) / (bMapBcount.get(tList.size()-1) - bMapBcount.get(i)+0.0);
					double lAfterP = (lSumAfter+0.0) / (lMapBcount.get(tList.size()-1) - lMapBcount.get(i)+0.0);
					
					
					DecimalFormat df = new DecimalFormat("############.####");

					try{
					bBeforeP = Double.parseDouble(df.format(bBeforeP));
					lBeforeP = Double.parseDouble(df.format(lBeforeP));
					bAfterP = Double.parseDouble(df.format(bAfterP));
					lAfterP = Double.parseDouble(df.format(lAfterP));
					}
					catch(Exception e) {}
//					
//					bBeforeP = Double.parseDouble(String.format("%.4f", bBeforeP));
//					lBeforeP = Double.parseDouble(String.format("%.4f", lBeforeP));
//					bAfterP = Double.parseDouble(String.format("%.4f", bAfterP));
//					lAfterP = Double.parseDouble(String.format("%.4f", lAfterP));
//					
					
					double den = bBeforeP + lBeforeP + bAfterP + lAfterP;
					
					double bnum = bBeforeP + bAfterP;
					double lnum = lBeforeP + lAfterP;
					
					
					
					if( bnum/den > lnum/den ) {
						if(lSum > bSum) {
							if(bBeforeP > lBeforeP && bAfterP>lAfterP) {
								
								finStr += (String.format("After chore %d: %.4f%% %.4f%% %.4f%% %.4f%%\n", i+1, bBeforeP * 100, lBeforeP * 100, bAfterP * 100, lAfterP * 100));
								detected = true;
								header = true;
								
							}
							
						}
					}	
					if( bnum/den < lnum/den ) {
						if(lSum < bSum) {
							
							if(bBeforeP < lBeforeP && bAfterP<lAfterP) {
								
								finStr += (String.format("After chore %d: %.4f%% %.4f%% %.4f%% %.4f%%\n", i+1, bBeforeP * 100, lBeforeP * 100, bAfterP * 100, lAfterP * 100));
								detected = true;
								header = true;
							}
						}
					}
					
					
				}
				
			}
			
			if(!detected) {
				System.out.println("Simpson's paradox not detected");
			}
			else if(header) {
				System.out.println("Trend measured in 2 parts is reversed");
				System.out.print(finStr);
			}
			
			c++;
		}
	}

	
//	public static int sum(String name, List<Tuple> tList) {
//		int sum = 0;
//		for(Tuple t : tList) {
//			if(t.name.equals(name) && t.val==1) {
//				sum++;
//			}
//		}
//		return sum;
//	}
//	
//	public static int count(String name, List<Tuple> tList) {
//		int c = 0;
//		for(Tuple t : tList) {
//			if(t.name.equals(name)) {
//				c++;
//			}
//		}
//		return c;
//	}
}

class Tuple {
	String name;
	int val;
	public Tuple(String name, int val) {
		this.name = name;
		this.val = val;
	}
}
