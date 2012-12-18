import java.util.Scanner;


public class Input {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while(true) {
			String line = kb.nextLine();
			if(line.equals("#")) {
				break;
			}
			line = line.replace("%", "%25");
			line = line.replace(" ", "%20");
			line = line.replace("!", "%21");
			line = line.replace("$", "%24");
			line = line.replace("(", "%28");
			line = line.replace(")", "%29");
			line = line.replace("*", "%2a");
			System.out.println(line);
		}
	}

}
