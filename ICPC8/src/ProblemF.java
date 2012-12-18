import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ProblemF {

	public static void dowork(int current, String line) {
		System.out.print("" + current + ":");
		String[] comma = line.split(",");
		HashMap<String, Set<String>> acl = new HashMap<String, Set<String>>();
		for (String s : comma) {
			int i = 0;
			Set<String> touched = new HashSet<String>();
			for (i = 0; s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'; i++) {

				touched.add("" + s.charAt(i));
				if (!acl.containsKey("" + s.charAt(i))) {
					acl.put("" + s.charAt(i), new HashSet<String>());
				}
			}
			char op = s.charAt(i);
			if (op == '=') {
				for (String t : touched) {
					acl.get(t).clear();
				}
			}
			i++;
			for (; i < s.length(); i++) {
				for (String t : touched) {
					switch (op) {
					case '=':
					case '+':
						acl.get(t).add("" + s.charAt(i));
						break;
					case '-':
						acl.get(t).remove("" + s.charAt(i));
						break;
					}
				}
			}
		}
		List<String> sorted = new ArrayList<String>(acl.keySet());
		Collections.sort(sorted);
		for (int i = 0; i < sorted.size(); i++) {
			String cur = sorted.get(i);
			String next = null;

			for (int j = i + 1; j < sorted.size(); j++) {
				next = sorted.get(j);
				if (acl.get(next).size() == 0) {
					next = null;
				} else {
					break;
				}
			}
			if (acl.get(cur).size() != 0) {
				System.out.print(cur);
			}
			boolean print = false;
			if (next == null) {
				print = true;
			} else {
				Set<String> curSet = acl.get(cur);
				Set<String> nextSet = acl.get(next);
				print = !curSet.equals(nextSet);
			}
			if (print && acl.get(cur).size() > 0) {
				List<String> val = new ArrayList<String>(acl.get(cur));
				Collections.sort(val);
				for (String v : val) {
					System.out.print(v);
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int count = 1;
		while (true) {
			String line = kb.nextLine();
			if (line.equals("#")) {
				break;
			}

			dowork(count++, line);
		}
	}

}
