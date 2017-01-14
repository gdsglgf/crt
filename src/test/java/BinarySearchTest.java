import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinarySearchTest {
	@Test
	public void testFind() {
		int[] data = new int[] {0, 1, 2, 3};
		assertEquals(-1, BinarySearch.find(data,  -1));
		assertEquals(0, BinarySearch.find(data,  0));
		assertEquals(1, BinarySearch.find(data,  1));
		assertEquals(2, BinarySearch.find(data,  2));
		assertEquals(3, BinarySearch.find(data,  3));
		assertEquals(-1, BinarySearch.find(data,  100));
	}
	
	@Test
	public void testFindMax() {
		int[] data = new int[] {3, 4, 5, 0, 1, 2};
		assertEquals(2, BinarySearch.findMax(data));
	}
	
	@Test
	public void testFindMin() {
		int[] data = new int[] {3, 4, 5, 0, 1, 2};
		assertEquals(3, BinarySearch.findMin(data));
	}
}
