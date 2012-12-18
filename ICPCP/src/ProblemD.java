import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ProblemD {

	public static Map<Integer, Integer> solve(int startIndex, List<Integer> seq) {
		HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
		if (startIndex == 0) {
			result.put(seq.get(startIndex), 1);
			return result;
		}

		Map<Integer, Integer> sub = solve(startIndex - 1, seq);
		int first = seq.get(startIndex);
		// add
		for (Integer i : sub.keySet()) {
			int r = first + i;
			
			int subCount = sub.get(i);
			int existingCount = 0;
			if (result.containsKey(r)) {
				existingCount = result.get(r);
			}
			result.put(r, existingCount + subCount);
		}
		// sub
		for (Integer i : sub.keySet()) {
			int r = Math.abs(first - i);

			int subCount = sub.get(i);
			int existingCount = 0;
			if (result.containsKey(r)) {
				existingCount = result.get(r);
			}
			result.put(r, existingCount + subCount);
		}
		// mul
		for (Integer i : sub.keySet()) {
			int r = first * i;
			
			int subCount = sub.get(i);
			int existingCount = 0;
			if (result.containsKey(r)) {
				existingCount = result.get(r);
			}
			result.put(r, existingCount + subCount);
		}
		// div
		for (Integer i : sub.keySet()) {
			if (first == 0) {
				continue;
			}
			int r = i / first;
			
			int subCount = sub.get(i);
			int existingCount = 0;
			if (result.containsKey(r)) {
				existingCount = result.get(r);
			}
			result.put(r, existingCount + subCount);
		}
		//System.err.println("result for " + first + " is: " + result);
		return result;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while (true) {
			String[] line = kb.nextLine().split(" ");
			if (line[0].equals("#")) {
				break;
			}
			List<Integer> sequence = new ArrayList<Integer>();
			for (int i = 0; i < line.length; i++) {
				sequence.add(Integer.parseInt(line[i]));
			}

			Map<Integer, Integer> res = solve(sequence.size() - 1, sequence);
			int mostFound = 0;
			int value = -1;
			for (Integer v : res.keySet()) {
				if (!("" + v).contains("3")) {
					continue;
				}
				if (res.get(v) > mostFound) {
					mostFound = res.get(v);
					value = v;
				} else if (res.get(v) == mostFound && v > value) {
					mostFound = res.get(v);
					value = v;
				}
			}
			//System.err.println(res);
			if (value == -1) {
				System.out.println("No result");
			} else {
				System.out.println(value);
				//System.err.println(mostFound);
			}
		}
	}
}
