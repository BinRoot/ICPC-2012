import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class ProblemI {
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNextLine()) {
			String line = kb.nextLine();
			if(line.equals("0 0")) {
				break;
			}
			
			String [] strArrs = line.split(" ");
			
			long m = Long.parseLong(strArrs[0]);
			long n = Long.parseLong(strArrs[1]);
			
			Fraction current = new Fraction(m,n);
			
			dowork(current);
		}
		
		
	}
	
	public static void dowork(Fraction f) {
		
		int count = 0;
		ArrayList<Fraction> sums = new ArrayList<Fraction>();
		for(long i=2; i<1000000; i++) {
			Fraction tmp = new Fraction(1,i);
			
			
			if(tmp.compareTo(f) <= 0) {
				
				Fraction res = f.sub(tmp);
//				System.out.println(f+" - "+tmp+" = "+res);
//				System.out.println("res = " + res.num + "/" + res.den);
				
				
				if(res.den < 1000000) {
					sums.add(new Fraction(tmp.num, tmp.den));
					i--;
					
					if(res.num==0) {
						break;
					}
					f.num = res.num;
					f.den = res.den;
				}
				
			}
			
			else if(tmp.num == f.num && tmp.den == f.den) {
				
				//System.out.println(f+" - "+tmp+" = "+res);
				//System.out.println("res = " + res.num + "/" + res.den);
				if(tmp.den < 1000000) {
					sums.add(new Fraction(tmp.num, tmp.den));
					f.num = tmp.num;
					f.den = tmp.den;
				}
			}
			
//			if(count >20){
//				System.out.println("---");
//				break;
//			}
			
			//count++;
		}
		
		String outStr = "";
		
		for(Fraction fr : sums) {
			outStr += fr.den + " ";
		}
		
		outStr = outStr.trim();
		System.out.println(outStr);
	}
	
}

class Fraction {
	public long num;
	public long den;
	
	Fraction(long num, long den) {
		this.num = num;
		this.den = den;
	}
	
	int compareTo(Fraction b) {
		if(this.num * b.den < b.num * this.den) {
			return -1;
		}
		else if(this.num * b.den > b.num * this.den) {
			return 1;
		}
		return 0;
	}
	
	double div() {
		return ((double)num)/((double)den);
	}
	
	long gcd(long num, long den){
		if (den ==0) {
			return num;
		}
		else {
			return gcd(den, num % den);
		}
	}
	
	long lcm(long num, long den) {
		return (num*den)/gcd(num,den);
	}
	
	Fraction sub(Fraction b) {
		long newDen = lcm(this.den, b.den);
		long newNum = this.num * (newDen / (this.den)) - b.num*(newDen / (b.den));
		
		long myGCD = gcd(newNum, newDen);
		Fraction res = new Fraction(newNum/myGCD, newDen/myGCD);
		
		
		return res;
	}
	
	public String toString() {
		return this.num+"/"+this.den;
	}
}
