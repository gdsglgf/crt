public class BinarySearch {
	public static int find(int[] data, int key) {
		int left = 0;
		int right = data.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (data[mid] == key) {
				return mid;
			} else if (data[mid] > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
	
	public static int findMax(int[] data) {
		int left = 0;
		int right = data.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (data[mid] < data[left]) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		return left;
	}
	
	public static int findMin(int[] data) {
		int left = 0;
		int right = data.length - 1;
		while (left < right) {
			if (data[right] > data[left]) {
				return left;
			}
			int mid = (left + right) / 2;
			if (data[mid] < data[left]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
