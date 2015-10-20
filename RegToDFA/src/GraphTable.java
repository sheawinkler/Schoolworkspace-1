
import java.util.*;
import java.util.Map.Entry;

public class GraphTable {
	
	private int numVert, numEdges;	
	Map<Integer, List<Pair<Vertex,Character>>> multiMap = new HashMap<Integer, List<Pair<Vertex,Character>  >>();
	
	
	GraphTable(){
		setNumVert(0);
		setNumEdges(0);
		multiMap.clear();
	}
	
	
	public int getNumVert() {
		return numVert;
	}


	public void setNumVert(int numVert) {
		this.numVert = numVert;
	}


	public int getNumEdges() {
		return numEdges;
	}

	
	public void setNumEdges(int numEdges) {
		this.numEdges = numEdges;
	}
	
	
	public void InsertEdgeByWeight(Vertex vertF, Vertex vertT, char A){
		//Make Edge
		Pair<Vertex,Character> edgePair = new Pair<Vertex, Character>();
		edgePair.setL(vertT);
		edgePair.setR(A);
		
		//Add edge to list
		if(multiMap.get(vertF.getStateID())!= null){
			multiMap.get(vertF.getStateID()).add(edgePair) ;	
		}else{
			List<Pair<Vertex,Character>> values = new ArrayList<Pair<Vertex,Character>>(); 
			values.add(edgePair);
			multiMap.put(vertF.getStateID(), values);
		}
	}
	
	public void PrintTable(){
		System.out.println("Attempting to print table now");
	    
		   Iterator<Entry<Integer, List<Pair<Vertex, Character>>>> it = multiMap.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry<Integer, List<Pair<Vertex, Character>>> graphPair = (Entry<Integer, List<Pair<Vertex, Character>>>)it.next();
		        List<Pair<Vertex,Character>> listPair = new ArrayList<Pair<Vertex,Character>>(); 
		        listPair = graphPair.getValue();
		        System.out.println("State "+ graphPair.getKey() + " = ");
		        for(int i=0;i<listPair.size();i++){
		        	Pair<Vertex, Character> output = listPair.get(i);
		        	char outputChar = output.getR();
		        	Vertex outputVertex = output.getL();
		        	
		        	System.out.println("---> "+outputChar+" to state "+outputVertex.getStateID());
		        }
		        it.remove(); // avoids a ConcurrentModificationException
		    }
	}
	
	
	public void Closure(){
		
	}
	
	public void TravelMarker(){
		
	}

	




	
}
