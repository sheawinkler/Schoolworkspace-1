import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.*;
public class mainConverter {
	
	
	int id =-1;
	char empty = '#';
	GraphTable gTable;
	Stack<  Pair<Vertex,Vertex> > stateHistory;


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

		   //Save State on stack for Operator
		    Pair<Vertex,Vertex> charPair = new Pair<Vertex,Vertex>();
		    
		    charPair.setL(rootNodeChar);
		    charPair.setR(endNodeChar);
		    stateHistory.push((Pair<Vertex,Vertex>)charPair);

		   //Figure out your table schema
		   gTable.InsertEdgeByWeight(rootNodeChar, endNodeChar, c);
		   gTable.setNumVert(gTable.getNumVert()+2); 
		   gTable.setNumEdges(gTable.getNumEdges()+1); 

	}
	//Change to End Node transition
	public void concatState(){
		   //Vertex Construction
		Vertex rootNode = createStart();
		Vertex endNode = createFinal();
		
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
		  //This is the nodeA -----> nodeB..
		Vertex nodeA = tempPair2.getL();
		stateHistory.pop();
		
		//Here we have nodeA-->nodeAFinal    going to be concat with nodeB -->nodeBFinal
		//CONCAT rootNode.out->edge to nodeA
		Edge concatRootEdge = new Edge(nodeA,empty);
		rootNode.out = concatRootEdge;	
		
		   //CONCAT nodeAFinal TO nodeB
		   Edge concatMiddleEdge =  new Edge(nodeB,empty);
		   nodeAFinal.setFinalState(false); 
		   nodeAFinal.setRootState(false); 
		   nodeAFinal.out = concatMiddleEdge;
		
		   //CONCAT nodeBFinal  to endNode
		   Edge concatFinalEdge = new Edge(endNode,empty);
		   //Dangling is the Edge----.out contains the node --->dangling
		   nodeBFinal.setFinalState(false);
		   nodeBFinal.setRootState(false); 
		   nodeBFinal.out = concatFinalEdge;		

		   //ALL CONNECTIONS MADE---CHANGING PERMISSIONS
		   nodeA.setRootState(false); 
		   nodeB.setRootState(false); 
		   nodeA.out.returnToVertex().makeFinalFalse();
		   nodeB.out.returnToVertex().makeFinalFalse();

		   //Save State on stack for Operator
		   	Pair<Vertex,Vertex> concatFinalPair = new Pair<Vertex,Vertex>();;
		    concatFinalPair.setL(rootNode);
		    concatFinalPair.setR(endNode);
		    stateHistory.push(concatFinalPair);
		
	}
	public void kleene(){
		   //Vertex Default Construction
		   Vertex startVertexKleene = createStart();
		   Vertex endVertexKleene = createFinal();
		   /*
		    * Popped last off stack
		    */
		   Pair<Vertex,Vertex> kleenePaire = stateHistory.peek();
		   //Start Node
		   Vertex kleeneStartNode = kleenePaire.getL();
		   //End Node
		   Vertex kleeneEndNode = kleenePaire.getR();
		   stateHistory.pop();
		   
		   //Going to New final state
		   Edge kleeneEdge = new Edge(endVertexKleene,empty);
		   Edge kleeneStartEdge = new Edge(kleeneStartNode,empty);

	   	   //Add Transitions
		   kleeneEndNode.out = kleeneEdge;
		   kleeneEndNode.out2 = kleeneStartEdge;

		   startVertexKleene.out = kleeneEdge;
		   startVertexKleene.out2 = kleeneStartEdge;

		   //ALL CONNECTIONS MADE---CHANGING PERMISSIONS
		   kleeneEndNode.makeRootFalse() ;
		   kleeneEndNode.out.returnToVertex().makeFinalFalse();

		   //Save State on stack for Operator
		    Pair<Vertex,Vertex> kleeneFinalPair = new Pair<Vertex,Vertex>();
		    kleeneFinalPair.setL(startVertexKleene);
		    kleeneFinalPair.setR(endVertexKleene);
		    stateHistory.push(kleeneFinalPair);
		   
			   //Add to graph
			   gTable.InsertEdgeByWeight(kleeneEndNode, endVertexKleene, empty);
			   gTable.InsertEdgeByWeight(kleeneEndNode, kleeneStartNode, empty);

			   gTable.InsertEdgeByWeight(startVertexKleene, kleeneStartNode, empty);
			   gTable.InsertEdgeByWeight(startVertexKleene, endVertexKleene, empty);
			   
			   gTable.setNumVert(gTable.getNumVert()+2); 
			   gTable.setNumEdges(gTable.getNumEdges()+4); 
			   
			   
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
		   stateHistory.pop();
		   
		   //First Pair popped off
		   Pair<Vertex,Vertex> OrPair1 = stateHistory.peek();
		   //Can still use end Node****
		   Vertex firstEndVertex = OrPair1.getR();     
		   Vertex firstNode =OrPair1.getL(); 
		   stateHistory.pop();
		   
		   //Add Edge creation
		   Edge secondEdge = new Edge(secondNode,empty);
		   Edge firstEdge = new Edge(firstNode,empty);
		   
		   //New Root node attached
		   rootNodeOr.out = firstEdge;
		   rootNodeOr.out2 = secondEdge;

		   //Remove old root and final state markers
		   secondNode.makeRootFalse();
		   secondNode.out.returnToVertex().makeFinalFalse();
		   secondNode.out2.returnToVertex().makeFinalFalse();

		   firstNode.makeRootFalse();
		   firstNode.out.returnToVertex().makeFinalFalse();
		   firstNode.out2.returnToVertex().makeFinalFalse();

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
    	
    	
    	String postfix = toPostfix.convertToPostfix(toPostfix.addConcat(regex));
    	System.out.println("Postfix: "+ postfix.toString());
    	
    	
    	
    	
    	
    	//Test cases are ran below
    	List<String> testCases = new ArrayList<String>();
    	
    		while(scanner.hasNextLine()){
    			testCases.add(scanner.nextLine());
    		}
//    		
//            for(String testCase : testCases) {
//                System.out.println(testCase);
//            }
    	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello this is the main system");
		mainConverter convertRegex = new mainConverter();
		convertRegex.fileParser();
			
	}

}
