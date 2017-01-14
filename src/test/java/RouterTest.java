import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RouterTest {
	int roomNum;
	int routerNum;
	int[] roomWeight;
	int[][] roomGraph;

	@Test
	public void test1() {
		roomNum = 5;
		routerNum = 1;
		roomWeight = new int[]{0, 1, 2, 3, 4, 5};		// first one element not use
		roomGraph = new int[][]{
			{0, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0},
			{0, 1, 0, 1, 1, 0},
			{0, 0, 1, 0, 0, 1},
			{0, 0, 1, 0, 0, 0},
			{0, 0, 0, 1, 0, 0}
		};			// first row and first column elements not use
		
		Router router = new Router(roomNum, routerNum, roomWeight, roomGraph);
		assertEquals(10, router.max());
		
		router.setRouterNum(2);
		assertEquals(15, router.max());
	}
	
	@Test
	public void test2() {
		roomNum = 5;
		routerNum = 2;
		roomWeight = new int[]{0, 1, 2, 3, 4, 5};		// first one element not use
		roomGraph = new int[][]{
			{0, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0},
			{0, 1, 0, 1, 0, 0},
			{0, 0, 1, 0, 1, 0},
			{0, 0, 0, 1, 0, 1},
			{0, 0, 0, 0, 1, 0}
		};			// first row and first column elements not use
		
		Router router = new Router(roomNum, routerNum, roomWeight, roomGraph);
		assertEquals(15, router.max());
	}
}
