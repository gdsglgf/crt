import java.util.Arrays;
import java.util.Scanner;

/**
 * SameDigitNumber: 
 * Find next number which has save number of one's.
 * Such as 10011 has numbers [10101, 10110, 11001, 11010, 11100].
 * The less and greater number is 10101.
 * 
 * More examples:
 * 1    -> 10
 * 101  -> 110
 * 1100 -> 10001
 */
public class SameDigitNumber {
    public static int lastIndex(char[] chars, char key, int from) {
        for (int i = from; i >= 0; i--) {
            if (chars[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static String zeros(int n) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < n; i++) {
            buf.append('0');
        }
        return buf.toString();
    }

    public static String nextNumber(String s) {
        char[] chars = s.toCharArray();
//        int j = lastIndex(chars, '1', chars.length - 1);
//        int i = lastIndex(chars, '0', j - 1);
        int j = s.lastIndexOf('1');
        int i = s.lastIndexOf('0', j - 1);
        
        System.out.println(String.format("i = %d, j = %d", i, j));
        
        if (i == -1) {
            System.out.println(String.format("zeros[%s], ones=[%s]", zeros(chars.length - j - 1), s.substring(1, j + 1)));
            return "10" + zeros(chars.length - j - 1) + s.substring(1, j + 1);
        } else {
            swap(chars, i, i + 1);

            for (int t = i + 2, r = chars.length - 1; t <= j; t++, r--) {
                chars[t] = '0';
                chars[r] = '1';
            }

            System.out.println(Arrays.toString(chars));
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String line = null;
        while (cin.hasNext()) {
            line = cin.nextLine();
            System.out.println(nextNumber(line));
        }
        cin.close();
    }
}
