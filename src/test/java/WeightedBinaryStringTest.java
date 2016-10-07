import org.junit.Assert;
import org.junit.Test;

public class WeightedBinaryStringTest {
	@Test
	public void testZeros() {
		Assert.assertEquals("", WeightedBinaryString.zeros(0));
		Assert.assertEquals("", WeightedBinaryString.zeros(-3));
		Assert.assertEquals("000", WeightedBinaryString.zeros(3));
	}
	
	@Test
	public void testNextNumber() {
		Assert.assertEquals("10", WeightedBinaryString.nextNumber("1"));
		Assert.assertEquals("1100", WeightedBinaryString.nextNumber("1010"));
		Assert.assertEquals("110001", WeightedBinaryString.nextNumber("101100"));
		Assert.assertEquals("10111001", WeightedBinaryString.nextNumber("10110110"));
		
		Assert.assertEquals("10001", WeightedBinaryString.nextNumber("1100"));
		Assert.assertEquals("10101", WeightedBinaryString.nextNumber("10011"));
		Assert.assertEquals("1100011", WeightedBinaryString.nextNumber("1011100"));
	}
}
