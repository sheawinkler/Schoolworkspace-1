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
		AssistFunctions help = new AssistFunctions();
		BigInteger val = BigInteger.valueOf(9);
		BigInteger ans = BigInteger.valueOf(3);
		BigInteger ferVal = BigInteger.valueOf(3);
		help.fermat(ferVal);
		System.out.println(help.PerfectSquare(val));
		
		assertEquals(ans,help.sqrt(val));
		assertEquals(ans, help.PerfectSquare(val));
		//assertEquals(true, help.isSquare(BigInteger.valueOf(9)));
	}

}
