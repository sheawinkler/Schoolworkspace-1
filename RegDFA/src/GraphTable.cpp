#include <string>
#include "GraphTable.h"
#include <iostream>
using namespace std;

//-------------------------------GRAPH TABLE----------------------------------------//
GraphTable::GraphTable(){
	numVert =0;
	numEdges=0;
	adjacencies = new std::vector< std::vector<Edge*>* >;
}

/*
 * Connecting Edge vertF -----> vertT via weight
 * adjacencies[v][e]
 */
void GraphTable::InsertEdgeByWeight(Vertex* vertF,Vertex* vertT, char weigh){
		Edge* tempEdge = new Edge(vertT,weigh);
		 std::vector< std::vector<Edge*>* >::iterator insertionIter2d;
		 insertionIter2d = adjacencies->begin();

		/* if vector at location doesn't exist, we will push a new vector of the edge otherwise we
		 * will need to push the edge into the corresponding vector location
		 */
		 if(adjacencies->size()<=vertF->thisState.stateId){
			 //Create new vector and insert the edge into it
			 std::vector<Edge*>* temp_vec = new vector<Edge*>;
			 std::vector<Edge*>::iterator insertionIter;
			 insertionIter = temp_vec->begin();
			 temp_vec->insert(insertionIter,tempEdge);

			 //Take that new vector and add it to the correct location
			 try{
				 std::vector< std::vector<Edge*>* >::iterator vectIter;
				 adjacencies->insert(vectIter, temp_vec);
			// adjacencies->at(vertF->thisState.stateId) = temp_vec;
			 }
			 catch(int e){
				 	cout<< "error vector position out of bounds";
			 }

		 }else{
			 adjacencies->at(vertF->thisState.stateId)->push_back(tempEdge);
		 }
}


void GraphTable::PrintTable(){
	std::vector< std::vector<Edge*> >::iterator row;
	std::vector<Edge*>::iterator col;
//	for(edgeVecIterator = adjacencies->begin(); edgeVecIterator != adjacencies->end(); edgeVecIterator){
//			std::cout<< " The State ID  "<< i <<"  contains the following Nodes "<<std::endl;
//			for(int j=0;j<adjacencies[i].size();j++){
//				std::vector<Edge*>* temp_cont = new vector<Edge*>;
//				temp_cont = adjacencies[i][j];
//				 for (std::vector<Edge*>::iterator it = temp_cont->begin() ; it != temp_cont->end(); ++it){
//					 Edge* tempEdging = *it;
//					 std::cout << "The weight is: " << tempEdging->returnWeight()<<" and the ID is: "<<tempEdging->returnToVertex()->thisState.stateId<<"\n"<<endl;
//				 }
//				   std::cout << '\n';
//				// std::cout<< "-->"<<temp_cont->
//				//std::cout<< "-->"<<tempVert->thisState.stateId<<"[weight: "<<adjacencies[i][j]->returnWeight()<<"]"<<endl;
//			}
//	}


}

void GraphTable::Closure(){

//--adjacencies Has it all--
//		while(true){
//
//		}
}

void GraphTable::TravelMarker(){



}
