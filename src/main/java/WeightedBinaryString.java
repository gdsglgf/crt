import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>We define the number of 1s in the binary string as its weight.
 * <p>Such as binary string "1010" has 2 1s, so it's weight is 2.
 * <p>Given a binary string(0 is exclusive), we find other binary 
 * string which has the same weight and it is closest and greater to the given string.
 * 
 * <blockquote><pre>
 * eg.
 *  "1"        -> "10"
 *  "1010"     -> "1100"
 *  "101100"   -> "110001"
 *  "10110110" -> "10111001"
 * </pre></blockquote>
 */
public class WeightedBinaryString {
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
    	if (s.equals("0")) {
    		return null;
    	}
        char[] chars = s.toCharArray();
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
