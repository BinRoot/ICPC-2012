import java.util.Scanner;

public class ProblemF {
	public static void main(String [] args) {

		Scanner s = new Scanner(System.in);

		while(s.hasNext()) {
		    String l1 = s.nextLine();
		    String l2 = s.nextLine();
		    if(l1.equals("E")) break;

		    int p1wins = 0;
		    int p2wins = 0;
		    for(int i=0; i<l1.length(); i++) {
			char p1 = l1.charAt(i);
			char p2 = l2.charAt(i);
			
			if( p1 == p2 ) {
			    
			}
			else if( p1=='R' && p2=='S') {
			    p1wins++;
			}
			else if( p1=='S' && p2=='R') {
			    p2wins++;
			}
			
			else if( p1=='P' && p2=='R') {
			    p1wins++;
			}
			else if( p1=='R' && p2=='P') {
			    p2wins++;
			}


			else if( p1=='S' && p2=='P') {
			    p1wins++;
			}
			else if( p1=='P' && p2=='S') {
			    p2wins++;
			}
		    }

		    System.out.println("P1: "+p1wins);
		    System.out.println("P2: "+p2wins);
		}

	}
}
