#include <string>
#include "GraphTable.h"
#include <iostream>
#include <map>
using namespace std;

//-------------------------------GRAPH TABLE----------------------------------------//
GraphTable::GraphTable(){
	numVert =0;
	numEdges=0;

    typedef std::pair<Vertex*,char> transitionPair;
	std::multimap<int, transitionPair > adjacencies;
	typedef std::pair<int, transitionPair > map_pair;
}


/*
 * Connecting Edge vertF -----> vertT via weight
 * adjacencies[v][e]
 */
void GraphTable::InsertEdgeByWeight(Vertex* vertF, Vertex* vertT,char A){

	transitionPair tempPair = make_pair(vertT, A);
	map_pair finalPair = make_pair(vertF->thisState.stateId,tempPair);
			 try{
				 adjacencies.insert(finalPair);
			 }
			 catch(int e){
				 	cout<< "error inserting pair";
			 }
}


void GraphTable::PrintTable(){
	cout << "Number of elements with key 0: " << adjacencies.count(0) << endl;
	std::multimap<int, transitionPair>::iterator it = adjacencies.find();

	if(it != adjacencies.end()){
		for(size_t i=0; )
	}
}

void GraphTable::Closure(){

//--adjacencies Has it all--
//		while(true){
//
//		}
}

void GraphTable::TravelMarker(){



}
