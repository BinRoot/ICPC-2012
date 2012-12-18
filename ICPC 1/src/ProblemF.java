import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProblemF {
	private static void debug(String s) {
		System.err.println(s);
	}

	public static ArrayList<String> readUnits(String line) {
		ArrayList<String> units = new ArrayList<String>();
		StringTokenizer t = new StringTokenizer(line, " ");
		while (t.hasMoreTokens()) {
			units.add(t.nextToken());
		}
		return units;
	}

	public static Map<Mapping, Conversion> readConversions(List<String> lines) {
		Map<Mapping, Conversion> map = new HashMap<Mapping, Conversion>();
		for (String line : lines) {
			String[] l = line.split(" ");
			debug(l[0]);
			debug(l[1]);
			debug(l[2]);
			debug(l[3]);
			debug(l[4]);
			int inFactor = Integer.parseInt(l[0]);
			String in = l[1];
			int outFactor = Integer.parseInt(l[3]);
			String out = l[4];
			debug(String.format(
					"Creating mapping of %s to %s with factors %d, %d", in,
					out, inFactor, outFactor));
			map.put(new Mapping(in, out), new Conversion(inFactor, outFactor));
			map.put(new Mapping(out, in), new Conversion(outFactor, inFactor));
		}
		return map;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		// TODO repeat for multiple cases
		ArrayList<String> units1 = readUnits(kb.nextLine());
		List<String> lines = new LinkedList<String>();
		for(int i = 0; i < units1.size() - 1; i++) {
			lines.add(kb.nextLine());
		}
		Map<Mapping, Conversion> conv1 = readConversions(lines);

		ArrayList<String> units2 = readUnits(kb.nextLine());
		lines = new LinkedList<String>();
		for(int i = 0; i < units2.size() - 1; i++) {
			lines.add(kb.nextLine());
		}
		Map<Mapping, Conversion> conv2 = readConversions(lines);
	}
}

class Mapping {
	public String in;
	public String out;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((in == null) ? 0 : in.hashCode());
		result = prime * result + ((out == null) ? 0 : out.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mapping other = (Mapping) obj;
		if (in == null) {
			if (other.in != null)
				return false;
		} else if (!in.equals(other.in))
			return false;
		if (out == null) {
			if (other.out != null)
				return false;
		} else if (!out.equals(other.out))
			return false;
		return true;
	}

	public Mapping(String in, String out) {
		super();
		this.in = in;
		this.out = out;
	}

}

class Conversion {
	public int inFactor;
	public int outFactor;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + inFactor;
		result = prime * result + outFactor;
		return result;
	}

	public Conversion(int inFactor, int outFactor) {
		super();
		this.inFactor = inFactor;
		this.outFactor = outFactor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conversion other = (Conversion) obj;
		if (inFactor != other.inFactor)
			return false;
		if (outFactor != other.outFactor)
			return false;
		return true;
	}
}
