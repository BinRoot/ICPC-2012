import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProblemI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);


		int numGames = Integer.parseInt(kb.nextLine());
		for (int g = 0; g < numGames; g++) {
			ArrayList<Col> colList = new ArrayList<Col>();

			int row = 0;
			while (kb.hasNextLine()) {

				String line = kb.nextLine();

				if (line.startsWith("-1")) {
					break;
				}

				// System.out.println("reading "+line);

				String uids[] = line.split(" ");

				for (int i = 1; i < uids.length; i++) {
					String uid = uids[i];

					boolean found = false;

					// System.out.println("search through current colList: "+colList);

					for (Col c : colList) {
						if (c.num.equals(uid)) {
							// System.out.println("found "+ uid);

							c.arr[row] = true;
							found = true;
						}
					}
					if (!found) {
						// System.out.println("NOT found "+ uid);
						Col c = new Col();
						c.num = uid;
						c.arr[row] = true;
						colList.add(c);
					}
				}

				row++;
			}

			// System.out.println(row + " rows");

			// System.out.println(colList);

			HashMap<String, List<String>> map = new HashMap<String, List<String>>();

			for (int i = 0; i < colList.size(); i++) {
				for (int j = i; j < colList.size(); j++) {

					// System.out.println("comparing "+i+" and "+j);

					if (Arrays.equals(colList.get(i).arr, colList.get(j).arr)) {
						String a = colList.get(i).num;
						String b = colList.get(j).num;
						if (!map.containsKey(a)) {
							map.put(a, new ArrayList<String>());
						}
						List<String> edges = map.get(a);
						edges.add(b);

						if (!map.containsKey(b)) {
							map.put(b, new ArrayList<String>());
						}
						edges = map.get(b);
						edges.add(a);
						//System.out.println(colList.get(i).num + " is with "
						//		+ colList.get(j).num);

					}
				}
			}

			HashSet<String> visited = new HashSet<String>();
			List<Answer> answers = new ArrayList<Answer>();
			for (String startNode : map.keySet()) {
				if (visited.contains(startNode)) {
					continue;
				}
				int count = 0;
				long min = Long.parseLong(startNode);
				LinkedList<String> toVisit = new LinkedList<String>();
				toVisit.add(startNode);
				while (toVisit.size() > 0) {
					String curNode = toVisit.remove();
					if (visited.contains(curNode)) {
						continue;
					}
					count++;
					//System.out.println("Visiting: " + curNode);
					visited.add(curNode);
					long curMin = Long.parseLong(curNode);
					if (curMin < min) {
						min = curMin;
					}
					for (String pnext : map.get(curNode)) {
						if (!visited.contains(pnext)) {
							toVisit.add(pnext);
						}
					}
				}
				//System.out.println("done");
				answers.add(new Answer(count, min));
			}
			Collections.sort(answers);
			boolean prototypesFound = false;
			System.out.println("Case " + (g + 1));
			for (Answer a : answers) {
				if (a.count <= 1) {
				} else {
					prototypesFound = true;
					System.out.println("" + a.count + " " + a.min);
				}
			}
			if(!prototypesFound) {
				System.out.println("no prototypes found");
			}
		}

	}
}

class Answer implements Comparable<Answer> {
	int count;
	long min;

	public Answer(int count, long min) {
		this.count = count;
		this.min = min;
	}

	@Override
	public int compareTo(Answer arg0) {
		int c = -((Integer) count).compareTo(new Integer(arg0.count));
		if (c == 0) {
			return (new Long(min)).compareTo(new Long(arg0.min));
		} else {
			return c;
		}
	}

}

class Col {
	String num;
	boolean[] arr = new boolean[50];

	public String toString() {
		String myarr = "";
		for (int i = 0; i < arr.length; i++) {
			myarr = myarr + " " + arr[i];
		}
		return num + ": " + myarr + "\n";
	}
}
