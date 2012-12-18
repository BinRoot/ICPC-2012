import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class ProblemF {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while (true) {
			String ln = kb.nextLine();
			if (ln.equals("END")) {
				break;
			}
			System.out.println(ln);

			LinkedList<Range> commands = new LinkedList<Range>();
			while (true) {
				ln = kb.nextLine();
				if (ln.equals("0")) {
					break;
				}
				String[] input = ln.split(" ");
				Range r = new Range(Long.parseLong(input[0]), Long
						.parseLong(input[1]), input[2], Long
						.parseLong(input[3]));
				commands.add(r);
			}

			LinkedList<Range> table = new LinkedList<Range>();
			table.add(commands.removeFirst());

			// process others
			for (Range r : commands) {
				processCommand(table, r);
			}

			// simplify!

			// output
			for (Range r : table) {
				System.out.println(r);
			}
		}
	}

	private static void processCommand(LinkedList<Range> table, Range r) {
		int initialSize = table.size();
		for (int i = 0; i < initialSize; i++) {
			if (!table.contains(r)) {
				table.add(r);
			}
			Range t = table.get(i);
			// r contains t
			if (t.start >= r.start && t.end <= r.end) {
				table.remove(i);

				continue;
			}

			if (t.start > r.end && t.end < r.start) {
				continue;
			}
			
			// t contains r
			if (r.start >= t.start && r.end <= t.end) {
				t.start = t.start;
				t.end = r.start - 1;
				Range n = new Range(r.end + 1, t.end, t.status, t.transfer);
				if(!(n.end < n.start)) {
					table.add(n);
				}
				continue;
			}

			if (r.start >= t.start) {
				t.start = Math.min(t.start, r.end + 1);
				t.end = Math.min(t.end, r.start - 1);
			} else if (r.){
				
			}
			
			
			if (t.end < t.start) {
				table.remove(i);
			}
		}
	}
}

class Range {
	// inclusive
	public long start;
	public long end;
	public String status;
	public long transfer;

	@Override
	public String toString() {
		return String.format("%d %d %s %d", start, end, status, transfer);
	}

	/*
	 * 0 = no overlap
	 * 
	 * -1 = left
	 * 
	 * 1 = right
	 * 
	 * 2 = inside
	 * 
	 * 3 = around
	 */
	public int overlap(Range r) {
		if (r.start > start && r.end < end) {
			return 2;
		}
		if (start > r.start && end < r.end) {
			return 3;
		}
		return -999;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (end ^ (end >>> 32));
		result = prime * result + (int) (start ^ (start >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + (int) (transfer ^ (transfer >>> 32));
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
		Range other = (Range) obj;
		if (end != other.end)
			return false;
		if (start != other.start)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (transfer != other.transfer)
			return false;
		return true;
	}

	public Range(long start, long end, String status, long transfer) {
		super();
		this.start = start;
		this.end = end;
		this.status = status;
		this.transfer = transfer;
	}

}
