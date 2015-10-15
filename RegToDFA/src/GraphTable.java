
import java.util.*;

public class GraphTable {
	private int numVert, numEdges;
	Map<Integer, List<Pair<Vertex,Character>>> multiMap = new HashMap<Integer, List<Pair<Vertex,Character>  >>();
	
	
	
	GraphTable(){
		setNumVert(0);
		setNumEdges(0);
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
			multiMap.get(vertF.getStateID()).add(edgePair) ;
	
		
	}
	
	public void PrintTable(){
		
		
		System.out.println("Attempting to print table now");
		
		for(List<Pair<Vertex,Character>> l : multiMap.values()){
			 System.out.println(l.size() + ": " + l);
		}
	}
	
	
	public void Closure(){
		
	}
	
	public void TravelMarker(){
		
	}

	




	
}
