import org.junit.Assert;
import org.junit.Test;

public class SameDigitNumberTest {
	@Test
	public void testZeros() {
		Assert.assertEquals("", SameDigitNumber.zeros(0));
		Assert.assertEquals("", SameDigitNumber.zeros(-3));
		Assert.assertEquals("000", SameDigitNumber.zeros(3));
	}
	
	@Test
	public void testNextNumber() {
		Assert.assertEquals("10", SameDigitNumber.nextNumber("1"));
		Assert.assertEquals("110", SameDigitNumber.nextNumber("101"));
		Assert.assertEquals("10001", SameDigitNumber.nextNumber("1100"));
		Assert.assertEquals("10101", SameDigitNumber.nextNumber("10011"));
		Assert.assertEquals("1100011", SameDigitNumber.nextNumber("1011100"));
	}
}
