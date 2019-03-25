import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Testcoin{
	private coin test1;
	@Before
	public void setUp() throws Exception {
		int[] a = {1,1,1,5,5,20,50};
		test1 = new coin(a);
	}
	
	@Test
	public void testTakeout() {
		assertFalse(test1.takeout(test1.coins,4));
		assertTrue(test1.takeout(test1.coins,5));
		assertFalse(test1.takeout(test1.coins,-1));
	}
	
}