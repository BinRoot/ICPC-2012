import java.util.Scanner;


public class InputGen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int numGames = Integer.parseInt(kb.nextLine());
		for(int g = 0; g < numGames; g++) {
			int numRounds = Integer.parseInt(kb.nextLine());
			int p1Wins = 0;
			int p2Wins = 0;
			for(int r = 0; r < numRounds; r++) {
				String line = kb.nextLine();
				String[] split = line.split(" ");
				char p1 = split[0].charAt(0);
				char p2 = split[1].charAt(0);
				int winner = 0;
				switch(p1) {
				case 'R':
					switch(p2) {
					case 'R':
						winner = 0;
						break;
					case 'P':
						winner = 2;
						break;
					case 'S':
						winner = 1;
						break;
					}
					break;
				case 'P':
					switch(p2) {
					case 'R':
						winner = 1;
						break;
					case 'P':
						winner = 0;
						break;
					case 'S':
						winner = 2;
						break;
					}
					break;
				case 'S':
					switch(p2) {
					case 'R':
						winner = 2;
						break;
					case 'P':
						winner = 1;
						break;
					case 'S':
						winner = 0;
						break;
					}
					break;
				}
				switch(winner) {
				case 0:
					break;
				case 1:
					p1Wins++;
					break;
				case 2:
					p2Wins++;
					break;
				}
			}
			if(p1Wins == p2Wins) {
				System.out.println("TIE");
			}
			if(p1Wins > p2Wins) {
				System.out.println("Player 1");
			}
			if(p2Wins > p1Wins) {
				System.out.println("Player 2");
			}
		}
	}

}
