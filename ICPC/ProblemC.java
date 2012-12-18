import java.util.*;

public class ProblemC {
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		while(true) {
			String[] line = s.nextLine().split(" ");
			if(line[0].equals("0")) {
				break;
			}

			HashMap<Integer, Integer> dllSizes = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> progSizes = new HashMap<Integer, Integer>();
			HashMap<Integer, List<Integer>> progDep = new HashMap<Integer, List<Integer>>();

			int N = Integer.parseInt(line[0]);
			int P = Integer.parseInt(line[1]);
			int S = Integer.parseInt(line[2]);
			line = s.nextLine().split(" ");
			for(int i = 0; i < line.length; i++) {
				dllSizes.put(i, Integer.parseInt(line[i]));
			}
			for(int i = 0; i < P; i++) {
				line = s.nextLine().split(" ");
				int psize = Integer.parseInt(line[0]);
				progSizes.put(i + 1, psize);
				List<Integer> dependencies = new ArrayList<Integer>();
				for(int dllIndex = 0; dllIndex < line[1].length(); dllIndex++) {
					dependencies.add((Integer) (line[1].charAt(dllIndex) - 'A'));
				}
				progDep.put(i + 1, dependencies);
			}
			//System.err.println("dllSizes: " + dllSizes.toString());
			//System.err.println("progSizes : " + progSizes.toString());
			//System.err.println("progDep: " + progDep.toString());

			String[] sequence = s.nextLine().split(" ");

			HashMap<Integer, Integer> curDllDep = new HashMap<Integer, Integer>();
			for(int i = 0; i < N; i++) {
				curDllDep.put(i, 0);
			}
			int maxMem = 0;
			int curMem = 0;
			//do stuff
			for(int sIndex = 0; sIndex < sequence.length; sIndex++) {
				int command = Integer.parseInt(sequence[sIndex]);
				if(command > 0) {
					curMem += progSizes.get(command);
					for(Integer dll : progDep.get(command)) {
						int oldDepNum = curDllDep.get(dll);
						curDllDep.put(dll, oldDepNum + 1);
						if(oldDepNum == 0) {
							curMem += dllSizes.get(dll);
						}
					}
				} else {
					command *= -1;
					curMem -= progSizes.get(command);
					for(Integer dll : progDep.get(command)) {
						int oldDepNum = curDllDep.get(dll);
						curDllDep.put(dll, oldDepNum - 1);
						if(oldDepNum - 1 == 0) {
							curMem -= dllSizes.get(dll);
						}
					}
				}

				//System.err.println("curMem: " + curMem);
				if(curMem > maxMem) {
					maxMem = curMem;
				}
			}
			System.out.println(maxMem);
		}
	}
}
