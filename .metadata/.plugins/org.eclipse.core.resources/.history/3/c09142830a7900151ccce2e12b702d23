import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class mainConverter {
	
	
	int id =-1;
	int startState = 0;
	char empty = 'e';
	GraphTable gTable = new GraphTable();
	Stack<  Pair<Vertex,Vertex> > stateHistory = new Stack<  Pair<Vertex,Vertex> >();


	public Vertex createStart(){
		Vertex startVertex = new Vertex();
		startVertex.setStateID(++id);
		startVertex.setRootState(true);
		startVertex.setFinalState(false);
		return startVertex;
	}
	public Vertex createFinal(){
		Vertex endVertex = new Vertex();
		endVertex.setStateID(++id);
		endVertex.setRootState(false);
		endVertex.setFinalState(true);
		return endVertex;
		
	}
	public void charTransition(char c){
		   //Vertex Construction
		   Vertex rootNodeChar = createStart();
		   Vertex endNodeChar = createFinal();
		   Edge tempEdge = new Edge(endNodeChar,c);
		   rootNodeChar.out = tempEdge;

		   //Save State[Root,End] on stack for Operator
		    Pair<Vertex,Vertex> charPair = new Pair<Vertex,Vertex>();
		    
		    charPair.setL(rootNodeChar);
		    charPair.setR(endNodeChar);
		    stateHistory.push((Pair<Vertex,Vertex>)charPair);

		   //Figure out your table schema
		   gTable.InsertEdgeByWeight(rootNodeChar, endNodeChar, c);
		   gTable.setNumVert(gTable.getNumVert()+2); 
		   gTable.setNumEdges(gTable.getNumEdges()+1); 

		   startState = rootNodeChar.stateID;
	}
	//Change to End Node transition
	public void concatState(){

		
		   //Pop last two off stack
		Pair<Vertex,Vertex> tempPair = stateHistory.peek();
		Vertex nodeBFinal = tempPair.getR();
		Vertex nodeB = tempPair.getL();
		stateHistory.pop();
		
		 //Remove as Start State and add as Final State
		nodeB.setRootState(false);
		
		//Pop first two off stack--Retrieving Pair from Stack  pair<start,end> 
		Pair<Vertex,Vertex> tempPair2 = stateHistory.peek();
		Vertex nodeAFinal = tempPair2.getR();
		Vertex nodeA = tempPair2.getL();
		
		stateHistory.pop();
		
		//Here we have nodeA-->nodeAFinal    going to be concat with nodeB -->nodeBFinal
		//CONCAT nodeAFinal.out->edge to nodeB
		Edge concatEdge = new Edge(nodeB,empty);
		nodeAFinal.out = concatEdge;	//Must insert this edge into gTable after this operation
		
		//ALL CONNECTIONS MADE---CHANGING PERMISSIONS
		nodeAFinal.setFinalState(false); 
		nodeAFinal.setRootState(false); 
		
		nodeB.setRootState(false);
		nodeB.setFinalState(false);
		
		nodeBFinal.setFinalState(true);
		nodeBFinal.setRootState(false); 	


	   //Save State on stack for Operator--Start-End
	   	Pair<Vertex,Vertex> concatFinalPair = new Pair<Vertex,Vertex>();;
	    concatFinalPair.setL(nodeA);
	    concatFinalPair.setR(nodeBFinal);
	    stateHistory.push(concatFinalPair);
	    
	   //Add edge to graph
	   gTable.InsertEdgeByWeight(nodeAFinal, nodeB, empty);
	   gTable.setNumEdges(gTable.getNumEdges()+1); 		
	   gTable.setStartState(nodeA.stateID);
	  
	}
	public void kleene(){
		   //Vertex Default Construction
		   Vertex newStart = createStart();
		   Vertex newFinal = createFinal();
		   /*
		    * Popped last off stack
		    */
		   Pair<Vertex,Vertex> kleenePaire = stateHistory.peek();
		   //Start Node
		   Vertex oldStart = kleenePaire.getL();
		   //End Node
		   Vertex oldFinal = kleenePaire.getR();
		   stateHistory.pop();
		   
		   //Epsilon Transition from new start to new final
		   Edge kleeneEdge = new Edge(newFinal,empty);
		   oldFinal.out = kleeneEdge;
		   newStart.out = kleeneEdge;
		   
		   
		   // Epsilon Transition from new start to original start
		   Edge kleeneStartEdge = new Edge(oldStart,empty);
		   newStart.out2 = kleeneStartEdge;

		   // Epsilon Transition from new final to original start
		   Edge finalToOld = new Edge(oldStart,empty);
		   newFinal.out = finalToOld;
		   
		   
		   //ALL CONNECTIONS MADE---CHANGING PERMISSIONS
		   oldFinal.makeRootFalse();
		   oldFinal.makeFinalFalse();
		   oldStart.makeRootFalse();
		   oldStart.makeFinalFalse();
		   
		   

		   //Save State on stack for Operator
		    Pair<Vertex,Vertex> kleeneFinalPair = new Pair<Vertex,Vertex>();
		    kleeneFinalPair.setL(newStart);
		    kleeneFinalPair.setR(newFinal);
		    stateHistory.push(kleeneFinalPair);
		   
			   //Add to graph
			   gTable.InsertEdgeByWeight(oldFinal, newFinal, empty);
			   gTable.InsertEdgeByWeight(newStart, newFinal, empty);
			   
			   gTable.InsertEdgeByWeight(newFinal, oldStart, empty);
			   gTable.InsertEdgeByWeight(newStart, oldStart, empty);
			  
			   
			   gTable.setNumVert(gTable.getNumVert()+2); 
			   gTable.setNumEdges(gTable.getNumEdges()+4);	 
			   gTable.setStartState(newStart.stateID);
			   
	}
	
	
	public void orSelection(){
		   Vertex rootNodeOr = createStart();
		   Vertex endNodeOr = createFinal();
		   
		 //Second Pair popped off
		   Pair<Vertex,Vertex> OrPair = stateHistory.peek();
		   //Final State
		   Vertex secondEndVertex = OrPair.getR(); 
		   secondEndVertex.makeFinalFalse();
		   //First State
		   Vertex secondNode = OrPair.getL();
		   secondNode.makeRootFalse();
		   stateHistory.pop();
		   
		   //First Pair popped off
		   Pair<Vertex,Vertex> OrPair1 = stateHistory.peek();
		   //Final State
		   Vertex firstEndVertex = OrPair1.getR();    
		   firstEndVertex.makeFinalFalse();
		   //First State	   
		   Vertex firstNode =OrPair1.getL(); 
		   firstNode.makeRootFalse();
		   stateHistory.pop();
		   
		   //Add Edge creation
		   Edge secondEdge = new Edge(secondNode,empty);
		   Edge firstEdge = new Edge(firstNode,empty);
		   
		   //New Root node attached
		   rootNodeOr.out = firstEdge;
		   rootNodeOr.out2 = secondEdge;




		   //Add new Final Node
		   Edge finalEdge = new Edge(endNodeOr,empty);

		   //Connect Final Node
		   secondEndVertex.out = finalEdge;
		   firstEndVertex.out = finalEdge;

		   //Save State on stack for Operator
		    Pair<Vertex,Vertex> orPairFinal = new Pair<Vertex,Vertex>();
		    orPairFinal.setL(rootNodeOr);
		    orPairFinal.setR(endNodeOr);
		    stateHistory.push(orPairFinal);


			   //Add to Graph Table
			  gTable.InsertEdgeByWeight(rootNodeOr,firstNode,empty);
			  gTable.InsertEdgeByWeight(rootNodeOr,secondNode,empty);
			  gTable.InsertEdgeByWeight(secondEndVertex,endNodeOr,empty);
			  gTable.InsertEdgeByWeight(firstEndVertex,endNodeOr,empty);
			  
			  
			   gTable.setNumVert(gTable.getNumVert()+2);
			   gTable.setNumEdges(gTable.getNumEdges()+4);   
			   gTable.setStartState(rootNodeOr.stateID);
	}
	
	
	/*
	 *
	 * Thompsons Construction Algorithm
	 * http://swtch.com/~rsc/regexp/regexp1.html
	 * -------------------------------------------------------------------------------------
	 */
	public void toNFA(String postfix){
		for(char c : postfix.toCharArray()) {
			   switch ( c ) {
			   	   case 'a':{
			   		   charTransition(c);
			   		 break;
			   	   }
			   	   case 'b':{
			   		   charTransition(c);
			   		 break;
			   	   }
			   	   case '*':{
			   		    kleene();
			   		 break;
			   	   }
			   	   case '|':{
			   		   orSelection();
			   		   break;
			   	   }
			   	   case '.':{
			   		   concatState();
			   		 break;
			   	   }
			   	   default:{
			   		   //Should probably have some default setting this boots to
			   		 break;
			   	   }
			  }
		}
	}
	
	
	
	public void fileParser(){
    	File regexFile = new File("/Users/Deverick/Documents/workspace/RegToDFA/Libs/input.txt");
    
    	Scanner scanner = null;
    	try{
    		scanner = new Scanner(regexFile);
    	}catch(FileNotFoundException t){
    		t.printStackTrace();
    	}
    	String regex = scanner.nextLine();
    	System.out.println("Regex: "+ regex);
    	InfixToPostfix toPostfix = new InfixToPostfix();
    	
    	String postfix = "";
    	
    	postfix = toPostfix.convertToPostfix(toPostfix.addConcat(regex)).toString();
    	
    	
    	System.out.println("Postfix: "+ postfix);
  
    	
    	toNFA(postfix);
    	gTable.copyMaps();
    	gTable.PrintTable();

  
    	gTable.subsetConstruction();
    	gTable.PrintDFATable();
    	
    	//Test cases are ran below
//    	List<String> testCases = new ArrayList<String>();
//    	
// 		while(scanner.hasNextLine()){
//    			testCases.add(scanner.nextLine());
//    		}
//    		
//            for(String testCase : testCases) {
//                System.out.println(testCase);
//            }
    	
	}
	
	
	public static void main(String[] args) {
		System.out.println("Hello this is the main system");
		mainConverter convertRegex = new mainConverter();
		convertRegex.fileParser();
			
	}

}
