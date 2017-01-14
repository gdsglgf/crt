import java.util.Scanner;

public class Router {
	private int roomNum;
	private int routerNum;
	private int[] roomWeight;
	private int[][] roomGraph;

	public Router(int roomNum, int routerNum, int[] roomWeight, int[][] roomGraph) {
		this.roomNum = roomNum;
		this.routerNum = routerNum;
		this.roomWeight = roomWeight;
		this.roomGraph = roomGraph;
	}
	
	public void setRouterNum(int routerNum) {
		this.routerNum = routerNum;
	}

	public int max() {
		boolean[] status = new boolean[roomNum + 1];
		return max(status, 0, 1);
	}

	private int max(boolean[] status, int routerNum, int roomNum) {
		if (this.routerNum == routerNum || roomNum > this.roomNum) {
			return 0;
		}

		boolean[] temp = new boolean[this.roomNum + 1];
		System.arraycopy(status, 1, temp, 1, this.roomNum);

		int sum1 = countWeight(status, roomNum);
		if (status[roomNum] == false) {
			sum1 += roomWeight[roomNum];
			status[roomNum] = true;
		}
		int result1 = sum1 + max(status, routerNum + 1, roomNum + 1);
		int result2 = max(temp, routerNum, roomNum + 1);
//		System.out.println(String.format("%d, %d", result1, result2));
		return Math.max(result1, result2);
	}

	private int countWeight(boolean[] status, int roomNum) {
		int sum = 0;
		for (int i = 1; i <= this.roomNum; i++) {
			if (roomGraph[roomNum][i] == 1 && status[i] == false) {
				sum += roomWeight[i];
				status[i] = true;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int roomNum;
		int routerNum;
		int[] roomWeight;
		int[][] roomGraph;

		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			roomNum = cin.nextInt();
			routerNum = cin.nextInt();
			roomWeight = new int[roomNum + 1];
			for (int i = 1; i <= roomNum; i++) {
				roomWeight[i] = cin.nextInt();
			}

			roomGraph = new int[roomNum + 1][roomNum + 1];
			int a, b;
			for (int i = 1; i < roomNum; i++) {
				a = cin.nextInt();
				b = cin.nextInt();
				roomGraph[a][b] = 1;
				roomGraph[b][a] = 1;
			}

			Router router = new Router(roomNum, routerNum, roomWeight, roomGraph);
			System.out.println(router.max());
		}
		cin.close();
	}
}