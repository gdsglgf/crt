public class LCS {
	public static int[][] lcs(String a, String b) {
		if (a == null || b == null) {
			return null;
		}
		int m = a.length();
		int n = b.length();
		if (m < n) {
			return null;
		}
		char[] row = a.toCharArray();
		char[] column = b.toCharArray();

		int[][] table = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (row[i - 1] == column[j - 1]) {
					table[i][j] = table[i - 1][j - 1] + 1;
				} else {
					table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
				}
				System.out.printf("%d ", table[i][j]);
			}
			System.out.println();
		}
		return table;
	}

	public static boolean isCommonSet(String longText, String shortText) {
		int[][] table = lcs(longText, shortText);
		if (table == null) {
			return false;
		}
		int m = longText.length();
		int n = shortText.length();
		return table[m][n] == n;
	}

	public static boolean isCommonSet2(String longText, String shortText) {
		if (longText == null || shortText == null) {
			return false;
		}
		int m = longText.length();
		int n = shortText.length();
		if (m < n) {
			return false;
		}
		int j = 0;
		for (int i = 0; i < m && j < n; i++) {
			if (longText.charAt(i) == shortText.charAt(j)) {
				j++;
			}
		}
		return j == n;
	}

	public static void main(String[] args) {
		System.out.println(isCommonSet("abcde", "bd"));
		System.out.println(isCommonSet("abcde", "db"));
	}
}