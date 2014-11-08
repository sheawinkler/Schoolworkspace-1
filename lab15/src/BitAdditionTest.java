import static org.junit.Assert.*;

import org.junit.Test;


public class BitAdditionTest {

	@Test
	public void testAdd() {
		//BitAddition tester = new BitAddition();
		assertEquals(14, BitAddition.add(10, 4));
		assertEquals(7, BitAddition.add(9, -2));
		assertEquals(3, BitAddition.add(3, 0));
		assertEquals(10, BitAddition.add(2, 8));
		assertEquals(48, BitAddition.add(57, -9));
		
	}

}
