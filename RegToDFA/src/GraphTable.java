
import java.util.*;
import java.util.Map.Entry;

public class GraphTable {
	
	private int numVert, numEdges, startState;	
	char empty = 'e';
	Map<Integer, List<Pair<Vertex,Character>>> multiMap = new HashMap<Integer, List<Pair<Vertex,Character>  >>();
	
	
	Map<Integer, List<Pair<Vertex,Character>>> DFAMap = new HashMap<Integer, List<Pair<Vertex,Character>  >>();
	
	GraphTable(){
		setNumVert(0);
		setNumEdges(0);
		setStartState(0);
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
	
	public int getStartState() {
		return startState;
	}

	
	public void setStartState(int startState) {
		this.startState = startState;
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
	
	/*
	 * Utilizing the well known subset Construction algorithm here.  
	 * Link to researched materials are below:
	 * http://binarysculpting.com/2012/02/15/converting-dfa-to-nfa-by-subset-construction-regular-expressions-part-2/
	 */
	
	public void subsetConstruction(){
		System.out.println("Attempting to convert table to a DFA now");
		List<Pair<Vertex, Character>> initialState = multiMap.get(startState);
		List<Integer> initialClosure = eClosure(0,initialState);
		
	
		
		
		
	}
	
	
	public List<Integer> eClosure(int key ,List<Pair<Vertex, Character>> states){
		List<Integer> closureStates = new ArrayList<Integer>();
		closureStates.add(key);
		for(int i =0;i<closureStates.size();i++){
			int currKey = closureStates.get(i);
			List<Pair<Vertex, Character>> currStateTransitions = multiMap.get(currKey);
			
			for(Pair<Vertex, Character> stateTransition : currStateTransitions){
				if(stateTransition.getR() ==empty){
					//Not sure if this needs to get checked with the below condition. think on that
					List<Integer> depthFirstEpsilons = recurseEpsilons(stateTransition.getL(),closureStates);
					closureStates.addAll(depthFirstEpsilons);
					
					if(!closureStates.contains(stateTransition.getL().stateID)){
						closureStates.add(stateTransition.getL().stateID);
					}
				}
			}
		}
		return closureStates;
	}
	
	/*
	 * Here I want to search transitionVertex for whether .out.returnWeight() and .out2 == empty,
	 * If so, check whether listOfStates !.contains transitionVertex.stateID and add to list if so.
	 * continue recursively searching the .out edges of those that have returnWeight()==empty
	 */
	
	public List<Integer> recurseEpsilons(Vertex transitionVertex, List<Integer> listOfStates ){
		
		List<Integer> recursedEpsilons = new LinkedList<Integer>();
		

			if(transitionVertex.out.returnWeight()==empty && !listOfStates.contains(transitionVertex.out.returnToVertex().stateID)){
				recursedEpsilons.add(transitionVertex.out.returnToVertex().stateID);
				recurseEpsilons(transitionVertex.out.returnToVertex(),listOfStates);
			}
			if(transitionVertex.out2.returnWeight()==empty && !listOfStates.contains(transitionVertex.out.returnToVertex().stateID)){
				recursedEpsilons.add(transitionVertex.out2.returnToVertex().stateID);
				recurseEpsilons(transitionVertex.out2.returnToVertex(),listOfStates);
			}

		
		return recursedEpsilons;
	}
	
	public void TravelMarker(){
		
	}

	




	
}
