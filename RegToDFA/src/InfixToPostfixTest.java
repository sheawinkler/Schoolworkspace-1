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
		assertEquals(").(",testReturn.addConcat(")("));
		assertEquals(").(",testReturn.addConcat(")("));
		assertEquals("a|a",testReturn.addConcat("a|a"));
		assertEquals("a*.a",testReturn.addConcat("a*a"));
		assertEquals("a.b.a.b",testReturn.addConcat("abab"));
		assertEquals("(a.b).a",testReturn.addConcat("(ab)a"));
		assertEquals("(b.a)*.(a.b)",testReturn.addConcat("(ba)*(ab)"));
		assertEquals("a|b.(a.b)",testReturn.addConcat("a|b(ab)"));
		assertEquals("a.b",testReturn.addConcat("ab"));
		assertEquals("(a.b)",testReturn.addConcat("(ab)"));

		
		assertEquals(3, testReturn.returnPrecedence('.') );
		assertEquals(2, testReturn.returnPrecedence('|') );
		assertEquals(false,testReturn.higherPrecedence('(', '.'));
		assertEquals(true,testReturn.higherPrecedence('*', '('));

		assertEquals(true, testReturn.higherPrecedence('*','('));
		assertEquals(true, testReturn.higherPrecedence('*','.'));
		assertEquals(true, testReturn.higherPrecedence('.','('));
		assertEquals(true, testReturn.higherPrecedence('|','('));
		
		assertEquals("ab.",testReturn.convertToPostfix("a.b"));
		assertEquals("ab|",testReturn.convertToPostfix("a|b"));
		assertEquals("ab*.",testReturn.convertToPostfix("a.b*"));
		assertEquals("ab.*",testReturn.convertToPostfix("(a.b)*"));
		assertEquals("a*b*|",testReturn.convertToPostfix("a*|b*"));
		assertEquals("ab*.",testReturn.convertToPostfix("a.b*"));
		assertEquals("ab.ba.|",testReturn.convertToPostfix("(a.b|b.a)"));
		assertEquals("a*b.ba.|",testReturn.convertToPostfix("((a*.b)|(b.a))"));

	}
	
	
	
}
