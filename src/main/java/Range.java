import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Range implements Comparator<Range> {
	private int start;
	private int end;
	private int price;

	public Range() {
	}

	public Range(int start, int end, int price) {
		this.start = start;
		this.end = end;
		this.price = price;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getPrice() {
		return price;
	}

	// 时段比较器
	public int compare(Range r1, Range r2) {
		return r1.getStart() - r2.getStart();
	}

	public static int[][] merge(int[][] dateRangePrices) {
		ArrayList<Range> list = new ArrayList<Range>();

		// 价格以后一时段为准
		// 定义list为ArrayList<Range>，方便引用时段
		// 将dateRangePrices中的时段按逆序添加至list
		for (int i = dateRangePrices.length - 1; i >= 0; i--) {
			list.add(new Range(dateRangePrices[i][0], dateRangePrices[i][1],
					dateRangePrices[i][2]));
		}

		ArrayList<Range> result = new ArrayList<Range>();

		// 将最后时段添加至result
		result.add(list.get(0));
		// 定义last为已知的最后时刻
		int last = result.get(0).getEnd();

		for (int i = 1; i < list.size(); i++) {

			// 定义previous表示比较时的前一时段
			// 定义next表示比较时的后一时段
			Range previous = list.get(i);
			Range next = result.get(result.size() - 1);

			// 修正已知的最后时刻
			if (previous.getEnd() > last) {
				result.add(new Range(Math.max(previous.getStart(), last + 1), previous.getEnd(), previous
						.getPrice()));
				last = previous.getEnd();
			}

			// 两时段存在重复区间
			if (next.getStart() - 1 <= previous.getEnd()) {
				// 两时段的价格相同，合并重复区间
				if (next.getPrice() == previous.getPrice()) {
					int start = Math.min(previous.getStart(), next.getStart());

					// 前一步添加至result的时间段需要修正
					result.remove(result.size() - 1);
					previous = new Range(start, next.getEnd(), next.getPrice());

					// 两时段的价格不同，以后一时段为准修正重复区间
				} else {
					int end = next.getStart();
					previous = new Range(previous.getStart(), end - 1,
							previous.getPrice());

				}
			}
			// 两时段不存在重复区间，或重复区间已修正
			result.add(previous);
		}

		// 重新按时序排列各时间段
		Collections.sort(result, new Range());

		int[][] array = new int[result.size()][3];
		for (int i = 0; i < result.size(); i++) {
			array[i][0] = result.get(i).getStart();
			array[i][1] = result.get(i).getEnd();
			array[i][2] = result.get(i).getPrice();
		}

		return array;

	}

	public static void main(String[] args) {
		int[][] range = 
//			{{1, 1, 100},
//				{2,3,100},
//				{4,5,110}};
			
			{{0, 100, 300}, {40, 50, 350}};
			
//			{ 
//				{ 10, 60, 250 }, 
//				{ 20, 50, 300 }, 
//				{ 40, 45, 350 },
//				{ 50, 55, 300 } };
		int[][] result = merge(range);
		
		System.out.print(Arrays.toString(result[0]));
		for (int i = 1; i < result.length; i++) {
//			System.out.println("[" + result[i][0] + ", " + result[i][1] + ", "
//					+ result[i][2] + "]");
			System.out.print(',');
			System.out.print(Arrays.toString(result[i]));
		}
		System.out.println();

	}
}
