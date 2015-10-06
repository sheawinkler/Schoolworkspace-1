//============================================================================
// Name        : RegDFA.cpp
// Author      : Deverick Simpson
// Version     :
// Copyright   : Your copyright notice
// Description : Reg To DFA in C++, Ansi-style
//============================================================================
#include "InfixToPostfix.h"
#include <iostream>
#include <stack>
#include <utility> //std::pair
#include <map>
#include <string>
#include <vector>
#include <sstream>  // requires standard library
#include <fstream>  // Note this extra header requirement whenever working with files
#include <cstdlib>
#include "Vertex.h"
#include "GraphTable.h"
#include <set>
using namespace std;

//I really dont want this to be global
int id =-1;
char empty = '#';
GraphTable gTable;
//Root Node and the ID of the finalState
std::stack<  std::pair<Vertex*,Vertex*> > *stateHistory;


Vertex* createStart(){
	   //StartingVertex
	   Vertex* startVertex = new Vertex();
	   startVertex->thisState.stateId=++id;
	   startVertex->thisState.rootState=true;
	   startVertex->thisState.finalState=false;
	   return startVertex;
}

Vertex* createFinal(){
   //EndingVertex
   Vertex* endVertex= new Vertex();
   endVertex->thisState.stateId=++id;
   endVertex->thisState.rootState=false;
   endVertex->thisState.finalState=true;
   return endVertex;
}

void charTransition(char c){
	   //Vertex Construction
	   Vertex* rootNodeChar = createStart();
	   Vertex* endNodeChar = createFinal();
	   Edge* tempEdge = new Edge(endNodeChar,c);
	   rootNodeChar->out = tempEdge;


	   //Save State on stack for Operator
	    std::pair<Vertex*,Vertex*> charPair;
	    charPair = make_pair(rootNodeChar, endNodeChar);
	    stateHistory->push((std::pair<Vertex*,Vertex*>)charPair);

	   //Figure out your table schema
	   //startVertex->thisState  and startVertex->out
	   gTable.InsertEdgeByWeight(rootNodeChar,endNodeChar,c);
	   gTable.numVert += 2;
	   gTable.numEdges++;

}

//Change to End Node transition
void concatState(){
	   //Vertex Construction
	   Vertex* rootNode = createStart();
	   Vertex* endNode = createFinal();

	   //Pop last two off stack
	   std::pair<Vertex*,Vertex*> tempPair = stateHistory->top();
	   Vertex* nodeBFinal = std::get<1>(tempPair);
 	   Vertex* nodeB = std::get<0>(tempPair);
	   stateHistory->pop();

	   //Remove as Start State and add as Final State
	   nodeB->thisState.rootState =false;

	   //Pop first two off stack--Retrieving Pair from Stack  pair<start,end>
	   std::pair<Vertex*,Vertex*> tempPair2 = stateHistory->top();
	   Vertex* nodeAFinal = std::get<1>(tempPair2);
	   //This is the nodeA -----> nodeB..
	   Vertex* nodeA = std::get<0>(tempPair2);
	   stateHistory->pop();


	   //CONCAT rootNode.out->edge to nodeA
	   Edge* concatRootEdge = new Edge(nodeA,empty);
	   rootNode->out = concatRootEdge;

	   //CONCAT nodeAFinal TO nodeB
	   Edge* concatMiddleEdge =  new Edge(nodeB,empty);
	   nodeAFinal->thisState.finalState = false;
	   nodeAFinal->thisState.rootState = false;
	   nodeAFinal->out = concatMiddleEdge;

	   //CONCAT nodeBFinal  to endNode
	   Edge* concatFinalEdge = new Edge(endNode,empty);
	   //Dangling is the Edge----.out contains the node --->dangling
	   nodeBFinal->thisState.finalState = false;
	   nodeBFinal->thisState.rootState = false;
	   nodeBFinal->out = concatFinalEdge;

	   //ALL CONNECTIONS MADE---CHANGING PERMISSIONS
	   nodeA->thisState.rootState =false;
	   nodeB->thisState.rootState =false;
	   nodeA->out->makeFinalFalse();
	   nodeB->out->makeFinalFalse();

	   //Save State on stack for Operator
	    std::pair<Vertex*,Vertex*> concatFinalPair;
	    concatFinalPair= make_pair(rootNode,endNode);
	    stateHistory->push(concatFinalPair);

	   //Insert into Graph
	   gTable.InsertEdgeByWeight(rootNode, nodeA, empty);

	   gTable.InsertEdgeByWeight(nodeAFinal,nodeB, empty);

	   gTable.InsertEdgeByWeight(nodeBFinal,endNode, empty);

	   gTable.numVert += 2;
	   gTable.numEdges += 2;
}

void kleene(){
	   //Vertex Default Construction
	   Vertex* startVertexKleene = createStart();
	   Vertex* endVertexKleene = createFinal();
	   /*
	    * Popped last off stack
	    */
	   std::pair<Vertex*,Vertex*> kleenePaire = stateHistory->top();
	   //Start Node
	   Vertex* kleeneStartNode = std::get<0>(kleenePaire);
	   //End Node
	   Vertex* kleeneEndNode = std::get<1>(kleenePaire);
	   stateHistory->pop();

	   //Going to New final state
	   Edge* kleeneEdge = new Edge(endVertexKleene,empty);
	   Edge* kleeneStartEdge = new Edge(kleeneStartNode,empty);

   	   //Add Transitions
	   kleeneEndNode->out = kleeneEdge;
	   kleeneEndNode->out2 = kleeneStartEdge;

	   startVertexKleene->out = kleeneEdge;
	   startVertexKleene->out2 = kleeneStartEdge;


	   //ALL CONNECTIONS MADE---CHANGING PERMISSIONS
	   kleeneEndNode->thisState.rootState =false;
	   kleeneEndNode->out->makeFinalFalse();

	   //Save State on stack for Operator
	    std::pair<Vertex*,Vertex*> kleeneFinalPair;
	    kleeneFinalPair= make_pair(startVertexKleene,endVertexKleene);
	    stateHistory->push(kleeneFinalPair);

   	   //Add to graph
	   gTable.InsertEdgeByWeight(kleeneEndNode, endVertexKleene, empty);
	   gTable.InsertEdgeByWeight(kleeneEndNode, kleeneStartNode, empty);

	   gTable.InsertEdgeByWeight(startVertexKleene, kleeneStartNode, empty);
	   gTable.InsertEdgeByWeight(startVertexKleene, endVertexKleene, empty);

	   gTable.numVert += 2;
	   gTable.numEdges += 4;
}

/*
 * This will define the | action, providing epsilon transitions
 * firstNode is the intermittent node
 * secondNode is the other intermittent node
 */
void orSelection(){
	   Vertex* rootNodeOr = createStart();
	   Vertex* endNodeOr = createFinal();

	   //Second Pair popped off
	   std::pair<Vertex*,Vertex*> OrPair = stateHistory->top();
	   //Final State
	   Vertex* secondEndVertex = std::get<1>(OrPair);
	   secondEndVertex->thisState.finalState = false;
	   //First State
	   Vertex* secondNode = std::get<0>(OrPair);
	   stateHistory->pop();

	   //First Pair popped off
	   std::pair<Vertex*,Vertex*> OrPair1 = stateHistory->top();
	   //Can still use end Node****
	   Vertex* firstEndVertex = std::get<1>(OrPair);
	   Vertex* firstNode = std::get<0>(OrPair1);
	   stateHistory->pop();


	   //Add Edge creation
	   Edge* secondEdge = new Edge(secondNode,empty);
	   Edge* firstEdge = new Edge(firstNode,empty);

	   //New Root node attached
	   rootNodeOr->out = firstEdge;
	   rootNodeOr->out2 = secondEdge;

	   //Remove old root and final state markers
	   secondNode->thisState.rootState=false;
	   secondNode->out->makeFinalFalse();
	   secondNode->out2->makeFinalFalse();

	   firstNode->thisState.rootState=false;
	   firstNode->out->makeFinalFalse();
	   firstNode->out2->makeFinalFalse();

	   //Add new Final Node
	   Edge* finalEdge = new Edge(endNodeOr,empty);

	   //Connect Final Node
	   secondEndVertex->out = finalEdge;
	   firstEndVertex->out = finalEdge;

	   //Save State on stack for Operator
	    std::pair<Vertex*,Vertex*> orPairFinal;
	    orPairFinal= make_pair(rootNodeOr,endNodeOr);
	    stateHistory->push(orPairFinal);

	   //Add to Graph Table
	  gTable.InsertEdgeByWeight(rootNodeOr,firstNode,empty);
	  gTable.InsertEdgeByWeight(rootNodeOr,secondNode,empty);
	  gTable.InsertEdgeByWeight(secondEndVertex,endNodeOr,empty);
	  gTable.InsertEdgeByWeight(firstEndVertex,endNodeOr,empty);

	   gTable.numVert += 2;
	   gTable.numEdges += 4;
}

/*
 *
 * Thompsons Construction Algorithm
 * http://swtch.com/~rsc/regexp/regexp1.html
 * -------------------------------------------------------------------------------------
 */
void toNFA(string Postfix){
	//WILL NEED TO CHANGE FOR CSE STANDARDS!!
	for(char& c : Postfix) {
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

/*
 * File Parsing and Main Function Call
 * ----------------------------------------------------------------------------------
 */
void fileparser(){
	string STRING;
	    ifstream infile;
	    int bIndex=0;
	    string previousLine="";
	   //Change to match homework readme
	    infile.open ("/Users/Deverick/Documents/workspace/RegDFA/Libs/input.txt");

	    while(!infile.eof()) // To get you all the lines.
	    {
	        getline(infile,STRING); // Saves the line in STRING.
	        //Parsing RegEx
	        if(bIndex==0){
	        	//Calling InfixToPostfix File returning a queue
	        	InfixToPostfix sampleTest;
	        	//converToPostfix is a string===remove string creation, wasting space
	        	string postfix = sampleTest.convertToPostfix(sampleTest.addConcat(STRING));
	        	int lengthOF = postfix.size();
	        	cout <<"Here is the postfix expression "<< postfix << endl;
	        	toNFA(postfix);
	        	//gTable.PrintTable();
	        }
	        //ONE EXTRA TEST CASE IS BEING RAN~~REMOVE--I added 1 to check on bIndex..check that
	        //Testing String Input against cases
	        //cout<<"The test case is: "<<endl;
	        if(bIndex>1){
	        	// cout<<STRING<<endl; // Prints our STRING.
	        }

	        bIndex++;
	    }
	    infile.close();
	    cout<<"We are here "<<endl;
	    //Need to return a parsing stack to manipulate the regex to a NFA
}


int main(){
	char Name[30];
	stateHistory = new std::stack<  std::pair<Vertex*,Vertex*> >;

	cout << "!!!Hello, what is your name!!!" << endl; // prints !!!Hello World!!!
	cin >> Name;
	ifstream ifs( "/Users/Deverick/Documents/workspace/RegDFA/Libs/input.txt" );       // note no mode needed
	   if ( ! ifs.is_open() ) {
		   cout << "Hello,"<< Name << " we have failed to open the file, check the path"<< endl;
	   }
	   else {
		   cout << "Hello, "<< Name <<" All seems to be running smooth...Here's the parsing of the file"<< endl;
		   fileparser();
	   }
	   cout<< "Closing Down"<< endl;
	return 0;
}
