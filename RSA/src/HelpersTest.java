import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.math.BigInteger;
public class HelpersTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFermat() {
		
	}

	@Test
	public void testIsSquare() {
		Helpers help = new Helpers();
		System.out.println(help.PerfectSquareOrNot(10));
		//assertEquals(true, help.PerfectSquareOrNot(9));
		//assertEquals(true, help.isSquare(BigInteger.valueOf(9)));
	}

}
