
import java.util.*;
import java.util.Map.Entry;

public class GraphTable {
	
	private int numVert, numEdges, startState,finalState;	
	char empty = 'e';
	Map<Integer, List<Pair<Vertex,Character>>> multiMap = new HashMap<Integer, List<Pair<Vertex,Character>  >>();
	Map<Integer, List<Pair<Vertex,Character>>> subsetMap = new HashMap<Integer, List<Pair<Vertex,Character>  >>();
	Map<List<Integer>,Pair<List<Integer>,List<Integer>>> dfaMap = new HashMap<List<Integer>,Pair<List<Integer>,List<Integer>>>();
	
	List<List<Integer>> finalStates = new ArrayList<List<Integer>>();
	List<Integer> initialClosure = new ArrayList<Integer>();
	
	ArrayList<Pair<List<Integer>,Boolean >> list = new ArrayList<Pair<List<Integer>,Boolean >>();	
	GraphTable(){
		setNumVert(0);
		setNumEdges(0);
		setStartState(0);
		setFinalState(0);
		multiMap.clear();
	}
	
	public Map<Integer, List<Pair<Vertex,Character>>>getMap(){
		return multiMap;
	}
	public 	void copyMaps(){
		subsetMap.putAll(multiMap);
		
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
	
	public int getFinalState() {
		return finalState;
	}

	
	public void setFinalState(int finalState) {
		this.finalState = finalState;
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
		        it.remove(); 
		    }
	}
	
	
	public void PrintDFATable(){
		System.out.println("Attempting to print table now");
	    
		   Iterator<Entry<List<Integer>, Pair<List<Integer>, List<Integer>>>> it = dfaMap.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry<List<Integer>, Pair<List<Integer>, List<Integer>>> graphPair = (Entry<List<Integer>, Pair<List<Integer>, List<Integer>>>)it.next();
		        
		        Pair<List<Integer>, List<Integer>> listPair = new Pair<List<Integer>, List<Integer>>(); 
		        
		        
		        
		        System.out.println("State "+ listPair.getL() + " = ");
		        listPair = graphPair.getValue();
//		        for(int i=0;i<listPair.;i++){
//		        	Pair<Vertex, Character> output = listPair.get(i);
//		        	char outputChar = output.getR();
//		        	Vertex outputVertex = output.getL();
//		        	
//		        	System.out.println("---> "+outputChar+" to state "+outputVertex.getStateID());
//		        }
		        it.remove(); 
		    }
	}
	/*
	 * Utilizing the well known subset Construction algorithm here.  
	 * Link to researched materials are below:
	 * http://binarysculpting.com/2012/02/15/converting-dfa-to-nfa-by-subset-construction-regular-expressions-part-2/
	 * http://www.idt.mdh.se/kurser/cd5560/10_01/examination/examination/NFA-DFA.pdf
	 */
	
	public void subsetConstruction(){
		System.out.println("Attempting to convert table to a DFA now");

		//Initial State of DFA
		//System.out.println(getStartState());
		//InitialClosure is our new starting state
		initialClosure = eClosure(startState);
		//Final States is
		char[] alpha = new char[2];
		alpha[0]='a';
		alpha[1]='b';
		
		//Compute U = ε -closure(move(T,a)
		Pair<List<Integer>,Boolean > transition = new Pair<List<Integer>,Boolean>();
		Boolean truth = false;
		transition.setL(initialClosure);
		transition.setR(truth);
		list.add(transition);

		
		while(marked()!=null){
			List<Integer> currState = new ArrayList<Integer>();
			currState= getState(list).getL();
			getState(list).setR(true);
			//curr value Needs to be set to true here to meet above condition allowing iteration
			Pair<List<Integer>,List<Integer>> packPair = new Pair<List<Integer>,List<Integer>>();
			for(int i=0;i<alpha.length;i++){	
				List<Integer> setListU = new ArrayList<Integer>();
				if(i==0){
					setListU = eClosureSet(travelMarker(currState,alpha[i]));
					packPair.setL(setListU);
				}
				if(i>0){
					setListU = eClosureSet(travelMarker(currState,alpha[i]));
					packPair.setR(setListU);
					//Empty case need to be considered when traverseMap()
					dfaMap.put(currState, packPair);
			
				}
				//We can build our table here based on the moves made
				if(!contains(list,setListU)){
					Pair<List<Integer>,Boolean> pairList = new Pair<List<Integer>,Boolean>();
					pairList.setL(setListU);
					pairList.setR(false);
					list.add(pairList);
				}
			}
		}
		
		//DFA has been constructed, must now located the final state
		findDFAFinals();


	}
	
	public void runCases(String[] allCases){
		for(String oneCase: allCases){
			traverseMap(oneCase);
		}
	}
	
	public void traverseMap(String testCase){
		
		if(recurseRun(testCase)){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}		
	}
	
	public boolean recurseRun(String testCase){
		boolean canTraverse = false;
		List<Integer> transferState = initialClosure;
		for(int i=0; i < testCase.toCharArray().length;i++){
			if(transferFunction(transferState)!=null){
				
				transferFunction();
				canTraverse= true;
			}else{
				return false;
			}
		}		
		return canTraverse	;
	}
	
	public void transferFunction(List<Integer> transferState, char transerChar){
		
	}
	
	public void findDFAFinals(){
		//Iterate thru list, and anything with original final state is final State
		
		for (Entry<List<Integer>, Pair<List<Integer>, List<Integer>>> entry : dfaMap.entrySet())
		{
			if(entry.getKey().contains(getFinalState())){
				finalStates.add(entry.getKey());
				System.out.println(entry.getKey().toString());
			}
		    
		}
		
	}
	
	public boolean contains(ArrayList<Pair<List<Integer>,Boolean >> currList,  List<Integer> setToCompare ){
		boolean truth = false;
		for(Pair<List<Integer>,Boolean > listPair:currList){
			if(listPair.getL().containsAll(setToCompare)){
				truth = true;
			}
		}
		return truth;
	}
	
	
	public List<Integer> travelMarker(List<Integer> travelList,char transitionMarker){
		List<Integer> returnList = new LinkedList<Integer>();
		for(int value: travelList){
			List<Pair<Vertex, Character>> tempList = new ArrayList<Pair<Vertex, Character>>();
			
			tempList = subsetMap.get(value);
			if(tempList != null){
				for(Pair<Vertex, Character> pair: tempList){
					if(pair.getR() == transitionMarker){
						returnList.add(pair.getL().stateID);
					}
				}
			}
		}
		return returnList;
		
	}
	public static Pair<List<Integer>,Boolean > getState(ArrayList<Pair<List<Integer>,Boolean >> list){
		Pair<List<Integer>,Boolean > returnItem = new Pair<List<Integer>,Boolean >();
		for(Pair<List<Integer>,Boolean > item: list){
			if(item.getR()==false){
				returnItem = item;
				return returnItem;
			}
		}
		return returnItem;
	}	
	/*
	 * Should avoid null, change to empy set on free time
	 */
	public Pair<List<Integer>,Boolean > marked(){
		for(Pair<List<Integer>,Boolean > item: list){
			if(item.getR()==false){
				return item;
			}
		}
		return null;	
	}
	
	public List<Integer> eClosureSet( List<Integer> subsetList ){
		List<Integer> closureList = new ArrayList<Integer>();
		for(int value: subsetList){
			closureList.addAll(eClosure(value));
		}
		return closureList;
	}
	
	public List<Integer> eClosure(int key){
		List<Integer> closureStates = new ArrayList<Integer>();
		closureStates.add(key);
		for(int i =0;i<closureStates.size();i++){
			int currKey = closureStates.get(i);
			List<Pair<Vertex, Character>> currStateTransitions = subsetMap.get(currKey);
			if(currStateTransitions!=null){
				for(Pair<Vertex, Character> stateTransition : currStateTransitions){
						if(stateTransition!=null && stateTransition.getR() ==empty  && !closureStates.contains(stateTransition.getL().stateID)){	
								closureStates.add(stateTransition.getL().stateID);
								//Not sure if this needs to get checked with the below condition. think on that
								List<Integer> depthFirstEpsilons = recurseEpsilons(stateTransition.getL(),closureStates);
								closureStates.addAll(depthFirstEpsilons);
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

			if(transitionVertex.out != null && transitionVertex.out.returnWeight()==empty && !listOfStates.contains(transitionVertex.out.returnToVertex().stateID)){
				recursedEpsilons.add(transitionVertex.out.returnToVertex().stateID);
				if(transitionVertex.out.returnToVertex() != null){
					recurseEpsilons(transitionVertex.out.returnToVertex(),listOfStates);
				}
			}
			if(transitionVertex.out2 !=null && transitionVertex.out2.returnWeight()==empty && !listOfStates.contains(transitionVertex.out2.returnToVertex().stateID)){
				recursedEpsilons.add(transitionVertex.out2.returnToVertex().stateID);
				if(transitionVertex.out2.returnToVertex() != null){
				recurseEpsilons(transitionVertex.out2.returnToVertex(),listOfStates);
				}
			}
		return recursedEpsilons;
	}
}
