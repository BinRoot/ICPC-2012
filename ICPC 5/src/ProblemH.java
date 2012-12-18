import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class ProblemH {
	

	public static void dowork(ArrayList<Gorlerian> gList) {
		ArrayList<Gorlerian> newGors = new ArrayList<Gorlerian>();
		
		for(int i=0; i<gList.size(); i++) {
			newGors.add(gList.get(i));
			
			while(true) {
				
				boolean foundNoneInside = true;
				
				for(Gorlerian g1 : newGors) {
					for(Gorlerian g2 : newGors) {
						
						boolean g2IsIng1 = isBinA(g1, g2);
						if(g2IsIng1 && g1.alive && g2.alive) {
							g1.inside++;
							if(!g1.equals(g2)) {
								foundNoneInside = false;
							}
						}
						
					}
				}
				
				if(foundNoneInside) {
					break;
				}
				
				Collections.sort(newGors, new Comparator<Gorlerian>() {

					public int compare(Gorlerian o1, Gorlerian o2) {
						return o2.inside - o1.inside;
					}
				});
				
				// debug("> "+ newGors);
				
				Gorlerian mergeG = newGors.get(0);
				double xtot = 0;
				double ytot = 0;
				double areatot = 0;
				double count=0;
				
				for(Gorlerian g : newGors) {
					if(isBinA(mergeG, g) && g.alive) {
						xtot += g.x;
						ytot += g.y;
						areatot += Math.PI * g.r*g.r;
						g.alive = false;
						count++;
					}
				}
				
				Gorlerian newg = new Gorlerian(xtot/count, ytot/count, 
						Math.sqrt(areatot/(Math.PI)));
				
				newGors.add(newg);
			
			
				for(Gorlerian g1 : newGors) {
					g1.inside=-1;
				}
			
			}
			
			
			
		}
		
		//debug("final list: "+newGors);
		
		int ccount = 0;
		for(Gorlerian gt : newGors) {
			if(gt.alive) {
				ccount++;
			}
		}
		System.out.println(ccount);
		
		//debug("---");
	}
	
	
	
	public static boolean isBinA(Gorlerian a, Gorlerian b){
		return Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y)) <= a.r;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNextLine()) {
			int lines = Integer.parseInt(kb.nextLine());
			if(lines == 0)
				break;
			
			ArrayList<Gorlerian> gList = new ArrayList<Gorlerian>();
			
			for(int i = 0; i < lines; i++) {
				String inLine = kb.nextLine();
				int x = Integer.parseInt(inLine.split(" ")[0]);
				int y = Integer.parseInt(inLine.split(" ")[1]);
				int r = Integer.parseInt(inLine.split(" ")[2]);
				Gorlerian g = new Gorlerian(x, y, r);
				gList.add(g);
				
			}
			dowork(gList);
		}
	}
	
	public static void debug(Object o) {
		System.out.println(o);
	}

}


class Gorlerian {
public double x;
public double y;
public double r;
public int inside = -1;
public boolean alive = true;

public Gorlerian(double x, double y, double r){
	this.x = x;
	this.y = y;
	this.r = r;
	
}



@Override
public String toString() {
	return "Gorlerian [alive=" + alive + ", inside=" + inside + ", r=" + r
			+ ", x=" + x + ", y=" + y + "]";
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (alive ? 1231 : 1237);
	result = prime * result + inside;
	long temp;
	temp = Double.doubleToLongBits(r);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(x);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(y);
	result = prime * result + (int) (temp ^ (temp >>> 32));
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
	Gorlerian other = (Gorlerian) obj;
	if (alive != other.alive)
		return false;
	if (inside != other.inside)
		return false;
	if (Double.doubleToLongBits(r) != Double.doubleToLongBits(other.r))
		return false;
	if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
		return false;
	if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
		return false;
	return true;
}



}

