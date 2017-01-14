import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers out of [1,n].
Example:
If n = 4 and k = 2, a solution is: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4] ]
*/
public class Combination {
	public static void findAll(int n, int k , List<Integer> data, int i) {
		int size = data.size();
		if (size == k) {
			System.out.println(data);
			return;
		}
		if (i <= n) {
			List<Integer> temp = new ArrayList<Integer>(data);
			data.add(i);
			findAll(n, k, data, i + 1);
			data.remove(data.size() - 1);
			findAll(n, k, temp, i + 1);
		}
	}
	
	public static void findAll(int n, int k, int[] cache, int i, int j) {
		if (k == i) {
			System.out.println(Arrays.toString(cache));
			return;
		}
		int num_remain = n - j + 1;
		int cache_remain = k - i;
		System.out.println(
				String.format("n=%d, k=%d, i=%d, j=%d, num_remain=%d, cache_remain=%d", 
						n, k, i, j, num_remain, cache_remain));
		if (num_remain < cache_remain) {
			return;
		} else if (num_remain == cache_remain) {
			for (;i < k; i++, j++) {
				cache[i] = j;
			}
			System.out.println(Arrays.toString(cache));
		} else {
			cache[i] = j;		// put j in index i of cache
			findAll(n, k, cache, i + 1, j + 1);		// put j in cache
			
			findAll(n, k, cache, i, j + 1);		// ignore j
		}
	}
	
	public static void main(String[] args) {
		List<Integer> data = new ArrayList<Integer>();
		findAll(4, 2, data, 1);
		
		System.out.println("--------------------");
		int[] cache = new int[2];
		findAll(4, 2, cache, 0, 1);
	}
}
