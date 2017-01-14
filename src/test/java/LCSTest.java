import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LCSTest {
	@Test
	public void testIsCommonSet() {
		assertEquals(true, LCS.isCommonSet("abcde", "bd"));
		assertEquals(false, LCS.isCommonSet("abcde", "db"));
	}

	@Test
	public void testIsCommonSet2() {
		assertEquals(true, LCS.isCommonSet2("abcde", "bd"));
		assertEquals(false, LCS.isCommonSet2("abcde", "db"));
	}
}