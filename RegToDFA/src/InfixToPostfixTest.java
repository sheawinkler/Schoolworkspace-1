import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InfixToPostfixTest {

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testSystem() {
		InfixToPostfix testReturn = new InfixToPostfix();
		System.out.println(testReturn.addConcat("a*a"));
		assertEquals("aa.",testReturn.addConcat("aa"));
		assertEquals("aa|",testReturn.addConcat("a|a"));
		//assertEquals("a*a.",testReturn.addConcat("a*a"));
		
		
		
		assertEquals(3, testReturn.returnPrecedence('.') );
		assertEquals(2, testReturn.returnPrecedence('|') );
		assertEquals(false,testReturn.higherPrecedence('(', '.'));
		assertEquals(true,testReturn.higherPrecedence('*', '('));
	}
	
	
	
}
