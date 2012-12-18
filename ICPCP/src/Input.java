import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String[] start = kb.nextLine().split(" ");
		float adist = Float.parseFloat(start[0]);
		float edist = Float.parseFloat(start[1]);
		float totalATime = 0;
		float totalETime = 0;
		float totalASpeed = 0;
		float totalESpeed = 0;
		for (int i = 0; i < 20; i++) {
			String[] ln = kb.nextLine().split(" ");
			if (ln[0].toLowerCase().equals("a")) {
				totalATime += Float.parseFloat(ln[1]);
				totalASpeed += adist / Float.parseFloat(ln[1]);
			} else {
				totalETime += Float.parseFloat(ln[1]);
				totalESpeed += edist/ Float.parseFloat(ln[1]);
			}
		}
		System.out.println("Method 1");
		System.out.println(String.format("African: %.2f furlongs per hour",
				adist *10.0f / (totalATime)));
		System.out.println(String.format("European: %.2f furlongs per hour",
				edist *10.0f / (totalETime)));
		System.out.println("Method 2");
		System.out.println(String.format("African: %.2f furlongs per hour",
				totalASpeed / (10.0f)));
		System.out.println(String.format("European: %.2f furlongs per hour",
				totalESpeed / (10.0f)));
	}

}
