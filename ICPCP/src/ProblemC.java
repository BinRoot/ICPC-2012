import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		for(int n=100; n<=999; n++) {
			for(int d=100; d<=999; d++) {
				if(n==d) {
					continue;
				}
				Fraction f = new Fraction(n, d);
				if(f.simplify()!=null) {
					System.out.println(f.num+" / "+f.den+" = "+f.simplify().num+" / "+f.simplify().den);
				}
			}
		}
	}
	
	

}

class Fraction {
	int num;
	int den;
	
	public Fraction(int num, int den) {
		this.num = num;
		this.den = den;
	}
	
	public Fraction reduce() {
		int g = gcd(num, den);
		return new Fraction(num/g, den/g);
	}
	
	public Fraction simplify() {
		String nStr = num+"";
		String dStr = den+"";
		
		if(nStr.charAt(2) == dStr.charAt(0)) {
			int newN = Integer.parseInt(nStr.substring(0, 2));
			int newD = Integer.parseInt(dStr.substring(1, 3));
			
			if(num*newD == newN*den) {
				return new Fraction(newN, newD);
			}
		}
		return null;
	}
	
	
	private int gcd(int a, int b) {
		if(b == 0) return a;
		else return gcd(b, a % b);
	}
}
