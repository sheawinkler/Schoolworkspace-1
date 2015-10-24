import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GraphTableTest {

	@Before
	public void setUp() throws Exception {
		
		
		
	}

	@Test
	public void testInsertEdgeByWeight() {
		
		Project1 main = new Project1();
		Vertex start = main.createStart();
		Vertex end = main.createFinal();
		Vertex start2 = main.createStart();
		Vertex end2 = main.createFinal();
		assertEquals(0,main.gTable.getNumVert());
		main.gTable.InsertEdgeByWeight(start, end, 'a');
		main.gTable.InsertEdgeByWeight(start2, start, 'b');
		main.gTable.InsertEdgeByWeight(start2, end2, 'b');
		main.gTable.PrintTable();
	}
}
