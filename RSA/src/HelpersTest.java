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
		BigInteger val = BigInteger.valueOf(9);
		System.out.println("Je;;p");
		System.out.println(help.PerfectSquareOrNot(9));
	//	help.PerfectSquare(val);
		System.out.println(help.PerfectSquare(val));
		//assertEquals(true, help.PerfectSquare(val));
		//assertEquals(true, help.isSquare(BigInteger.valueOf(9)));
	}

}
