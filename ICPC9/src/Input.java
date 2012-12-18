import java.util.Scanner;


public class Input {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNextLine()) {
			String line = kb.nextLine();
			if(line.equals("#")) {
				break;
			}
			long accum = 0;
			for(int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				int pos = i + 1;
				int val;
				if(c == ' ') {
					val = 0;
				} else {
					val = c - 'A' + 1;
				}
				accum += pos * val;
			}
			System.out.println(accum);
		}
		
	}

}
