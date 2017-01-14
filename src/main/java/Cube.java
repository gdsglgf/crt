import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Location {
	public int x;
	public int y;
	public int z;

	public Location() {}

	public Location(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String toString() {
		return String.format("%d %d %d", x, y, z);
	}
}

public class Cube {
	private int dim;
	private int[] data;
	private int[][][] cube;

	public Cube() {}

	public Cube(int dim, int[] data) {
		this.dim = dim;
		this.data = data;
		cube = new int[dim][dim][dim];
		for (int i = 0; i < this.dim; i++) {
			for (int j = 0; j < this.dim; j++) {
				for (int k = 0; k < this.dim; k++) {
					cube[i][j][k] = data[i * dim * dim + j * dim + k];
				}
			}
		}
	}

	public int getValue(int i) {
		return data[i];
	}

	public Location toLocation(int i) {
		if (i == -1) {
			return null;
		}
		int x = i / (dim * dim);
		i -= x * dim * dim;
		int y = i / dim;
		i -= y * dim;
		int z = i % dim;
		return new Location(x, y, z);
	}
	
	public int calc(int a, int b, int p) {
		return (a + b) % p;
	}

	public int firstMatch(int v, int p) {
		return nextMatch(v, p, 0);
	}

	public int nextMatch(int v, int p, int from) {
		for (int i = from; i < data.length; i++) {
			if (calc(data[i], v, p) == 0) {
				return i;
			}
		}
		return -1;
	}

	public int getDim() {
		return this.dim;
	}

	public int length() {
		return data.length;
	}

	public Location match(Cube small, int index, int p) {
		Location s = toLocation(index);
		
		int max = Math.max(s.x, Math.max(s.y, s.z));
		if (max + small.dim > dim) {
			return null;	// out of boundary
		}
		
		for (int i = 0; i < small.dim; i++) {
			for (int j = 0; j < small.dim; j++) {
				for (int k = 0; k < small.dim; k++) {
					if (calc(small.cube[i][j][k], cube[i + s.x][j + s.y][k + s.z], p) != 0) {
						return null;
					}
				}
			}
		}
		return s;
	}
	
	public static boolean isValid(List<Location> result) {
		int size = result.size();
		if (size != n) {
			return false;
		}
		for (int i = 1; i < n; i++) {
			Location loc1 = result.get(i);
			for (int j = 0; j < i; j++) {
				int d = smaller.get(j).dim;
				Location loc2 = result.get(j);
				if (loc1.x >= loc2.x && loc1.x < loc2.x + d
					&& loc1.y >= loc2.y && loc1.y < loc2.y + d
					&& loc1.z >= loc2.z && loc1.z < loc2.z + d) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void showResult(List<Location> result) {
		for (Location loc : result) {
			System.out.println(loc);
		}
	}
	
	public static boolean solve(List<Location> result, int i) {
		if (i == n) {
			if (isValid(result)) {
				showResult(result);
				return true;
			}
			return false;
		} else {
			Cube c = smaller.get(i);
			int v = c.getValue(0);
			int index = 0;
			while ((index = larger.nextMatch(v, p, index)) != -1) {
				Location loc = larger.match(c, index, p);
				if (loc != null) {
					result.add(loc);
					boolean status = solve(result, i + 1);
					if (status) {
						return true;
					} else {
						result.remove(result.size() - 1);
					}
				}
				index++;
			}
			
			return false;
		}
	}
	
	public static void solve() {
		List<Location> result = new ArrayList<Location>();
		solve(result, 0);
	}
	
	public static int m, n, p;
	public static Cube larger;
	public static List<Cube> smaller;

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		while (cin.hasNext()) {
			m = cin.nextInt();
			n = cin.nextInt();
			p = cin.nextInt();

			int largeSize = m * m * m;
			int[] data = new int[largeSize];
			for (int i = 0; i < largeSize; i++) {
				data[i] = cin.nextInt();
			}

			larger = new Cube(m, data);
			smaller = new ArrayList<Cube>(n);

			for (int i = 0; i < n; i++) {
				int d = cin.nextInt();
				int smallSize = d * d * d;
				int[] small = new int[smallSize];
				for (int j = 0; j < smallSize; j++) {
					small[j] = cin.nextInt();
				}
				smaller.add(new Cube(d, small));
			}

			solve();
		}
		cin.close();
	}
}
