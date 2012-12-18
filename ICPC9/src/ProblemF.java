import java.util.LinkedList;
import java.util.Scanner;

public class ProblemF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while (kb.hasNextLine()) {
			int n = Integer.parseInt(kb.nextLine());
			if (n == 0) {
				break;
			}
			LinkedList<Planet> planets = new LinkedList<Planet>();
			for (int i = 0; i < n; i++) {
				String[] ln = kb.nextLine().split(" ");
				int id = Integer.parseInt(ln[0]);
				int x = Integer.parseInt(ln[1]);
				int y = Integer.parseInt(ln[2]);
				int z = Integer.parseInt(ln[3]);
				Planet nP = new Planet(id, x, y, z);
				planets.add(nP);
			}

			LinkedList<Planet> existingPlanets = new LinkedList<Planet>();
			existingPlanets.add(planets.getFirst());
			planets.removeFirst();

			for (Planet nP : planets) {
				double minDist = Double.MAX_VALUE;
				Planet closest = null;
				for (Planet e : existingPlanets) {
					double d = e.dist(nP);
					if (d < minDist) {
						minDist = d;
						closest = e;
					}
				}
				closest.children.add(nP);
				nP.parent = closest;
				existingPlanets.add(nP);
			}

			Planet closestA = null;
			Planet closestB = null;
			int maxHops = Integer.MAX_VALUE;
			for (Planet p : existingPlanets) {
				int hops = p.maxDist(null);
				if (hops < maxHops) {
					maxHops = hops;
					closestA = p;
					closestB = null;
				} else if (hops == maxHops) {
					closestB = p;
				}
			}
			if(closestB != null) {
				int a = closestA.id;
				int b = closestB.id;
				if(a < b) {
					System.out.println(String.format("%d %d", a, b));
				} else {
					System.out.println(String.format("%d %d", b, a));
				}
			} else {
				System.out.println(closestA.id);
			}
		}
	}

}

class Planet {
	public int id, x, y, z;
	public LinkedList<Planet> children = new LinkedList<Planet>();
	public Planet parent = null;

	public double dist(Planet other) {
		float dx = x - other.x;
		float dy = y - other.y;
		float dz = z - other.z;
		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}

	public int maxDist(Planet prev) {
		int max = 0;
		for (Planet p : children) {
			if (!p.equals(prev)) {
				int dist = p.maxDist(this);
				if (dist > max) {
					max = dist;
				}
			}
		}
		if (parent != null && !parent.equals(prev)) {
			int dist = parent.maxDist(this);
			if (dist > max) {
				max = dist;
			}
		}
		return 1 + max;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((children == null) ? 0 : children.hashCode());
		result = prime * result + id;
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
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
		Planet other = (Planet) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (id != other.id)
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}

	public Planet(int id, int x, int y, int z) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "Planet [children=" + children + ", id=" + id + ", parent="
				+ parent + ", x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}
