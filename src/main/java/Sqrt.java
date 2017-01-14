
public class Sqrt {
	public static double abs(double a) {
		return a > 0 ? a : -1 * a;
	}
	
	public static double power(double a) {
		return a * a;
	}
	
	public static double sqrt(double v, double epsilon) {
		assert (v > 0 && epsilon > 0) : "params must be greater than zero.";
		double mid = 0;
		double left = 0, right = v, diff;
		while(true) {
			mid = (left + right) / 2;
//			System.out.println(String.format("[%f, %f, %f]", left, mid, right));
			diff = power(mid) - v;
			if (abs(diff) < epsilon / (2 * mid)) {	// better than abs(diff) < epsilon
				break;
			} else if (diff > 0) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return mid;
	}
	
	public static void main(String[] args) {
		System.out.println(sqrt(4, 0.21));
		System.out.println(sqrt(5, 0.01));
		System.out.println(sqrt(9, 0.21));
		System.out.println(sqrt(9, 1.0e-16));
		System.out.println(sqrt(10, 0.00001));
//		System.out.println(sqrt(-4, 0.00001));
	}
}
