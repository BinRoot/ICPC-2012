import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Scanner;


public class InputGen {
	
	static HashMap<String, String> opBinMap = new HashMap<String, String>();
	
	public static void dowork(int n, String c, int d, String s) {
		String part1 = opBinMap.get(c);
		
		String part2 = padx(Integer.toString(d,2),11);
		
		String part3 = s.equals("F") ? "0" : "1";
		
		String allBin = part1 + part2 + part3;
		
		//System.out.println(">> "+allBin);
		
		double dval = binToDec(allBin);
		
		DecimalFormat dff = new DecimalFormat("0.0###############");
		
		System.out.println(n+" "+dff.format(dval));
	}
	
	public static double binToDec(String binstr) {
		String newBin = "";
		
		int posOfLastOne = 0;
		
		for(int i=binstr.length()-1; i>=0; i--) {
			if(binstr.charAt(i) == '1') {
				posOfLastOne = i;
				break;
			}
		}
		
		
		if(binstr.charAt(0) == '1') {
			
			for(int i=0; i<posOfLastOne; i++) {
				newBin = newBin + (binstr.charAt(i)=='1' ? "0" : "1");
			}
			for(int i=posOfLastOne; i<binstr.length(); i++) {
				newBin = newBin + (binstr.charAt(i)+"");
			}
			
			//System.out.println(binstr + " --> "+newBin);
			
			return -1*binToDec2(newBin);
		}
		
		//System.out.println("input: "+binstr + " --> " + newBin);
		
		return binToDec2(binstr);
	}
	
	public static double binToDec2(String binstr) {
		
		double retd = 0.0;
		
		for(int i=0; i<binstr.length(); i++) {
			if(binstr.charAt(i) == '1') {
				retd += Math.pow(2, -1*i);
			}
		}
		
		return retd;
	}
	
	public static String padx(String str, int x) {
		int numzeros = x-str.length();
		String outstr = str;
		for(int i=0; i<numzeros; i++) {
			outstr = "0"+outstr;
		}
		return outstr;
	}
	
	
	public static void main(String [] args) {
		
		String edsac = "PQWERTYUIOJ#SZK*?F@D!HNM&LXGABCV";
		
		DecimalFormat df = new DecimalFormat("00000");
		for(int i=0; i<edsac.length(); i++) {
			String opcodeLetter = edsac.charAt(i) + "";
			opBinMap.put(opcodeLetter, padx(Integer.toString(i, 2),5));
			//System.out.println(opcodeLetter+" -> "+pad5(Integer.toString(i, 2)));
		}
		
		
		Scanner kb = new Scanner(System.in);
		int P = Integer.parseInt(kb.nextLine());
		
		for(int i = 0; i< P; i++) {
			String line = kb.nextLine();
			String strsplit[] = line.split("\\s");
			String c = strsplit[1];
			int d = Integer.parseInt(strsplit[2]);
			String s = strsplit[3];
			
			dowork(i+1, c, d, s);
		}
	}
}

